

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import ec.EvolutionState;
import ec.Evolve;
import ec.util.Output;
import ec.util.Parameter;
import ec.util.ParameterDatabase;

public class ECJStarterForEqnSolver {	
	
	public static int getnParms() {
		return Equation.sysConfig.getNGenes();
	}	
	
	public static void main(String[] args) {
		for(int jobIdx=0; jobIdx<50; jobIdx++) {
			Equation.sysConfig = new SystemConfig();
			String parentOutputDir = Equation.sysConfig.getParentOutputDirectory();
			PreECJ.populateSysConfigTrueRHSFromSheet();
			System.out.println("True RHS");
			for(int i=0;i<Equation.sysConfig.getTrueRHS().length;i++) {					
				System.out.print(Equation.sysConfig.getTrueRHS()[i]+" ");
			}		
			System.out.println();
			
			ParameterDatabase parameterDB=null;
				try {
					String fileName = "";			
					
					fileName = "input//eqnsolver_real.params";					
					
					File f = new File(fileName); 
					parameterDB = new ParameterDatabase(f);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	
			Output output = Evolve.buildOutput();
						
			
			if(args.length==0) {		
				int nodeID=2;
				
				File opDir = new File("output//"+parentOutputDir);
				if(!opDir.exists()){
					opDir.mkdir();
				}
				
				parameterDB.set(new Parameter("breedthreads"), "25");
				parameterDB.set(new Parameter("evalthreads"), "25");
				for(int i=0;i<25;i++) {
					parameterDB.set(new Parameter("seed."+i), "time");
				}				
				parameterDB.set(new Parameter("stat.file"), "..//output//"+parentOutputDir+"/job."+jobIdx+".Full");
				parameterDB.set(new Parameter("stat.child.0.file"), "..//output//"+parentOutputDir+"/job."+jobIdx+".Stat");
	
			}		
	       
			EvolutionState state = Evolve.initialize(parameterDB, jobIdx+1, output );	
				
			state.job = new Object[1];           
	        state.job[0] = new Integer(jobIdx); 
			state.run(EvolutionState.C_STARTED_FRESH);
					
			Evolve.cleanup(state);
		}
	}
}