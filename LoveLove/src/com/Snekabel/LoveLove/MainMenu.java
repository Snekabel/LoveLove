package com.Snekabel.LoveLove;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu  implements Screen{
	final Game game;
	private Sprite logoSprite;
	private Sprite cloudSprite;
	@SuppressWarnings("unused")
	private Sprite girlSprite;
	private SpriteBatch spriteBatch;
	@SuppressWarnings("unused")
	private CharSequence str;
	int width = Gdx.graphics.getWidth();
	int height = Gdx.graphics.getHeight();
	
	public MainMenu(final LoveLoveGame game)
	{
        this.game = game;
	}
	
	@Override
	public void render(float delta) {
		Gdx.graphics.getGL20().glClearColor( 1, 0, 0, 1 );	
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
        spriteBatch.begin();
        //Draw Clouds
       /* for(int i = 0; i < 5; i++)
        {
        	spriteBatch.draw(cloudSprite, MathUtils.random(0, width), MathUtils.random(0, height));
        }*/
        spriteBatch.draw(cloudSprite,100,300);
        spriteBatch.draw(cloudSprite,800,100);
        spriteBatch.draw(cloudSprite,100,100);
        spriteBatch.draw(cloudSprite,200, 800);
        
        //Draw logo in center
        spriteBatch.draw(logoSprite, width/4, height/2);	
        
        //Draw Girl to the right
        //TODO Get a girl (As a sprite)
        //spriteBatch.draw(girlSprite, width/4*3, height/2);	
        
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
		//girlSprite = new Sprite(Resources.getGUITextures().get(2));
		spriteBatch = new SpriteBatch();
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
