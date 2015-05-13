
import java.util.*;

public class Neighborhood {

	private ArrayList<ArrayList<Pokemon>> listOfNeighborhoods;
	private int numberOfNeighborhoods = 20;
	private Pokemon[] neighborhoodBestArray = new Pokemon[numberOfNeighborhoods];

	/*
	 * Constructor: initializes the neighborhoods 
	 */
	public Neighborhood()
	{
		listOfNeighborhoods = new ArrayList<ArrayList<Pokemon>>(numberOfNeighborhoods);
		for (int i=0; i<numberOfNeighborhoods; i++)
		{
			listOfNeighborhoods.add(i, new ArrayList<Pokemon>());
		}
	}

	/*
	 * Clears the neighborhoods to remove old pokemon and make room for new pokemon
	 */
	public void clearNeighborhoods()
	{
		for (int i=0; i<numberOfNeighborhoods; i++)
		{
			(listOfNeighborhoods.get(i)).clear();
		}
	}

	/*
	 * Add pokemon to the neighborhoods 
	 */
	public void addToNeighborhood(Pokemon pokemon)
	{
		int counter = 0;
		for (int i=0; i<pokemon.getPossibleMovesArray().length-2; i++)
		{
			for (int j=i+1; j<pokemon.getPossibleMovesArray().length-1; j++)
			{
				for (int k=j+1; k<pokemon.getPossibleMovesArray().length; k++)
				{
					if (Arrays.asList(pokemon.getSelectedMovesArray()).contains((pokemon.getPossibleMovesArray())[i]) && 
							Arrays.asList(pokemon.getSelectedMovesArray()).contains((pokemon.getPossibleMovesArray())[j]) &&
							Arrays.asList(pokemon.getSelectedMovesArray()).contains((pokemon.getPossibleMovesArray())[k]))
					{
						ArrayList<Pokemon> neighborhood = listOfNeighborhoods.get(counter);
						neighborhood.add(pokemon);
						listOfNeighborhoods.set(counter, neighborhood);
						return;
					}
					counter++;
				}
			}
		}
	}

	/*
	 * Finds the neighborhood best for each neighborhood
	 */
	public void setNeighborhoodBest()
	{
		for (int i=0; i<numberOfNeighborhoods; i++)
		{
			if (listOfNeighborhoods.get(i).isEmpty())
			{
				neighborhoodBestArray[i] = null;
			}
			else 
			{
				Pokemon neighborhoodBest = listOfNeighborhoods.get(i).get(0);

				for (int j=1; j<listOfNeighborhoods.get(i).size(); j++)
				{
					Pokemon p = listOfNeighborhoods.get(i).get(j);

					if (p.getPersonalBest()>neighborhoodBest.getPersonalBest())
					{
						neighborhoodBest = p;
					}
				}
				neighborhoodBestArray[i] = neighborhoodBest;
			}
		}
	}
	
	/*
	 * Returns the neighborhood number for a given pokemon 
	 */
	public static int getNeighborhoodNumber(Move[] moves, Move[] possibleMoves)
	{
		int counter = 0;
		int number = -1;
		for (int i=0; i<possibleMoves.length-2; i++)
		{
			for (int j=i+1; j<possibleMoves.length-1; j++)
			{
				for (int k=j+1; k<possibleMoves.length; k++)
				{
					if (Arrays.asList(moves).contains(possibleMoves[i]) && Arrays.asList(moves).contains(possibleMoves[j]) && Arrays.asList(moves).contains(possibleMoves[k]))
					{
						number = counter;
					}
					counter++;
				}
			}
		}
		return number;
	}

	/*
	 * Getters and Setters
	 */
	public ArrayList<ArrayList<Pokemon>> getlistOfNeighborhoods()
	{
		return ((ArrayList<ArrayList<Pokemon>>)(listOfNeighborhoods.clone()));
	}

	public ArrayList<Pokemon> getNeighborhood(int index)
	{ 
		return ((ArrayList<Pokemon>)((listOfNeighborhoods.get(index)).clone()));
	}
	
	public Pokemon getNeighborhoodBest(int index)
	{
		return neighborhoodBestArray[index];
	}

	public int getnumberOfNeighborhoods()
	{
		return numberOfNeighborhoods;
	}

}
