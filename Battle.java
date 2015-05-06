import java.io.*;
import java.util.*;
import java.util.Random;

public class Battle {

	Vector<Pokemon> battleCrew = new Vector<Pokemon>(5);
	Random rand = new Random();
	final private int NUMBEROFBATTLECREW = 5;
	
	 public Vector<Pokemon> hybridBattle(Vector<Pokemon> eevees)
	 {

	 	int alternate = 0;
	 	double newHP = Double.MAX_VALUE;
	 	double[] battleHealth = new double[NUMBEROFBATTLECREW]; 
	 	double[] battleAttack = new double[NUMBEROFBATTLECREW]; 
	 	double[] battleDefense = new double[NUMBEROFBATTLECREW]; 
	 	boolean[] battleWon = new boolean[NUMBEROFBATTLECREW];
	 	double[] battleResults = new double[NUMBEROFBATTLECREW];

	 	//initialize battleResults to 0
	 	for(int i=0; i<NUMBEROFBATTLECREW; i++){
	 		battleResults[i] = 0;
	 	}

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
		 				battleCrew.get(j).setHealth(newHP);
		 			}
		 			if((alternate%2)==1){
		 				newHP = damageFunction(battleCrew.get(j), eevees.get(i));
		 				eevees.get(i).setHealth(newHP);
		 			}
		 			alternate++;
		 		}	
		 		
		 		if(eevees.get(i).getHealth()<0){
		 			battleHealth[j] = 0;
		 		}
		 		else{
		 			battleHealth[j] = eevees.get(i).getHealth();
		 		}
		 		if(eevees.get(i).getAttack()<0){
		 			battleAttack[j] = 0;
		 		}
		 		else{
		 			battleAttack[j] = eevees.get(i).getAttack();
		 		}
		 		if(eevees.get(i).getDefense()<0){
		 			battleDefense[j] = 0;
		 		}
		 		else{
		 			battleDefense[j] = eevees.get(i).getDefense();
		 		}
		 		if(eevees.get(i).getHealth()>0){
		 			battleWon[j] = true;
		 			battleResults[j] += 1.0;
		 		}
		 		else{
		 			battleWon[j] = false;
		 		}


		 		battleCrew.get(j).powerUp();
		 		alternate = 0;
			}

			eevees.get(i).setBattleHP(battleHealth);
			eevees.get(i).setBattleAtt(battleAttack);
			eevees.get(i).setBattleDef(battleDefense);
			eevees.get(i).setBattleWinB(battleWon);
		}

		for(int i=0; i<eevees.size(); i++){	
			eevees.get(i).calculateFitness(eevees.get(i).getBattleHP(), eevees.get(i).getBattleAtt(), eevees.get(i).getBattleDef(), eevees.get(i).getBattleWinB(), battleResults);
		 	eevees.get(i).levelUp(eevees.get(i).getBattleWinB());
		}

		return eevees;

	 }


	 //eevee1 gets updated while fighting eevee2
	 public Coevolution coevolutionBattle(Vector<Pokemon> eevees1, Vector<Pokemon> eevees2){
	 	int alternate = 0;
	 	double newHP = Double.MAX_VALUE;
	 	int popSize = eevees1.size();
	 	//eevee1 stats
	 	double[] battleHealth1 = new double[popSize]; 
	 	double[] battleAttack1 = new double[popSize]; 
	 	double[] battleDefense1 = new double[popSize];
	 	boolean[] battleWon1 = new boolean[popSize];
		double[] battleResults1 = new double[popSize];
	 	//eevee2 stats
	 	double[][] battleHealth2 = new double[popSize][popSize]; 
	 	double[][] battleAttack2 = new double[popSize][popSize]; 
	 	double[][] battleDefense2 = new double[popSize][popSize];
	 	boolean[][] battleWon2 = new boolean[popSize][popSize];
	 	double[] battleResults2 = new double[popSize];


	 	//initialize battleResults to 0
	 	for(int i=0; i<popSize; i++){
	 		battleResults1[i] = 0;
	 		battleResults2[i] = 0;
	 	}

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
		 				eevees2.get(i).setHealth(newHP);
		 			}
		 			if((alternate%2)==1){
		 				newHP = damageFunction(eevees2.get(i), eevees1.get(j));
		 				eevees1.get(i).setHealth(newHP);
		 			}
		 			alternate++;
		 		}	
		 		
		 		//eevee1 updates
		 		if(eevees1.get(i).getHealth()<0){
		 			battleHealth1[j] = 0;
		 		}
		 		else{
		 			battleHealth1[j] = eevees1.get(i).getHealth();
		 		}
		 		if(eevees1.get(i).getAttack()<0){
		 			battleAttack1[j] = 0;
		 		}
		 		else{
		 			battleAttack1[j] = eevees1.get(i).getAttack();
		 		}
		 		if(eevees1.get(i).getDefense()<0){
		 			battleDefense1[j] = 0;
		 		}
		 		else{
		 			battleDefense1[j] = eevees1.get(i).getDefense();
		 		}
		 		if(eevees1.get(i).getHealth()>0){
		 			battleWon1[j] = true;
		 			battleResults1[j] += 1.0;
		 		}
		 		else{
		 			battleWon1[j] = false;
		 		}

		 		//eevee2 updates
		 		if(eevees2.get(j).getHealth()<0){
		 			battleHealth2[j][i] = 0;
		 		}
		 		else{
		 			battleHealth2[j][i] = eevees2.get(j).getHealth();
		 		}
		 		if(eevees2.get(j).getAttack()<0){
		 			battleAttack2[j][i] = 0;
		 		}
		 		else{
		 			battleAttack2[j][i] = eevees2.get(j).getAttack();
		 		}
		 		if(eevees2.get(j).getDefense()<0){
		 			battleDefense2[j][i] = 0;
		 		}
		 		else{
		 			battleDefense2[j][i] = eevees2.get(j).getDefense();
		 		}
		 		if(eevees2.get(j).getHealth()>0){
		 			battleWon2[j][i] = true;
		 			battleResults2[i] += 1.0;
		 		}
		 		else{
		 			battleWon2[j][i] = false;
		 		}

		 		eevees2.get(j).powerUp();
		 		alternate = 0;

			} //j

			eevees1.get(i).setBattleHP(battleHealth1);
			eevees1.get(i).setBattleAtt(battleAttack1);
			eevees1.get(i).setBattleDef(battleDefense1);
			eevees1.get(i).setBattleWinB(battleWon1);

		} //i

		for(int i=0; i<popSize; i++){
			eevees2.get(i).setBattleHP(battleHealth2[i]);
			eevees2.get(i).setBattleAtt(battleAttack2[i]);
			eevees2.get(i).setBattleDef(battleDefense2[i]);
			eevees2.get(i).setBattleWinB(battleWon2[i]);
		}


		for(int i=0; i<popSize; i++){		
		 	eevees1.get(i).calculateFitness(eevees1.get(i).getBattleHP(), eevees1.get(i).getBattleAtt(), eevees1.get(i).getBattleDef(), eevees1.get(i).getBattleWinB(), battleResults1);
		 	eevees1.get(i).levelUp(eevees1.get(i).getBattleWinB());

		 	eevees2.get(i).calculateFitness(eevees2.get(i).getBattleHP(), eevees2.get(i).getBattleAtt(), eevees2.get(i).getBattleDef(), eevees2.get(i).getBattleWinB(), battleResults2);
		 	eevees2.get(i).levelUp(eevees2.get(i).getBattleWinB());
		}

		Coevolution coevolution = new Coevolution(eevees1, eevees2);
		return coevolution;
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
