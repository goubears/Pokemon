
import java.util.*;

public class Move {

	//pokemon types
	private static int EEVEE = 1;
	private static int PIKACHU = 2;
	private static int CHARMANDER = 3;
	private static int MEOWTH = 4;
	private static int HOUNDOUR = 5;
	//private static int KOFFING = 6;

	//pokemon moves
	private static Move EEVEE_SAND_ATTACK = new Move("Sand Attack", true, "accuracy", 10, 1.0);
	private static Move EEVEE_TAIL_WHIP = new Move("Tail Whip", true, "defense", 10, 1.0);
	private static Move EEVEE_GROWL = new Move("Growl", true, "attack", 10, 1.0);
	private static Move EEVEE_QUICK_ATTACK = new Move("Quick Attack", true, "first", 40, 1.0);
	private static Move EEVEE_BITE = new Move("Bite", false, "none", 60, 1.0);
	private static Move EEVEE_TAKE_DOWN = new Move("Take Down", false, "none", 100, 0.75);

	private static Move PIKACHU_GROWL = new Move("Growl", true, "attack", 10, 1.0);
	private static Move PIKACHU_TAIL_WHIP = new Move("Tail Whip", true, "defense", 10, 1.0);
	private static Move PIKACHU_THUNDER_WAVE = new Move("Thunder Wave", true, "paralyze", 0, 1.0);
	private static Move PIKACHU_QUICK_ATTACK = new Move("Quick Attack", true, "first", 30, 1.0);
	private static Move PIKACHU_THUNDER_SHOCK = new Move("Thunder Shock", false, "none", 50, 1.0);
	private static Move PIKACHU_SLAM = new Move("Slam", false, "none", 80, 0.85);

	private static Move CHARMANDER_GROWL = new Move("Growl", true, "attack", 10, 1.0);
	private static Move CHARMANDER_LEER = new Move("Leer", true, "defense", 10, 1.0);
	private static Move CHARMANDER_FIRE_SPIN = new Move("Fire Spin", true, "burn", 0, 1.0);
	private static Move CHARMANDER_EMBER = new Move("Ember", false, "none", 40, 1.0);
	private static Move CHARMANDER_SLASH = new Move("Slash", false, "none", 70, 0.85);
	private static Move CHARMANDER_FLAMETHROWER = new Move("Flamethrower", false, "none", 90, 0.75);

	private static Move MEOWTH_GROWL = new Move("Growl", true, "attack", 10, 1.0);
	private static Move MEOWTH_SCREECH = new Move("Screech", true, "defense", 10, 1.0);
	private static Move MEOWTH_SCRATCH = new Move("Scratch", false, "none", 40, 1.0);
	private static Move MEOWTH_FURY_SWIPES = new Move("Fury Swipes", false, "none", 50, 0.95);
	private static Move MEOWTH_BITE = new Move("Bite", false, "none", 60, 0.90);
	private static Move MEOWTH_SLASH = new Move("Slash", false, "none", 70, 0.85);

	private static Move HOUNDOUR_HOWL = new Move("Howl", true, "attack", 10, 1.0);
	private static Move HOUNDOUR_LEER = new Move("Leer", true, "defense", 10, 1.0);
	private static Move HOUNDOUR_DARK_VOID = new Move("Dark Void", true, "sleep", 0, 0.75);
	private static Move HOUNDOUR_BITE = new Move("Bite", false, "none", 60, 1.0);
	private static Move HOUNDOUR_FEINT_ATTACK = new Move("Feint Attack", false, "none", 70, 0.95);
	private static Move HOUNDOUR_CRUNCH = new Move("Crunch", false, "none", 80, 0.90);

	private static Move KOFFING_HAZE = new Move("Haze", true, "reset", 0, 1.0);
	private static Move KOFFING_SMOKE_SCREEN = new Move("Smoke Screen", true, "accuracy", 10, 1.0);
	private static Move KOFFING_POISON_GAS = new Move("Poison Gas", true, "poison", 0, 1.0);
	private static Move KOFFING_SMOG = new Move("Smog", false, "none", 30, 1.0);
	private static Move KOFFING_TACKLE = new Move("Tackle", false, "none", 50, 0.90);
	private static Move KOFFING_SLUDGE = new Move("Sludge", false, "none", 70, 0.80);

	//move attributes
	private String nameOfMove;
	private boolean statusChangingMove;
	private String typeOfStatusChange;
	private int movePower;
	private double moveAccuracy;

	/*
	 * Constructor: initializes the individual moves
	 */
	public Move(String name, boolean status, String type, int power, double accuracy)
	{
		nameOfMove = name;
		statusChangingMove = status;
		typeOfStatusChange = type;
		movePower = power;
		moveAccuracy = accuracy;
	}

	/*
	 * Returns an array of possible moves given the type of pokemon
	 */
	public static Move[] getPossibleMoves(int nameOfPokemon)
	{		
		if (nameOfPokemon == EEVEE)
		{
			Move[] possibleMoves = new Move[]{EEVEE_SAND_ATTACK, EEVEE_TAIL_WHIP, EEVEE_GROWL, EEVEE_QUICK_ATTACK, EEVEE_BITE, EEVEE_TAKE_DOWN};
			return possibleMoves;
		}
		else if (nameOfPokemon == PIKACHU)
		{
			Move[] possibleMoves = new Move[]{PIKACHU_GROWL, PIKACHU_TAIL_WHIP, PIKACHU_THUNDER_WAVE, PIKACHU_QUICK_ATTACK, PIKACHU_THUNDER_SHOCK, PIKACHU_SLAM};
			return possibleMoves;
		}
		else if (nameOfPokemon == CHARMANDER)
		{
			Move[] possibleMoves = new Move[]{CHARMANDER_GROWL, CHARMANDER_LEER, CHARMANDER_FIRE_SPIN, CHARMANDER_EMBER, CHARMANDER_SLASH, CHARMANDER_FLAMETHROWER};
			return possibleMoves;
		}
		else if (nameOfPokemon == MEOWTH)
		{
			Move[] possibleMoves = new Move[]{MEOWTH_GROWL, MEOWTH_SCREECH, MEOWTH_SCRATCH, MEOWTH_FURY_SWIPES, MEOWTH_BITE, MEOWTH_SLASH};
			return possibleMoves;
		}
		else if (nameOfPokemon == HOUNDOUR)
		{
			Move[] possibleMoves = new Move[]{HOUNDOUR_HOWL, HOUNDOUR_LEER, HOUNDOUR_DARK_VOID, HOUNDOUR_BITE, HOUNDOUR_FEINT_ATTACK, HOUNDOUR_CRUNCH}; 
			return possibleMoves;
		}
		else //(nameOfPokemon == KOFFING)
		{
			Move[] possibleMoves = new Move[]{KOFFING_HAZE, KOFFING_SMOKE_SCREEN, KOFFING_POISON_GAS, KOFFING_SMOG, KOFFING_TACKLE, KOFFING_SLUDGE}; 
			return possibleMoves;
		}  
	}

	/*
	 * Returns an array of selected moves for the given pokemon
	 */
	public static Move[] getSelectMoves(Move[] possibleMoves, int moveLimit)
	{
		//random number generator
		Random random = new Random();

		Move[] moves = new Move[moveLimit]; 

		for (int i=0; i<moveLimit; i++)
		{
			while (moves[i] == null)
			{
				int randomMove = random.nextInt(possibleMoves.length); //select random move from possible moves

				if (!Arrays.asList(moves).contains(possibleMoves[randomMove])) //don't want to duplicate moves
				{
					moves[i] = possibleMoves[randomMove];
				}
			}
		}

		return moves;
	}

	/*
	 * Returns an array of selected moves for the given pokemon
	 */
	public static Move[] mutateSelectMoves(Move[] moves, Move[] possibleMoves)
	{
		//random number generator
		Random random = new Random();

		//select random move from array of moves -> mutate that move
		int randomMove = random.nextInt(moves.length); 
		moves[randomMove] = null;

		while (moves[randomMove] == null)
		{
			int randomNewMove = random.nextInt(possibleMoves.length); //select random move from possible moves

			if (!Arrays.asList(moves).contains(possibleMoves[randomNewMove])) //don't want to duplicate moves
			{
				moves[randomMove] = possibleMoves[randomNewMove];
			}
		}

		return moves;
	}

	/*
	 * Getters and Setters
	 */
	public String getNameOfMove()
	{
		return nameOfMove;
	}

	public void setNameOfMove(String name)
	{
		nameOfMove = name;
	}

	public boolean getMoveStatus()
	{
		return statusChangingMove;
	}

	public void setMoveStatus(boolean status)
	{
		statusChangingMove = status;
	}

	public String getStatusType()
	{
		return typeOfStatusChange;
	}

	public void setStatusType(String type)
	{
		typeOfStatusChange = type;
	}

	public int getMovePower()
	{
		return movePower;
	}

	public void setMovePower(int power)
	{
		movePower = power;
	}

	public double getMoveAccuracy()
	{
		return moveAccuracy;
	}

	public void setMoveAccuracy(double accuracy)
	{
		moveAccuracy = accuracy;
	}

}
