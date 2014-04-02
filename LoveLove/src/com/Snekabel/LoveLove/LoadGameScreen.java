package com.Snekabel.LoveLove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoadGameScreen implements Screen {
	//Needed for most things
	final LoveLoveGame game;
	int width = Gdx.graphics.getWidth();
	int height = Gdx.graphics.getHeight();
	private SpriteBatch spriteBatch;
	private CharSequence str;
	Point touchPos;
	private OrthographicCamera camera;
		
	public LoadGameScreen(final LoveLoveGame game)
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
		
		//Draw Back-button
		spriteBatch.draw(cloudButtonSprite, width/100*1, height/100*5);
        str = "Back";
        font1.draw(spriteBatch, str, width/100*1, height/100*3);
		
		spriteBatch.end();
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
		cloudButtonSprite = new Sprite(Resources.getGUITextures().get(2));
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
