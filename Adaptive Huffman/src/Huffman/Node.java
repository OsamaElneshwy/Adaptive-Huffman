package Huffman;

class Node extends Huffman 
{ 
    char Character = '-';
    int counter;
    int nodeCounter1;
    String nodeCode;
    Node left, right; 
  
    public Node() {
    	left = right = null;
    }
    
    public Node(char item) 
    {	
    	this.Character = item;
    	if(item!='*')
    	{
    		this.counter = 1;
    	}
    	else
    	{
    		this.counter=0;
    	}
    	
    	nodeCounter--;
    	this.nodeCounter1 = nodeCounter;
        this.left = this.right = null;
    }
    
    void insert( Node root, char key)
    { 

    	
        Node curr =new Node();
        Node y =new Node();
        if(root.Character == '*')
        {
        	root.Character='3';
        	root.right=new Node(key);
        	root.left=new Node('*');
        	root.counter=root.right.counter;   	
        }
        else if(root.Character != '*')
        {
        	if(root.right.right == null)
        	{
        		curr = root.left;
        	}
        	else if( root.left.left == null)
        	{
        		curr = root.right;
        	}
        	
        	
        	while (curr.Character == '*')
        	{
        		
        		if(curr.Character =='*' && curr.left == null)
            	{
            		curr.right = new Node(key);
            		curr.left = new Node('*');
            		curr.counter=curr.right.counter+curr.left.counter;
            		break;
            	}
        		curr = curr.left;
        	}
        }

     } 
    
    public void updateCounter(Node root)
    {
        Node curr2 = new Node();
        curr2 = root;
        if(root.right.right == null)
    	{
    		curr2 = root.left;
    	}
    	else if( root.left.left == null)
    	{
    		curr2 = root.right;
    	}
    	
    	while(curr2 != null)
        {
        	if (curr2.right != null)
        	{
        	curr2.counter=curr2.right.counter+curr2.left.counter;
        	}
        	curr2 = curr2.left;
        }
        root.counter = right.counter + left.counter; 
    }
     
    public void print(Node root)
    {
    	
    	 Node curr =new Node();
         if(root.Character=='*')
         {
         	System.out.println("This tree is empty.");
         }
         else if(root.Character !='*')
         {
        	System.out.println("root counter ="+root.counter);
         	if(root.right.right == null)
         	{
         		System.out.println(root.right.Character+" " + " Counter = " +  root.right.counter + " Node code " + root.right.nodeCode + " nodeCounter  " + root.right.nodeCounter1);
         		System.out.println(root.left.Character+" " + " Counter = " +  root.left.counter+ " Node code " + root.left.nodeCode +" nodeCounter "+ root.left.nodeCounter1);
         		curr = root.left;
         	}
         	else if( root.left.left == null)
         	{
         		System.out.println(root.right.Character+" " + " Counter = " +  root.right.counter + " Node code " + root.right.nodeCode + " nodeCounter  " + root.right.nodeCounter1);
         		System.out.println(root.left.Character+" " + " Counter = " +  root.left.counter+ " Node code " + root.left.nodeCode +" nodeCounter "+ root.left.nodeCounter1);
         		curr = root.right;
         	}
         	
	         	while (curr != null)
	         	{
	         		if (curr.right != null && curr.left != null)
	         		{
	             		System.out.println(curr.right.Character+" " + " Counter = " +  curr.right.counter + " Node code " + curr.right.nodeCode + " nodeCounter  " + curr.right.nodeCounter1);
	             		System.out.println(curr.left.Character+" " + " Counter = " +  curr.left.counter+ " Node code " + curr.left.nodeCode +" nodeCounter "+ curr.left.nodeCounter1);
	         		
	         		}
	         		curr = curr.left;
	         	}
         	}  	
     }
         
    public Node search(Node root , char key)
    {
    	Node curr = new Node();
    	Node curr2 = new Node();
    	if (root.Character == '*')
    	{
    		return curr2;
    	}
    	else
    	{
    	if (root.right.Character == key)
    	{
    		curr2 = root.right;
    		
    	}
    	else if (root.left.Character == key)
    	{
    		curr2 = root.left;
    		
    	}
    	
    	if(root.right.right == null)
    	{
    		curr = root.left;
    	}
    	else if( root.left.left == null)
    	{
    		curr = root.right;
    	}
    	
    	
    	while (curr.right != null)
    	{
    		Node y = new Node();
    		
    		if(curr.right.Character == key)
        	{
        		curr2 = curr.right;
        	}
    		
    		curr = curr.left;
    	}
    	
    	return curr2;
    	}
    }
    
    public Node searchnC(Node root , String key)
    {
    	Node curr = new Node();
    	Node curr2 = new Node();
    	if (root.Character == '*')
    	{
    		return curr2;
    	}
    	else
    	{
    	if (root.right.nodeCode.equals(key) )
    	{
    		curr2 =root.right;
    		return curr2;    		    		
    	}
    	else if (root.left.nodeCode.equals(key))
    	{
    		curr2 =root.left;
    		return curr2;
    	}
    	
    	if(root.right.right == null)
    	{
    		curr = root.left;
    	}
    	else if( root.left.left == null)
    	{
    		curr = root.right;
    	}
    	
    	
    	while (curr.right != null)
    	{    		
    		if(curr.right.nodeCode.equals(key))
        	{
    			System.out.println("NodeCode Found");
        		curr2 = curr.right;
        	}
    		curr = curr.left;
    	}
    	
    	return curr2;
    	}
    }
    
    public Node searchNYT(Node root , char key)
    {

    	Node curr = new Node();
    	Node curr2 = new Node();
    	if (root.Character == '*')
    	{
    		System.out.println("The tree is empty");
    		return curr2;
    	}
    	else
    	{
    	if (root.right.Character == key)
    	{
    		curr2 = root.right;
    		
    	}
    	else if (root.left.Character == key)
    	{
    		curr2 = root.left;
    		
    	}
    	
    	if(root.right.right == null)
    	{
    		curr = root.left;
    	}
    	else if( root.left.left == null)
    	{
    		curr = root.right;
    	}
    	
    	
    	while (curr.left != null)
    	{    		
    		
    		curr = curr.left;
    	}
    	if(curr.left == null)
    	{
    		curr2 = curr;
    	}
    	
    	return curr2;
    	}
    	
    }
 
    public void inc(Node root , char key)
    {
    	Node y=new Node();
    	y=search(root, key);
    	if(y != null)
    	{
    		y.counter++;
    	}
    }
    
    public  void swap(Node x , Node y)
    {
    	Node c = new Node();
    	c.left = x.left;
    	c.right = x.right;
    	int o , o2 , o3 , o4;
    	char k1,k;
    	 o=x.nodeCounter1; 
    	o2=y.nodeCounter1;
    	k= x.Character;
    	k1 = y.Character;
    	o3 = x.counter;
    	o4 = y.counter;
    	y.nodeCounter1 = o2;
    	x.nodeCounter1 = o;
    	y.Character =k;
    	x.Character =k1;
    	y.counter = o3;
    	x.counter = o4;
    	x.left = y.left;
    	x.right = y.right;
    	y.right = c.right;
    	y.left = c.left;
    }
    
    public void update(Node root)
    {
    	int check= 0;
    	Node curr = new Node();
    	Node curr2 = new Node();
    	 if(root.right.right == null )
    	{
    		curr = root.left;
    		check = 1;	
    	}
    	else if( root.left.left == null )
    	{
    		curr = root.right;
    		check = 2;
    	}
     	if(root.left.counter >= root.right.counter )
    	{
    		swap(root.left , root.right);
    	}
    	else 
    	{
    		if (check == 1 )
    		{
    			while(curr.left != null)
    			{
    			if( curr.right.counter >= root.right.counter)
    			{
    				swap(curr.right , root.right);
    			}
    				curr = curr.left;
    			}
    			curr = root.left;
    			
    			while(curr.left.left != null)
    			{
    				if(curr.right.counter <= curr.left.right.counter )
    				{
    					swap(curr.left.right, curr.right);
    				}
    				curr = curr.left;
    			}
    		}
    		else if(check==2)
    		{
    			while(curr.left != null)
    			{
    			if( curr.right.counter >= root.left.counter)
    			{
    				swap(curr.right , root.left);
    			}
    				curr = curr.left;
    			}
    			curr = root.right;
    			
    			while(curr.left.left != null)
    			{
    				if(curr.right.counter <= curr.left.right.counter )
    				{
    					swap(curr.left.right, curr.right);
    				}
    				curr = curr.left;
    			}
    		}
    	}	
    }

    public void nCodeUpdate(Node root)
    {
    	Node curr = new Node();
    	Node curr2 = new Node();
    	curr = root.left;
    	curr2 = root.right;
    	curr.nodeCode = "0";
    	curr2.nodeCode= "1";
    	while(curr.left != null)
    	{
    		curr.left.nodeCode = curr.nodeCode + "0";
    		curr.right.nodeCode = curr.nodeCode + "1";
    		curr = curr.left;
    	}
    	while(curr2.left != null)
    	{
    		curr2.left.nodeCode = curr2.nodeCode + "0";
    		curr2.right.nodeCode = curr2.nodeCode + "1";
    		curr2 = curr2.left;
    	}
    	
    	
    	
    }

    public Node ParentSearch(Node root , char key)
    {
    	Node curr = new Node();
    	Node curr2 = new Node();
    	if (root.Character == '*')
    	{
    		return curr2;
    	}
    	else
    	{
    	if (root.right.Character == key)
    	{
    		curr2 = root;	
    	}
    	else if (root.left.Character == key)
    	{
    		curr2 = root;
    		
    	}
    	
    	if(root.right.right == null)
    	{
    		curr = root.left;
    	}
    	else if( root.left.left == null)
    	{
    		curr = root.right;
    	} 	
    	while (curr.right != null)
    	{
    		Node y = new Node();
    		
    		if(curr.right.Character == key)
        	{
        		curr2 = curr;
        	}	
    		curr = curr.left;
    	}
    	return curr2;
    	}
    }
}
    
    
