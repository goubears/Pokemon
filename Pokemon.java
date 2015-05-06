
import java.util.*;
	
//Make getters and setters

public class Pokemon {

	private Neighborhood neighborhood = new Neighborhood();

	private double MAX_LEVEL = 50;

	private int pokemonName;
	final private int EEVEE = 1; //oddly enough was missing this
	final private int PIKACHU = 2;
	final private int CHARMANDER = 3;
	final private int MEOWTH = 4;
	final private int HOUNDOUR = 5;
	final private int KOFFING = 6;

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

	private int level;
	private int battlesWon;
	private int levelUpThreshold;

	private double health;
	private double attack;
	private double defense;

	private double maxHealth;
	private double maxAttack;
	private double maxDefense;

	private double healthProbability;
	private double attackProbability;
	private double defenseProbability;
	private double[] probabilitiesArray = new double[3];

	private Move move1;
	private Move move2;
	private Move move3;
	private Move[] movesArray = new Move[3];

	private double fitness;
	private double personalBest;

	//random number generator
	Random random = new Random();

	//initial constructor. TO GENERATE POKEMON, CREATE INSTANCE OF MOVE myMove AND CALL Pokemon(INT_NAME, ALGORITHM, myMove.getPossibleMoves(INT_NAME)) - AMS
	public Pokemon(int typeOfPokemon, int algorithm, Move[] possibleMoves)
	{
		pokemonName = typeOfPokemon;
		level = 1;
		battlesWon = 0;
		levelUpThreshold = algorithm;

		health = 0;
		attack = 0;
		defense = 0;

		maxHealth = 0;
		maxAttack = 0;
		maxDefense = 0;
		updateStats();

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

		//randomly choose 3 DIFFERENT moves from the vector of possible moves -> assign those moves to move1, move2, move3
		int randomInteger = random.nextInt(possibleMoves.length);
		move1 = possibleMoves[randomInteger];

		boolean moveChanged = false;
		while (moveChanged==false)
		{
			randomInteger = random.nextInt(possibleMoves.length);
			if (move1!=possibleMoves[randomInteger])
			{
				move2 = possibleMoves[randomInteger];
				moveChanged = true;
			}
		}	

		moveChanged = false;
		while (moveChanged==false)
		{
			randomInteger = random.nextInt(possibleMoves.length);
			if (move1!=possibleMoves[randomInteger] && move2!=possibleMoves[randomInteger])
			{
				move3 = possibleMoves[randomInteger];
				moveChanged = true;
			}
		}	

		//given move combo, assign to the appropriate neighborhood...
		//neighborhood = getNeighborhood(move1, move2, move3);

		fitness = 0;
		personalBest = 0;

		movesArray[0] = move1;
		movesArray[1] = move2;
		movesArray[2] = move3;

		probabilitiesArray[0] = healthProbability;
		probabilitiesArray[1] = attackProbability;
		probabilitiesArray[2] = defenseProbability;
	}

	//new baby (result of crossover) constructor 
	public Pokemon(int typeOfPokemon, int parent1Level, int parent2Level, int algorithm, 
			double parentHealthProbability, double parentAttackProbability, double parentDefenseProbability, 
			Move parentMove1, Move parentMove2, Move parentMove3)
	{
		pokemonName = typeOfPokemon;
		level = (parent1Level+parent2Level)/2;
		battlesWon = 0;
		levelUpThreshold = algorithm;

		health = 0;
		attack = 0;
		defense = 0;

		maxHealth = 0;
		maxAttack = 0;
		maxDefense = 0;
		updateStats();

		//assign probabilities based on parent's probabilities
		healthProbability = parentHealthProbability;
		attackProbability = parentAttackProbability;
		defenseProbability = parentDefenseProbability;

		double normalize = healthProbability+attackProbability+defenseProbability;

		healthProbability = healthProbability/normalize;
		attackProbability = attackProbability/normalize;
		defenseProbability = defenseProbability/normalize;

		//assign moves based on parent's moves
		move1 = parentMove1;
		move2 = parentMove2;
		move3 = parentMove3;

		//given move combo, assign to the appropriate neighborhood...
		//neighborhood = getNeighborhood(move1, move2, move3);

		fitness = 0;
		personalBest = 0;


		movesArray[0] = move1;
		movesArray[1] = move2;
		movesArray[2] = move3;

		probabilitiesArray[0] = healthProbability;
		probabilitiesArray[1] = attackProbability;
		probabilitiesArray[2] = defenseProbability;
	}

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
	 * STILL NEED TO CODE:
	 */
	//private Neighborhood getNeighborhood(Move firstMove, Move secondMove, Move thirdMove) 
	// {
	// 	return null;
	// }

	public void powerUp()
	{
		health = (maxHealth/2)*(1+healthProbability);
		attack = (maxAttack/2)*(1+attackProbability);
		defense = (maxDefense/2)*(1+defenseProbability);
	}

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
	}

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

		fitness = (averageHealth*averageAttack*averageDefense)+battleStrength;

		//update personal best if necessary 
		if (fitness>personalBest)
		{
			personalBest = fitness;
		}
	}

	/*
	 * STILL NEED TO CODE
	 */
	public void moveProbabilities()
	{
		//PSO stuff...
		//use personal best
		//use neighborhood best
		//move toward optimal

		double healthAdjustment = 0;
		double attackAdjustment = 0;
		double defenseAdjustment = 0;

		healthProbability = healthProbability+healthAdjustment;
		attackProbability = attackProbability+attackAdjustment;
		defenseProbability = defenseProbability+defenseAdjustment;

		double normalize = healthProbability+attackProbability+defenseProbability;

		healthProbability = healthProbability/normalize;
		attackProbability = attackProbability/normalize;
		defenseProbability = defenseProbability/normalize;
	}

	public void mutate(double mutationProbability, Move[] possibleMoves)
	{
		//new moveRandomDouble between 0 and 1
		double moveRandomDouble = random.nextDouble();
		if (moveRandomDouble<mutationProbability)
		{
			boolean moveChanged = false;
			while (moveChanged==false)
			{
				//new randomMove
				int randomMove = random.nextInt(possibleMoves.length);
				if (move1!=possibleMoves[randomMove] && move2!=possibleMoves[randomMove] && move3!=possibleMoves[randomMove])
				{
					//new randomNumber
					int randomNumber = random.nextInt(3);
					if (randomNumber==0)
					{
						move1 = possibleMoves[randomMove];
					}
					else if (randomNumber==1)
					{
						move2 = possibleMoves[randomMove];
					}
					else
					{
						move3 = possibleMoves[randomMove];
					}

					moveChanged = true;
				}
			}	
		}

		//new probabilityRandomDouble between 0 and 1
		double probabilityRandomDouble = random.nextDouble();
		if (probabilityRandomDouble<mutationProbability)
		{
			double change;

			//new randomBoolean
			boolean randomBoolean = random.nextBoolean();
			if (randomBoolean)
			{
				change = 0.1;
			}
			else 
			{
				change = -0.1;
			}

			//new randomNumber: 1-3
			int randomProbability = random.nextInt(3);
			if (randomProbability==1)
			{
				healthProbability = healthProbability+change;
			}
			else if (randomProbability==2)
			{
				attackProbability = attackProbability+change;
			}
			else
			{
				defenseProbability = defenseProbability+change;
			}

			double normalize = healthProbability+attackProbability+defenseProbability;

			healthProbability = healthProbability/normalize;
			attackProbability = attackProbability/normalize;
			defenseProbability = defenseProbability/normalize;
		}
	}

	public void print(){
		System.out.println("Pokemon name: " + pokemonName);
		System.out.println("Level: " + level);
		System.out.println("Health: " + maxHealth);
		System.out.println("Attack: " + maxAttack);
		System.out.println("Defense:" + maxDefense);
		System.out.println("Health probability: " + healthProbability);
		System.out.println("Attack probability: " + attackProbability);
		System.out.println("Defense probability: " + defenseProbability);
		System.out.println("Fitness: " + fitness);
		System.out.println("Move 1: " + move1.getMoveName());
		System.out.println("Move 2: " + move2.getMoveName());
		System.out.println("Move 3: " + move3.getMoveName());
		System.out.println();
	}

	public Move getMoveOne(){
		return move1;
	}
	public Move getMoveTwo(){
		return move2;
	}
	public Move getMoveThree(){
		return move3;
	}
	public int getLevel(){
		return level;
	}
	public int getBattlesWon(){
		return battlesWon;
	}
	public void setBattlesWin(int battle){
		battlesWon = battle;
	}
	public double getHealth(){
		return health;
	}
	public void setHealth(double hp){
		health = hp;
	}
	public double getAttack(){
		return attack;
	}
	public double getDefense(){
		return defense;
	}
	public double getHealthProbability(){
		return healthProbability;
	}
	public double getAttackProbability(){
		return attackProbability;
	}
	public double getDefenseProbability(){
		return defenseProbability;
	}
	public double getFitness(){
		return fitness;
	}
	public double getPersonalBest(){
		return personalBest;
	}
	public int getName(){
		return pokemonName;
	}
	public double getMaxHealth(){
		return maxHealth;
	}
	public double getMaxAttack(){
		return maxAttack;
	}
	public double getMaxDefense(){
		return maxDefense;
	}
	public void setFitness(double fit){
		fitness = fit;
	}
	public Move[] getMovesArray(){
		return movesArray;
	}
	public double[] getProbabilitiesArray(){
		return probabilitiesArray;
	}

/*
private int level;
	private int battlesWon;
	private int levelUpThreshold;

	private double health;
	private double attack;
	private double defense;

	private double maxHealth;
	private double maxAttack;
	private double maxDefense;

	private double healthProbability;
	private double attackProbability;
	private double defenseProbability;

	private Move move1;
	private Move move2;
	private Move move3;

	//private Neighborhood neighborhood;

	private double fitness;
	private double personalBest;
	*/
}
