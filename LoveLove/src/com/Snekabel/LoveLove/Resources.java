package com.Snekabel.LoveLove;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Array;

public class Resources {
	private static Array<Texture> GUI = new Array<Texture>();
	private static Array<BitmapFont> Fonts = new Array<BitmapFont>();
	private static Array<Texture> Girls = new Array<Texture>();

	public static void loadGUITextures()
	{
		if(GUI.size <= 0)
		{
			GUI.add(new Texture(Gdx.files.internal("gui/LoveLove Logo.png")));
			GUI.add(new Texture(Gdx.files.internal("gui/LoveLove Cloud.png")));
			GUI.add(new Texture(Gdx.files.internal("gui/cloud_button.png")));
		}
	}
	
	public static Array<Texture> getGUITextures()
	{
		return GUI;
	}
	
	public static void loadGirlsTextures()
	{
		if(Girls.size <= 0)
		{
			Girls.add(new Texture(Gdx.files.internal("girls/girl_001.png")));
			Girls.add(new Texture(Gdx.files.internal("girls/girl_002.png")));
			Girls.add(new Texture(Gdx.files.internal("girls/girl_003.png")));
			Girls.add(new Texture(Gdx.files.internal("girls/girl_004.png")));
			Girls.add(new Texture(Gdx.files.internal("girls/girl_005.png")));
			Girls.add(new Texture(Gdx.files.internal("girls/girl_006.png")));
		}
	}
	
	public static Array<Texture> getGirlsTextures()
	{
		return Girls;
	}
	
	public static void loadFonts()
	{
		Fonts.add(new BitmapFont(Gdx.files.internal("fonts/test.fnt"),
		        Gdx.files.internal("fonts/test.png"), false));
		Fonts.add(new BitmapFont(Gdx.files.internal("fonts/YellowItalicBoldVerdana.fnt"),
		        Gdx.files.internal("fonts/YellowItalicBoldVerdana.png"), false));
	}
	
	public static Array<BitmapFont> getFonts()
	{
		return Fonts;
	}

}