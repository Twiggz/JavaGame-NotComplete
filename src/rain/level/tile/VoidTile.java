package rain.level.tile;

import rain.graphics.Screen;
import rain.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
		
	}
	//Copy and pasted from the "grassTile" class"
	public void render(int x, int y, Screen screen){
		//Do render stuff here
		screen.renderTile(x << 4, y << 4, this);		//"this" is the type of tile being called 
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
