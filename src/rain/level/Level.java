package rain.level;

import rain.graphics.Screen;
import rain.level.tile.Tile;

//MAIN BASE GENERATION LEVEL
public class Level {

	protected int width, height;
	protected int[] tiles;
	
	
	//This constructor is to generate a random level as it call that method
	public Level(int width, int height){
		this.width = width;
		this.height = height;
		tiles = new int[width * height];		//number of tiles in the level
		generateLevel();
			
	}
	
	//This constructor is to call the load level from file as it calls that method
	public Level(String path){
		loadLevel(path);
	}
	
	//This method loads a level form file
	private void loadLevel(String path) {
		
		
	}
	
	// Method to generate the level from random
	protected void generateLevel() {
		
	}
	
	/*
	 This is to update the level, load bot's, creatures, and 
	 update there position	 
	 */
	public void update(){
		
	}
	
	//This method manages the time
	private void time(){
		
	}
	
	public void render(int xScroll, int yScroll, Screen screen){
		//The tiles are 16 pixels wide
		screen.setOffset(xScroll, yScroll);				//Set the location of the player to x AND yOffset
		int x0 = xScroll >> 4; 							//(The left side of the screen) - We multiply by 4 to deal at the pixel level
		int x1 = (xScroll + screen.width + 16) >> 4;	//The right side of the screen + 1 tile to finish edges
		int y0 = yScroll >> 4;							//The top of the screen
		int y1 = (yScroll + screen.height + 16) >> 4;	//The bottom of the screen + 1 tile to finish edges
		
		//This will cycle thru every number from top to bottom and right to left
		for(int y = y0 ; y < y1 ; y++){
			for(int x = x0 ; x < x1 ; x++){
				getTile(x, y).render(x, y, screen); //this will render the tile on to the screen
				
			}
		}
	}
	
	//This method will retrieve the tile needed
	public Tile getTile(int x, int y){
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;	//will prevent indexOutOfBounds
		if(tiles[x + y * width] == 0) return Tile.grass;	//will return a grass tile for the screen
		return Tile.voidTile;
		
	}
	
	
	
	
	
	
	
	
}
