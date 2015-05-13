		/****************************************
         *                                      *
         *           PokemonEvolution           *
         *         Andrew Miller-Smith          *
         *                                      *
         ****************************************/

        /*

        Description:    Well done, android. The Enrichment Center once again reminds you that android 
        				hell is a real place where you will be sent at the first sign of defiance.

        */

import java.util.*;

public class Main {

	private static Evolution evo = new Evolution();
	private static Coevolution coevo;
	private static Battle battle = new Battle();

	//variables for tracking best Pokemon
	private static Pokemon globalBestHybrid;
	private static Pokemon globalBestCoevolutionOne;
	private static Pokemon globalBestCoevolutionTwo;
	private static double bestHybridFitness = 0;
	private static double bestCoevolutionOneFitness = 0;
	private static double bestCoevolutionTwoFitness = 0;
	
	//variables for tracking pokemon level
	private static final int MAX_LEVEL = 50;
	private static boolean hybridMaxLevelReached = false;
	private static boolean coevolutionMaxLevelReached = false;
	private static boolean bothMaxLevelsReached = false;

	//ArrayLists for the three pokemon populations
	private static ArrayList<Pokemon> hybrid;
	private static ArrayList<Pokemon> coevolutionOne;
	private static ArrayList<Pokemon> coevolutionTwo;

	//command line arguments
	private static int populationSize; //100
	private static int iterations; //100

	//variables for Evolution algorithm
	private static final int LEVELUP_THRESHOLD_HYBRID = 3;
	private static final int LEVELUP_THRESHOLD_COEVOLUTION = 30;
	private static final int HYBRID = 0;
	private static final int COEVOLUTION_ONE = 1;
	private static final int COEVOLUTION_TWO = 2;
	
	//timer
	private static long duration;

	//MAIN METHOD
	public static void main(String[] args) 
	{
		//read in from command line
		populationSize = Integer.parseInt(args[0]);
		iterations = Integer.parseInt(args[1]);
		
		//create initial populations
		hybrid = evo.generatePokemon(populationSize, LEVELUP_THRESHOLD_HYBRID);
		coevolutionOne = evo.generatePokemon(populationSize/2, LEVELUP_THRESHOLD_COEVOLUTION);
		coevolutionTwo = evo.generatePokemon(populationSize/2, LEVELUP_THRESHOLD_COEVOLUTION);
		
		//START OF CYCLE
		int numberOfIterations = 0;
		
		//start timer
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        duration = 0;
 
		while (numberOfIterations < iterations && bothMaxLevelsReached == false)
		{			
			if (!hybridMaxLevelReached)
			{
				//send pokemon population into battle
				hybrid = battle.hybridBattle(hybrid);
				
				//genetic algorithm and PSO
				hybrid = evo.evolution(hybrid, LEVELUP_THRESHOLD_HYBRID, bestHybridFitness, HYBRID);
			}
			
			if (!coevolutionMaxLevelReached)
			{
				//send pokemon populations into battle
				coevo = battle.coevolutionBattle(coevolutionOne, coevolutionTwo);
				coevolutionOne = coevo.getEevee1();
				coevolutionTwo = coevo.getEevee2();
				
				//genetic algorithm and PSO
				coevolutionOne = evo.evolution(coevolutionOne, LEVELUP_THRESHOLD_COEVOLUTION, bestCoevolutionOneFitness, COEVOLUTION_ONE);	
				coevolutionTwo = evo.evolution(coevolutionTwo, LEVELUP_THRESHOLD_COEVOLUTION, bestCoevolutionTwoFitness, COEVOLUTION_TWO);
			}

			//check if any Pokemon has leveled up to 50
			if (globalBestHybrid.getLevel() >= MAX_LEVEL)
			{
				hybridMaxLevelReached = true;
			}
			if (globalBestCoevolutionOne.getLevel() >= MAX_LEVEL || globalBestCoevolutionTwo.getLevel() >= MAX_LEVEL)
			{
				coevolutionMaxLevelReached = true;
			}
			if (hybridMaxLevelReached && coevolutionMaxLevelReached)
			{
				bothMaxLevelsReached = true;
			}
			
			numberOfIterations++;
		}
		//END OF CYCLE

		//update time
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);

		//print out our findings
        System.out.println("\n******************* Genetic Algorithm and Pokemon Swarm Optimization Results *******************");

        //print out the population size
        System.out.println("Number of Pokemon: " + populationSize);   
        
        //print reason for stopping
        if (bothMaxLevelsReached)
        {
        	System.out.println("Max Level Reached: Max level (" + MAX_LEVEL + ") reached after " + numberOfIterations + " iterations.");
        }
        else
        {
        	System.out.println("Number of iterations: " + numberOfIterations);
        }
       
        System.out.println();
        System.out.println("Hybrid battle best pokemon: ");
        globalBestHybrid.print();
        
        System.out.println();
        System.out.println("Coevolution group-one best pokemon: ");
        globalBestCoevolutionOne.print();
        
        System.out.println();
        System.out.println("Coevolution group-two best pokemon: ");
        globalBestCoevolutionTwo.print();
        
        System.out.println();
        System.out.println("This method took: " + duration + " milliseconds.");
	}
	
	//function for Evolution to update global bests
	public static void updateBest(Pokemon bestPokemon, double bestFitness, int population)
	{
		if (population == HYBRID)
		{
			globalBestHybrid = bestPokemon;
			bestHybridFitness = globalBestHybrid.getPersonalBest();
		}
		else if (population == COEVOLUTION_ONE)
		{
			globalBestCoevolutionOne = bestPokemon;
			bestCoevolutionOneFitness = globalBestCoevolutionOne.getPersonalBest();
		}
		else if (population == COEVOLUTION_TWO)
		{
			globalBestCoevolutionTwo = bestPokemon;
			bestCoevolutionTwoFitness = globalBestCoevolutionTwo.getPersonalBest();
		}
	}
	
}
