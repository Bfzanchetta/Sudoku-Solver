public class Board
{
	/** loop constants */
	public static final int ZONE_SUM = 45;
	public static final int CELL_NUMBER = 9;
	public static final int ZONE_NUMBER = 3;
	
	/** dificulty constants */
	public static final int DIFICULTY_VERYEAZY   = 5;
	public static final int DIFICULTY_EAZY       = 4;
	public static final int DIFICULTY_MEDIUM     = 3;
	public static final int DIFICULTY_HARD       = 2;
	public static final int DIFICULTY_IMPOSSIBLE = 1;
	
	/** singleton */
	public static Board boardObject;	
	
	/** actual cells references */
	public static Cell[][] cellBoard = new Cell[9][9];
								
	private Board()
	{
		
	}			

	/** Retrieves the Singleton */
	public static Board getThisBoard()
	{
		if (boardObject == null)
			boardObject = new Board();
		return boardObject;
	}
	
	/** Populates the board depending on the dificulty */
	public static void populateCellBoard(int dificulty)
	{		
		cellBoard[0][0] = new Cell(7, 0, 0);
		cellBoard[0][2] = new Cell(2, 0, 2);
		cellBoard[0][4] = new Cell(5, 0, 4);
		cellBoard[0][6] = new Cell(6, 0, 6);
		cellBoard[1][5] = new Cell(3, 1, 5);
		cellBoard[2][0] = new Cell(1, 2, 0);
		cellBoard[2][5] = new Cell(9, 2, 5);
		cellBoard[2][6] = new Cell(5, 2, 6);
		cellBoard[3][0] = new Cell(8, 3, 0);
		cellBoard[3][7] = new Cell(9, 3, 7);
		cellBoard[4][1] = new Cell(4, 4, 1);
		cellBoard[4][2] = new Cell(3, 4, 2);
		cellBoard[4][6] = new Cell(7, 4, 6);
		cellBoard[4][7] = new Cell(5, 4, 7);
		cellBoard[5][1] = new Cell(9, 5, 1);
		cellBoard[5][8] = new Cell(8, 5, 8);
		cellBoard[6][2] = new Cell(9, 6, 2);
		cellBoard[6][3] = new Cell(7, 6, 3);
		cellBoard[6][8] = new Cell(5, 6, 8);
		cellBoard[7][3] = new Cell(2, 7, 3);
		cellBoard[8][2] = new Cell(7, 8, 2);
		cellBoard[8][4] = new Cell(4, 8, 4);
		cellBoard[8][6] = new Cell(2, 8, 6);
		cellBoard[8][8] = new Cell(3, 8, 8);
		
		for (int i=0; i< CELL_NUMBER; i++)
		{
			for (int j=0; j< CELL_NUMBER; j++)
			{
				if (cellBoard[i][j] == null)
					cellBoard[i][j] = new Cell(0, i, j);
			}
		}
	}
	
	/** prints current board */	
	public static void printMyBoard()
	{
		for (int i=0; i< CELL_NUMBER; i++)
		{
			for (int j=0; j< CELL_NUMBER; j++)
			{
				System.out.print(cellBoard[i][j].value);
			}
			System.out.print("\n");
		}
	}
	
	/** Given a cell unit, returns the 3x3 zone that is belongs */
	public static Cell[][] getZone(Cell cell)
	{
		if ((cell == null) || (cell.zone == Cell.ZONE_ID_ERROR))
			return null;
		
		Cell[][] miniCell = new Cell[3][3];
		int xIndex = ((cell.zone > 3) ? ((cell.zone > 6) ? 6 : 3) : 0);
		int yIndex = ((((cell.zone)%3)-1)*3);
				
		miniCell[0][0] = cellBoard[xIndex][yIndex];
		miniCell[0][1] = cellBoard[xIndex][yIndex+1];
		miniCell[0][2] = cellBoard[xIndex][yIndex+2];
		miniCell[1][0] = cellBoard[(xIndex + 1)][yIndex];
		miniCell[1][1] = cellBoard[(xIndex + 1)][(yIndex + 1)];
		miniCell[1][2] = cellBoard[(xIndex + 1)][(yIndex + 2)];
		miniCell[2][0] = cellBoard[(xIndex + 2)][yIndex];
		miniCell[2][1] = cellBoard[(xIndex + 2)][(yIndex + 1)];
		miniCell[2][2] = cellBoard[(xIndex + 2)][(yIndex + 2)];
		
		printZone(miniCell);
		
		return miniCell; 
	}
	
	/** Get the row of the given cell */
	public static Cell[] getRow(Cell cell)
	{
		if ((cell == null) || (cell.zone == Cell.ZONE_ID_ERROR))
			return null;
		
		Cell[] miniCell = new Cell[9];
		int x = cell.xPosition;	
			
		for (int i=0; i< CELL_NUMBER; i++)
		{
			miniCell[i] = cellBoard[x][i];
			System.out.print("" + miniCell[i].value);
		}			
		System.out.print("\n");
		
		return miniCell; 
	}
	
	/** Get the column of the given cell */
	public static Cell[] getCol(Cell cell)
	{
		if ((cell == null) || (cell.zone == Cell.ZONE_ID_ERROR))
			return null;
		
		Cell[] miniCell = new Cell[9];
		int y = cell.yPosition;
				
		for (int i=0; i< CELL_NUMBER; i++)
		{
			miniCell[i] = cellBoard[i][y];
			System.out.print("" + miniCell[i].value + "\n");
		}			
		
		
		return miniCell; 
	}
	
	/** Get the row of the given index */
	public static Cell[] getRow(int xIndex)
	{	
		if ((xIndex < 0) || (xIndex > 8))
			return null;
		
		Cell[] miniCell = new Cell[9];
				
		for (int i=0; i< CELL_NUMBER; i++)
		{
			miniCell[i] = cellBoard[xIndex][i];
			System.out.print("" + miniCell[i].value);
		}			
		System.out.print("\n");
		
		return miniCell; 
	}
	
	/** Get the column of the given index */
	public static Cell[] getCol(int yIndex)
	{
		if ((yIndex < 0) || (yIndex > 8))
			return null;
		
		Cell[] miniCell = new Cell[9];
				
		for (int i=0; i< CELL_NUMBER; i++)
		{
			miniCell[i] = cellBoard[i][yIndex];
			System.out.print("" + miniCell[i].value + "\n");
		}			
		
		return miniCell; 
	}
	
	/** Prints a given zone */
	public static void printZone(Cell[][] zone)
	{
		for (int i=0; i< ZONE_NUMBER; i++)
		{
			for (int j=0; j< ZONE_NUMBER; j++)
			{
				System.out.print(zone[i][j].value);
			}
			System.out.print("\n");
		}
	}
	
}