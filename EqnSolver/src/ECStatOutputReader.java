

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ECStatOutputReader {

	public static double[] readBestSolution(String fileName, int nParms) {
		double[] parms = new double[nParms];
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String str = br.readLine();
			String lastLine = null;
			String lastButOne = null;
			String lastButTwo = null;
			while(str!=null) {
				str = br.readLine();
				lastButTwo = lastButOne;
				lastButOne=lastLine;
				lastLine=str;				
			}
			StringTokenizer st = new StringTokenizer(lastButOne);			
			String token = null;
			int i=0;
			while(st.hasMoreTokens()) {
				token = st.nextToken();
				parms[i++] = Double.parseDouble(token);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parms;
	}
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

}
