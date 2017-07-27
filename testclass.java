import java.util.Scanner;
class testclass
{
	public static void main(String args[])
	{
		String s;
		int i;
		//s = "[\"Ford\",\"BMW\",\"Fiat\",true,null,false]";
		s = "{\"alan\":123,\"jake\":44,\"car\":[\"Ford\",\"BMW\",\"Fiat\",triue,null,false]}";
                //s = "[\"Ford\",123,\"Fiat\",true,null,false,1.234,7.6e+7]";
                
		checkdata c = new checkdata(s);
		c.next();
		
		
		
	
	}
}
