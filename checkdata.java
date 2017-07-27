import java.util.*;
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
		//ArrayList<Object> arr = new ArrayList<Object>();
		Object arr;
		//boolean res=false;
		if(i==0)
		{
			System.out.println("ddx");
			arr = value(p.charAt(i++));
			//arr = (ArrayList<Object>)arr;
			System.out.println();
			System.out.println(arr);
			System.out.println();
			//System.out.println("aaaaaa"+((HashMap<String,Object>)arr));
			//Set<Entry<String,Object>> hashSet=(HashMap<String,Object>)arr.entrySet();
			if(arr==null)
			{
				System.out.println("There is error");
			}
			else
			{
			for(Map.Entry<String, Object> er:((HashMap<String,Object>)arr).entrySet())
			{
				System.out.println("Key = "+er.getKey()+"Value = "+er.getValue());
			}
			}
                        //System.out.println("ddy"+res);

		}
		else if(i<p.length())
		{
		
			return (p.charAt(i++));
		}
		//System.out.println("dd");
		//System.out.println("res"+res);
		return 'a';
	}
	public void   prev()
	{
		this.i = this.i-1;
	}
	public Object value(char s)
	{
		try{
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
			 Object res;
			//System.out.println("cc");
			res =  CheckObject();
			//System.out.println("cc"+res);
			return res;
		}
		if(s==':')
		{
			new ModifiedException("No opening brace of object");
		}
		if((Character.isDigit(s)==true)||s=='-')
		{
			Double res;
			res = CheckInteger(s);
			System.out.println("dd"+res);
			return res;
		}
		}catch(ModifiedException e){System.out.println(e.getMessage());}
		return null;
	}
	public Integer checknull() throws ModifiedException
	{
		if((next()=='u')&&(next()=='l')&&(next()=='l'))
		{
			return null;
		}
		else
			throw new ModifiedException("It should be null");
	}
	public boolean Checkbool(char ch) throws ModifiedException
	{
		if(ch=='t')
		{
			if((next()=='r')&&(next()=='u')&&(next()=='e'))
			{
				return true;
			}
			else
				throw new ModifiedException("It should be true");
		}
		if(ch=='f')
		{
			if((next()=='a')&&(next()=='l')&&(next()=='s')&&(next()=='e'))
                        {
				System.out.println("sss");
                                return true;
                        }
                        else
                                throw new ModifiedException("It should be false");
		}
		return false;
	}
	public String CheckString()
	{
		char s = next();
		String y = "";
		while(s!='\"')
		{
			y=y+s;
			s = next();
		}
		System.out.println("str"+y+s);
		return y;
	}
	public ArrayList<Object> CheckArray() throws ModifiedException
	{
		ArrayList<Object> arr = new ArrayList<Object>();
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
			throw new ModifiedException("] bracket expected");
		}
		if(s==']')
		{
			System.out.println("xx");
			return arr;
		}
		arr.add(value(s));
		s = next();
		}while(s==',');
		System.out.println("pp"+s);
		System.out.println(arr.size());
		if(s==']')
			return arr;
		 throw  new ModifiedException("Bad Array");
	}
	public HashMap<String,Object> CheckObject() throws ModifiedException
	{
		HashMap<String,Object> hm = new HashMap<String,Object>();
		char s = next();
		String  x;
		Object y;
		do
		{
			if(s==',')
				s = next();
			if(s=='{')
				throw new ModifiedException("{ this one not valid");
			if(s=='}')
				return hm;
			x = (String)value(s);
			s = next(); 
			if(s!=':')
			{
				throw new ModifiedException(": this expected before"+s);
			}
			s = next();
			System.out.println("obj"+s);
			y = value(s);
			hm.put(x,y);
			s = next();
		}while(s==',');
		if(s=='}')
			return hm;
		throw new ModifiedException("Bad Object at"+s);
	}
	public Double CheckInteger(char ch) throws ModifiedException
	{
		System.out.println("hello");
		String s = checknumber(ch);
		System.out.println("xxxxxxx"+s);
		try
		{
			Double d = Double.parseDouble(s);
			return d;
			
		}
		catch(Exception e)
		{
			throw new ModifiedException("Invalid Number");
		}
		//return null;
	}
	public String checknumber(char ch)
	{
		
		String x="";
		while(Character.isDigit(ch)||(ch=='.')||(ch=='+')||(ch=='-')||(ch=='e'))
		{
			x = x+ch;
			System.out.println(x);
			ch = next();
		}
		prev();
		return x;
	}
}
