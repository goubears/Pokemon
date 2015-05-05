
import java.io.*;
import java.util.*;

	public class Move {
		
		//Variables
		private String pokemonName;
		private int attack;
		private int accuracy;
		private int identifier;
		private String moveName;

        final private int EEVEE = 1;
        final private int PIKACHU = 2;
        final private int CHARMANDER = 3;
        final private int MEOWTH = 4;
        final private int HOUNDOUR = 5;
        final private int KOFFING = 6;

		//Move list
		private String[] possibleMoves = new String[6];
		private int[] attackPower = new int[6];
		private int[] attackHitChance = new int[6];
		private String[] moves = new String[3];
		private Random random = new Random();

		public Move(String name)
		{
			allMoves(name);
			identifier = random.nextInt(3);
			attack = attackPower[identifier];
			accuracy = attackHitChance[identifier];
			moveName = possibleMoves[identifier];		        
		}

        public Move(int name){

            String nameOfPokemon;
            //find appropriate name
            if (name == 1){
                allMoves("Eevee");
                nameOfPokemon = "Eevee";
            }
            else if (name == 2){
                allMoves("Pikachu");
                nameOfPokemon = "Pikachu";
            }
            else if (name == 3){
                allMoves("Charmander");
                nameOfPokemon = "Charmander";
            }
            else if (name == 4){
                allMoves("Meowth");
                nameOfPokemon = "Meowth";
            }
            else if (name == 5){
                allMoves("Houndour");
                nameOfPokemon = "Houndour";
            }
            else{
                allMoves("Koffing");
                nameOfPokemon = "Koffing";
            }

            allMoves(nameOfPokemon);
            identifier = random.nextInt(3);
            attack = attackPower[identifier];
            accuracy = attackHitChance[identifier];
            moveName = possibleMoves[identifier];

        }

        public Move(String name, int moveIdentifier){

            allMoves(name);
            identifier = moveIdentifier;
            attack = attackPower[identifier];
            accuracy = attackHitChance[identifier];
            moveName = possibleMoves[identifier]; 
        }

        public Move[] getPossibleMoves(int name){

            String nameOfPokemon;
            //find appropriate name
            if (name == 1){
                allMoves("Eevee");
                nameOfPokemon = "Eevee";
            }
            else if (name == 2){
                allMoves("Pikachu");
                nameOfPokemon = "Pikachu";
            }
            else if (name == 3){
                allMoves("Charmander");
                nameOfPokemon = "Charmander";
            }
            else if (name == 4){
                allMoves("Meowth");
                nameOfPokemon = "Meowth";
            }
            else if (name == 5){
                allMoves("Houndour");
                nameOfPokemon = "Houndour";
            }
            else{
                allMoves("Koffing");
                nameOfPokemon = "Koffing";
            }

            Move[] possible = new Move[3];
            //construct array of possible moves for Pokemon constructor
            for (int i = 0; i < 3; i++){

                Move nextMove = new Move(nameOfPokemon, i);
                possible[i] = nextMove;

            }

            return possible;  
        }

		public void allMoves(String name){
			pokemonName = name;
			
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

    public int getIdentifier(){
        return identifier;
    }

    public void setIdentifier(int i) {
       identifier = i;
    }
    
    public int getAttack(){
        return attack;
    }

    public void setAttack(int at){
         attack = at;
    }
    
    public int getAccuracy(){
        return accuracy;
    }

    public void setAccuracy(int ac){
         accuracy = ac;
    }
    
    public String getPokemonName(){
        return pokemonName;
    }

    public void setPokemonName(String pn) {
       pokemonName = pn;
    }

    public String getMoveName(){
        return moveName;
    }

    public void setMoveName(String mn) {
       moveName = mn;
    }
}