
public class Neighborhood {
	private static comboMoves combo;

	Vector<Vector<comboMoves>> neighborhood = new Vector<Vector<comboMoves>>();
	Vector<Vector<Pokemon>> pokemonNeighborhoods = new Vector<Vector<Pokemon>>(20);

	//hard coded, doesnt have to be though
	//should be moves instead of combo moves, make it take an int

	//returns the index of the neighborhood
	//adds the pokemon to matched neighborhood
	public int getNeighborhood(Pokemon pokemon){
		int index = -1;
		boolean match = false;
		for(int i=0; i<20; i++){ //get length
			for(int j=0; j<6; j++){ //get length
				match = neighborhood.get(i).get(j).getClass().equals(pokemon.moves.getClass());
				if(match){
					pokemonNeighborhoods.get(i).add(pokemon);
					return i;
				}
			}
		}
	}
	

	public void initNeighborhood(int maxMoves){
	
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
	
		Vector<comboMoves> temp = new Vector<comboMoves>();

		//#0
		comboMoves a = new combo.comboMoves(1,2,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(1,3,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,1,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,3,1);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,1,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,2,1);
		temp.add(a);
		neighborhood.add(temp);

		//#1
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(1,2,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(1,4,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,1,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,4,1);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,1,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,2,1);
		temp.add(a);
		neighborhood.add(temp);

		//#2
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(1,2,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(1,5,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,1,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,5,1);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,1,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,2,1);
		temp.add(a);

		//#3
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(1,2,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(1,6,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,1,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,6,1);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,1,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,2,1);
		temp.add(a);

		//#4
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(1,4,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(1,3,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,1,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,3,1);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,1,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,4,1);
		temp.add(a);

		//#5
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(1,5,3);
		temp.add(a); 
		comboMoves a = new combo.comboMoves(1,3,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,1,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,3,1);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,1,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,5,1);
		temp.add(a);

		//#6
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(1,6,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(1,3,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,1,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,3,1);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,1,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,6,1);
		temp.add(a);

		//#7
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(4,2,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,3,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,4,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,3,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,4,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,2,4);
		temp.add(a);

		//#8
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(5,2,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,3,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,5,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,3,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,5,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,2,5);
		temp.add(a);

		//#9
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(6,2,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,3,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,6,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,3,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,6,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,2,6);
		temp.add(a);

		//#10
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(1,4,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(1,5,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,1,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,5,1);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,1,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,4,1);
		temp.add(a);


		//#11
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(1,4,6); 
		temp.add(a);
		comboMoves a = new combo.comboMoves(1,6,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,1,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,6,1);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,1,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,4,1);
		temp.add(a);


		//#12
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(1,5,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(1,6,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,1,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,6,1);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,1,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,5,1);
		temp.add(a);

		//#13
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(4,2,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,5,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,4,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,5,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,4,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,2,4);
		temp.add(a);

		//#14
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(4,2,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,6,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,4,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,6,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,4,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,2,4);
		temp.add(a);
		
		//#15
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(5,2,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,6,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,5,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(2,6,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,5,2);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,2,5);
		temp.add(a);
		
		//#16
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(4,5,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,3,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,4,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,3,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,4,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,5,4);
		temp.add(a);
		

		//#17
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(4,6,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,3,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,4,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,3,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,4,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,6,4);
		temp.add(a);
		

		//#18
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(5,6,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,3,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,5,3);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,3,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,5,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(3,6,5);
		temp.add(a);
		

		//#19
		temp = new Vector<comboMoves>();
		comboMoves a = new combo.comboMoves(4,5,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(4,6,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,4,6);
		temp.add(a);
		comboMoves a = new combo.comboMoves(5,6,4);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,4,5);
		temp.add(a);
		comboMoves a = new combo.comboMoves(6,5,4);
		temp.add(a);

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
