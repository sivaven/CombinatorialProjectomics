package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EcjNohupReader {

	
	public static List<EAInstance> returnStatsFromNohups(String nohupFile, int fromGen, int toGen) {
		List<EAInstance>  instances = new ArrayList<>();
				
		try {
			BufferedReader br = new BufferedReader(new FileReader(nohupFile));	
			boolean populate_fields = false;
			String ln = br.readLine();
			EAInstance instance=null;
			while(ln!=null) {	
				if(ln.equals("Generation "+fromGen)) {
					populate_fields = true;
					instance = new EAInstance();
				}
					
				if(ln.equals("Generation "+toGen) || ln.startsWith("Found")) {
					populate_fields = false;
					instances.add(instance);
				}
					
				
				if(populate_fields == true) {
					if(ln.startsWith("Gen")) {
						StringTokenizer st = new StringTokenizer(ln, " ");
						st.nextToken();
						int gen=Integer.valueOf(st.nextToken());
						instance.addGen(gen);
					}
					if(ln.startsWith("Sub")) {
						//System.out.println(instances.size()+" "+ln);
						StringTokenizer st = new StringTokenizer(ln, ":");
						st.nextToken();
						float err=Float.valueOf(st.nextToken());
						instance.addError(err);
					}					
				}				
				
				ln = br.readLine();
				
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return instances;		
	}
	
	public static void main(String[] args) {
		String nohupFile = "m3_n0_et4_2";
		String rootDir = "output\\ECJ_GEN_OUTS\\";
		
		List<EAInstance> instances = returnStatsFromNohups(rootDir+nohupFile+".out", 1, 19000);
		File dir = new File(rootDir+nohupFile);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		for(int i=0;i<instances.size();i++) {
			instances.get(i).writeCSV(dir+"\\"+i+".csv");
		}
		
		//System.out.println(instances.size());
	}

}

class EAInstance{
	List<Integer> generations;
	List<Float> error;
	public EAInstance(){
		generations = new ArrayList<>();
		error = new ArrayList<>();
	}
	
	void addGen(int gen) {
		generations.add(gen);
	}
	void addError(float err) {
		error.add(err);
	}
	void writeCSV(String filename) {
		if(generations.size()!=error.size()) {
			System.out.println("Length mismatch in writeCSV of EAInstance!");
			System.exit(0);
		}
		try {
			FileWriter fw = new FileWriter(filename);
			for(int i=0;i<generations.size();i++) {
				fw.write(""+generations.get(i)+","+error.get(i)+"\n");
			}
			fw.close();
		} catch (IOException e) {				
			e.printStackTrace();
		}
		
	}
}
