import java.util.*;

class Main
{	
	private static Board myBoard;
		
	public static void main(String[] args)
	{
		myBoard = Board.getThisBoard();
		myBoard.populateCellBoard(Board.DIFICULTY_VERYEAZY);
		
		printTextDivision();
		
		myBoard.printMyBoard();
		
		printTextDivision();
		
		myBoard.getZone(new Cell(9, 6, 2));
		
		printTextDivision();
		
		myBoard.getRow(new Cell(9, 6, 2));
		
		printTextDivision();
		
		myBoard.getCol(new Cell(9, 6, 2));
	}
	
	public static void printTextDivision()
	{
		System.out.println("\n");
		System.out.println("*************** \n");
		System.out.println("\n");
	}
}