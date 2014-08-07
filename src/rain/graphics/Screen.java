package rain.graphics;

import java.util.Random;

import rain.level.tile.Tile;

public class Screen {

	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles =  new int[MAP_SIZE * MAP_SIZE];
	
	public int xOffset, yOffset;	//For when the player moves
	
	private Random random = new Random();
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];	//This make one integer for each pixel in the game
		
		for(int i = 0; i < MAP_SIZE*MAP_SIZE; i++){
			tiles[i] = random.nextInt(0xffffff);		//will add random colors
			
			
		}
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;	//this will set every pixels in the array to 0/black
		}
	}
	
	//public void render(int xOffset, int yOffset){
		//for(int y=0; y < height; y++){	
			//int yp = y + yOffset;
			//if(yp < 0 || yp >= height) continue;
			//for(int x=0; x < width; x++){
				//int xp = x + xOffset;
				//if(xp < 0 || xp >= width) continue;
				//Every 32 by 32
				//int tileIndex = ((xx >> 4) & MAP_SIZE_MASK) + ((yy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;	//in code the y == 4		
				//pixels[xp + yp * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];			
			//}
		//}	
	//}
	
	//Method to calculate the offset and render tiles based on player position
	public void renderTile(int xp, int yp, Tile tile){
		xp -= xOffset;	//adjusting the x location of the tile by the offset
		yp -= yOffset;	//adjusting the y location of the tile by the offset
		for(int y = 0; y < tile.sprite.SIZE; y++){		//offset thru y
			int ya = y + yp;
			for(int x = 0; x < tile.sprite.SIZE; x++){	//offset thru x
				int xa = x + xp;
				if(xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;	//xa is the horizontal
				if(xa < 0) xa = 0;
				//if a tile was at the edge of the screen stop rendering that tile
				pixels[xa + ya * width] =  tile.sprite.pixels[x + y * tile.sprite.SIZE];	//which pixels of the sprite get rendered
			}
		}			
	}
	
	/*
	 Pass in the 2 offset parameters from the fields 
	 and adjust the "yp" variable in the render tile method
	 */
	public void setOffset(int xOffset, int yOffset){
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}

