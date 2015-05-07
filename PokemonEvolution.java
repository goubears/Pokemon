		/****************************************
         *                                      *
         *           PokemonEvolution           *
         *         Andrew Miller-Smith          *
         *                                      *
         ****************************************/

        /*

        Description:    

                        Well done, android. The Enrichment Center once again reminds you that android hell is a real place where you will be sent at the first sign of defiance.

        */

import java.io.*;
import java.util.*;


public class PokemonEvolution {

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
	private static final int MAX_LEVEL = 50;
	private static boolean maxLevelReached = false;

	//tracker for highest level
	private static int highestLevel = Integer.MIN_VALUE;

	//vectors for the three pokemon populations
	private static Vector<Pokemon> hybrid;
	private static Vector<Pokemon> coevolutionOne;
	private static Vector<Pokemon> coevolutionTwo;

	//command line arguments
	private static int populationSize;
	private static int iterations;

	//variables for PSOEvolution algorithm
	private static final int LEVELUP_THRESHOLD_HYBRID = 2;
	private static final int LEVELUP_THRESHOLD_COEVOLUTION = 25;
	private static final int HYBRID = 0;
	private static final int COEVOLUTION_ONE = 1;
	private static final int COEVOLUTION_TWO = 2;
	
	//timer
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

			//if any Pokemon has leveled up to 50, stop
			if (numIterations > 0){
				if (globalBestHybrid.getLevel() >= MAX_LEVEL || globalBestCoevolutionOne.getLevel() >= MAX_LEVEL || globalBestCoevolutionTwo.getLevel() >= MAX_LEVEL){
					maxLevelReached = true;
					break;
				}
			}


			//send pokemon populations into battle
			hybrid = battle.hybridBattle(hybrid);
			coevol = battle.coevolutionBattle(coevolutionOne, coevolutionTwo);
			coevolutionOne = coevol.getEevee1();
			coevolutionTwo = coevol.getEevee2();

			//genetic algorithm and PSO
			hybrid = pso.evolutionPSO(hybrid, LEVELUP_THRESHOLD_HYBRID, HYBRID);
			coevolutionOne = pso.evolutionPSO(coevolutionOne, LEVELUP_THRESHOLD_COEVOLUTION, COEVOLUTION_ONE);
			coevolutionTwo = pso.evolutionPSO(coevolutionTwo, LEVELUP_THRESHOLD_COEVOLUTION, COEVOLUTION_TWO);

			numIterations++;
		}

		//update time
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime);

		//print out our findings
        System.out.println("\n******************* Genetic Algorithm and Pokemon Swarm Optimization Results *******************");
        System.out.println("The Enrichment Center reminds you that the Weighted Companion Cube cannot speak. In the event that the Weighted Companion Cube does speak, the Enrichment Center urges you to disregard its advice.");
        //we'll need to print out the name of the file we are reading. This should come from the user-input parsing part...maybe make it a global variable?

        //same for NUM_VARIABLES and number of clauses
        System.out.println("Number of Pokemon: " + populationSize);   
        
        //print if we have reached max level
        if (maxLevelReached == true){
        	System.out.println("Max Level Reached: Max level (" + MAX_LEVEL + ") reached after " + numIterations + " iterations.");
        }
        else{
        	System.out.println("Number of iterations: " + numIterations);
        }
       
        System.out.println("\nHybrid battle best pokemon: ");
        globalBestHybrid.print();
        System.out.println("\nCoevolution one battle best pokemon: ");
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
