package com.Snekabel.LoveLove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class MainMenu  implements Screen{
	//Needed for most things
	final LoveLoveGame game;
	int width = Gdx.graphics.getWidth();
	int height = Gdx.graphics.getHeight();
	private SpriteBatch spriteBatch;
	private CharSequence str;
	Point touchPos;
	private OrthographicCamera camera;
	private Array<Button> Buttons = new Array<Button>();
	
	public MainMenu(final LoveLoveGame game)
	{
        this.game = game;
	}
	
	private Sprite logoSprite;
	private Sprite cloudSprite;
	private Sprite cloudButtonSprite;
	private Sprite girlSprite;
	private BitmapFont font1;
	private Array<Point> Clouds = new Array<Point>();
	int girlTimer = 900;
	int currentGirlSprite = 0;
	int maxGirlSprites = Resources.getGirlsTextures().size;

	
	@Override
	public void render(float delta) {
		//Set Background color to Red
		Gdx.graphics.getGL20().glClearColor( 1, 0, 0, 1 );	
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//If its time, update shown girl.
		if(girlTimer == 0)
		{
			currentGirlSprite++;
			if(currentGirlSprite == maxGirlSprites)
			{
				currentGirlSprite = 0;
			}
			girlSprite = new Sprite(Resources.getGirlsTextures().get(currentGirlSprite));
			girlTimer = 900;
		}
		girlTimer--;
		System.out.println(girlTimer);
		
		//Move Clouds
		for(int i = 0; i < Clouds.size; i++)
        {
			Point cloud = Clouds.get(i);
        	cloud.x = (cloud.x - 5);
        	if(cloud.x < 0-512)
        	{
        		cloud.x = width;
        	}
        }
		
        spriteBatch.begin();
        //Draw Clouds
        for(int i = 0; i < Clouds.size; i++)
        {
        	spriteBatch.draw(cloudSprite, Clouds.get(i).x, Clouds.get(i).y);
        }
        
        //Draw logo in center
        spriteBatch.draw(logoSprite, width/100*50-(logoSprite.getWidth()/2), height/100*60);
        
        //Draw Girl
        spriteBatch.draw(girlSprite, width/100*70, height/100*10);
        
        //Draw MainMenu Buttons to the left
        for(Button button : Buttons)
        {
	        spriteBatch.draw(button.getSprite(), button.getLocation().x, button.getLocation().y);
	        font1.draw(spriteBatch, button.getText(), button.getTextLocation().x, button.getTextLocation().y);
        }
        spriteBatch.end();
        
        //Check for inputs
        if(Gdx.input.justTouched())
        {
        	//Get the Point that was touched
        	Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        	System.out.println(touchPos);
        	camera.unproject(touchPos);
        	
        	//Check if any of the buttons where pressed
        	for(Button button : Buttons)
            {
        		if(button.isTouched(touchPos))
            	{
            		System.out.println("Pressed " + button.getText());
            		game.setScreen(new MainMenu(game));
            	}
            }
        }
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show() {
		//Everything that should be loaded when the Screen appears
		camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        
		logoSprite = new Sprite(Resources.getGUITextures().get(0));
		cloudSprite = new Sprite(Resources.getGUITextures().get(1));
		girlSprite = new Sprite(Resources.getGirlsTextures().get(0));
		cloudButtonSprite = new Sprite(Resources.getGUITextures().get(2));
		font1 = Resources.getFonts().get(0);
		spriteBatch = new SpriteBatch();
		
		//Make clouds
		for(int i = 0; i < 5; i++)
        {
        	Clouds.add(new Point(MathUtils.random(0, width), MathUtils.random(0, height)));
        }
		
		//Make Buttons
		Buttons.add(new Button(cloudButtonSprite, "New Game", new Point(width/100*1, height/100*60)));
		Buttons.add(new Button(cloudButtonSprite, "Continue Game", new Point(width/100*1, height/100*40)));
		Buttons.add(new Button(cloudButtonSprite, "Exit to DOS", new Point(width/100*1, height/100*20)));
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	
}
