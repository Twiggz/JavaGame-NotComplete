package rain.level.tile;

import rain.graphics.Screen;
import rain.graphics.Sprite;

public class GrassTile extends Tile {

	public GrassTile(Sprite sprite) {
		super(sprite);		//super is explained in the RandomLeven Class

	}
	
	public void render(int x, int y, Screen screen){
		//Do render stuff here
		screen.renderTile(x << 4, y << 4, this);		//"this" is the type of tile being called in this case a grassTile
	}
	










}
