class checkdata
{
	public String p;
	public static int i;
	checkdata(String s)
	{
		this.p = s;
		this. i=0;

	}
	public char next()
	{
		boolean res=false;
		if(i==0)
		{
			System.out.println("ddx");
			res = value(p.charAt(i++));
                        System.out.println("ddy"+res);

		}
		else if(i<p.length())
		{
		
			return (p.charAt(i++));
		}
		System.out.println("dd");
		System.out.println("res"+res);
		return 'a';
	}
	public boolean value(char s)
	{
		System.out.println("a"+s);
		if(s == 'n')
		{
			return checknull();
		}
		if((s=='t')||(s=='f'))
		{
			return Checkbool(s);
		}
		if((s=='\"'))
		{
			return CheckString();
		}
		if(s=='[')
		{
			System.out.println("a");
			return CheckArray();
		}
		if(s=='{')
		{
			boolean res;
			//System.out.println("cc");
			res =  CheckObject();
			System.out.println("cc"+res);
			return res;
		}
		return false;
	}
	public boolean checknull()
	{
		if((next()=='u')&&(next()=='l')&&(next()=='l'))
		{
			return true;
		}
		else
			return false;
	}
	public boolean Checkbool(char ch)
	{
		if(ch=='t')
		{
			if((next()=='r')&&(next()=='u')&&(next()=='e'))
			{
				return true;
			}
			else
				return false;
		}
		if(ch=='f')
		{
			if((next()=='a')&&(next()=='l')&&(next()=='s')&&(next()=='e'))
                        {
				System.out.println("sss");
                                return true;
                        }
                        else
                                return false;
		}
		return false;
	}
	public boolean CheckString()
	{
		char s = next();
		String y = "";
		while(s!='\"')
		{
			y=y+s;
			s = next();
		}
		System.out.println("str"+y);
		return true;
	}
	public boolean CheckArray()
	{
		char s = next();
		do
		{
		System.out.println("yy"+s);
		
		if(s==',')
		{
			s = next();
		}
		if(s=='[')
		{
			return false;
		}
		if(s==']')
		{
			System.out.println("xx");
			return true;
		}
		if(value(s)==false)
		{
			return false;
		}
		s = next();
		}while(s==',');
		System.out.println("pp"+s);
		if(s==']')
			return true;
		return false;
	}
	public boolean CheckObject()
	{
		char s = next();
		boolean x;
		do
		{
			if(s==',')
				s = next();
			if(s=='{')
				return false;
			if(s=='}')
				return true;
			x = value(s);
			if(x==false)
			{
				return false;
			}
			s = next(); 
			if((x==true) && (s!=':'))
			{
				System.out.println("bb");
				return false;
			}
			s = next();
			x = value(s);
			if(x==false)
				return false;
			s = next();
		}while(s==',');
		if(s=='}')
			return true;
		return false;
	}
	
}
