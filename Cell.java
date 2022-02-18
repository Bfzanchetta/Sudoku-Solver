public class Cell
{
	/** constants that map to which zone the cell belongs to */
	public static final int ZONE_ID_ERROR = -1;
	public static final int ZONE_ID_ONE   = 1;
	public static final int ZONE_ID_TWO   = 2;
	public static final int ZONE_ID_THREE = 3;
	public static final int ZONE_ID_FOUR  = 4;
	public static final int ZONE_ID_FIVE  = 5;
	public static final int ZONE_ID_SIX   = 6;
	public static final int ZONE_ID_SEVEN = 7;
	public static final int ZONE_ID_EIGHT = 8;
	public static final int ZONE_ID_NINE  = 9;
	
	/** actual cell /0-9/ value */
	int value;
	/** matrix x and y positions */
	int xPosition;
	int yPosition;
	/** zone that current cell belongs to */
	int zone;
	
	public Cell()
	{
		
	}
	
	public Cell(int v, int x, int y)
	{
		this.value = v;
		this.xPosition = x;
		this.yPosition = y;
		this.zone = getZoneId(x, y);
	}
	
	/** Given the cells x and y position, returns its zone */
	public int getZoneId(int x, int y)
	{
		if ((x < 3) && (y < 3))
		{
			return ZONE_ID_ONE;
		}
		else if ((x < 3) && (y < 6))
		{
			return ZONE_ID_TWO;
		}
		else if ((x < 3) && (y < 9))
		{
			return ZONE_ID_THREE;
		}
		else if ((x < 6) && (y < 3))
		{
			return ZONE_ID_FOUR;
		}
		else if ((x < 6) && (y < 6))
		{
			return ZONE_ID_FIVE;
		}
		else if ((x < 6) && (y < 9))
		{
			return ZONE_ID_SIX;
		}
		else if ((x < 9) && (y < 3))
		{
			return ZONE_ID_SEVEN;
		}
		else if ((x < 9) && (y < 6))
		{
			return ZONE_ID_EIGHT;
		}
		else if ((x < 9) && (y < 9))
		{
			return ZONE_ID_NINE;
		}
		return ZONE_ID_ERROR;
	}
}