package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GeneralFileReader {

	public static double[][] readGenes(String fileName, int nparms) {
		List<Double[]> geneList = new ArrayList<>();
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));			
			String ln = br.readLine();
			while(ln!=null) {	
				Double[] genes = new Double[nparms];
				StringTokenizer st = new StringTokenizer(ln, " ");				
				for(int j=0;j<nparms;j++) {
					genes[j]=Double.parseDouble(st.nextToken());
				}
				geneList.add(genes);
				ln = br.readLine();
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listToArrayDouble(geneList);
	}
	
	public static double[][] listToArrayDouble(List<Double[]> list) {
		double[][] array = new double[list.size()][list.get(0).length];
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.get(i).length;j++)
			array[i][j] = list.get(i)[j];
		}
		return array;
	}
}
