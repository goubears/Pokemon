
import java.io.*;
import java.util.*;

public class Move {
	
	//Variables
	private String pokemonName;
	private int attack;
	private int accuracy;

	//Move list
	private String[] possibleMoves;
	private int[] attackPower;
	private int[] attackHitChance;
	private String[] moves = new String[3];
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