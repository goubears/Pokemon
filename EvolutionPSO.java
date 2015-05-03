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

    public static void evolutionPSO(Vector<Pokemon> breedingPopulation, int iterations)
    {
        //set up variables
        pokemon = breedingPopulation;
        NUM_ITERATIONS = iterations;
        
        //start timer
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        duration = 0;

            //update time
            endTime = System.currentTimeMillis();
            duration = (endTime - startTime)/1000;

        

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