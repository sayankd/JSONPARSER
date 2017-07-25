class ObjectParse
{
	public void objectparser(String s ,int j)
	{
		int i,length=0,ind=0,end=0,start=0;
		/*for(i=j;i<s.length();i++)
		{
		if(s.charAt(i)=='}')
			//return "Empty Object";
		}*/
		System.out.println("j="+j+s.length());
		start = j;
		for(i=j;i<s.length();i++)
		{
			if((s.charAt(i)=='}')||(s.charAt(i)==','))
			{
				end = i;
				fetchvalue(s,start,end);
				start = i;
				
			}
			//System.out.println("l="+length);
		}
	}
	public void fetchvalue(String s ,int st,int en)
	{
		int del=0,i;
		String x="",y="";
		for(i=st;i<en;i++)
		{
			if(s.charAt(i)==':')
			{
				del = i;
			}
		}
		if(del==0)
		{
			System.out.println(": not in object "+s.substring(st,en));
		}
		else
		{
		//System.out.println("asas"+s.substring(st+2,del-2));
		
		for(i=st+2;i<=del-2;i++)
		{
			x = x+s.charAt(i);
		}
		for(i=del+2;i<=en-2;i++)
		{
			y = y+s.charAt(i);
		}
		System.out.println(x+" "+y);
		}
	}
}
