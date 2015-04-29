
import java.io.*;
import java.util.*;

public class Pokemon {
	
	//Stats
    private String pokemonName;
	private int level;
	private int health;
	private int defense;
	private int attack;
    private Move[] moves;

    // If Eevee
        // HP start 55, max 140
        // A start 55, max 85
        // D start 50, max 80

    // If Pikachu
        // HP start 35, max 120
        // A start 55, max 85
        // D start 30, max 60

    // If Charmander
        // HP start 40, max 125
        // A start 50, max 85
        // D start 45, max 75

    // If Meowth
        // HP start 40, max 125
        // A start 45, max 75
        // D start 35, max 65

    // If Houndour
        // HP start 45, max 130
        // A start 60, max 90
        // D start 30, max 60

    // If Koffing
        // HP start 40, max 125
        // A start 65, max 95
        // D start 95, max 125


    public Pokemon(String name; int lValue; int hValue; int dValue; int aValue){
        pokemonName = name;
        level = lValue;
        health = hValue;
        defense = dValue;
        attack = aValue;
    }

    
    
    public void levelUp(int level; int health; int defense; int attack){
        level += 1;
        health += 1;
        defense += 1;
        attack += 1;

    }
}
