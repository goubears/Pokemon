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
    private static Vector<Pokemon> pokemon = new Vector<Pokemon>();
    private static Vector<Pokemon> newGeneration = new Vector<Pokemon>();

    private static final int NUM_MOVES = 3;
    private static final int NUM_PROBABILITIES = 3;

    
    //private static int NUM_ITERATIONS;
    private static final double CROSSOVER_PROBABILITY = 0.7;
    private static final double MUTATION_PROBABILITY = 0.01;

    //time limit to stop algorithm. set at eight minutes (ms)
    private static final long TIME_LIMIT = 480000;

    //random number generators
    private static Random rand = new Random();

    //named constants assigned upon receiving parameters
    private static int NUM_ITERATIONS = 50;
    private static int POPULATION_SIZE = 100;
    private static int ALGORITHM = 5;
    private static int totalIterations;
    private static long duration;

    // public static void evolutionPSO(Vector<Pokemon> breedingPopulation, int algo)
    // {
    //     //set up variables
    //     pokemon = breedingPopulation;
    //     ALGORITHM = algo;
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

        generatePokemon();

        //PSO HERE, NEED NEIGHBORHOODS TO BE FINISHED
        //update each Pokemon's stats according to its personal and global bests
        // for (int i = 0; i < pokemon.size(); i++){
        // 	pokemon.get(i).moveProbabilities();
        // }
		
		//put Pokemon fitness values into RouletteWheel for roulette selection
        ArrayList<Double> fitnesses = new ArrayList<Double>();
        for (int i = 0; i < POPULATION_SIZE; i++){
            fitnesses.add(pokemon.get(i).getFitness());
        }

        RouletteWheel wheel = new RouletteWheel(fitnesses);
        ArrayList<Pokemon> breedingPool = new ArrayList<Pokemon>();
        ArrayList<Pokemon> tempPopulation = new ArrayList<Pokemon>();

        //copy pokemon into tempPopulation
        for (int i = 0; i < POPULATION_SIZE; i++){
            tempPopulation.add(pokemon.get(i));
        }

        //spin wheel to create breeding pairs. If odd number, don't select last individual
        while(wheel.size() > 1){

            int selectionIndex = wheel.selectAndRemove();
            breedingPool.add(tempPopulation.get(selectionIndex));
            tempPopulation.remove(selectionIndex);
            int secondIndex = wheel.selectAndRemove();
            breedingPool.add(tempPopulation.get(secondIndex));
            tempPopulation.remove(secondIndex);
            // System.out.println("Wheel size: " + wheel.size());
            // System.out.println("Selected index: " + selectionIndex);
            // System.out.println("Breeding pool size: " + breedingPool.size());
            // System.out.println();

            // System.out.println("Parent index: " + selectionIndex);
            // pokemon.get(selectionIndex).print();
            // System.out.println("Parent index: " + secondIndex);
            // pokemon.get(secondIndex).print();

        }

        //test print
        for (int i = 0; i < breedingPool.size(); i++){
            //breedingPool.get(i).print();
        }

        //loop through breeding pairs, make have each make two babies
        for (int i = 0; i < breedingPool.size(); i = i + 2){
            System.out.println("Index: " + i);
            makeBabies(breedingPool.get(i), breedingPool.get(i + 1));

            // breedingPool.get(i).print();
            // breedingPool.get(i + 1).print();

        }
		
		//MUTATION
		for (int i = 0; i < breedingPool.size(); i++){
            //breedingPopulation.get(i).mutuate()

        }
		
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

    public static void makeBabies(Pokemon parentOne, Pokemon parentTwo){

        //generate random double to see if they will mate
        double randomDouble = rand.nextDouble();
        if (randomDouble > CROSSOVER_PROBABILITY){
            return;
            //They don't seem to like one another.
        }

        // parentOne.print();
        // parentTwo.print();

        Move[] babyOneMoves = new Move[NUM_MOVES];
        Move[] babyTwoMoves = new Move[NUM_MOVES];
        Move[] parentOneMoves = parentOne.getMovesArray();
        Move[] parentTwoMoves = parentTwo.getMovesArray();
        double[] babyOneProbabilities = new double[NUM_PROBABILITIES];
        double[] babyTwoProbabilities = new double[NUM_PROBABILITIES];
        double[] parentOneProbabilities = parentOne.getProbabilitiesArray();
        double[] parentTwoProbabilities = parentTwo.getProbabilitiesArray();

        //TEST PRINT
        // for (int i = 0; i < NUM_PROBABILITIES; i++){
        //     System.out.println("Parent one probability: " + parentOneProbabilities[i]);
        //     System.out.println("Parent two probability: " + parentTwoProbabilities[i]);
        // }

        Boolean[] movesAssigned = new Boolean[NUM_MOVES];
        //if parents share a move, both babies learn it
        for (int i = 0; i < NUM_MOVES; i++){
            Move curr = parentOneMoves[i];
            for (int j = 0; j < NUM_MOVES; j++){
                if (curr.getMoveName().equals(parentTwoMoves[j].getMoveName())){
                    babyOneMoves[i] = curr;
                    babyTwoMoves[i] = curr;
                    movesAssigned[i] = true;

                    System.out.println("Matched move: " + curr.getMoveName());
                }
            }
        }       
        //assign remaining moves randomly
        for (int i = 0; i < NUM_MOVES; i++){
            while (movesAssigned[i] == false){

                Move newMove = new Move(parentOne.getName());
                for (int j = 0; j < NUM_MOVES; j++){
                    if (babyOneMoves[j] != null && !babyOneMoves[j].getMoveName().equals(newMove.getMoveName())){
                        babyOneMoves[i] = newMove;
                        babyTwoMoves[i] = newMove;
                        movesAssigned[i] = true;

                        System.out.println("Move " + i + " assigned randomly.");
                    }
                }    
            }
        }

        //for each probability, generate a random boolean. if true, babyOne gets that probability, babyTwo gets the opposite
        for (int i = 0; i < NUM_PROBABILITIES; i++){
            boolean randomBoolean = rand.nextBoolean();
            if (randomBoolean == true){
                babyOneProbabilities[i] = parentOneProbabilities[i];
                babyTwoProbabilities[i] = parentTwoProbabilities[i];
                // System.out.println("Random boolean: true");
                // System.out.println("Parent one probability: " + parentOneProbabilities[i]);
                // System.out.println("Parent two probability: " + parentTwoProbabilities[i]);
            }
            else{
                babyOneProbabilities[i] = parentTwoProbabilities[i];
                babyTwoProbabilities[i] = parentOneProbabilities[i];
                // System.out.println("Random boolean: false.");
                // System.out.println("Parent one probability: " + parentOneProbabilities[i]);
                // System.out.println("Parent two probability: " + parentTwoProbabilities[i]);
            }
        }

        //create and assign baby pokemon!
        Pokemon firstBaby = new Pokemon(parentOne.getName(), parentOne.getLevel(), parentTwo.getLevel(), ALGORITHM, babyOneProbabilities[0], babyOneProbabilities[1], babyOneProbabilities[2], babyOneMoves[0], babyOneMoves[1], babyOneMoves[2]);
        Pokemon secondBaby = new Pokemon(parentOne.getName(), parentOne.getLevel(), parentTwo.getLevel(), ALGORITHM, babyTwoProbabilities[0], babyTwoProbabilities[1], babyTwoProbabilities[2], babyTwoMoves[0], babyTwoMoves[1], babyTwoMoves[2]);

        firstBaby.print();
        secondBaby.print();

        newGeneration.add(firstBaby);
        newGeneration.add(secondBaby);
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
        int NAME = 1;
        Move myMove = new Move("Eevee");
        Move[] testMoves = myMove.getPossibleMoves(NAME);


        for (int i = 0; i < POPULATION_SIZE; i++){
            //generate Eevee, give it random fitness
            Pokemon testPokemon = new Pokemon(1, 5, testMoves);
            double randomFitness = rand.nextDouble()*100;
            testPokemon.setFitness(randomFitness);
            pokemon.add(testPokemon);
            //testPokemon.print();
        }
 
    }

}