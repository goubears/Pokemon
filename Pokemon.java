
import java.io.*;
import java.util.*;

public class Pokemon {
	
	//Stats
    private String pokemonName;
	private int level = 1; //max 50
	private double health;
	private double defense;
	private double attack;
    private Move[] moves;

    //Eevee Leveling increases
    private double eeveeHealthUp = (140-55)/50.0;
    private double eeveeAttackUp = (85-55)/50.0;
    private double eeveeDefenseUp = (80-50)/50.0;

    //Pickachu Leveling increases
    private double pikachuHealthUp = (120-35)/50.0;
    private double pikachuAttackUp = (85-55)/50.0;
    private double pikachuDefenseUp = (60-30)/50.0;

    //Charmander Leveling increases
    private double charmanderHealthUp = (125-40)/50.0;
    private double charmanderAttackUp = (85-50)/50.0;
    private double charmanderDefenseUp = (75-45)/50.0;

    //Meowth Leveling increases
    private double meowthHealthUp = (125-40)/50.0;
    private double meowthAttackUp = (75-45)/50.0;
    private double meowthDefenseUp = (65-35)/50.0;

    //Houndour Leveling increases
    private double houndourHealthUp = (130-45)/50.0;
    private double houndourAttackUp = (90-60)/50.0;
    private double houndourDefenseUp = (60-30)/50.0;

    //Koffing Leveling increases
    private double koffingHealthUp = (125-40)/50.0;
    private double koffingAttackUp = (95-65)/50.0;
    private double koffingDefenseUp = (125-95)/50.0;

    //Make getters and setters


    public Pokemon(String name; int lValue){
        pokemonName = name;
        level = lValue;

        //Initializes stats
        switch (pokemonName){

            case Pikachu:
                health = 35 + (level-1)*pikachuHealthUp; // max 120
                attack = 55 + (level-1)*pikachuAttackUp; // max 85
                defense = 30 + (level-1)*pikachuDefenseUp; // max 60
                break;

            case Charmander:
                health = 40 + (level-1)*charmanderHealthUp; // max 125
                attack = 50 + (level-1)*charmanderAttackUp; // max 85
                defense = 45 + (level-1)*charmanderDefenseUp; // max 75
                break;

            case Meowth:
                health = 40 + (level-1)*meowthHealthUp; // max 125
                attack = 45 + (level-1)*meowthAttackUp; // max 75
                defense = 35 + (level-1)*meowthDefenseUp; // max 65
                break;

            case Houndour:
                health = 45 + (level-1)*houndourHealthUp; // max 130
                attack = 60 + (level-1)*houndourAttackUp; // max 90
                defense = 30 + (level-1)*houndourDefenseUp; // max 60
                break;

            case Koffing:
                health = 40 + (level-1)*koffingHealthUp; //max 125
                attack = 65 + (level-1)*koffingAttackUp; //max 95
                defense = 95 + (level-1)*koffingDefenseUp; //max 125
                break;

            default: //Eevee
                health = 55 + (level-1)*eeveeHealthUp; //max 140
                attack = 55 + (level-1)*eeveeAttackUp; //max 85
                defense = 50 + (level-1)*eeveeDefenseUp; //max 80
                break;
            }
    }

       
    public void levelUp(int level; int health; int defense; int attack){
        level += 1;
        health += 1;
        defense += 1;
        attack += 1;
    }
}
