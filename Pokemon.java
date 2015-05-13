
import java.util.*;

public class Pokemon {

	private int MAX_LEVEL = 50;
	private final double PSO_INCREMENT = 0.05;

	//pokemon types
	private int pokemonName;
	final private int EEVEE = 1; 
	final private int PIKACHU = 2;
	final private int CHARMANDER = 3;
	final private int MEOWTH = 4;
	final private int HOUNDOUR = 5;
	final private int KOFFING = 6;

	//pokemon base-status
	private double EEVEE_START_HEALTH = 55.0;
	private double EEVEE_END_HEALTH = 140.0;
	private double EEVEE_HEALTH_INCREMENT = (EEVEE_END_HEALTH-EEVEE_START_HEALTH)/MAX_LEVEL;
	private double EEVEE_START_ATTACK = 55.0;
	private double EEVEE_END_ATTACK = 85.0;
	private double EEVEE_ATTACK_INCREMENT = (EEVEE_END_ATTACK-EEVEE_START_ATTACK)/MAX_LEVEL;
	private double EEVEE_START_DEFENSE = 50.0;
	private double EEVEE_END_DEFENSE = 80.0;
	private double EEVEE_DEFENSE_INCREMENT = (EEVEE_END_DEFENSE-EEVEE_START_DEFENSE)/MAX_LEVEL;

	private double PIKACHU_START_HEALTH = 35.0;
	private double PIKACHU_END_HEALTH = 120.0;
	private double PIKACHU_HEALTH_INCREMENT = (PIKACHU_END_HEALTH-PIKACHU_START_HEALTH)/MAX_LEVEL;
	private double PIKACHU_START_ATTACK = 55.0;
	private double PIKACHU_END_ATTACK = 85.0;
	private double PIKACHU_ATTACK_INCREMENT = (PIKACHU_END_ATTACK-PIKACHU_START_ATTACK)/MAX_LEVEL;
	private double PIKACHU_START_DEFENSE = 30.0;
	private double PIKACHU_END_DEFENSE = 60.0;
	private double PIKACHU_DEFENSE_INCREMENT = (PIKACHU_END_DEFENSE-PIKACHU_START_DEFENSE)/MAX_LEVEL;

	private double CHARMANDER_START_HEALTH = 40.0;
	private double CHARMANDER_END_HEALTH = 125.0;
	private double CHARMANDER_HEALTH_INCREMENT = (CHARMANDER_END_HEALTH-CHARMANDER_START_HEALTH)/MAX_LEVEL;
	private double CHARMANDER_START_ATTACK = 50.0;
	private double CHARMANDER_END_ATTACK = 85.0;
	private double CHARMANDER_ATTACK_INCREMENT = (CHARMANDER_END_ATTACK-CHARMANDER_START_ATTACK)/MAX_LEVEL;
	private double CHARMANDER_START_DEFENSE = 45.0;
	private double CHARMANDER_END_DEFENSE = 75.0;
	private double CHARMANDER_DEFENSE_INCREMENT = (CHARMANDER_END_DEFENSE-CHARMANDER_START_DEFENSE)/MAX_LEVEL;

	private double MEOWTH_START_HEALTH = 40.0;
	private double MEOWTH_END_HEALTH = 125.0;
	private double MEOWTH_HEALTH_INCREMENT = (MEOWTH_END_HEALTH-MEOWTH_START_HEALTH)/MAX_LEVEL;
	private double MEOWTH_START_ATTACK = 45.0;
	private double MEOWTH_END_ATTACK = 75.0;
	private double MEOWTH_ATTACK_INCREMENT = (MEOWTH_END_ATTACK-MEOWTH_START_ATTACK)/MAX_LEVEL;
	private double MEOWTH_START_DEFENSE = 35.0;
	private double MEOWTH_END_DEFENSE = 65.0;
	private double MEOWTH_DEFENSE_INCREMENT = (MEOWTH_END_DEFENSE-MEOWTH_START_DEFENSE)/MAX_LEVEL;

	private double HOUNDOUR_START_HEALTH = 45.0;
	private double HOUNDOUR_END_HEALTH = 130.0;
	private double HOUNDOUR_HEALTH_INCREMENT = (HOUNDOUR_END_HEALTH-HOUNDOUR_START_HEALTH)/MAX_LEVEL;
	private double HOUNDOUR_START_ATTACK = 60.0;
	private double HOUNDOUR_END_ATTACK = 90.0;
	private double HOUNDOUR_ATTACK_INCREMENT = (HOUNDOUR_END_ATTACK-HOUNDOUR_START_ATTACK)/MAX_LEVEL;
	private double HOUNDOUR_START_DEFENSE = 30.0;
	private double HOUNDOUR_END_DEFENSE = 60.0;
	private double HOUNDOUR_DEFENSE_INCREMENT = (HOUNDOUR_END_DEFENSE-HOUNDOUR_START_DEFENSE)/MAX_LEVEL;

	private double KOFFING_START_HEALTH = 40.0;
	private double KOFFING_END_HEALTH = 125.0;
	private double KOFFING_HEALTH_INCREMENT = (KOFFING_END_HEALTH-KOFFING_START_HEALTH)/MAX_LEVEL;
	private double KOFFING_START_ATTACK = 65.0;
	private double KOFFING_END_ATTACK = 95.0;
	private double KOFFING_ATTACK_INCREMENT = (KOFFING_END_ATTACK-KOFFING_START_ATTACK)/MAX_LEVEL;
	private double KOFFING_START_DEFENSE = 95.0;
	private double KOFFING_END_DEFENSE = 125.0;
	private double KOFFING_DEFENSE_INCREMENT = (KOFFING_END_DEFENSE-KOFFING_START_DEFENSE)/MAX_LEVEL;

	private int pokemonNumber;

	//pokemon level variables
	private int level;
	private int battlesWon;
	private int levelUpThreshold;

	//pokemon status variables
	private double health;
	private double attack;
	private double defense;
	private double maxHealth;
	private double maxAttack;
	private double maxDefense;

	//pokemon battle status variables
	private int status;
	private double accuracy;
	private boolean[] battleWins;
	private double[] battleHealth; 
	private double[] battleAttack;
	private double[] battleDefense;
	private double healthInBattle;
	private double attackInBattle;
	private double defenseInBattle;

	//pokemon probability variables
	private double healthProbability;
	private double attackProbability;
	private double defenseProbability;

	//pokemon move arrays
	private Move[] possibleMoves = new Move[6];
	private Move[] moves = new Move[3];

	//pokemon neighborhood
	private int neighborhoodNumber;

	//pokemon fitness measures
	private double fitness;
	private double personalBestFitness;
	private double personalBestHealthProbability;
	private double personalBestAttackProbability;
	private double personalBestDefenseProbability;

	//random number generator
	Random random = new Random();

	/*
	 * Constructor: initializes individual pokemon
	 */
	public Pokemon(int typeOfPokemon, int number, int threshold)
	{
		pokemonName = typeOfPokemon;
		pokemonNumber = number;
		level = 1;
		battlesWon = 0;
		levelUpThreshold = threshold;

		health = 0;
		attack = 0;
		defense = 0;

		maxHealth = 0;
		maxAttack = 0;
		maxDefense = 0;
		updateStats();

		status = 0;
		accuracy = 1.0;
		healthInBattle = 0;
		attackInBattle = 0;
		defenseInBattle = 0;

		//randomly choose 3 doubles between 0 and 1 -> assign those doubles to healthProbability, attackProbability, defenseProbability
		double randomNumber = random.nextDouble();
		healthProbability = randomNumber;

		randomNumber = random.nextDouble();
		attackProbability = randomNumber;

		randomNumber = random.nextDouble();
		defenseProbability = randomNumber;

		double normalize = healthProbability+attackProbability+defenseProbability;

		healthProbability = healthProbability/normalize;
		attackProbability = attackProbability/normalize;
		defenseProbability = defenseProbability/normalize;

		//randomly choose 3 DIFFERENT moves from the ArrayList of possible moves -> assign those moves to move1, move2, move3
		possibleMoves = Move.getPossibleMoves(pokemonName);
		moves = Move.getSelectMoves(possibleMoves, 3);

		//given move combo, assign pokemon to the appropriate neighborhood...
		neighborhoodNumber = Neighborhood.getNeighborhoodNumber(moves, possibleMoves);

		fitness = 0;
		personalBestFitness = 0;
		personalBestHealthProbability = -1;
		personalBestAttackProbability = -1;
		personalBestDefenseProbability = -1;
	}

	/*
	 * Constructor: initializes new baby pokemon 
	 */
	public Pokemon(int typeOfPokemon, int number, int parent1Level, int parent2Level, int threshold, double[] newProbabilities, Move[] newMoves)
	{
		pokemonName = typeOfPokemon;
		pokemonNumber = number;
		level = (parent1Level+parent2Level)/2;
		battlesWon = 0;
		levelUpThreshold = threshold;

		health = 0;
		attack = 0;
		defense = 0;

		maxHealth = 0;
		maxAttack = 0;
		maxDefense = 0;
		updateStats();

		status = 0;
		accuracy = 1.0;
		healthInBattle = 0;
		attackInBattle = 0;
		defenseInBattle = 0;

		//assign probabilities based on parent's probabilities
		healthProbability = newProbabilities[0];
		attackProbability = newProbabilities[1];
		defenseProbability = newProbabilities[2];

		double normalize = healthProbability+attackProbability+defenseProbability;

		healthProbability = healthProbability/normalize;
		attackProbability = attackProbability/normalize;
		defenseProbability = defenseProbability/normalize;
		
		if (Double.isNaN(healthProbability)) 
		{
			healthProbability = 1.0/3.0;
		}
		if (Double.isNaN(attackProbability)) 
		{
			attackProbability =  1.0/3.0;
		}
		if (Double.isNaN(defenseProbability)) 
		{
			defenseProbability =  1.0/3.0;
		}
		
		//assign moves based on parent's moves
		possibleMoves = Move.getPossibleMoves(pokemonName);
		moves = newMoves;

		//given move combo, assign pokemon to the appropriate neighborhood...
		neighborhoodNumber = Neighborhood.getNeighborhoodNumber(moves, possibleMoves);

		fitness = 0;
		personalBestFitness = 0;
		personalBestHealthProbability = -1;
		personalBestAttackProbability = -1;
		personalBestDefenseProbability = -1;
	}

	/*
	 * Updates the status maximum levels
	 */
	public void updateStats()
	{
		switch (pokemonName)
		{
		case EEVEE:
			maxHealth = EEVEE_START_HEALTH+((level-1)*EEVEE_HEALTH_INCREMENT); //max 140
			maxAttack = EEVEE_START_ATTACK+((level-1)*EEVEE_ATTACK_INCREMENT); //max 85
			maxDefense = EEVEE_START_DEFENSE+((level-1)*EEVEE_DEFENSE_INCREMENT); //max 80
			break;

		case PIKACHU:
			maxHealth = PIKACHU_START_HEALTH+((level-1)*PIKACHU_HEALTH_INCREMENT); // max 120
			maxAttack = PIKACHU_START_ATTACK+((level-1)*PIKACHU_ATTACK_INCREMENT); // max 85
			maxDefense = PIKACHU_START_DEFENSE+((level-1)*PIKACHU_DEFENSE_INCREMENT); // max 60
			break;

		case CHARMANDER:
			maxHealth = CHARMANDER_START_HEALTH+((level-1)*CHARMANDER_HEALTH_INCREMENT); // max 125
			maxAttack = CHARMANDER_START_ATTACK+((level-1)*CHARMANDER_ATTACK_INCREMENT); // max 85
			maxDefense = CHARMANDER_START_DEFENSE+((level-1)*CHARMANDER_DEFENSE_INCREMENT); // max 75
			break;

		case MEOWTH:
			maxHealth = MEOWTH_START_HEALTH+((level-1)*MEOWTH_HEALTH_INCREMENT); // max 125
			maxAttack = MEOWTH_START_ATTACK+((level-1)*MEOWTH_ATTACK_INCREMENT); // max 75
			maxDefense = MEOWTH_START_DEFENSE+((level-1)*MEOWTH_DEFENSE_INCREMENT); // max 65
			break;

		case HOUNDOUR:
			maxHealth = HOUNDOUR_START_HEALTH+((level-1)*HOUNDOUR_HEALTH_INCREMENT); // max 130
			maxAttack = HOUNDOUR_START_ATTACK+((level-1)*HOUNDOUR_ATTACK_INCREMENT); // max 90
			maxDefense = HOUNDOUR_START_DEFENSE+((level-1)*HOUNDOUR_DEFENSE_INCREMENT); // max 60
			break;

		case KOFFING:
			maxHealth = KOFFING_START_HEALTH+((level-1)*KOFFING_HEALTH_INCREMENT); //max 125
			maxAttack = KOFFING_START_ATTACK+((level-1)*KOFFING_ATTACK_INCREMENT); //max 95
			maxDefense = KOFFING_START_DEFENSE+((level-1)*KOFFING_DEFENSE_INCREMENT); //max 125
			break;

		default: //ERROR
			maxHealth = -1.0; 
			maxAttack = -1.0; 
			maxDefense = -1.0; 
			break;
		}	
	}

	/*
	 * Initializes battle arrays 
	 */
	public void initializeBattleArrays(int number) 
	{
		battleWins = new boolean[number];
		battleHealth = new double[number]; 
		battleAttack = new double[number]; 
		battleDefense = new double[number];
	}

	/*
	 * Updates the status levels before battles begin
	 */
	public void powerUp()
	{
		health = (maxHealth/2)*(1+healthProbability);
		attack = (maxAttack/2)*(1+attackProbability);
		defense = (maxDefense/2)*(1+defenseProbability);
	}

	/*
	 * Updates the pokemon's level after battles are over
	 */
	public void levelUp(boolean[] battleWon)
	{
		for (int i=0; i<battleWon.length; i++)
		{
			if (battleWon[i]==true)
			{
				battlesWon++;
			}
		}

		if (battlesWon>=levelUpThreshold)
		{
			int amount = battlesWon/levelUpThreshold;	
			level = level+amount;
			battlesWon = battlesWon%levelUpThreshold;
			updateStats();
		}
		
		if (level>=MAX_LEVEL)
		{
			level = MAX_LEVEL;
		}
	}

	/*
	 * Calculates pokemon fitness after completing battles
	 */
	public void calculateFitness(double[] battleHealth, double[] battleAttack, double[] battleDefense, boolean[] battleWon, double[] battleResults)
	{
		double sumHealth = 0;
		double sumAttack = 0;
		double sumDefense = 0;
		double battleStrength = 0;

		for (int i=0; i<battleResults.length; i++)
		{
			sumHealth = sumHealth+battleHealth[i];
			sumAttack = sumAttack+battleAttack[i];
			sumDefense = sumDefense+battleDefense[i];

			if (battleWon[i]==true)
			{
				battleStrength = battleStrength+(1/battleResults[i]);
			}
		}

		double averageHealth = (sumHealth/battleResults.length)/maxHealth;
		double averageAttack = (sumAttack/battleResults.length)/maxAttack;
		double averageDefense = (sumDefense/battleResults.length)/maxDefense;

		fitness = (averageHealth*averageAttack*averageDefense)*level+battleStrength;

		//update personal best if necessary 
		if (fitness>personalBestFitness)
		{
			personalBestFitness = fitness;
			personalBestHealthProbability = healthProbability;
			personalBestAttackProbability = attackProbability;
			personalBestDefenseProbability = defenseProbability;
		}
	}

	/*
	 * Calculates probabilities of individual pokemon after PSO adjustments
	 */
	public void updateProbabilities(Pokemon neighborhoodBest)
	{	
		double healthAdjustment = 0;
		double attackAdjustment = 0;
		double defenseAdjustment = 0;

		//update toward personal best
		healthAdjustment += personalBestHealthProbability*PSO_INCREMENT*sign(healthProbability - personalBestHealthProbability);
		attackAdjustment += personalBestAttackProbability*PSO_INCREMENT*sign(attackProbability - personalBestAttackProbability);
		defenseAdjustment += personalBestDefenseProbability*PSO_INCREMENT*sign(defenseProbability - personalBestDefenseProbability);

		//update toward neighborhood best
		healthAdjustment += neighborhoodBest.getHealthProbability()*PSO_INCREMENT*sign(healthProbability - neighborhoodBest.getHealthProbability());
		attackAdjustment += neighborhoodBest.getAttackProbability()*PSO_INCREMENT*sign(attackProbability - neighborhoodBest.getAttackProbability());
		defenseAdjustment += neighborhoodBest.getDefenseProbability()*PSO_INCREMENT*sign(defenseProbability - neighborhoodBest.getDefenseProbability());

		//"move" probabilities to new position
		healthProbability = healthProbability+healthAdjustment;
		attackProbability = attackProbability+attackAdjustment;
		defenseProbability = defenseProbability+defenseAdjustment;

		//can't have negative probabilities
		if (healthProbability < 0)
		{
			healthProbability = 0;
		}
		if (attackProbability < 0)
		{
			attackProbability = 0;
		}
		if (defenseProbability < 0)
		{
			defenseProbability = 0;
		}

		double normalize = healthProbability+attackProbability+defenseProbability;

		healthProbability = healthProbability/normalize;
		attackProbability = attackProbability/normalize;
		defenseProbability = defenseProbability/normalize;
	}

	/*
	 * Calculates positive/negative sign of a double
	 */
	public double sign(double a)
	{
		if (a == 0)
		{
			return 0.0;
		}
		else if (a > 0)
		{
			return 1.0;
		}
		else
		{
			return -1.0;	
		}
	}

	/*
	 * Exposes pokemon to possible move mutation and/or probability mutation
	 */
	public void mutate(double mutationProbability)
	{
		//new moveRandomDouble between 0 and 1
		double moveRandomDouble = random.nextDouble();
		if (moveRandomDouble<mutationProbability)
		{
			moves = Move.mutateSelectMoves(moves, possibleMoves);
			neighborhoodNumber = Neighborhood.getNeighborhoodNumber(moves, possibleMoves);
		}

		//new probabilityRandomDouble between 0 and 1
		double probabilityRandomDouble = random.nextDouble();
		if (probabilityRandomDouble<mutationProbability)
		{
			double change;

			//new randomBoolean
			if (random.nextBoolean())
			{
				change = 0.1;
			}
			else 
			{
				change = -0.1;
			}

			//new randomNumber
			int randomProbability = random.nextInt(3);
			if (randomProbability==0)
			{
				healthProbability = healthProbability+change;
				if (healthProbability<0)
				{
					healthProbability = 0;
				}
			}
			else if (randomProbability==1)
			{
				attackProbability = attackProbability+change;
				if (attackProbability<0)
				{
					attackProbability = 0;
				}
			}
			else
			{
				defenseProbability = defenseProbability+change;
				if (defenseProbability<0)
				{
					defenseProbability = 0;
				}
			}

			double normalize = healthProbability+attackProbability+defenseProbability;

			healthProbability = healthProbability/normalize;
			attackProbability = attackProbability/normalize;
			defenseProbability = defenseProbability/normalize;
		}
	}

	/*
	 * Prints out pokemon variable values 
	 */
	public void print()
	{
		System.out.println("Pokemon name: " + pokemonName);
		System.out.println("Level: " + level);
		System.out.println("Health: " + maxHealth);
		System.out.println("Attack: " + maxAttack);
		System.out.println("Defense:" + maxDefense);
		System.out.println("Health probability: " + healthProbability);
		System.out.println("Attack probability: " + attackProbability);
		System.out.println("Defense probability: " + defenseProbability);
		System.out.println("Move 1: " +moves[0].getNameOfMove());
		System.out.println("Move 2: " +moves[1].getNameOfMove());
		System.out.println("Move 3: " +moves[2].getNameOfMove());
		System.out.println("Fitness: " + fitness);
		System.out.println();
	}

	/*
	 * Getters and Setters
	 */
	public int getName()
	{
		return pokemonName;
	}

	public int getIDNumber()
	{
		return pokemonNumber;
	}

	public int getLevel()
	{
		return level;
	}

	public void setLevel(int newLevel)
	{
		level = newLevel;
	}

	public int getBattlesWon()
	{
		return battlesWon;
	}

	public void setBattlesWon(int battle)
	{
		battlesWon = battle;
	}

	public int getLevelUpThreshold()
	{
		return levelUpThreshold;
	}

	public int getStatus()
	{
		return status;
	}

	public void setStatus(int newStatus)
	{
		status = newStatus;
	}

	public double getAccuracy()
	{
		return accuracy;
	}

	public void setAccuracy(double newAccuracy)
	{
		accuracy = newAccuracy;
	}

	public double getHealthInBattle()
	{
		return healthInBattle;
	}

	public void setHealthInBattle(double newHealth)
	{
		healthInBattle = newHealth;
	}

	public double getAttackInBattle()
	{
		return attackInBattle;
	}

	public void setAttackInBattle(double newAttack)
	{
		attackInBattle = newAttack;
	}

	public double getDefenseInBattle()
	{
		return defenseInBattle;
	}

	public void setDefenseInBattle(double newDefense)
	{
		defenseInBattle = newDefense;
	}

	public double getHealth()
	{
		return health;
	}

	public double getAttack()
	{
		return attack;
	}

	public void setAttack(double newAttack)
	{
		attack = newAttack;
	}

	public double getDefense()
	{
		return defense;
	}

	public void setDefense(double newDefense)
	{
		defense = newDefense;
	}

	public double getMaxHealth()
	{
		return maxHealth;
	}

	public double getMaxAttack()
	{
		return maxAttack;
	}

	public double getMaxDefense()
	{
		return maxDefense;
	}

	public double getHealthProbability()
	{
		return healthProbability;
	}

	public void setHealthProbability(double hProbability)
	{
		healthProbability = hProbability;
	}

	public double getAttackProbability()
	{
		return attackProbability;
	}

	public void setAttackProbability(double aProbability)
	{
		attackProbability = aProbability;
	}

	public double getDefenseProbability()
	{
		return defenseProbability;
	}

	public void setDefenseProbability(double dProbability)
	{
		defenseProbability = dProbability;
	}

	public double[] getProbabilitiesArray()
	{
		double[] proabilitiesArray = new double[3];
		proabilitiesArray[0] = getHealthProbability();
		proabilitiesArray[1] = getAttackProbability();
		proabilitiesArray[2] = getDefenseProbability();
		return proabilitiesArray;
	}

	public Move[] getPossibleMovesArray()
	{
		return possibleMoves;
	}

	public Move[] getSelectedMovesArray()
	{
		return moves;
	}

	public int getNeighborhoodNumber()
	{
		return neighborhoodNumber;
	}

	public double getFitness()
	{
		return fitness;
	}

	public double getPersonalBest()
	{
		return personalBestFitness;
	}

	public double getPersonalBestHealthProbability() 
	{
		return personalBestHealthProbability;
	}

	public double getPersonalBestAttackProbability() 
	{
		return personalBestAttackProbability;
	}

	public double getPersonalBestDefenseProbability() 
	{
		return personalBestDefenseProbability;
	}



	public boolean[] getBattleWin()
	{
		return battleWins;
	}

	public void setBattleWin(boolean[] wins)
	{
		battleWins = wins.clone();
	}

	public void addBattleWin(int index, boolean win)
	{
		battleWins[index] = win;
	}

	public double[] getBattleHealth()
	{
		return battleHealth;
	} 

	public void setBattleHealth(double[] health)
	{
		battleHealth = health.clone();
	}

	public void addBattleHealth(int index, double health)
	{
		battleHealth[index] = health;
	}

	public double[] getBattleAttack()
	{
		return battleAttack;
	}

	public void setBattleAttack(double[] attack)
	{
		battleAttack = attack.clone();
	}

	public void addBattleAttack(int index, double attack)
	{
		battleAttack[index] = attack;
	}

	public double[] getBattleDefense()
	{
		return battleDefense;
	}

	public void setBattleDefense(double[] defense)
	{
		battleDefense = defense.clone();
	}

	public void addBattleDefense(int index, double defense)
	{
		battleDefense[index] = defense;
	}

}
