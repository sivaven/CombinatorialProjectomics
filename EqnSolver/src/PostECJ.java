import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import utils.GeneralFileReader;

public class PostECJ {
	
	public static Equation getEquationObject(String configDir, String subDir, int jobIdx) {
		int nParms = Equation.sysConfig.getNGenes();
		String fileName =  configDir+"/"+subDir+"/job."+jobIdx+".Full";
		double[] genes = ECStatOutputReader.readBestSolution(fileName, nParms);
		Equation eqn = new Equation(genes, false);
		return eqn;		
	}
	public static void goThruAllECJOutputFiles(String rootDir, boolean displayAllFitness, double fitnessThreshold) {
		int nParms=Equation.sysConfig.getNGenes();
		 
		 File dir = new File(rootDir);
		 File[] files = dir.listFiles();
		 
		for(int i=0;i<files.length-1;i++) {
			String fileName =  rootDir+"/job."+i+".Full";
			if(!(new File(fileName)).exists()) {
				continue;
			}
			double[] genes = ECStatOutputReader.readBestSolution(fileName, nParms);
			Equation eqn = new Equation(genes, false);
			
			double fitness=-777777;
			 
			fitness = eqn.fitnessRel(false);
	        
			if(displayAllFitness)
				System.out.println(i+"\t"+fitness);
	        if(fitness<fitnessThreshold) {
	        	for(int j=0;j<genes.length;j++)
	        		System.out.print(genes[j]+" ");
	        	System.out.print("\n");
	        }
	        
		}
	}
	
		
	private static double writeCSVs_topP(String rootDir, String expDir, int n_et, int mockup_id, int n_l, int server_dir, double p) throws IOException {
		Equation.POST_ECJ = true;
		Equation.sysConfig = new SystemConfig(4, 3, n_et, mockup_id, n_l);
		PreECJ.populateSysConfigTrueRHSFromSheet();		
		PreECJ.populateSysConfigTrueVarsFromSheet();			
		String parentOutputDir = rootDir+expDir+Equation.sysConfig.getParentOutputDirectory()+"/";
		
		File configDir = new File(parentOutputDir);
		Equation eqn = null;
		
		List<ECJSolution> ecjSolutions = new ArrayList<>();
		String dirName = "";//+server_dir;
			File ecjOpDir = new File(parentOutputDir+dirName);		
			System.out.println(ecjOpDir.getPath());
			String[] ecjJobFiles = ecjOpDir.list();
			for(int i=0;i<(ecjJobFiles.length/2);i++) {        
				eqn = getEquationObject(parentOutputDir, dirName, i);				
				ECJSolution solution = new ECJSolution(
						eqn.xi, 
						eqn.ai,
						eqn.fitnessRel(false),
						Equation.sysConfig.calculateIntErrorAbs(eqn.xi),
						dirName, i
						);
				ecjSolutions.add(solution);
			}
		
		String filename = rootDir+"consolidated/m"+mockup_id+"/"+expDir+"m"+mockup_id+"_nl"+n_l+"_et"+n_et+"_serdir_"+server_dir+"_onlyEAErrors_rel.csv";
		ECJSolution.writeAllEAerrors(ecjSolutions, filename);		
		
		String solnFileName = rootDir+"consolidated/m"+mockup_id+"/"+expDir+"m"+mockup_id+"_nl"+n_l+"_et"+n_et+"_serdir_"+server_dir+"_acceptedSolns.csv";
		String aiFileName = rootDir+"consolidated/m"+mockup_id+"/"+expDir+"m"+mockup_id+"_nl"+n_l+"_et"+n_et+"_serdir_"+server_dir+"_acceptedSolns_ais.csv";

		FileWriter fw = new FileWriter(solnFileName);
		double[] approximateSoln = ECJSolution.getApproximationFromAllSolutions_FromTopN(ecjSolutions, p, fw);
		
		FileWriter fw_ai = new FileWriter(aiFileName);
		ECJSolution.getAisFromAllSolutions_FromTopN(ecjSolutions, p, fw_ai);		
		
		return Equation.sysConfig.calculateIntError_Balanced_W_around_Apriori(approximateSoln);
	}
	
	public static void main(String[] args) {
		String rootDir = "output/";
		String expDir = "";
		
		if(args!=null && args.length>0) {
			rootDir = args[0];
		}
		
		double p = 10;
		
		int[] nETs = new int[] {3};
		int[] nls = new int[] {0};
		int mockup_id = 0;
		
		int ser_dir = 2;
		
		double error = 0;
		try {
			for(int i=0;i<nETs.length;i++) {				
				
				for(int j=0;j<nls.length;j++) {
					FileWriter fw = new FileWriter(rootDir+"consolidated/m"+mockup_id+"/"+expDir+"m"+mockup_id+"_nl"+nls[j]+"_et"+nETs[i]+"_serdir_"+ser_dir+"_robustness_tp"+p+"_bwaa.csv");
				
					error = writeCSVs_topP(rootDir, expDir, nETs[i], mockup_id,  nls[j], ser_dir, p);
					System.out.println("error "+error);
					fw.write(nls[j]+","+error+"\n");
					fw.close();
				}				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}			
	}
}
