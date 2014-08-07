package rain.entity.mob;

import rain.input.Keyboard;

public class Player extends Mob {
	
	private Keyboard input;
	
	//Spawning location when starting
	public Player(Keyboard input){
		this.input = input;
	}
	
	//Load into new area/realm of X and Y
	public Player(int x, int y, Keyboard input){
		this.x = y;
		this.y = y;
		this.input = input;
	}
	
	public void update(){
		int xa = 0, ya = 0;
		if(input.up)	ya--;
		if(input.down)	ya++;
		if(input.left)	xa--;
		if(input.right)	xa++;
		
		if(xa != 0 || ya != 0) move(xa, ya);
	}
	
	
	public void render(){
		
	}
	
	
	
	
	
	
	
	
	
}
