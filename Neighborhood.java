
public class Neighborhood {
	
	/**
	 * If you can think of a better way to do this, go ahead and implement it.
	 * This is just a guideline to get what we need for the program - I'm sure there are better ways to do this,
	 * I just can't think of them now...  
	 */
	
	//function to create neighborhoods
	
	//go through array of possible moves and create every possible combination of 3-moves (order doesn't matter)
	//ex: possibleMoves = {A, B, C, D, E, F} -> 20 possible combinations
	
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
	
	//go through the array of neighborhoods
	//find which neighborhood that individual belongs to
	//assign that individual to that neighborhood
		//pokemon.neighborhood = 14;
		//neighborhoodPokemon[14] = {23, 54, 72, 95};
	

}
