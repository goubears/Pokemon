import java.io.*;
import java.util.*;


public class Main {

	private static EvolutionPSO pso = new EvolutionPSO();
	private static Battle battle = new Battle();
	private static Neighborhood neighbor = new Neighborhood();
	private static Coevolution coevol;


	//main method
	public static void main(String[] args) 
	{

		Vector<Integer> temp = new Vector<Integer>();
		Vector<Pokemon> tempP = new Vector<Pokemon>();
		
		//Adela's testing:	
		pso.generatePokemon();
		//System.out.println(pso.getPokemon().get(1).getName());
		neighbor.initNeighborhood();
		//System.out.println("s" + neighbor.neighborhood.size() +  "h" + neighbor.neighborhood.get(1).size() + "m" +  neighbor.neighborhood.get(1).get(1).getMove1());
		neighbor.assignNeighborhood(pso.getPokemon());
		//temp = neighbor.getNeighborhood(1);
		//for(int i=0; i<temp.size(); i++){
		//	System.out.println(temp.get(i));
		//}

		//System.out.println(neighbor.pokemonNeighborhoods.size());
		/*for(int i = 0; i<neighbor.pokemonNeighborhoods.size(); i++){
			for(int j=0; j<neighbor.pokemonNeighborhoods.get(i).size(); j++){
				System.out.println(neighbor.pokemonNeighborhoods.size());
				System.out.println(neighbor.pokemonNeighborhoods.get(i).size());
				System.out.println(neighbor.pokemonNeighborhoods.get(i).get(j));
			}
		}
		*/

		//System.out.println("hey");
		tempP = battle.hybridBattle(pso.getPokemon());
		//System.out.println("hey");
		coevol = battle.coevolutionBattle(pso.getPokemon(), pso.getPokemon());

		//System.out.println("hey");
		//System.out.println(coevol.getEevee1().get(1).getLevel());




		/*
		int NAME = 5;
		Move myMove = new Move("Eevee");
		Move[] testMoves = myMove.getPossibleMoves(NAME);
		

		for (Move m : testMoves){
			System.out.println("Pokemon name: " + m.getPokemonName());
			System.out.println("Move name: " + m.getMoveName());
			System.out.println("Attack: " + m.getAttack());
			System.out.println("Accuracy: " + m.getAccuracy());
			System.out.println();
		}
		*/

		//test Pokemon creation
		// Pokemon testPokemon = new Pokemon(1, 5, testMoves);
		// System.out.println("Pokemon name" + testPokemon.getName());
		// System.out.println("Level: " + testPokemon.getLevel());
		// System.out.println("Health: " + testPokemon.getMaxHealth());
		// System.out.println("Attack: " + testPokemon.getMaxAttack());
		// System.out.println("Defense:" + testPokemon.getMaxDefense());
		// System.out.println("Health probability: " + testPokemon.getHealthProbability());
		// System.out.println("Attack probability: " + testPokemon.getAttackProbability());
		// System.out.println("Defense probability: " + testPokemon.getDefenseProbability());
		// System.out.println("Fitness: " + testPokemon.getFitness());

		/*
		//test Pokemon creation
		Pokemon testPokemon = new Pokemon(NAME, 5, 7, 5, 0.33, 0.33, 0.34, testMoves[0], testMoves[1], testMoves[2]);
		System.out.println("Pokemon name: " + testPokemon.getName());
		System.out.println("Level: " + testPokemon.getLevel());
		System.out.println("Health: " + testPokemon.getMaxHealth());
		System.out.println("Attack: " + testPokemon.getMaxAttack());
		System.out.println("Defense:" + testPokemon.getMaxDefense());
		System.out.println("Health probability: " + testPokemon.getHealthProbability());
		System.out.println("Attack probability: " + testPokemon.getAttackProbability());
		System.out.println("Defense probability: " + testPokemon.getDefenseProbability());
		System.out.println("Fitness: " + testPokemon.getFitness());
		*/


		// public Pokemon(int typeOfPokemon, int parent1Level, int parent2Level, int algorithm, 
		// 	double parentHealthProbability, double parentAttackProbability, double parentDefenseProbability, 
		// 	Move parentMove1, Move parentMove2, Move parentMove3)


		//create an initial population of 100 eevee's
		
		//START OF CYCLE
		
		//have each pokemon "power up" (method in pokemon class)
		
		//send each pokemon into battle (make sure you differentiate between hybrid battles and co-evolution battles) 
		
		//have each pokemon calculate its fitness (method in pokemon class)
			//record all the fitness values for later
		
		//PSO
		//tell each pokemon to "move" i.e. change its probabilities (method in pokemon class)
		
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
		
		//RESTART
		//go back to the start of the cycle and use the newly created population of eevee's
		//keep repeating this cycle for a set number of generations, or until a pokemon reaches level 50
		
		//DONE
		//print out results: best pokemon - it's stats, probabilities, and moves
	}
}
