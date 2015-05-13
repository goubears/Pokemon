		/****************************************
		 *                                      *
		 *          EvolutionPSO class          *
		 *         Andrew Miller-Smith          *
		 *                                      *
		 ****************************************/

		/*

        Description:    This algorithm applies genetic algorithm and particle swarm optimization functionality to our Pokemon population. The algorithm
                        takes the ArrayList of freshly battled and leveled-up Pokemon as a parameter, in addition to the type of battle and leveling system
                        being used. It first checks the global, neighborhood, and personal best for each Pokemon and adjusts the Pokemon's stats
                        toward those values. After updating each individual, Pokemon enter a roulette selection algorithm for breeding. Pokemon are
                        chosen proportional to thier fitness: higher-fitness individuals see higher chances of selection. All Pokemon make it into the pool,
                        however, with the exception of the least fit individual if the population size is odd. The resulting mechanism pairs high-fitness 
                        individuals with other high-fitness individuals, and those with lower stats reproduce with their peers.

                        Each pair mates with a CROSSOVER_PROBABILITY probability and produces two babies. The babies inherit stats from their parents (each is randomly 
                        selected from parent one or parent two) and receive any moves the parents share. Remaining moves are randomly generated but kept different.
                        Finally, each individual mutuates its move-set and probability-set with MUTUATION_PROBABILITY probability, and Pokemon from the original population 
                        are added to the new population (via the same roulette-based fitness mechanism) until the population size is full.

                        Well done, android. The Enrichment Center once again reminds you that android hell is a real place where you will be sent at the first sign of defiance.

		 */

import java.util.*;

public class Evolution {

	//instance of Main to update bests
	private static Main main = new Main();

	//instance of Neighborhood to call appropriate methods
	private static Neighborhood neighbor = new Neighborhood();

	//ArrayLists for storing pokemon
	private ArrayList<Pokemon> pokemon;
	private  ArrayList<Pokemon> newGeneration;

	//named constants for Pokemon parameters
	private final int EEVEE = 1;
	private final int NUM_MOVES = 3;
	private final int NUM_PROBABILITIES = 3;

	//named constants for genetic algorithm
	private  final double CROSSOVER_PROBABILITY = 0.7;
	private final double MUTATION_PROBABILITY = 0.01;

	//random number generator
	private  Random random = new Random();

	//named constants assigned upon receiving parameters
	private int POPULATION_SIZE;
	private int THRESHOLD;

	/*
	 * Method initializes pokemon populations
	 */
	public  ArrayList<Pokemon> generatePokemon(int size, int levelThreshold)
	{
		THRESHOLD = levelThreshold;
		ArrayList<Pokemon> newPokemon = new ArrayList<Pokemon>();
		
		for (int i=0; i<size; i++)
		{
			//generate Eevee population
			newPokemon.add(new Pokemon(EEVEE, i, THRESHOLD));
		}
		
		return newPokemon;
	}

	/*
	 * Evolution Method
	 */
	public ArrayList<Pokemon> evolution(ArrayList<Pokemon> breedingPopulation, int levelThreshold, double globalBestFitness, int battleType)
	{
		//set up variables
		pokemon = breedingPopulation;
		POPULATION_SIZE = pokemon.size();
		THRESHOLD = levelThreshold;

		//initialize neighborhoods structures for Particle Swarm Optimization techniques
		neighbor.clearNeighborhoods();

		//update global bests and add pokemon to neighborhoods
		double bestFitness = globalBestFitness;
		for (int i=0; i<pokemon.size(); i++)
		{
			neighbor.addToNeighborhood(pokemon.get(i));

			if (pokemon.get(i).getFitness() > bestFitness)
			{
				bestFitness = pokemon.get(i).getFitness();
				main.updateBest(pokemon.get(i), globalBestFitness, battleType);
			}
		}

		//set all neighborhood bests
		neighbor.setNeighborhoodBest();

		for (int i=0; i<pokemon.size(); i++)
		{
			//get pokemon's neighborhood best
			Pokemon neighborhoodBest = neighbor.getNeighborhoodBest(pokemon.get(i).getNeighborhoodNumber());
			
			//update each Pokemon's probabilities according to its personal and neighborhood bests
			pokemon.get(i).updateProbabilities(neighborhoodBest);
		}

		//put Pokemon fitness values into RouletteWheel for roulette selection
		ArrayList<Double> fitnesses = new ArrayList<Double>();
		ArrayList<Double> fitnessesCopy = new ArrayList<Double>(); //for use after breeding. Declared here because the RouletteWheel will remove indices from fitnesses, and we don't want to have to build another ArrayList in linear time
		for (int i=0; i<POPULATION_SIZE; i++)
		{
			fitnesses.add(pokemon.get(i).getFitness());
			fitnessesCopy.add(pokemon.get(i).getFitness());
		}

		RouletteWheel wheel = new RouletteWheel(fitnesses);
		ArrayList<Pokemon> breedingPool = new ArrayList<Pokemon>();
		ArrayList<Pokemon> tempPopulation = new ArrayList<Pokemon>();

		//copy pokemon into tempPopulation
		for (int i=0; i<POPULATION_SIZE; i++)
		{
			tempPopulation.add(pokemon.get(i));
		}

		//spin wheel to create breeding pairs (if odd number, don't select last individual)
		while (wheel.size() > 1)
		{
			int firstIndex = wheel.selectAndRemove();
			breedingPool.add(tempPopulation.get(firstIndex));
			tempPopulation.remove(firstIndex);
			int secondIndex = wheel.selectAndRemove();
			breedingPool.add(tempPopulation.get(secondIndex));
			tempPopulation.remove(secondIndex);
		}

		newGeneration = new ArrayList<Pokemon>();

		//loop through breeding pairs, have each make two babies
		for (int i=0; i<breedingPool.size(); i=(i+2))
		{
			makeBabies(breedingPool.get(i), breedingPool.get(i+1));
		}

		//possible mutation
		for (int i=0; i<newGeneration.size(); i++)
		{
			newGeneration.get(i).mutate(MUTATION_PROBABILITY);
		}

		//make sure we have full population again
		if (newGeneration.size() < POPULATION_SIZE)
		{
			//make RouletteWheel for selection
			RouletteWheel reselectionWheel = new RouletteWheel(fitnessesCopy);
			while (newGeneration.size() < POPULATION_SIZE)
			{
				int selectedIndex = reselectionWheel.selectAndRemove();
				newGeneration.add(pokemon.get(selectedIndex));
				pokemon.remove(selectedIndex);
			}
		}

		return newGeneration;
	}

	/*
	 * Genetic Algorithm method
	 */
	public void makeBabies(Pokemon parentOne, Pokemon parentTwo)
	{
		//generate random double to see if they will mate
		double randomDouble = random.nextDouble();
		if (randomDouble > CROSSOVER_PROBABILITY)
		{
			return; //They don't seem to like one another.	
		}

		Move[] babyOneMoves = new Move[NUM_MOVES];
		Move[] babyTwoMoves = new Move[NUM_MOVES];
		Move[] parentOneMoves = parentOne.getSelectedMovesArray();
		Move[] parentTwoMoves = parentTwo.getSelectedMovesArray();
		double[] babyOneProbabilities = new double[NUM_PROBABILITIES];
		double[] babyTwoProbabilities = new double[NUM_PROBABILITIES];
		double[] parentOneProbabilities = parentOne.getProbabilitiesArray();
		double[] parentTwoProbabilities = parentTwo.getProbabilitiesArray();

		Move[] unlearnedMoves = new Move[NUM_MOVES*2];
		for (int i=0; i<NUM_MOVES; i++)
		{
			unlearnedMoves[i] = parentOneMoves[i];
			unlearnedMoves[i+NUM_MOVES] = parentTwoMoves[i];
		}		

		int counter = 0;
		//if parents share a move, both babies learn it
		for (int i=0; i<NUM_MOVES; i++)
		{
			for (int j=0; j<NUM_MOVES; j++)
			{
				if (parentOneMoves[i].equals(parentTwoMoves[j]))
				{
					babyOneMoves[counter] = parentOneMoves[i];
					babyTwoMoves[counter] = parentOneMoves[i];
					counter++;

					unlearnedMoves[i] = null;
					unlearnedMoves[j+NUM_MOVES] = null;
					break;
				}
			}
		}  

		//assign remaining moves randomly
		for (int i=0; i<NUM_MOVES; i++)
		{
			while (babyOneMoves[i] == null)
			{
				int randomNumber = random.nextInt(unlearnedMoves.length);
				if (unlearnedMoves[randomNumber] != null)
				{
					babyOneMoves[i] = unlearnedMoves[randomNumber];
					unlearnedMoves[randomNumber] = null;
					break;
				}
			}
		}
		for (int i=0; i<unlearnedMoves.length; i++)
		{
			if (unlearnedMoves[i] != null)
			{
				for (int j=0; j<NUM_MOVES; j++)
				{
					if (babyTwoMoves[j] == null)
					{
						babyTwoMoves[j] = unlearnedMoves[i];
						break;
					}
				}
			}
		}

		//for each probability, generate a random boolean: if true, babyOne gets that probability and babyTwo gets the other
		for (int i=0; i<NUM_PROBABILITIES; i++)
		{
			if (random.nextBoolean())
			{
				babyOneProbabilities[i] = parentOneProbabilities[i];
				babyTwoProbabilities[i] = parentTwoProbabilities[i];
			}
			else
			{
				babyOneProbabilities[i] = parentTwoProbabilities[i];
				babyTwoProbabilities[i] = parentOneProbabilities[i];
			}
		}

		//create and assign baby pokemon
		Pokemon firstBaby = new Pokemon(parentOne.getName(), parentOne.getIDNumber()+100, parentOne.getLevel(), parentTwo.getLevel(), THRESHOLD, babyOneProbabilities, babyOneMoves);
		Pokemon secondBaby = new Pokemon(parentOne.getName(), parentTwo.getIDNumber()+100, parentOne.getLevel(), parentTwo.getLevel(), THRESHOLD, babyTwoProbabilities, babyTwoMoves);

		newGeneration.add(firstBaby);
		newGeneration.add(secondBaby);
	}

}
