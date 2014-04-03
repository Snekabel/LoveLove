package com.Snekabel.LoveLove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

public class NewGameScreen implements Screen {
	//Needed for most things
	final LoveLoveGame game;
	int width = Gdx.graphics.getWidth();
	int height = Gdx.graphics.getHeight();
	private SpriteBatch spriteBatch;
	Point touchPos;
	private OrthographicCamera camera;
	private Array<Button> Buttons = new Array<Button>();
		
	public NewGameScreen(final LoveLoveGame game)
	{
        this.game = game;
	}
	
	//From here its Screen-specifik stuffs
	private BitmapFont font1;
	private Sprite cloudButtonSprite;

	@Override
	public void render(float delta) {
		//Set Background color to Red
		Gdx.graphics.getGL20().glClearColor( 1, 0, 0, 1 );	
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		spriteBatch.begin();
		
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
            font1 = Resources.getFonts().get(0);
        	
        	//Check if any of the buttons where pressed
        	for(int i = 0; i < Buttons.size; i++)
            {
        		Button button = Buttons.get(i);
        		if(button.isTouched(touchPos))
            	{
        			System.out.println("Pressed " + button.getText());
	        		switch (i)
	        		{
	        			case 0:
	        					game.setScreen(new MainMenu(game));
	        				break;
	        		}
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
        spriteBatch = new SpriteBatch();
        font1 = Resources.getFonts().get(0);
        
        //Ladda in saker specefikt för denna screen
        cloudButtonSprite = new Sprite(Resources.getGUITextures().get(2));
        
		//Make Buttons
		Buttons.add(new Button(cloudButtonSprite, "Back", new Point(width/100*1, height/100*1)));
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
