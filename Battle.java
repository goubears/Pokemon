import java.io.*;
import java.util.*;
import java.util.Random;

public class Battle {

	Vector<Pokemon> battleCrew = new Vector<Pokemon>(5);
	Random rand = new Random();
	final private int NUMEROFBATTLECREW = 5;
	
	 public Vector hybridBattle(Vector<Pokemon> eevees)
	 {

	 	int alternate = 0;
	 	double newHP = Double.MAX_VALUE;
	 	double[] battleHealth = new double[NUMEROFBATTLECREW]; 
	 	double[] battleAttack = new double[NUMEROFBATTLECREW]; 
	 	double[] battleDefense = new double[NUMEROFBATTLECREW]; 
	 	boolean[] battleWon = new boolean[NUMEROFBATTLECREW];
	 	double[] battleResults = new double[NUMEROFBATTLECREW];

	 	//powers ups for eevees and battle crew
		 for(int i=0; i<eevees.size(); i++){
		 	eevees.get(i).powerUp();
		 }
		 for(int i=0; i<battleCrew.size(); i++){
		 	battleCrew.get(i).powerUp();
		 }


		for(int i=0; i<eevees.size(); i++){	
			for(int j=0; j<battleCrew.size(); j++){ 
				while((eevees.get(i).getHealth()>0) && (battleCrew.get(j).getHealth()>0)){
		 			if((alternate%2)==0){
		 				newHP = damageFunction(eevees.get(i), battleCrew.get(j));
		 				eevees.get(i).setHealth(newHP);
		 			}
		 			if((alternate%2)==1){
		 				newHP = damageFunction(eevees.get(i), battleCrew.get(j));
		 				eevees.get(i).setHealth(newHP);
		 			}
		 			alternate++;
		 		}	
		 		
		 		battleHealth[j] = eevees.get(i).getHealth();
		 		battleAttack[j] = eevees.get(i).getAttack();
		 		battleDefense[j] = eevees.get(i).getDefense();
		 		if(eevees.get(i).getHealth()>0)
		 			battleWon[j] = true;
		 		else{
		 			battleWon[j] = false;
		 		}
		 		//battleResults?

		 		battleCrew.get(j).powerUp();
		 		alternate = 0;
		 		//reset health of eevee?
		 		eevees.get(i).calculateFitness(battleHealth, battleAttack, battleDefense, battleWon, battleResults);
		 		eevees.get(i).levelUp(battleWon);

			}
		}

		return eevees;

	 }


	 //eevee1 gets updated while fighting eevee2
	 public Vector coevolutionBattle(Vector<Pokemon> eevees1, Vector<Pokemon> eevees2){
	 	int alternate = 0;
	 	double newHP = Double.MAX_VALUE;
	 	int popSize = eevees1.size();
	 	double[] battleHealth = new double[popSize]; 
	 	double[] battleAttack = new double[popSize]; 
	 	double[] battleDefense = new double[popSize];
	 	boolean[] battleWon = new boolean[popSize];
	 	double[] battleResults = new double[popSize];

	 	//powers ups for eevees and eevee battle crew
		 for(int i=0; i<eevees1.size(); i++){
		 	eevees1.get(i).powerUp();
		 	eevees2.get(i).powerUp();
		 }

		for(int i=0; i<eevees1.size(); i++){	
			for(int j=0; j<eevees2.size(); j++){ 
				while((eevees1.get(i).getHealth()>0) && (eevees2.get(j).getHealth()>0)){
		 			if((alternate%2)==0){
		 				newHP = damageFunction(eevees1.get(i), eevees2.get(j));
		 				eevees1.get(i).setHealth(newHP);
		 			}
		 			if((alternate%2)==1){
		 				newHP = damageFunction(eevees1.get(i), eevees2.get(j));
		 				eevees1.get(i).setHealth(newHP);
		 			}
		 			alternate++;
		 		}	
		 		
		 		battleHealth[j] = eevees1.get(i).getHealth();
		 		battleAttack[j] = eevees1.get(i).getAttack();
		 		battleDefense[j] = eevees1.get(i).getDefense();
		 		if(eevees1.get(i).getHealth()>0)
		 			battleWon[j] = true;
		 		else{
		 			battleWon[j] = false;
		 		}
		 		//battleResults?

		 		eevees2.get(j).powerUp();
		 		alternate = 0;
		 		//reset health of eevee1?
		 		eevees1.get(i).calculateFitness(battleHealth, battleAttack, battleDefense, battleWon, battleResults);
		 		eevees1.get(i).levelUp(battleWon);

			}
		}

		return eevees1;
	 }


	 public double damageFunction(Pokemon attacker, Pokemon opponent){
	 	double damage = Double.MAX_VALUE;
	 	int temp;
	 	temp = rand.nextInt(3);
	 	switch(temp){
	 		case 0:
	 			damage = ((2*attacker.getLevel()+10)/(250))*(attacker.getAttack()/opponent.getDefense())*attacker.getMoveOne().getAttack()+2;
	 		case 1:	
	 			damage = ((2*attacker.getLevel()+10)/(250))*(attacker.getAttack()/opponent.getDefense())*attacker.getMoveTwo().getAttack()+2;
	 		case 2:
	 			damage = ((2*attacker.getLevel()+10)/(250))*(attacker.getAttack()/opponent.getDefense())*attacker.getMoveThree().getAttack()+2;
	 		default: //error
	 			System.out.println("Error in assigning a random move for a pokemon.");
 				System.exit(0);
	 	}

	 	return attacker.getHealth()-damage;
	 }


	 //initialize the battle crew and their stats & moves
	 public void initBattleCrew(){
        int NAME2 = 2;
        Move myMove2 = new Move("Pikachu");
        Move[] testMoves2 = myMove2.getPossibleMoves(NAME2);
        Pokemon battle2 = new Pokemon(2, 5, testMoves2);
        battleCrew.add(battle2);


        int NAME3 = 3;
        Move myMove3 = new Move("Charmander");
        Move[] testMoves3 = myMove3.getPossibleMoves(NAME3);
        Pokemon battle3 = new Pokemon(3, 5, testMoves3);
        battleCrew.add(battle3);

        int NAME4 = 4;
        Move myMove4 = new Move("Meowth");
        Move[] testMoves4 = myMove4.getPossibleMoves(NAME4);
        Pokemon battle4 = new Pokemon(4, 5, testMoves4);
        battleCrew.add(battle4);

        int NAME5 = 5;
        Move myMove5 = new Move("Houndour");
        Move[] testMoves5 = myMove5.getPossibleMoves(NAME5);
        Pokemon battle5 = new Pokemon(5, 5, testMoves5);
        battleCrew.add(battle5);

        int NAME6 = 6;
        Move myMove6 = new Move("Koffing");
        Move[] testMoves6 = myMove6.getPossibleMoves(NAME6);
        Pokemon battle6 = new Pokemon(6, 5, testMoves6);
        battleCrew.add(battle6);
	 }

}
