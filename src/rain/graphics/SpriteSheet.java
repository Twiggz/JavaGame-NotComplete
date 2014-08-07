package rain.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


//This class will load the SpriteSheet into the program
public class SpriteSheet {

	private String path;
	public final int SIZE;
	public int[] pixels;
	
	/*
	-This will load the sprite sheet into the game 
	-Will pass the pathname to the sheet and the size of
	-Size is the size of the sheet
	START path at resources folder and start with "/"
	*/
	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);
	
	//Constructor
	public SpriteSheet(String path, int size){
		this.path = path;
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		load();		//Will call the load method and load the method into the "pixels" array
	}
	
	private void load(){
		try {
			//This line of code throws an exception so we nee try catch
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);		//This will set the buffered image into the pixel array
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
}
