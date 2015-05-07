import java.io.*;
import java.util.*;
import java.util.Random;

public class Battle {

	Vector<Pokemon> battleCrew = new Vector<Pokemon>();
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

	 	initBattleCrew();

	 	//initialize battleResults to 0
	 	for(int i=0; i<NUMBEROFBATTLECREW; i++){
	 		battleResults[i] = 0;
	 	}

	 	//powers ups for eevees and battle crew
		 for(int i=0; i<eevees.size(); i++){
		 	eevees.get(i).powerUp();
		 }
		 //System.out.println(eevees.get(1).getHealth());
		 for(int i=0; i<battleCrew.size(); i++){
		 	battleCrew.get(i).powerUp();
		 }

		 //System.out.println("meep");
		for(int i=0; i<eevees.size(); i++){	
			//System.out.println(eevees.size());
			//System.out.println(battleCrew.size());
			for(int j=0; j<battleCrew.size(); j++){ 
				//System.out.println("meep");
				while((eevees.get(i).getHealth()>0) && (battleCrew.get(j).getHealth()>0)){
		 			if((alternate%2)==0){
		 				newHP = damageFunction(eevees.get(i), battleCrew.get(j));
		 				battleCrew.get(j).setHealth(newHP);
		 				//System.out.println(" b " +battleCrew.get(j).getHealth());
		 			}
		 			if((alternate%2)==1){
		 				newHP = damageFunction(battleCrew.get(j), eevees.get(i));
		 				eevees.get(i).setHealth(newHP);
		 				//System.out.println(" e " + eevees.get(i).getHealth());
		 			}
		 			alternate++;
		 		}	
		 		
		 		//System.out.println("finished");

		 		if(eevees.get(i).getHealth()<0){
		 			battleHealth[j] = 0;
		 		}
		 		else{
		 			//System.out.println(" j " +  j + " i " + i);
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

		 		eevees.get(i).powerUp();
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

		battleCrew = new Vector<Pokemon>();
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
		 				eevees2.get(j).setHealth(newHP);
		 				//System.out.println(" 2 " + eevees2.get(j).getHealth());
		 			}
		 			if((alternate%2)==1){
		 				newHP = damageFunction(eevees2.get(j), eevees1.get(i));
		 				eevees1.get(i).setHealth(newHP);
		 				//System.out.println(" 1 " + eevees1.get(i).getHealth());
		 			}
		 			alternate++;
		 		}	
		 		//System.out.println("finished");

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

		 		eevees1.get(i).powerUp();
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
	 	//System.out.println(temp);
	 	switch(temp){
	 		case 0:
	 			damage = ((2*attacker.getLevel()+10)/(250))*(attacker.getAttack()/opponent.getDefense())*attacker.getMoveOne().getAttack()+2;
	 			break;
	 		case 1:	
	 			damage = ((2*attacker.getLevel()+10)/(250))*(attacker.getAttack()/opponent.getDefense())*attacker.getMoveTwo().getAttack()+2;
	 			break;
	 		case 2:
	 			damage = ((2*attacker.getLevel()+10)/(250))*(attacker.getAttack()/opponent.getDefense())*attacker.getMoveThree().getAttack()+2;
	 			break;
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
	//}
