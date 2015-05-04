
import java.io.*;
import java.util.*;

<<<<<<< HEAD
	public class Move {
		
		//Variables
		private String pokemonName;
		private int attack;
		private int accuracy;

		//Move list
		private String[] possibleMoves = new String[6];
		private int[] attackPower = new int[6];
		private int[] attackHitChance = new int[6];
		private String[] moves = new String[3];
		private Random random = new Random();

		private int attack;
		private int accuracy;
		private int identifier;
		private String moveName;


		public Move(String name)
		{
			allMoves(name);
			identifer = random.nextInt(3);
			attack = attackPower[identifier];
			accuracy = attackHitChance[identifier];
			moveName = possibleMoves[identifier];

					        
		}

		public allMoves(String name){
			pokemonName = name;
			// attack = power;
		 //    accuracy = hitChance;

	        if (pokemonName.equals("Eevee")){
	            possibleMoves = {"Quick Attack", "Bite", "Take Down", "Move4", "Move5", "Move6"}; 
	            attackPower = {40, 60, 100};
	            attackHitChance = {100, 100, 75};
	        }

	        if (pokemonName.equals("Pikachu")){
	            possibleMoves = {"Quick Attack", "Thunder Shock", "Slam", "Move4", "Move5", "Move6"}; 
	            attackPower = {30, 50, 80};
	            attackHitChance = {100, 100, 85};
	        }

	        if (pokemonName.equals("Charmander")){
	            possibleMoves = {"Ember", "Slash", "Flamethrower", "Move4", "Move5", "Move6"}; 
	            attackPower = {40, 70, 90};
	            attackHitChance = {100, 85, 75};
	        }

	        if (pokemonName.equals("Meowth")){
	            possibleMoves = {"Scratch", "Bite", "Slash", "Move4", "Move5", "Move6"}; 
	            attackPower = {40, 60, 70};
	            attackHitChance = {100, 90, 85};
	        }

	        if (pokemonName.equals("Houndour")){
	            possibleMoves = {"Bite", "Feint Attack", "Crunch", "Move4", "Move5", "Move6"}; 
	            attackPower = {60, 70, 80};
	            attackHitChance = {100, 95, 90};
	        }

	        if (pokemonName.equals("Koffing")){
	            possibleMoves = {"Smog", "Tackle", "Sludge", "Move4", "Move5", "Move6"}; 
	            attackPower = {30, 50, 70};
	            attackHitChance = {100, 90, 80};
	        }
	    }

	    public void 
	}
=======
public class Move {
	
	//Variables
	private String pokemonName;
	private int attack;
	private int accuracy;

	//Move list
	private String[] possibleMoves;
	private int[] attackPower;
	private int[] attackHitChance;
	private int[] moves = new String[3];
	private Random random = new Random();


	public Move(String name)
	{
		for (int i=0; i<2; i++)
		{
			moves[i] = (random.nextInt(3));
		}		        
	}

	public void allMoves(String name, int power, int hitChance){
		pokemonName = name;
		attack = power;
	    accuracy = hitChance;

        if (pokemonName.equals("Eevee")){
            String[] pokemonMoves = {"Quick Attack", "Bite", "Take Down", "Move4", "Move5", "Move6"};
            possibleMoves = pokemonMoves;
            int[] powers = {40, 60, 100};
            attackPower = powers;
            int[] accuracies = {100, 100, 75};
            attackHitChance = accuracies;

        }

        if (pokemonName.equals("Pikachu")){

            String[] pokemonMoves = {"Quick Attack", "Thunder Shock", "Slam", "Move4", "Move5", "Move6"};
            possibleMoves = pokemonMoves;
            int[] powers = {30, 50, 80};
            attackPower = powers;
            int[] accuracies = {100, 100, 85};
            attackHitChance = accuracies;
        }

        if (pokemonName.equals("Charmander")){

            String[] pokemonMoves = {"Ember", "Slash", "Flamethrower", "Move4", "Move5", "Move6"};
            possibleMoves = pokemonMoves;
            int[] powers = {40, 70, 90};
            attackPower = powers;
            int[] accuracies = {100, 85, 75};
            attackHitChance = accuracies;
        }

        if (pokemonName.equals("Meowth")){

            String[] pokemonMoves = {"Scratch", "Bite", "Slash", "Move4", "Move5", "Move6"};
            possibleMoves = pokemonMoves;
            int[] powers = {40, 60, 70};
            attackPower = powers;
            int[] accuracies = {100, 90, 85};
            attackHitChance = accuracies;
        }

        if (pokemonName.equals("Houndour")){

 			String[] pokemonMoves = {"Bite", "Feint Attack", "Crunch", "Move4", "Move5", "Move6"}; 
            possibleMoves = pokemonMoves;
            int[] powers = {60, 70, 80};
            attackPower = powers;
            int[] accuracies = {100, 95, 90};
            attackHitChance = accuracies;
        }

        if (pokemonName.equals("Koffing")){
  
            String[] pokemonMoves = {"Smog", "Tackle", "Sludge", "Move4", "Move5", "Move6"}; 
            possibleMoves = pokemonMoves;
            int[] powers = {30, 50, 70};
            attackPower = powers;
            int[] accuracies = {100, 90, 80};
            attackHitChance = accuracies;
        }
    }
}
>>>>>>> 5f560e7349ba914767b7c04d317c7ed3afb09fd6
