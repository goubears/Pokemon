import java.io.*;
import java.util.*;


public class Main {

	private static EvolutionPSO pso = new EvolutionPSO();
	private static Battle battle = new Battle();
	private static Neighborhood neighbor = new Neighborhood();
	private static Coevolution coevol;

	//variables for tracking best Pokemon
	private static Pokemon globalBestHybrid;
	private static double bestFitnessHybrid = Double.NEGATIVE_INFINITY;
	private static Pokemon globalBestCoevolutionOne;
	private static double bestFitnessCoevolutionOne = Double.NEGATIVE_INFINITY;
	private static Pokemon globalBestCoevolutionTwo;
	private static double bestFitnessCoevolutionTwo = Double.NEGATIVE_INFINITY;

	//tracker for highest level
	private static int highestLevel = Integer.MIN_VALUE;

	//vectors for the three pokemon populations
	private static Vector<Pokemon> hybrid;
	private static Vector<Pokemon> coevolutionOne;
	private static Vector<Pokemon> coevolutionTwo;

	//command line arguments
	private static int populationSize;
	private static int iterations;

	private static final int LEVELUP_THRESHOLD = 3;
	private static final int HYBRID = 0;
	private static final int COEVOLUTION_ONE = 1;
	private static final int COEVOLUTION_TWO = 2;
	private static long duration;

	//main method
	public static void main(String[] args) 
	{
		//read in from command line
		populationSize = Integer.parseInt(args[0]);
		iterations = Integer.parseInt(args[1]);

		//create an initial populations
		hybrid = pso.generatePokemon(populationSize);
		coevolutionOne = pso.generatePokemon((int)(populationSize/2));
		//System.out.println("Population size: " + populationSize);
		coevolutionTwo = pso.generatePokemon((int)(populationSize/2));

		//START OF CYCLE
		int numIterations = 0;
		//start timer
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        duration = 0;

		while (numIterations < iterations){

			//send pokemon populations into battle
			hybrid = battle.hybridBattle(hybrid);
			coevol = battle.coevolutionBattle(coevolutionOne, coevolutionTwo);
			coevolutionOne = coevol.getEevee1();
			coevolutionTwo = coevol.getEevee2();

			//genetic algorithm and PSO
			hybrid = pso.evolutionPSO(hybrid, LEVELUP_THRESHOLD, HYBRID);
			coevolutionOne = pso.evolutionPSO(coevolutionOne, LEVELUP_THRESHOLD, COEVOLUTION_ONE);
			coevolutionTwo = pso.evolutionPSO(coevolutionTwo, LEVELUP_THRESHOLD, COEVOLUTION_TWO);

			numIterations++;
		}

		//update time
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);

		//print out our findings
        System.out.println("\n******************* Elitist Ant Algorithm Results *******************");
        System.out.println("Please note that we have added a consequence for failure. Any contact with the chamber floor will result in an 'unsatisfactory' mark on your official testing record, followed by death. Good luck!");
        //we'll need to print out the name of the file we are reading. This should come from the user-input parsing part...maybe make it a global variable?

        //same for NUM_VARIABLES and number of clauses
        System.out.println("Number of Pokemon: " + populationSize);
        System.out.println("Number of iterations: " + iterations);
        
        // if (bestLength < TARGET_OPTIMUM)
        // {
        //     System.out.println("Target optimum reached early.");   
        // }    
        
        // if (duration > TIME_LIMIT)
        // {
        //     System.out.println("Time limit reached.");
        // }
       
        System.out.println("Hybrid battle best pokemon: ");
        globalBestHybrid.print();
        System.out.println("Coevolution one battle best pokemon: ");
        globalBestCoevolutionOne.print();
        System.out.println("Coevolution two battle best pokemon: ");
        globalBestCoevolutionTwo.print();
        
        System.out.println("\nThis method took: " + duration + " milliseconds.");

	}


	//function for EvolutionPSO to update global bests
	public static void updateBest(Pokemon best, int population){

		if (population == HYBRID){
			globalBestHybrid = best;
			bestFitnessHybrid = best.getFitness();
		}
		else if (population == COEVOLUTION_ONE){
			globalBestCoevolutionOne = best;
			bestFitnessCoevolutionOne = best.getFitness();
		}
		else if (population == COEVOLUTION_TWO){
			globalBestCoevolutionTwo = best;
			bestFitnessCoevolutionTwo = best.getFitness();
		}
	}
	
}
