import java.util.*;
import java.io.*;
public class test
{
	public static void main(String args[])
	{
		try{
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		
    		StringBuilder sb = new StringBuilder();
    		String line = br.readLine();

    		while (line != null) {
        		sb.append(line);
        		sb.append(System.lineSeparator());
        		line = br.readLine();
    		}
    		String st = sb.toString();
		st = st.replaceAll("\\s+","");
		//System.out.println(st);
		checkdata c = new checkdata(st);
		c.next();
		br.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
