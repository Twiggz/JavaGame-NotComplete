package rain; //the package for this class is "rain"

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import rain.entity.mob.Player;
import rain.graphics.Screen;
import rain.input.Keyboard;
import rain.level.Level;
import rain.level.RandomLevel;

//Canvas is where the game is "painted" or a blank rectangle on the screen
//By extending canvas game inherits canvas
public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	public static int width = 300;
	//public static int height = 168;
	public static int height = width / 16 * 9;
	public static int scale = 3;			//how much the width and height is going to be scaled
	public static String title = "Rain";
	
	private Keyboard key;
	private Thread thread;					//Threads are sub processes
	private JFrame frame; 					//JFrame is basically the windows
	private boolean running = false;		//is the program running or not
	private Level level; 
	private Screen screen;
	public Player player;

	/*This is the image with a buffer with the array below
	 *Essentially the below 2 lines make and image for us to draw things onto
	 *The 2nd line allows us to draw things onto said image
	 */
	private BufferedImage image =  new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

	//Constructor
	public Game(){
		Dimension size = new Dimension(width*scale, height*scale);
		setPreferredSize(size); 			//Will set preferred size of the window to this.

		screen = new Screen(width, height);	//This will make a new screen object in the other class
		frame = new JFrame();				// Will create a new instance of the JFrame
		level  = new RandomLevel(64, 64);
		player = new Player(key);			//makes a new player with keyboard input so we can use the KB in the player class
		key = new Keyboard();				//add this 1st ALWAYS
		addKeyListener(key);				//add this second ALWAYS
	}

	//Sync ensures there are no overlaps
	//This method will start the game
	public synchronized void start(){
		running = true;	//when the game is started running == true
		thread = new Thread(this, "Display"); //name is display
		/*
		 Because the class implements "Runnable" and new Thread is set to "this",
		 when one starts the thread on the line below it will automatically runs
		 the run(); method.
		 */
		thread.start();	

	}


	//threads will start the game
	//This method will stop the game
	public synchronized void stop(){
		running = false;	//will stop the game
		try{
			thread.join();	//thread throws and exception and we need to catch it
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//When we start the program it will implement/run this method
	public void run(){

		long lastTime = System.nanoTime();		//the computers current time in nanoseconds
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;	//60 is number of update p/s
		double delta = 0;
		int frames = 0;							//will count how many frames we have time to render/s
		int updates = 0;						//measures how many times the update() method gets called

		requestFocus();							//Will make it so we don't have to click on the screen

		while(running){							//while running == true
			long now = System.nanoTime();
			delta += (now-lastTime)/ns;			//add to delta the difference between now and lastTime / ns
			lastTime = now;						//update lastTime

			while(delta >= 1){
				update();						// this method handles all the logic
				updates++;
				delta--;
			}
			//Both render and update are below this method
			render();							// this will display images on the screen
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;	//add 1 second
				System.out.println(updates + " Updates p/s, " + frames + " Frames p/s.");
				frame.setTitle(title + "   |   " + updates + " Updates p/s, " + frames + " Frames p/s.");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}


	public void update(){
		key.update();							//update the keyboard inputs
		player.update();						//update the player class

	}


	public void render(){
		// A buffer is a temporary storage place for data
		BufferStrategy bs = getBufferStrategy();		//Java's inbuilt buff strategy updates

		/*
		If the canvas is returning null for the BufferStrategy
		create it in the if loop below with triple buffering, 
		then return
		 */
		if(bs == null){
			createBufferStrategy(3);//ALWAYS HAVE 3 BUFFERS
			return;
		}
		screen.clear();									//clear the screen from the screen class
		level.render(player.x, player.y, screen);		//will update the player position to screen thru the level extends player class
		//screen.render(x,y);							//then render the new image onto the screen from the screen class

		for(int i=0; i<pixels.length; i++){				//the array pixels
			pixels[i] = screen.pixels[i];				//will set every pixel == to the other classes "Screen" loop
		}

		Graphics g = bs.getDrawGraphics();				//Creates a link between you drawing and the buffer
		//g.setColor(Color.BLACK); 					
		//g.fillRect(0, 0, getWidth(), getHeight());	//Both are built into the canvas class, both return int
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();									//This disposes of the current graphics at the end of each frame
		bs.show();      								//This will make the next buffer visible

	}




	//THE MAIN METHOD
	//This is where the program/game starts
	public static void main(String[] args){
		Game game =  new Game();						// Will create a new instance of the game
		game.frame.setResizable(false);					//This will stop the window from being resized
		game.frame.setTitle(Game.title);				//window title
		game.frame.add(game);							//adds a components to the frame, it fills the window with something
		game.frame.pack();								//set the size of the frame according the size of the components
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 	//Will close on exit button
		game.frame.setLocationRelativeTo(null); 		//will make the window in the center of the screen
		game.frame.setVisible(true);					//Show the window as set to true

		game.start();
	}












}
