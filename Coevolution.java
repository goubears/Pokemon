import java.io.*;
import java.util.*;
import java.util.Vector;



public class Coevolution{
	
	private Vector<Pokemon> eevee1 = new Vector<Pokemon>();
	private Vector<Pokemon> eevee2 = new Vector<Pokemon>();


	public Coevolution(Vector<Pokemon> eev1, Vector<Pokemon> eev2){
		eevee1 = (Vector<Pokemon>)eev1.clone();
		eevee2 = (Vector<Pokemon>)eev2.clone();

		// if((eevee1.equals(eev1)) && (eevee2.equals(eev2))){
		// 	System.out.println("true");
		// }
	}

	public Vector<Pokemon> getEevee1(){
		return eevee1;
	}

	public Vector<Pokemon> getEevee2(){
		return eevee2;
	}


}