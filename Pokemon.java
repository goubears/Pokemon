
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

    switch (pokemonName){
        case Eevee:
            health = 55; //max 140
            attack = 55; //max 85
            defense = 50; //max 80

        case Pikachu:
            health = 35, max 120
            attack = 55, max 85
            defense = 30, max 60

        case Charmander:
            health = 40, max 125
            attack = 50, max 85
            defense = 45, max 75

        case Meowth:
            health = 40, max 125
            attack = 45, max 75
            defense = 35, max 65

        case Houndour:
            health = 45, max 130
            attack = 60, max 90
            defense = 30, max 60

        case Koffing:
            health = 40, max 125
            attack = 65, max 95
            defense = 95, max 125


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
