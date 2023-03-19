package Huffman;

import java.util.Vector;

public class Huffman 
{
	public static int nodeCounter=101; 
	public String SC;
	public String Symbol;
	
	
	public Huffman() {}
	
	
	public void ShortSymbols(Vector<Huffman> v , String input) {
		int count = 0 , count2;
		Vector<String> v2 = new Vector<String>();
		for(int i = 0; i < input.length() ; i++)
		{
			char c = input.charAt(i);
			String x = String.valueOf(c);
			if(!v2.contains(x)) {
				v2.add(x);
				count++;
			}
		}
		if(count%2 != 0)
		{
			count2 = count/2;
			if(v2.size() >= 7)
			{
				count2-=1;
			}
			count2+=1;
		}
		else
		{
			count2=count/2;
			if(v2.size() >= 7)
			{
				count2-=1;
			}
		}
		for(int i=0; i < v2.size();i++)
		{
			Huffman obj = new Huffman();
			String x="" , x2="";
			x = v2.get(i);
			x2 = Integer.toBinaryString(i);
			for(int j = 1 ; j<count2 ; j++)
			{
				if( x2.length() != count2)
				{
				x2="0" + x2;
				}
			}
			obj.Symbol = x;
			obj.SC = x2;
			v.add(obj);
			
			
		}
				
	}
	
	
	public String replace( String x, String y)
	{
		String c;
		c=x.substring(1);
		
		y+=c;
		return y;
	}
	
}
