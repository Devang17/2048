
public class Tile 
{
	int value = 0; 
	
	//Constructor to make an empty tile
	public Tile()
	{
		value = 0; 
	}
	
	
	//Constructor to make a tile with a value  
	public Tile(int value)
	{
		this.value = value; 
	}
	
	
	public int getValue()
	{
		return value;
	}

}
