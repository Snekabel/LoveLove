package com.Snekabel.LoveLove;

import com.badlogic.gdx.utils.Array;

public class Lib {
	
}

/*

//Fix Description length, max 20 chars and then \n
str = car2.getDescription();
str = str.subSequence(1,str.length());
int maxCharCount = 23;
Array<CharSequence> strArray = new Array<CharSequence>();

for(int i = 0; i < ((str.length()/20)+(str.length()%20)); i++)
{
	
	//System.out.println("I:" + i + " *20  "+ i*20);
	if(i*maxCharCount < str.length() && i*maxCharCount+maxCharCount < str.length())
	{
    	//System.out.println(str.subSequence(i*maxCharCount, i*maxCharCount+maxCharCount));
    	strArray.add(str.subSequence(i*maxCharCount, i*maxCharCount+maxCharCount));
	}
	else
	{
		//System.out.println("First " + str.length() + " Second: " + str.length()/20 + " Third " + str.length()%maxCharCount + " Fourth: " + i*maxCharCount);
		//System.out.println(str.subSequence(i*maxCharCount, (i*maxCharCount)+str.length()%maxCharCount));
    	strArray.add(str.subSequence(i*maxCharCount, (i*maxCharCount)+str.length()%maxCharCount));
    	break;
	}
}
*/