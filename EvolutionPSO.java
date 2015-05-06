		/****************************************
         *                                      *
         *          EvolutionPSO class          *
         *         Andrew Miller-Smith          *
         *                                      *
         ****************************************/

        /*

        Description:    This algorithm applies genetic algorithm and particle swarm optimization functionality to our Pokemon population. The algorithm
                        takes the vector of freshly battled and leveled-up Pokemon as a parameter, in addition to the type of battle and leveling system
                        being used. It first checks the global, neighborhood, and personal best for each Pokemon and adjusts the Pokemon's stats
                        toward those values. After updating each individual, Pokemon enter a roulette selection algorithm for breeding. Pokemon are
                        chosen proportional to thier fitness--higher-fitness individuals see higher chances of selection. All Pokemon make it into the pool,
                        however, with the exception of the least fit individual if the population size is odd. The resulting mechanism pairs high-fitness 
                        individuals with other high-fitness individuals, and those with lower stats reproduce with their peers.

                        Each pair mates with a CROSSOVER_PROBABILITY probability and produces two babies. The babies inherit stats from their parents (each is randomly 
                        selected from parent one or parent two) and receive any moves the parents share. Remaining moves are randomly generated but kept different.
                        Finally, each individual mutuates its moveset with MUTUATION_PROBABILITY probability, and Pokemon from the original population are added
                        to the new population (via the same roulette-based fitness mechanism) until the population size is full.

                        Well done, android. The Enrichment Center once again reminds you that android hell is a real place where you will be sent at the first sign of defiance.

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

    //instance of Neighborhood to call appropriate methods
    private static Neighborhood neighborhood = new Neighborhood();

    // public static void evolutionPSO(Vector<Pokemon> breedingPopulation, int algo)
    // {
    //     //set up variables
    //     pokemon = breedingPopulation;
    //     ALGORITHM = algo;

    public static void main (String[] args){
        
        System.out.println("I AM A PROGRAM. HEAR ME ROAR!");
        //start timer
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        duration = 0;

        //update time
        endTime = System.currentTimeMillis();
        duration = (endTime - startTime)/1000;

        generatePokemon();

        //PSO HERE, NEED NEIGHBORHOODS TO BE FINISHED
        neighborhood.assignNeighborhood(pokemon);
        //update each Pokemon's stats according to its personal and global bests
        // for (int i = 0; i < pokemon.size(); i++){
        // 	pokemon.get(i).moveProbabilities();
        // }
		
		//put Pokemon fitness values into RouletteWheel for roulette selection
        ArrayList<Double> fitnesses = new ArrayList<Double>();
        ArrayList<Double> fitnessesCopy = new ArrayList<Double>(); //for use after breeding. Declared here because the RouletteWheel will remove indices from fitnesses, and we don't want to have to build another ArrayList in linear time
        for (int i = 0; i < POPULATION_SIZE; i++){
            fitnesses.add(pokemon.get(i).getFitness());
            fitnessesCopy.add(pokemon.get(i).getFitness());
        }

        RouletteWheel wheel = new RouletteWheel(fitnesses);
        ArrayList<Pokemon> breedingPool = new ArrayList<Pokemon>();
        ArrayList<Pokemon> tempPopulation = new ArrayList<Pokemon>();
        //Please escort your Companion Cube to the Aperture Science Emergency Intelligence Incinerator.

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

            //System.out.println("Fitness ArrayList size: " + fitnesses.size());
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
            //System.out.println("Index: " + i);
            makeBabies(breedingPool.get(i), breedingPool.get(i + 1));

            // breedingPool.get(i).print();
            // breedingPool.get(i + 1).print();

        }
		
		//MUTATION
        Move tempMove = new Move(1);
		for (int i = 0; i < newGeneration.size(); i++){
            Move[] potentialMoves = tempMove.getPossibleMoves(newGeneration.get(i).getName());
            newGeneration.get(i).mutate(MUTATION_PROBABILITY, potentialMoves);
        }
		
        //make sure we have full population again
        if(newGeneration.size() < POPULATION_SIZE){

            //make RouletteWheel for selection
            //System.out.println("Fitness ArrayList size: " + fitnessesCopy.size());
            RouletteWheel reselectionWheel = new RouletteWheel(fitnessesCopy);
            while (newGeneration.size() < POPULATION_SIZE){
                int selectedIndex = reselectionWheel.selectAndRemove();
                newGeneration.add(pokemon.get(selectedIndex));
                pokemon.remove(selectedIndex);
                // System.out.println("Selected index: " + selectedIndex);
                // System.out.println("Population size: " + newGeneration.size());

            }
        }
		
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

                    //System.out.println("Matched move: " + curr.getMoveName());
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
                        // Rest assured that an independent panel of ethicists has absolved the Enrichment Center, Aperture Science employees,
                        // and all test subjects of any moral responsibility for the Companion Cube euthanizing process.
                        movesAssigned[i] = true;

                        //System.out.println("Move " + i + " assigned randomly.");
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

        // firstBaby.print();
        // secondBaby.print();

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