
import java.util.*;

public class Battle {

	//final private int EEVEE = 1; 
	final private int PIKACHU = 2;
	final private int CHARMANDER = 3;
	final private int MEOWTH = 4;
	final private int HOUNDOUR = 5;
	final private int KOFFING = 6;

	final private int NUMBER_OF_BATTLE_CREW = 5;

	private ArrayList<Pokemon> battleCrew = new ArrayList<Pokemon>(NUMBER_OF_BATTLE_CREW);
	private Random random = new Random();

	/*
	 * Hybrid algorithm's battle function 
	 */
	public ArrayList<Pokemon> hybridBattle(ArrayList<Pokemon> eevees)
	{
		int alternate = 0;
		int maxNumberOfTurns = 0;
		double damage = 0.0;
		double[] battleHealth = new double[NUMBER_OF_BATTLE_CREW]; 
		double[] battleAttack = new double[NUMBER_OF_BATTLE_CREW]; 
		double[] battleDefense = new double[NUMBER_OF_BATTLE_CREW]; 
		boolean[] battleWon = new boolean[NUMBER_OF_BATTLE_CREW];
		double[] battleResults = new double[NUMBER_OF_BATTLE_CREW];

		//initialize battleResults to 0
		for (int i=0; i<NUMBER_OF_BATTLE_CREW; i++)
		{
			battleResults[i] = 0;
		}

		//initialize battle arrays and power up eevees 
		for (int i=0; i<eevees.size(); i++)
		{
			eevees.get(i).initializeBattleArrays(NUMBER_OF_BATTLE_CREW);
			eevees.get(i).powerUp();
		}

		//battle begins
		for (int i=0; i<eevees.size(); i++)
		{	
			//initialize the battle opponents
			initializeBattleCrew(eevees.get(i).getLevel());
			
			//battle each opponent
			for (int j=0; j<NUMBER_OF_BATTLE_CREW; j++) 
			{ 
				//eevee starting stats
				eevees.get(i).setStatus(0);
				eevees.get(i).setAccuracy(1.0);
				eevees.get(i).setHealthInBattle(eevees.get(i).getHealth());
				eevees.get(i).setAttackInBattle(eevees.get(i).getAttack());
				eevees.get(i).setDefenseInBattle(eevees.get(i).getDefense());
				
				//opponent starting stats
				battleCrew.get(j).setStatus(0);
				battleCrew.get(j).setAccuracy(1.0);
				battleCrew.get(j).setHealthInBattle(battleCrew.get(j).getHealth());
				battleCrew.get(j).setAttackInBattle(battleCrew.get(j).getAttack());
				battleCrew.get(j).setDefenseInBattle(battleCrew.get(j).getDefense());
				
				//battle
				while ((eevees.get(i).getHealthInBattle()>0) && (battleCrew.get(j).getHealthInBattle()>0) && (maxNumberOfTurns!=150)) //both pokemon still alive
				{
					if ((alternate%2)==0) //eevee moves first
					{
						damage = damageFunction(eevees.get(i), battleCrew.get(j));
						battleCrew.get(j).setHealthInBattle(battleCrew.get(j).getHealthInBattle()-damage);
					}
					if ((alternate%2)==1) //opponent moves first
					{
						damage = damageFunction(battleCrew.get(j), eevees.get(i));
						eevees.get(i).setHealthInBattle(eevees.get(i).getHealthInBattle()-damage);
					}
					
					alternate++;
					maxNumberOfTurns++;

					if (maxNumberOfTurns == 150)
					{
						eevees.get(i).setHealthInBattle(0);
					}
				}
				alternate = 0;
				maxNumberOfTurns = 0;

				//battle results
				if (eevees.get(i).getHealthInBattle()<=0)
				{
					battleHealth[j] = 0;
					battleWon[j] = false;
				}
				else
				{
					battleHealth[j] = eevees.get(i).getHealthInBattle();
					battleWon[j] = true;
					battleResults[j] += 1.0;
				}

				if (eevees.get(i).getAttackInBattle()<=0)
				{
					battleAttack[j] = 0;
				}
				else
				{
					battleAttack[j] = eevees.get(i).getAttackInBattle();
				}

				if (eevees.get(i).getDefenseInBattle()<=0)
				{
					battleDefense[j] = 0;
				}
				else
				{
					battleDefense[j] = eevees.get(i).getDefenseInBattle();
				}
			}
			eevees.get(i).setBattleHealth(battleHealth);
			eevees.get(i).setBattleAttack(battleAttack);
			eevees.get(i).setBattleDefense(battleDefense);
			eevees.get(i).setBattleWin(battleWon);
		}

		//calculate eevee fitness and update level
		for (int i=0; i<eevees.size(); i++)
		{	
			eevees.get(i).calculateFitness(eevees.get(i).getBattleHealth(), eevees.get(i).getBattleAttack(), eevees.get(i).getBattleDefense(), eevees.get(i).getBattleWin(), battleResults);
			eevees.get(i).levelUp(eevees.get(i).getBattleWin());
		}

		return eevees;
	}

	/*
	 * Initializes the battle crew's stats
	 */ 
	public void initializeBattleCrew(int level)
	{
		battleCrew.clear();
		battleCrew.add(new Pokemon(PIKACHU, -1, 100));
		battleCrew.add(new Pokemon(CHARMANDER, -1, 100));
		battleCrew.add(new Pokemon(MEOWTH, -1, 100));
		battleCrew.add(new Pokemon(HOUNDOUR, -1, 100));
		battleCrew.add(new Pokemon(KOFFING, -1, 100));

		//power up battle crew 
		for (int j=0; j<battleCrew.size(); j++)
		{
			battleCrew.get(j).setLevel(level);
			battleCrew.get(j).updateStats();
			battleCrew.get(j).setHealthProbability(1/3);
			battleCrew.get(j).setAttackProbability(1/3);
			battleCrew.get(j).setDefenseProbability(1/3);
			battleCrew.get(j).powerUp();
		}
	}

	/*
	 * Coevolution algorithm's battle function 
	 */
	public Coevolution coevolutionBattle(ArrayList<Pokemon> eevees1, ArrayList<Pokemon> eevees2)
	{
		int alternate = 1;
		int maxNumberOfTurns = 0;
		double damage = 0.0;
		int populationSize = eevees1.size();

		//eevee1 stats
		double[] battleHealth1 = new double[populationSize]; 
		double[] battleAttack1 = new double[populationSize]; 
		double[] battleDefense1 = new double[populationSize];
		boolean[] battleWon1 = new boolean[populationSize];
		double[] battleResultsAgainstOpponents = new double[populationSize];

		//eevee2 stats
		double battleHealth2; 
		double battleAttack2; 
		double battleDefense2;
		boolean battleWon2;
		double[] battleResultsAgainstEevees = new double[populationSize];

		//initialize battleResults to 0
		for (int i=0; i<populationSize; i++)
		{
			battleResultsAgainstOpponents[i] = 0;
			battleResultsAgainstEevees[i] = 0;
		}

		//powers ups for both populations of eevees
		for (int i=0; i<populationSize; i++)
		{
			eevees1.get(i).initializeBattleArrays(populationSize);
			eevees1.get(i).powerUp();
			eevees2.get(i).initializeBattleArrays(populationSize);
			eevees2.get(i).powerUp();
		}

		//battle begins
		for (int i=0; i<populationSize; i++)
		{	
			//battle each opponent
			for (int j=0; j<populationSize; j++) 
			{ 
				//eevee1 starting stats
				eevees1.get(i).setStatus(0);
				eevees1.get(i).setAccuracy(1.0);
				eevees1.get(i).setHealthInBattle(eevees1.get(i).getHealth());
				eevees1.get(i).setAttackInBattle(eevees1.get(i).getAttack());
				eevees1.get(i).setDefenseInBattle(eevees1.get(i).getDefense());

				//eevee2 starting stats
				eevees2.get(j).setStatus(0);
				eevees2.get(j).setAccuracy(1.0);
				eevees2.get(j).setHealthInBattle(eevees2.get(j).getHealth());
				eevees2.get(j).setAttackInBattle(eevees2.get(j).getAttack());
				eevees2.get(j).setDefenseInBattle(eevees2.get(j).getDefense());
				
				//battle
				while ((eevees1.get(i).getHealthInBattle()>0) && (eevees2.get(j).getHealthInBattle()>0) && (maxNumberOfTurns!=150)) //both pokemon still alive
				{
					if ((alternate%2)==0) //eevee1 moves first
					{
						damage = damageFunction(eevees1.get(i), eevees2.get(j));
						eevees2.get(j).setHealthInBattle(eevees2.get(j).getHealthInBattle()-damage);
					}
					if ((alternate%2)==1) //eevee2 moves first
					{
						damage = damageFunction(eevees2.get(j), eevees1.get(i));
						eevees1.get(i).setHealthInBattle(eevees1.get(i).getHealthInBattle()-damage);
					}
					
					alternate++;
					maxNumberOfTurns++;
					
					if (maxNumberOfTurns == 150)
					{
						eevees1.get(i).setHealthInBattle(0);
						eevees2.get(j).setHealthInBattle(0);
					}
				}
				alternate = 1;
				maxNumberOfTurns = 0;

				//eevee1 updates
				if (eevees1.get(i).getHealthInBattle()<=0)
				{
					battleHealth1[j] = 0;
					battleWon1[j] = false;
				}
				else
				{
					battleHealth1[j] = eevees1.get(i).getHealthInBattle();
					battleWon1[j] = true;
					battleResultsAgainstOpponents[j] += 1.0;
				}
				if (eevees1.get(i).getAttackInBattle()<=0)
				{
					battleAttack1[j] = 0;
				}
				else
				{
					battleAttack1[j] = eevees1.get(i).getAttackInBattle();
				}
				if (eevees1.get(i).getDefenseInBattle()<=0)
				{
					battleDefense1[j] = 0;
				}
				else
				{
					battleDefense1[j] = eevees1.get(i).getDefenseInBattle();
				}

				//eevee2 updates
				if (eevees2.get(j).getHealthInBattle()<=0)
				{
					battleHealth2 = 0;
					battleWon2 = false;
				}
				else
				{
					battleHealth2 = eevees2.get(j).getHealthInBattle();
					battleWon2 = true;
					battleResultsAgainstEevees[i] += 1.0;
				}
				if (eevees2.get(j).getAttackInBattle()<=0)
				{
					battleAttack2 = 0;
				}
				else
				{
					battleAttack2 = eevees2.get(j).getAttackInBattle();
				}
				if (eevees2.get(j).getDefenseInBattle()<=0)
				{
					battleDefense2 = 0;
				}
				else
				{
					battleDefense2 = eevees2.get(j).getDefenseInBattle();
				}

				eevees2.get(j).addBattleHealth(i, battleHealth2);
				eevees2.get(j).addBattleAttack(i, battleAttack2);
				eevees2.get(j).addBattleDefense(i, battleDefense2);
				eevees2.get(j).addBattleWin(i, battleWon2);

				alternate = 0;
			} //end opponent battle

			eevees1.get(i).setBattleHealth(battleHealth1);
			eevees1.get(i).setBattleAttack(battleAttack1);
			eevees1.get(i).setBattleDefense(battleDefense1);
			eevees1.get(i).setBattleWin(battleWon1);
		} //eevee has battled all opponents

		for (int i=0; i<populationSize; i++)
		{		
			eevees1.get(i).calculateFitness(eevees1.get(i).getBattleHealth(), eevees1.get(i).getBattleAttack(), eevees1.get(i).getBattleDefense(), eevees1.get(i).getBattleWin(), battleResultsAgainstOpponents);
			eevees1.get(i).levelUp(eevees1.get(i).getBattleWin());

			eevees2.get(i).calculateFitness(eevees2.get(i).getBattleHealth(), eevees2.get(i).getBattleAttack(), eevees2.get(i).getBattleDefense(), eevees2.get(i).getBattleWin(), battleResultsAgainstEevees);
			eevees2.get(i).levelUp(eevees2.get(i).getBattleWin());
		}

		Coevolution coevolution = new Coevolution(eevees1, eevees2);
		return coevolution;
	}

	/*
	 * Calculates damage using battle damage function 
	 */
	public double damageFunction(Pokemon attacker, Pokemon opponent)
	{
		double damage = 0;

		if (random.nextDouble()<attacker.getAccuracy()) //chance to make a move
		{
			if (attacker.getStatus() == 1 || attacker.getStatus() == 2) //paralyzed or sleeping
			{
				if (random.nextDouble()>0.50) //unable to make move
				{
					return damage;
				}
				else //able to make move
				{
					if (attacker.getStatus() == 2) //woke up
					{
						attacker.setStatus(0); //back to normal
					}
				}
			}
			
			//choose a move
			int randomMove = random.nextInt(attacker.getSelectedMovesArray().length);
			Move selectedMove = (attacker.getSelectedMovesArray())[randomMove];

			if (random.nextDouble()<selectedMove.getMoveAccuracy()) //move hit target
			{
				int attackerLevel = attacker.getLevel();
				double attackerAttack = attacker.getAttackInBattle();
				double opponentDefense = opponent.getDefenseInBattle();
				double movePower = selectedMove.getMovePower();

				//check if move is a special case
				if (selectedMove.getMoveStatus())
				{
					String moveStatusEffect = selectedMove.getStatusType();
					if (moveStatusEffect.equals("accuracy"))
					{
						opponent.setAccuracy(opponent.getAccuracy()-0.05);
					}
					else if (moveStatusEffect.equals("attack"))
					{
						opponent.setAttackInBattle(opponent.getAttackInBattle()*0.9);
						
					}
					else if (moveStatusEffect.equals("defense"))
					{
						opponent.setDefenseInBattle(opponent.getDefenseInBattle()*0.9);
					}
					else if (moveStatusEffect.equals("first"))
					{
						damage = 2.5*(((2*attackerLevel+10)/250)*(attackerAttack/opponentDefense)*movePower+2);
					}
					else if (moveStatusEffect.equals("paralyze"))
					{
						opponent.setStatus(1); //paralyzed
					}
					else if (moveStatusEffect.equals("sleep"))
					{
						opponent.setStatus(2); //sleeping
					}
					else if (moveStatusEffect.equals("burn") || moveStatusEffect.equals("poison"))
					{
						if (random.nextDouble()<0.50) //burned or poisoned
						{
							opponent.setStatus(3);
							damage = opponent.getMaxHealth()/10;
						}
					}
					return damage;
				}

				damage = 2*(((2*attackerLevel+10)/250)*(attackerAttack/opponentDefense)*movePower+2);

				if (opponent.getStatus() == 3) //burned or poisoned
				{
					damage = damage+opponent.getMaxHealth()/10;
				}
			}
		}
		
		return damage;
	}

}
