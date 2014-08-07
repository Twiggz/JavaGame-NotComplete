package rain.graphics;


//We want one spite class where we can adjust, to suit every spite in the game
public class Sprite {

	public final int SIZE;
	private int x, y;	//coordinates of our sprite passed into the constructor
	public int[] pixels;
	private SpriteSheet sheet;
	
	/*
	 Creates a new STATIC version of the sprite class
	 SpriteSheet.tiles is from the new sheet created in the
	 SpriteSheet class
	*/
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);	
	public static Sprite voidSprite =  new Sprite(16, 0);			//This is the void tile
	
	//Constructor
	public Sprite(int size, int x, int y, SpriteSheet sheet){
		SIZE = size;
		pixels = new int[SIZE * SIZE];	//will create a new pixel array the size of our sprite
		this.x = x * size;				//this is setting the location our target sprite in the sheet
		this.y = y * size;				//this is setting the location our target sprite in the sheet
		this.sheet = sheet;
		load();
		
	}
	public Sprite(int size, int colour){
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColour(colour);
	}

	private void setColour(int colour) {
		for(int i = 0 ; i < SIZE*SIZE ; i++){
			pixels[i] = colour;
		}
		
	}
	private void load() {
		//Will search the SpriteSheet Class for our sprite
		for(int y = 0; y < SIZE; y++){
			for(int x = 0; x < SIZE; x++){
				/*
				 This is extracting a single sprite out of our sprite sheet.
				 Done by setting (of the array of pixels) them to a specific pixel
				 in the sprite sheet. Done by accessing every single pixel, then out of that 
				 extracting the appropriate sprite.
				 */
				pixels[x+y*SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
