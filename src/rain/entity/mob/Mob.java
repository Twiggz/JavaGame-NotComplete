package rain.entity.mob;

import rain.entity.Entity;
import rain.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite Sprite;
	protected int dir = 0;
	protected boolean moving = false;	//mobs have an animation 
	
	
	public void move(int xa, int ya){	//"xa" is which way movement is on the x-axis, and "ya" is for the y-axis
		if(xa > 0) dir = 1;		//movement is east
		if(xa < 0) dir = 3;		//movement is west
		if(ya > 0) dir = 2;		//movement is south
		if(ya < 0) dir = 0;		//movement is north
		
		if(!collision()){
		x += xa;
		y += ya;
		}
	}
	
	public void update(){

	}
	
	private boolean collision(){
		return false;
	}
	
	
	public void render(){
		
	}
	
	
	
	
	
}
