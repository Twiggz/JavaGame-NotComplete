package rain.level.tile;

import rain.graphics.Screen;
import rain.graphics.Sprite;



public class Tile {

	public int x, y;
	public Sprite sprite;
	
	public static Tile grass =  new GrassTile(Sprite.grass);	//make new grass tile
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	//Constructor
	public Tile(Sprite sprite){
		this.sprite = sprite;
	}
	
	//Every tile renders itself
	public void render(int x, int y, Screen screen){
		
		
	}
	
	public boolean solid(){		
		return false;		//by default it has to return
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
