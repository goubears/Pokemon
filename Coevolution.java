
import java.util.*;

public class Coevolution{
	
	private ArrayList<Pokemon> eevee1 = new ArrayList<Pokemon>();
	private ArrayList<Pokemon> eevee2 = new ArrayList<Pokemon>();

	public Coevolution(ArrayList<Pokemon> eev1, ArrayList<Pokemon> eev2)
	{
		eevee1 = (ArrayList<Pokemon>)eev1.clone();
		eevee2 = (ArrayList<Pokemon>)eev2.clone();
	}

	public ArrayList<Pokemon> getEevee1()
	{
		return eevee1;
	}

	public ArrayList<Pokemon> getEevee2()
	{
		return eevee2;
	}
	
}
