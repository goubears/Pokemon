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





	//main method
	public static void main(String[] args) 
	{

		//VARIABLES FROM COMMAND LINE
		//EVEN NUMBER OF EEVEES (POPULATION SIZE)
		//ITERATIONS

		populationSize = Integer.parseInt(args[0]);
		iterations = Integer.parseInt(args[1]);

		//create an initial populations
		hybrid = pso.generatePokemon(populationSize);
		coevolutionOne = pso.generatePokemon((int)(populationSize/2));
		//System.out.println("Population size: " + populationSize);
		coevolutionTwo = pso.generatePokemon((int)(populationSize/2));

		//START OF CYCLE
		int numIterations = 0;
		while (numIterations < iterations){

			//send pokemon populations into battle
			hybrid = battle.hybridBattle(hybrid);
			coevol = battle.coevolutionBattle(coevolutionOne, coevolutionTwo);
			coevolutionOne = coevol.getEevee1();
			coevolutionTwo = coevol.getEevee2();

			//genetic algorithm and PSO
			hybrid = pso.evolutionPSO(hybrid, LEVELUP_THRESHOLD);
			coevolutionOne = pso.evolutionPSO(coevolutionOne, LEVELUP_THRESHOLD);
			coevolutionTwo = pso.evolutionPSO(coevolutionTwo, LEVELUP_THRESHOLD);

			numIterations++;
		}
		
		//RESTART
		//go back to the start of the cycle and use the newly created population of eevee's
		//keep repeating this cycle for a set number of generations, or until a pokemon reaches level 50
		
		//DONE
		//print out results: best pokemon - it's stats, probabilities, and moves
	}
}
