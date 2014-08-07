package rain.entity;

import java.util.Random;

import rain.entity.mob.Player;
import rain.graphics.Screen;
import rain.level.Level;

public abstract class Entity {
	
	public int x, y;					//control the location of any entity on the map
	private boolean removed = false;	//removed from level or not
	protected Level level;
	protected final Random random = new Random();
	public Player player;
	
	//This will run 60 times p/s
	public void update(){

	}
	
	
	public void render(Screen screen){
		
	}
	
	
	public void remove(){
		//Remove entity from level
		removed = true;
	}
	
	
	public boolean isRemoved(){
		return removed;
	}
	
	
	
	
	
	
	
}