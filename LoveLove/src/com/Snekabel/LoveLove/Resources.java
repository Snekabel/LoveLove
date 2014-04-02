package com.Snekabel.LoveLove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class Resources {
	private static Array<Texture> GUI = new Array<Texture>();

	public static void loadGUITextures()
	{
		if(GUI.size <= 0)
		{
			GUI.add(new Texture(Gdx.files.internal("gui/LoveLove Logo.png")));
			GUI.add(new Texture(Gdx.files.internal("gui/LoveLove Cloud.png")));
		}
	}
	
	public static Array<Texture> getGUITextures()
	{
		return GUI;
	}

}