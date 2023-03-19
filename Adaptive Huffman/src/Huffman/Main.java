package Huffman;

import java.util.Scanner;
import java.util.Vector;

public class Main 
{
	public static Huffman obj = new Huffman();
	public static Vector<Huffman> vec = new Vector<>();
	
	public static void main(String[] args) 
	{
	
		Scanner in=new Scanner(System.in);
		System.out.print("Enter your sequence: ");
		String input;
		String FinalComp;
		input = in.nextLine();
		obj.ShortSymbols(vec, input);
		FinalComp = comp(input);
		decomp(FinalComp);
		
	}
	public static String comp(String input)
	{
		Node root = new Node('*');
		String comp="";
		int check = 0;		
		for(int i = 0; i < input.length() ; i++)
		{
			char key = input.charAt(i);
			String keyString = String.valueOf(key);
			Node x=new Node();
			Node y=new Node();
			x = root.search(root, key);
			if(x.Character=='-')
			{
				root.insert(root, key);
				check++;
				root.updateCounter(root);
				root.nCodeUpdate(root);
				for(int j = 0 ; j < vec.size(); j++)
				{
					if( keyString.equals(vec.get(j).Symbol) )
					{
						y = root.ParentSearch(root, key);
						if(y != root)
						{
						comp+=y.nodeCode;
						}
						comp+= vec.get(j).SC;
						
						break;
					}
				}
				if(check >= 3)
				{
				root.update(root);
				}
				root.nCodeUpdate(root);
			}
			else
			{
				root.nCodeUpdate(root);
				comp+= x.nodeCode;
				root.inc(root, key);
				if(check >= 3)
				{
				root.update(root);
				}
				root.updateCounter(root);
				root.nCodeUpdate(root);
		}	
	}
		System.out.println("Output = " + comp);
		Huffman.nodeCounter=101;
		return comp;
	}

	public static void decomp(String input)
	{
		Node root = new Node('*');
		Node NYT = new Node();
		Node curr = new Node();
		Node nC = new Node();
		String decomp="" , now = "";
		int SClength = vec.get(0).SC.length();
		int charIndex = 0 , UpdateCheck=0 , counter=1;
		boolean check = false;
		
		String x = vec.get(0).Symbol;
		char c = x.charAt(0);
		
		if(root.Character == '*')
		{
			root.insert(root,c);
			UpdateCheck++;
			root.updateCounter(root);
			root.nCodeUpdate(root);
			decomp+= x;
		}
		
		for(int i = SClength ; i < input.length() ; i++)
		{
			NYT = root.searchNYT(root, '*');
			char c1 = input.charAt(i);
			String x1 = String.valueOf(c1);
			now+=x1;
			
			nC = root.searchnC(root,now);
		//	System.out.println("NodeCode Found = " + nC.nodeCode);
			if( nC.Character !='*' && nC.Character != '-' && counter < vec.size())
			{
				check = true;
			}
			else
			{
				System.out.println("Inside else if");
				check = false;
			}
		//	System.out.println("NYT = " + NYT.nodeCode);
				
			if(NYT.nodeCode.equals(now) && counter < vec.size())
			{
				counter++;
				char c2 ;
				String x2="";
				int y = i+1;
				while(y < (i + SClength +1) )
				{
					 c2 = input.charAt(y);
					 x2+= String.valueOf(c2);
					 y++;
				}
				
				for(int j = 0 ; j < vec.size() ; j++)
				{
					if(x2.equals(vec.get(j).SC) )
					{
						charIndex = j;
					}
				}
				x2 = vec.get(charIndex).Symbol;
				c2 = x2.charAt(0);
				root.insert(root,c2);
				UpdateCheck++;
				decomp+=x2;
				now = "";
				i+=SClength;
				root.nCodeUpdate(root);
				root.updateCounter(root);
				if(UpdateCheck >= 3)
				{	
					root.update(root);
				}
				root.nCodeUpdate(root);
				root.updateCounter(root);
			}
			else if(counter > vec.size() - 1 || check)
			{
				nC = root.searchnC(root,now);
				System.out.println("NodeCode Found = " + nC.nodeCode);
				if( nC.Character !='*' && nC.Character != '-')
				{
					decomp+= nC.Character;
					root.inc(root, nC.Character);
					if(UpdateCheck >= 3)
					{	
						root.update(root);
					}
					root.nCodeUpdate(root);
					root.updateCounter(root);
					now = "";
				}
			}
		}

		System.out.println("Output = " + decomp);		
	}
}
