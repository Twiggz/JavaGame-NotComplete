package rain.level;

import java.util.Random;

public class RandomLevel extends Level {
	
	private static final Random random = new Random();

	public RandomLevel(int width, int height) {
		 /*
		 					SUPER MEANS
		 Whatever parameters are input into this constructor 
		 method will be passed/input back into the "Level"
		 class, since it has "extended" to it in the main 
		 class declaration. And will also execute all the
		 code there as well.
		 */
		super(width, height);			
	}
	
	protected void generateLevel(){
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x + y * width] = random.nextInt(4);	
				
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
