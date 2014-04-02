package com.Snekabel.LoveLove;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class LoveLoveGame extends Game {
	
	@Override
	public void create() {
		Resources.loadGUITextures();
		 this.setScreen(new MainMenu(this));
		 Gdx.graphics.setTitle("LoveLove game");
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {
		super.render(); //important!
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
