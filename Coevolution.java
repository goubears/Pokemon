import java.io.*;
import java.util.*;
import java.util.Collections;



public class Coevolution{
	
	private Vector<Pokemon> eevee1 = new Vector<Pokemon>();
	private Vector<Pokemon> eevee2 = new Vector<Pokemon>();


	public Coevolution(Vector<Pokemon> eev1, Vector<Pokemon> eev2){
		Collections.copy(eevee1, eev1);
		Collections.copy(eevee2, eev2);
	}

	public Vector<Pokemon> getEevee1(){
		return eevee1;
	}

	public Vector<Pokemon> getEevee2(){
		return eevee2;
	}


}