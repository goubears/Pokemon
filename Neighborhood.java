import java.io.*;
import java.util.*;


public class Neighborhood {
	Vector<Vector<comboMoves>> neighborhood = new Vector<Vector<comboMoves>>(); //initialized neighborhood combos
	Vector<Vector<Integer>> pokemonNeighborhoods = new Vector<Vector<Integer>>(20); //vector of indexes of pokemon in specified neighborhoods

	//returns the vector of the neighborhood
	public Vector<Integer> getNeighborhood(int pokeIndex){
		for(int i=0; i<20; i++){
			for(int j=0; j<pokemonNeighborhoods.get(i).size(); j++){
				if(pokemonNeighborhoods.get(i).get(j) == pokeIndex){
					return pokemonNeighborhoods.get(i);
				}
			}
		}
		System.out.println("There's an error in the return vector of the Pokemon's neighborhood.");
		return null;
	}


	//assigns all pokemon to a neighborhood
	public void assignNeighborhood(Vector<Pokemon> vPokemon){

		for(int i=0; i<vPokemon.size(); i++){ //all elements of vector
			for(int j=0; j<20; j++){ //neighborhoods
				for(int k=0; k<6; k++){ //elements of neighborhoods
					if(	(neighborhood.get(j).get(k).getMove1() == vPokemon.get(i).getMoveOne().getIdentifier()) &&
						(neighborhood.get(j).get(k).getMove2() == vPokemon.get(i).getMoveTwo().getIdentifier()) && 
						(neighborhood.get(j).get(k).getMove3() == vPokemon.get(i).getMoveThree().getIdentifier())
						){
						 
						pokemonNeighborhoods.get(j).add(i);
					}
					
				}
			}
		}	
	}

	
	
	//initializes the neighborhoods to all possible combinations of the 3 moves
	public void initNeighborhood(){
	
		Vector<comboMoves> temp = new Vector<comboMoves>();

		//#0
		comboMoves a1 = new comboMoves(1,2,3);
		temp.add(a1);
		comboMoves a2 = new comboMoves(1,3,2);
		temp.add(a2);
		comboMoves a3 = new comboMoves(2,1,3);
		temp.add(a3);
		comboMoves a4 = new comboMoves(2,3,1);
		temp.add(a4);
		comboMoves a5 = new comboMoves(3,1,2);
		temp.add(a5);
		comboMoves a6 = new comboMoves(3,2,1);
		temp.add(a6);
		neighborhood.add(temp);

		//#1
		temp = new Vector<comboMoves>();
		comboMoves b1 = new comboMoves(1,2,4);
		temp.add(b1);
		comboMoves b2 = new comboMoves(1,4,2);
		temp.add(b2);
		comboMoves b3 = new comboMoves(2,1,4);
		temp.add(b3);
		comboMoves b4 = new comboMoves(2,4,1);
		temp.add(b4);
		comboMoves b5 = new comboMoves(4,1,2);
		temp.add(b5);
		comboMoves b6 = new comboMoves(4,2,1);
		temp.add(b6);
		neighborhood.add(temp);

		//#2
		temp = new Vector<comboMoves>();
		comboMoves c1 = new comboMoves(1,2,5);
		temp.add(c1);
		comboMoves c2 = new comboMoves(1,5,2);
		temp.add(c2);
		comboMoves c3 = new comboMoves(2,1,5);
		temp.add(c3);
		comboMoves c4 = new comboMoves(2,5,1);
		temp.add(c4);
		comboMoves c5 = new comboMoves(5,1,2);
		temp.add(c5);
		comboMoves c6 = new comboMoves(5,2,1);
		temp.add(c6);
		neighborhood.add(temp);

		//#3
		temp = new Vector<comboMoves>();
		comboMoves d1 = new comboMoves(1,2,6);
		temp.add(d1);
		comboMoves d2 = new comboMoves(1,6,2);
		temp.add(d2);
		comboMoves d3 = new comboMoves(2,1,6);
		temp.add(d3);
		comboMoves d4 = new comboMoves(2,6,1);
		temp.add(d4);
		comboMoves d5 = new comboMoves(6,1,2);
		temp.add(d5);
		comboMoves d6 = new comboMoves(6,2,1);
		temp.add(d6);
		neighborhood.add(temp);

		//#4
		temp = new Vector<comboMoves>();
		comboMoves e1 = new comboMoves(1,4,3);
		temp.add(e1);
		comboMoves e2 = new comboMoves(1,3,4);
		temp.add(e2);
		comboMoves e3 = new comboMoves(4,1,3);
		temp.add(e3);
		comboMoves e4 = new comboMoves(4,3,1);
		temp.add(e4);
		comboMoves e5 = new comboMoves(3,1,4);
		temp.add(e5);
		comboMoves e6 = new comboMoves(3,4,1);
		temp.add(e6);
		neighborhood.add(temp);

		//#5
		temp = new Vector<comboMoves>();
		comboMoves f1 = new comboMoves(1,5,3);
		temp.add(f1); 
		comboMoves f2 = new comboMoves(1,3,5);
		temp.add(f2);
		comboMoves f3 = new comboMoves(5,1,3);
		temp.add(f3);
		comboMoves f4 = new comboMoves(5,3,1);
		temp.add(f4);
		comboMoves f5 = new comboMoves(3,1,5);
		temp.add(f5);
		comboMoves f6 = new comboMoves(3,5,1);
		temp.add(f6);
		neighborhood.add(temp);

		//#6
		temp = new Vector<comboMoves>();
		comboMoves g1 = new comboMoves(1,6,3);
		temp.add(g1);
		comboMoves g2 = new comboMoves(1,3,6);
		temp.add(g2);
		comboMoves g3 = new comboMoves(6,1,3);
		temp.add(g3);
		comboMoves g4 = new comboMoves(6,3,1);
		temp.add(g4);
		comboMoves g5 = new comboMoves(3,1,6);
		temp.add(g5);
		comboMoves g6 = new comboMoves(3,6,1);
		temp.add(g6);
		neighborhood.add(temp);

		//#7
		temp = new Vector<comboMoves>();
		comboMoves h1 = new comboMoves(4,2,3);
		temp.add(h1);
		comboMoves h2 = new comboMoves(4,3,2);
		temp.add(h2);
		comboMoves h3 = new comboMoves(2,4,3);
		temp.add(h3);
		comboMoves h4 = new comboMoves(2,3,4);
		temp.add(h4);
		comboMoves h5 = new comboMoves(3,4,2);
		temp.add(h5);
		comboMoves h6 = new comboMoves(3,2,4);
		temp.add(h6);
		neighborhood.add(temp);

		//#8
		temp = new Vector<comboMoves>();
		comboMoves i1 = new comboMoves(5,2,3);
		temp.add(i1);
		comboMoves i2 = new comboMoves(5,3,2);
		temp.add(i2);
		comboMoves i3 = new comboMoves(2,5,3);
		temp.add(i3);
		comboMoves i4 = new comboMoves(2,3,5);
		temp.add(i4);
		comboMoves i5 = new comboMoves(3,5,2);
		temp.add(i5);
		comboMoves i6 = new comboMoves(3,2,5);
		temp.add(i6);
		neighborhood.add(temp);

		//#9
		temp = new Vector<comboMoves>();
		comboMoves j1 = new comboMoves(6,2,3);
		temp.add(j1);
		comboMoves j2 = new comboMoves(6,3,2);
		temp.add(j2);
		comboMoves j3 = new comboMoves(2,6,3);
		temp.add(j3);
		comboMoves j4 = new comboMoves(2,3,6);
		temp.add(j4);
		comboMoves j5 = new comboMoves(3,6,2);
		temp.add(j5);
		comboMoves j6 = new comboMoves(3,2,6);
		temp.add(j6);
		neighborhood.add(temp);

		//#10
		temp = new Vector<comboMoves>();
		comboMoves k1 = new comboMoves(1,4,5);
		temp.add(k1);
		comboMoves k2 = new comboMoves(1,5,4);
		temp.add(k2);
		comboMoves k3 = new comboMoves(4,1,5);
		temp.add(k3);
		comboMoves k4 = new comboMoves(4,5,1);
		temp.add(k4);
		comboMoves k5 = new comboMoves(5,1,4);
		temp.add(k5);
		comboMoves k6 = new comboMoves(5,4,1);
		temp.add(k6);
		neighborhood.add(temp);


		//#11
		temp = new Vector<comboMoves>();
		comboMoves l1 = new comboMoves(1,4,6); 
		temp.add(l1);
		comboMoves l2 = new comboMoves(1,6,4);
		temp.add(l2);
		comboMoves l3 = new comboMoves(4,1,6);
		temp.add(l3);
		comboMoves l4 = new comboMoves(4,6,1);
		temp.add(l4);
		comboMoves l5 = new comboMoves(6,1,4);
		temp.add(l5);
		comboMoves l6 = new comboMoves(6,4,1);
		temp.add(l6);
		neighborhood.add(temp);


		//#12
		temp = new Vector<comboMoves>();
		comboMoves m1 = new comboMoves(1,5,6);
		temp.add(m1);
		comboMoves m2 = new comboMoves(1,6,5);
		temp.add(m2);
		comboMoves m3 = new comboMoves(5,1,6);
		temp.add(m3);
		comboMoves m4 = new comboMoves(5,6,1);
		temp.add(m4);
		comboMoves m5 = new comboMoves(6,1,5);
		temp.add(m5);
		comboMoves m6 = new comboMoves(6,5,1);
		temp.add(m6);
		neighborhood.add(temp);

		//#13
		temp = new Vector<comboMoves>();
		comboMoves n1 = new comboMoves(4,2,5);
		temp.add(n1);
		comboMoves n2 = new comboMoves(4,5,2);
		temp.add(n2);
		comboMoves n3 = new comboMoves(2,4,5);
		temp.add(n3);
		comboMoves n4 = new comboMoves(2,5,4);
		temp.add(n4);
		comboMoves n5 = new comboMoves(5,4,2);
		temp.add(n5);
		comboMoves n6 = new comboMoves(5,2,4);
		temp.add(n6);
		neighborhood.add(temp);

		//#14
		temp = new Vector<comboMoves>();
		comboMoves o1 = new comboMoves(4,2,6);
		temp.add(o1);
		comboMoves o2 = new comboMoves(4,6,2);
		temp.add(o2);
		comboMoves o3 = new comboMoves(2,4,6);
		temp.add(o3);
		comboMoves o4 = new comboMoves(2,6,4);
		temp.add(o4);
		comboMoves o5 = new comboMoves(6,4,2);
		temp.add(o5);
		comboMoves o6 = new comboMoves(6,2,4);
		temp.add(o6);
		neighborhood.add(temp);
		
		//#15
		temp = new Vector<comboMoves>();
		comboMoves p1 = new comboMoves(5,2,6);
		temp.add(p1);
		comboMoves p2 = new comboMoves(5,6,2);
		temp.add(p2);
		comboMoves p3 = new comboMoves(2,5,6);
		temp.add(p3);
		comboMoves p4 = new comboMoves(2,6,5);
		temp.add(p4);
		comboMoves p5 = new comboMoves(6,5,2);
		temp.add(p5);
		comboMoves p6 = new comboMoves(6,2,5);
		temp.add(p6);
		neighborhood.add(temp);
		
		//#16
		temp = new Vector<comboMoves>();
		comboMoves q1 = new comboMoves(4,5,3);
		temp.add(q1);
		comboMoves q2 = new comboMoves(4,3,5);
		temp.add(q2);
		comboMoves q3 = new comboMoves(5,4,3);
		temp.add(q3);
		comboMoves q4 = new comboMoves(5,3,4);
		temp.add(q4);
		comboMoves q5 = new comboMoves(3,4,5);
		temp.add(q5);
		comboMoves q6 = new comboMoves(3,5,4);
		temp.add(q6);
		neighborhood.add(temp);
		

		//#17
		temp = new Vector<comboMoves>();
		comboMoves r1 = new comboMoves(4,6,3);
		temp.add(r1);
		comboMoves r2 = new comboMoves(4,3,6);
		temp.add(r2);
		comboMoves r3 = new comboMoves(6,4,3);
		temp.add(r3);
		comboMoves r4 = new comboMoves(6,3,4);
		temp.add(r4);
		comboMoves r5 = new comboMoves(3,4,6);
		temp.add(r5);
		comboMoves r6 = new comboMoves(3,6,4);
		temp.add(r6);
		neighborhood.add(temp);
		

		//#18
		temp = new Vector<comboMoves>();
		comboMoves s1 = new comboMoves(5,6,3);
		temp.add(s1);
		comboMoves s2 = new comboMoves(5,3,6);
		temp.add(s2);
		comboMoves s3 = new comboMoves(6,5,3);
		temp.add(s3);
		comboMoves s4 = new comboMoves(6,3,5);
		temp.add(s4);
		comboMoves s5 = new comboMoves(3,5,6);
		temp.add(s5);
		comboMoves s6 = new comboMoves(3,6,5);
		temp.add(s6);
		neighborhood.add(temp);
		

		//#19
		temp = new Vector<comboMoves>();
		comboMoves t1 = new comboMoves(4,5,6);
		temp.add(t1);
		comboMoves t2 = new comboMoves(4,6,5);
		temp.add(t2);
		comboMoves t3 = new comboMoves(5,4,6);
		temp.add(t3);
		comboMoves t4 = new comboMoves(5,6,4);
		temp.add(t4);
		comboMoves t5 = new comboMoves(6,4,5);
		temp.add(t5);
		comboMoves t6 = new comboMoves(6,5,4);
		temp.add(t6);
		neighborhood.add(temp);

	}
}

/**
	 * If you can think of a better way to do this, go ahead and implement it.
	 * This is just a guideline to get what we need for the program - I'm sure there are better ways to do this,
	 * I just can't think of them now...  
	 */
	
	//function to create neighborhoods
	
	//go through array of possible moves and create every possible combination of 3-moves (order doesn't matter)
	//ex: possibleMoves = {A, B, C, D, E, F} -> 20 possible combinations
	//					  {1  2  3  4  5  6}
	
	//neighborhood[0] = {ABC, ACB, BAC, BCA, CAB, CBA};
	//neighborhood[1] = {ABD, ADB, BAD, BDA, DAB, DBA};
	//neighborhood[2] = {ABE, AEB, BAE, BEA, EAB, EBA};
	//neighborhood[3] = {ABF, AFB, BAF, BFA, FAB, FBA};
	//neighborhood[4] = {ACD, ADC, CAD, CDA, DAC, DCA};
	//neighborhood[4] = {ACE, AEC, CAE, CEA, EAC, ECA};
	//neighborhood[4] = {ACF, AFC, CAF, CFA, FAC, FCA};
	//neighborhood[7] = {ADE, AED, DAE, DEA, EAD, EDA};
	//neighborhood[8] = {ADF, AFD, DAF, DFA, FAD, FDA};
	//neighborhood[9] = {AEF, AFE, EAF, EFA, FAE, FEA};
	
	//neighborhood[10] = {BCD, BDC, CBD, CDB, DBC, DCB};
	//neighborhood[11] = {BCE, BEC, CBE, CEB, EBC, ECB};
	//neighborhood[12] = {BCF, BFC, CBF, CFB, FBC, FCB};
	//neighborhood[13] = {BDE, BED, DBE, DEB, EBD, EDB};
	//neighborhood[13] = {BDF, BFD, DBF, DFB, FBD, FDB};
	//neighborhood[15] = {BEF, BFE, EBF, EFB, FBE, FEB};
	
	//neighborhood[16] = {CDE, CED, DCE, DEC, ECD, EDC};
	//neighborhood[17] = {CDF, CFD, DCF, DFC, FCD, FDC};
	//neighborhood[18] = {CFE, CEF, FCE, FEC, ECF, EFC};
	
	//neighborhood[19] = {DEF, DFE, EDF, EFD, FDE, FED};
	
	
	//function to assign individual to neighborhood
	
	//somehow relate moves to comboMoves
	//go through the array of neighborhoods
	//find which neighborhood that individual belongs to
	//assign that individual to that neighborhood
		//pokemon.neighborhood = 14;
		//neighborhoodPokemon[14] = {23, 54, 72, 95};

// neighborhood[0] = {comboMoves a = new combo.comboMoves(1,2,3), comboMoves b = new combo.comboMoves(1,3,2), comboMoves c = new combo.comboMoves(2,1,3), comboMoves d = new combo.comboMoves(2,3,1), comboMoves e = new combo.comboMoves(3,1,2), comboMoves f = new combo.comboMoves(3,2,1)};
		// neighborhood[1] = {comboMoves a = new combo.comboMoves(1,2,4), comboMoves b = new combo.comboMoves(1,4,2), comboMoves c = new combo.comboMoves(2,1,4), comboMoves d = new combo.comboMoves(2,4,1), comboMoves e = new combo.comboMoves(4,1,2), comboMoves f = new combo.comboMoves(4,2,1)};
		// neighborhood[2] = {comboMoves a = new combo.comboMoves(1,2,5), comboMoves b = new combo.comboMoves(1,5,2), comboMoves c = new combo.comboMoves(2,1,5), comboMoves d = new combo.comboMoves(2,5,1), comboMoves e = new combo.comboMoves(5,1,2), comboMoves f = new combo.comboMoves(5,2,1)};
		// neighborhood[3] = {comboMoves a = new combo.comboMoves(1,2,6), comboMoves b = new combo.comboMoves(1,6,2), comboMoves c = new combo.comboMoves(2,1,6), comboMoves d = new combo.comboMoves(2,6,1), comboMoves e = new combo.comboMoves(6,1,2), comboMoves f = new combo.comboMoves(6,2,1)};
		// neighborhood[4] = {comboMoves a = new combo.comboMoves(1,4,3), comboMoves b = new combo.comboMoves(1,3,4), comboMoves c = new combo.comboMoves(4,1,3), comboMoves d = new combo.comboMoves(4,3,1), comboMoves e = new combo.comboMoves(3,1,4), comboMoves f = new combo.comboMoves(3,4,1)};
		// neighborhood[5] = {comboMoves a = new combo.comboMoves(1,5,3), comboMoves b = new combo.comboMoves(1,3,5), comboMoves c = new combo.comboMoves(5,1,3), comboMoves d = new combo.comboMoves(5,3,1), comboMoves e = new combo.comboMoves(3,1,5), comboMoves f = new combo.comboMoves(3,5,1)};
		// neighborhood[6] = {comboMoves a = new combo.comboMoves(1,6,3), comboMoves b = new combo.comboMoves(1,3,6), comboMoves c = new combo.comboMoves(6,1,3), comboMoves d = new combo.comboMoves(6,3,1), comboMoves e = new combo.comboMoves(3,1,6), comboMoves f = new combo.comboMoves(3,6,1)};
		// neighborhood[7] = {comboMoves a = new combo.comboMoves(4,2,3), comboMoves b = new combo.comboMoves(4,3,2), comboMoves c = new combo.comboMoves(2,4,3), comboMoves d = new combo.comboMoves(2,3,4), comboMoves e = new combo.comboMoves(3,4,2), comboMoves f = new combo.comboMoves(3,2,4)};
		// neighborhood[8] = {comboMoves a = new combo.comboMoves(5,2,3), comboMoves b = new combo.comboMoves(5,3,2), comboMoves c = new combo.comboMoves(2,5,3), comboMoves d = new combo.comboMoves(2,3,5), comboMoves e = new combo.comboMoves(3,5,2), comboMoves f = new combo.comboMoves(3,2,5)};
		// neighborhood[9] = {comboMoves a = new combo.comboMoves(6,2,3), comboMoves b = new combo.comboMoves(6,3,2), comboMoves c = new combo.comboMoves(2,6,3), comboMoves d = new combo.comboMoves(2,3,6), comboMoves e = new combo.comboMoves(3,6,2), comboMoves f = new combo.comboMoves(3,2,6)};
		// neighborhood[10] = {comboMoves a = new combo.comboMoves(1,4,5), comboMoves b = new combo.comboMoves(1,5,4), comboMoves c = new combo.comboMoves(4,1,5), comboMoves d = new combo.comboMoves(4,5,1), comboMoves e = new combo.comboMoves(5,1,4), comboMoves f = new combo.comboMoves(5,4,1)};
		// neighborhood[11] = {comboMoves a = new combo.comboMoves(1,4,6), comboMoves b = new combo.comboMoves(1,6,4), comboMoves c = new combo.comboMoves(4,1,6), comboMoves d = new combo.comboMoves(4,6,1), comboMoves e = new combo.comboMoves(6,1,4), comboMoves f = new combo.comboMoves(6,4,1)};
		// neighborhood[12] = {comboMoves a = new combo.comboMoves(1,5,6), comboMoves b = new combo.comboMoves(1,6,5), comboMoves c = new combo.comboMoves(5,1,6), comboMoves d = new combo.comboMoves(5,6,1), comboMoves e = new combo.comboMoves(6,1,5), comboMoves f = new combo.comboMoves(6,5,1)};
		// neighborhood[13] = {comboMoves a = new combo.comboMoves(4,2,5), comboMoves b = new combo.comboMoves(4,5,2), comboMoves c = new combo.comboMoves(2,4,5), comboMoves d = new combo.comboMoves(2,5,4), comboMoves e = new combo.comboMoves(5,4,2), comboMoves f = new combo.comboMoves(5,2,4)};
		// neighborhood[14] = {comboMoves a = new combo.comboMoves(4,2,6), comboMoves b = new combo.comboMoves(4,6,2), comboMoves c = new combo.comboMoves(2,4,6), comboMoves d = new combo.comboMoves(2,6,4), comboMoves e = new combo.comboMoves(6,4,2), comboMoves f = new combo.comboMoves(6,2,4)};
		// neighborhood[15] = {comboMoves a = new combo.comboMoves(5,2,6), comboMoves b = new combo.comboMoves(5,6,2), comboMoves c = new combo.comboMoves(2,5,6), comboMoves d = new combo.comboMoves(2,6,5), comboMoves e = new combo.comboMoves(6,5,2), comboMoves f = new combo.comboMoves(6,2,5)};
		// neighborhood[16] = {comboMoves a = new combo.comboMoves(4,5,3), comboMoves b = new combo.comboMoves(4,3,5), comboMoves c = new combo.comboMoves(5,4,3), comboMoves d = new combo.comboMoves(5,3,4), comboMoves e = new combo.comboMoves(3,4,5), comboMoves f = new combo.comboMoves(3,5,4)};
		// neighborhood[17] = {comboMoves a = new combo.comboMoves(4,6,3), comboMoves b = new combo.comboMoves(4,3,6), comboMoves c = new combo.comboMoves(6,4,3), comboMoves d = new combo.comboMoves(6,3,4), comboMoves e = new combo.comboMoves(3,4,6), comboMoves f = new combo.comboMoves(3,6,4)};
		// neighborhood[18] = {comboMoves a = new combo.comboMoves(5,6,3), comboMoves b = new combo.comboMoves(5,3,6), comboMoves c = new combo.comboMoves(6,5,3), comboMoves d = new combo.comboMoves(6,3,5), comboMoves e = new combo.comboMoves(3,5,6), comboMoves f = new combo.comboMoves(3,6,5)};
		// neighborhood[19] = {comboMoves a = new combo.comboMoves(4,5,6), comboMoves b = new combo.comboMoves(4,6,5), comboMoves c = new combo.comboMoves(5,4,6), comboMoves d = new combo.comboMoves(5,6,4), comboMoves e = new combo.comboMoves(6,4,5), comboMoves f = new combo.comboMoves(6,5,4)};
