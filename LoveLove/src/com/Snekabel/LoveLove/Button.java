package com.Snekabel.LoveLove;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;

public class Button {
	private Sprite buttonSprite;
	private Point location;
	private Point textLocation;
	private CharSequence text;
	
	public Button(Sprite buttonSprite)
	{
		this.buttonSprite = buttonSprite;
	}
	
	public Button(Sprite buttonSprite, String text)
	{
		this.buttonSprite = buttonSprite;
		this.text = text;
	}
	
	public Button(Sprite buttonSprite, String text, Point location)
	{
		this.buttonSprite = buttonSprite;
		this.text = text;
		this.location = location;
		textLocation = new Point(location.x + (buttonSprite.getWidth()/100*10), location.y + (buttonSprite.getHeight()/100*60));
	}
	
	public Sprite getSprite()
	{
		return buttonSprite;
	}
	
	public CharSequence getText()
	{
		return text;
	}
	
	public Point getLocation()
	{
		return location;
	}
	
	public Point getTextLocation()
	{
		return textLocation;
	}
	
	public void setLocation(Point location)
	{
		this.location = location;
		textLocation = new Point(location.x + (buttonSprite.getWidth()/100*10), location.y + (buttonSprite.getHeight()/100*50));
	}
	
	public void setCharSequence(String text)
	{
		this.text = text;
	}
	
	public void setSprite(Sprite buttonSprite)
	{
		this.buttonSprite = buttonSprite;
	}
	
	public boolean isTouched(Vector3 touchPos)
	{
		if(touchPos.x >= location.x && touchPos.x <= location.x + buttonSprite.getWidth() && touchPos.y >= location.y && touchPos.y <= location.y + buttonSprite.getHeight())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
