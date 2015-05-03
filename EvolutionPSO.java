		/****************************************
         *                                      *
         *          EvolutionPSO class          *
         *         Andrew Miller-Smith          *
         *                                      *
         ****************************************/

        /*

        Description:    This algorithm simulates Ant Colony Optimization on the traveling salesman problem. Paths are constructed between cities, and ants
                        walk these paths to complete tours. After each tour is complete, paths receive pheromone updates. Updates are proportional to the
                        frequency which which the ants use the path. Paths on the shortest tour receive extra boosts in order to steer the ants toward
                        the best current solution. Pheromone evaporates over time.

                        The Enrichment Center promises to always provide a safe testing environment. In dangerous testing environments, 
                        the Enrichment Center promises to always provide useful advice. For instance, the floor here will kill you. Try to avoid it.
        */

import java.util.*;
import java.io.*;
import java.util.Random;

public class EvolutionPSO {
	
    //Vectors and arrays for storing tours the ants make and paths between cities
    private static Vector<Pokemon> pokemon;
    
    //private static int NUM_ITERATIONS;

    //time limit to stop algorithm. set at eight minutes (ms)
    private static final long TIME_LIMIT = 480000;

    //random number generators
    private static Random rand = new Random();

    //named constants assigned upon receiving parameters
    private static int NUM_ITERATIONS = 50;
    private static int totalIterations;
    private static long duration;

    // public static void evolutionPSO(Vector<Pokemon> breedingPopulation, int iterations)
    // {
    //     //set up variables
    //     pokemon = breedingPopulation;
    //     NUM_ITERATIONS = iterations;

    public static void main (String[] args){
        
        System.out.println("Entered main function.");
        //start timer
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        duration = 0;

        //update time
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime)/1000;

        //update each Pokemon's stats according to its personal and global bests
        for (int i = 0; i < pokemon.size(); i++){
        	pokemon.get(i).moveProbabilities();
        }
		
		//SELECTION
		//use fitness values to make a roulette wheel (pre-existing java function - google it)


		
		//"spin" the wheel -> an individual will be chosen, and they become parent 1
		//remove parent 1 from the wheel (1 less individual in the wheel, so all remaining sections of the wheel get proportionally larger to keep the wheel whole)
		//"spin" the wheel again -> an individual will be chosen, and they become parent 2
		//remove parent 2 from the wheel
		//these two are now a mating pair -> store them together for later
		//continue spinning the wheel and making pairings until the wheel is empty 
			//if there's an odd number and a single unmated individual is left, then discard it
		
		//CROSSOVER
		//if a random double is below the probability 0.7, then the pair mate to create two babies
		
		//determine which baby gets which moves
			//if both parents have the same move(s), then that move(s) goes to each baby
			//for the remaining different moves, randomly assign each move to one of the babies until both babies have 3 moves and there are no parent moves remaining 
		//determine which baby gets which probabilities
			//random boolean - if true, baby 1 get's probability from parent 1; if false, baby 1 get's probability from parent 2 
			//baby 2 gets whatever baby 1 doesn't get
			//do this 3 times for the 3 different probabilities
		//now that you have each babies' moves and probabilities, pass those values along to the "pokemon baby constructor" (method in pokemon class)
		
		//MUTATION
		//take your newly constructed babies, and (with a probability of 0.01) expose them to mutation (method already in pokemon class)
		
		//POPULATION
		//the new population should all be new babies
			//do the individuals total up to 100? (initial population level)
		//if so, great - continue on
		//if not, select adults to add to the population using a roulette wheel
			//"spin" the wheel -> an individual will be chosen -> remove them from the wheel and add them to the population
			//keep selecting individual adults until the new population level equals the initial population amount

        //print out our findings
        // System.out.println("\n******************* Elitist Ant Algorithm Results *******************");
        // System.out.println("Please note that we have added a consequence for failure. Any contact with the chamber floor will result in an 'unsatisfactory' mark on your official testing record, followed by death. Good luck!");
        //we'll need to print out the name of the file we are reading. This should come from the user-input parsing part...maybe make it a global variable?
        // System.out.println("Name of file: " + FILE_NAME);

        //same for NUM_VARIABLES and number of clauses
        // System.out.println("Number of cities: " + NUM_CITIES);
        // System.out.println("Number of ants: " + NUM_ANTS);
        
        // if (bestLength < TARGET_OPTIMUM)
        // {
        //     System.out.println("Target optimum reached early.");   
        // }    
        
        // if (duration > TIME_LIMIT)
        // {
        //     System.out.println("Time limit reached.");
        // }
       
        // System.out.println("Number of iterations: " + totalIterations);
        
        //we know how many clauses we have satisfied
        // System.out.println("Length of shortest path: " + bestLength);
        
        // System.out.println("\nThis method took: " + duration + " milliseconds.");

    }

    public static int getTotalIterations(){
        return totalIterations;
    }

    public static long getDuration(){
        return duration;
    }

    //method to fill temp cities vector. DON'T GET RID OF ME! I AM A TIMELSS RELIC OF THE PAST
    public static void generatePokemon()
    {
 
    }

}