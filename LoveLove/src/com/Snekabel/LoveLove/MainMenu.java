package com.Snekabel.LoveLove;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class MainMenu  implements Screen{
	final Game game;
	private Sprite logoSprite;
	private Sprite cloudSprite;
	private Sprite cloudButtonSprite;
	private Sprite girlSprite;
	private SpriteBatch spriteBatch;
	private CharSequence str;
	private BitmapFont font1;
	private Array<Point> Clouds = new Array<Point>();
	int width = Gdx.graphics.getWidth();
	int height = Gdx.graphics.getHeight();
	int girlTimer = 900;
	
	int currentGirlSprite = 0;
	int maxGirlSprites = Resources.getGirlsTextures().size;
	
	public MainMenu(final LoveLoveGame game)
	{
        this.game = game;
	}
	
	@Override
	public void render(float delta) {
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
        	cloud.setX(cloud.getX() - 5);
        	if(cloud.getX() < 0-512)
        	{
        		cloud.setX(width);
        	}
        }
		
        spriteBatch.begin();
        //Draw Clouds
        for(int i = 0; i < Clouds.size; i++)
        {
        	spriteBatch.draw(cloudSprite, Clouds.get(i).getX(), Clouds.get(i).getY());
        }
        
        //Draw logo in center
        spriteBatch.draw(logoSprite, width/100*25, height/100*60);
        
        //Draw Girl
        spriteBatch.draw(girlSprite, width/100*70, height/100*10);
        
        //Draw MainMenu Buttons to the left
        spriteBatch.draw(cloudButtonSprite, width/100*1, height/100*60);
        str = "New Game";
        font1.draw(spriteBatch, str, width/100*1, height/100*68);
        
        spriteBatch.draw(cloudButtonSprite, width/100*1, height/100*40);
        str = "Continue Game";
        font1.draw(spriteBatch, str, width/100*1, height/100*48);
        
        spriteBatch.draw(cloudButtonSprite, width/100*1, height/100*20);
        str = "Exit to DOS";
        font1.draw(spriteBatch, str, width/100*1, height/100*28);
        
        spriteBatch.end();
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void show() {
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
