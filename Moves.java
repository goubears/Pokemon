
	import java.io.*;
	import java.util.*;

	public class Moves {
		
		//Variables
		private String pokemonName;
		private int attack;
		private int accuracy;

		//Move list
		private String[] possibleMoves = new String[6];
		private int[] attackPower = new int[6];
		private int[] attackHitChance = new int[6];
		private String[] moves = new String[3];
		private Random r = new Random();


		public Moves(String name){
			for (i = 0; i++; i<2){
				moves[i] = r.nextInt(3);
			}		    
		    
		}

		public allMoves(String name; int power; int hitChance){
			pokemonName = name;
			attack = power;
		    accuracy = hitChance;

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
	}