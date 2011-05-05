package pkg;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PerlTest {

	public String  getName(String Name){
		String line = null;
		Runtime r = Runtime.getRuntime();
	    try {
	    	  String com = "perl /home/ec2-user/test.pl " + Name;
	          Process p = r.exec(com);
	          InputStream in = p.getInputStream();
	          BufferedInputStream buf = new BufferedInputStream(in);
	          InputStreamReader inread = new InputStreamReader(buf);
	          BufferedReader bufferedreader = new BufferedReader(inread);
	          line = bufferedreader.readLine();
	          try {
	                 if (p.waitFor() != 0) {
	                     System.err.println("exit value = " + p.exitValue());
	                 }
	             } catch (InterruptedException e) {
	                 System.err.println(e);
	             } finally {
	                 // Close the InputStream
	                 bufferedreader.close();
	                 inread.close();
	                 buf.close();
	                 in.close();
	             }
	         } catch (IOException e) {
	             System.err.println(e.getMessage());
	         }
		
		return line;
	}
	
}
