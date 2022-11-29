import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.commons.math3.util.CombinatoricsUtils;
import org.json.JSONObject;
public class SystemConfig {

	private int nRegions;
	private int nInjections;
	private int nExpTrials;
	
	private int mockupID;
	private int noiseLevel;
	
	private double[] trueRHS;
	private double[] trueInts;
	private double[] trueReals;
	
	private boolean rhsPopulated;
	private boolean trueVarsPopulated;
	
	SystemConfig(){
		JSONObject jObject = readPrimaryInput("input/primary_input.json");		
		nRegions = jObject.getInt("nRegions");
		nInjections = jObject.getInt("nInjections");
		nExpTrials =jObject.getInt("nExpTrials");		
		
		mockupID=jObject.getInt("mockupID");
		noiseLevel = jObject.getInt("noiseLevel");
		
		if(nExpTrials<1) {
			throw new IllegalStateException("n_exp_trials should be greater than 0!");
		}
		
		rhsPopulated  = false;
		trueVarsPopulated = false;
	}
	
	SystemConfig(int n_regions, int n_injections, int n_exp_trials, int mockup_id, int noise_level){
		//JSONObject jObject = readPrimaryInput("input/primary_input.json");		
		nRegions = n_regions;
		nInjections = n_injections;
		nExpTrials =n_exp_trials;		
		
		mockupID=mockup_id;
		noiseLevel = noise_level;
		
		if(nExpTrials<1) {
			throw new IllegalStateException("n_exp_trials should be greater than 0!");
		}
		
		rhsPopulated  = false;
		trueVarsPopulated = false;
	}
	public void populateTrueVars(double[] true_ints, double[] true_reals) {
		if(true_ints.length != getNInts()) {
			throw new IllegalStateException("true int length mismatch!");
		}
		if(true_reals.length != getNReals()) {
			throw new IllegalStateException("true reals length mismatch!");
		}	
		trueInts = true_ints;
		trueReals = true_reals;
		trueVarsPopulated = true;
	}
	public void populateTrueRHS(double[] rhs) {
		if(rhs.length!=getNRHS()) {
			throw new IllegalStateException("RHS length mismatch!" + rhs.length +"\t"+getNRHS());
		}
		trueRHS = rhs;
		rhsPopulated = true;
	}
	public boolean isTrueVarsPopulated() {
		return trueVarsPopulated;
	}
	public boolean isRHSpopulated() {
		return rhsPopulated;
	}
	public int getNRegions() {
		return nRegions;
	}
	public int getNInjections() {
		return nInjections;
	}
	public int getNExpTrials() {
		return nExpTrials;
	}
	public int getNInts() {
		return (int)(Math.pow(2, nRegions)-1);
	}
	public int getNReals() {		
		return nExpTrials*nInjections*(int)
		(CombinatoricsUtils.factorial(nRegions)
				/
		(CombinatoricsUtils.factorial(nRegions - nInjections) * CombinatoricsUtils.factorial(nInjections)));
	}
	public int getNRHS() {
		return nExpTrials* (int)(Math.pow(2, nInjections)-1) *
				(int)
				(CombinatoricsUtils.factorial(nRegions)
						/
				(CombinatoricsUtils.factorial(nRegions - nInjections) * CombinatoricsUtils.factorial(nInjections)));
	}
	public int getNGenes() {
		//sum , 14 ratios of sum, dummy, reals
		return (1 + getNInts()-1 ) + 1+ getNReals() ;
	}
	
	public double calculateEAerror(long[] calculated_RHS) {		
		return calculateEAerror_absolute(calculated_RHS);
	}
	
	private double calculateEAerror_absolute(long[] calculated_RHS) {
		if(!isRHSpopulated()) {
			throw new IllegalStateException("True RHS not populated");
		}
		if(calculated_RHS.length!= getNRHS()) {
			throw new IllegalStateException("RHS length mismatch!");
		}
		double error=0;
		int no_of_missing_exp_constraints=0;
		
		for(int i=0;i<calculated_RHS.length;i++) {	
			if(trueRHS[i]> -0.1) {
				error += ((calculated_RHS[i]-trueRHS[i])*(calculated_RHS[i]-trueRHS[i]));				
			}else { 
				// trueRHS is negative in xlsx to indicate unavailable experiment data...
				no_of_missing_exp_constraints +=1;
			}
		}
		
		return Math.sqrt(error/((getNRHS() - no_of_missing_exp_constraints)*1.0d));		
	}
	
	public double calculateIntErrorAbs(int[] Xi) {
		if(!isTrueVarsPopulated()) {
			throw new IllegalStateException("True Vars not populated");
		}
		if(Xi.length!= getNInts()) {
			throw new IllegalStateException("Xi length mismatch!");
		}
		
		double solerror = 0;
		for(int i=0;i<Xi.length;i++) {
			solerror += Math.abs(Xi[i]-trueInts[i]);
		}
		return (solerror/(Xi.length*1.0d));
	}
	public double calculateIntError_Balanced_W_around_Apriori(double[] Xi) {
		if(!isTrueVarsPopulated()) {
			throw new IllegalStateException("True Vars not populated");
		}
		if(Xi.length!= getNInts()) {
			throw new IllegalStateException("Xi length mismatch!");
		}
		
		double Error = 0;				
		double N = 20498.0;
		double k= 15.0d;
		
		double _n = N/k; // total count / n_types 
		double C = 1/N;  //mild dependency on group size
	//	double C = 1/(N-_n);  //stronger dependency on group size
		
		for(int i=0;i<Xi.length;i++) {
			double absError_i = Math.abs(Xi[i]-trueInts[i]);
			double d_i = C * (_n-trueInts[i]);			
			double W_i = 1.0d +d_i;			
			Error += W_i * absError_i;
		}	
	
		return Error/(N);   
	}
	
	public double[] getTrueRHS() {
		return trueRHS;
	}

	public double[] getTrueInts() {
		return trueInts;
	}

	public void setTrueInts(double[] true_ints) {
		if(true_ints.length!=getNInts()) {
			throw new IllegalStateException("true ints length mismatch!");
		}
		this.trueInts = true_ints;
	}

	public double[] getTrueReals() {
		return trueReals;
	}

	public double[] getTrueFlattenedIntRatios() {
		double[] flattenedRatios = new double[this.trueInts.length];
		double sum = getSumOfAllTrueInts();
		for(int i=0;i<flattenedRatios.length; i++) {
			flattenedRatios[i] = trueInts[i]/sum;
		}
		return flattenedRatios;
	}
	
	public double getSumOfAllTrueInts() {
		double sum = 0;
		for(int i=0;i<trueInts.length;i++)
			sum+=trueInts[i];
		return sum;
	}
	public void setTrueReals(double[] true_reals) {
		if(true_reals.length!=getNReals()) {
			throw new IllegalStateException("true reals length mismatch!");
		}
		this.trueReals = true_reals;
	}
	public String getParentOutputDirectory(){
		return	"m"+mockupID+"_n"+noiseLevel+"_et"+nExpTrials;
	}
	
	public int getMockupID() {
		return this.mockupID;
	}
	
	public int getNoiseLevel() {
		return this.noiseLevel;
	}
	public int getColIdxForNoiseLevel() {
		int colIdxForNoiseLevel=0;
		if(noiseLevel==0) colIdxForNoiseLevel=0;
		if(noiseLevel==1) colIdxForNoiseLevel=1;
		if(noiseLevel==5) colIdxForNoiseLevel=2;
		if(noiseLevel==10) colIdxForNoiseLevel=3;
		if(noiseLevel==20) colIdxForNoiseLevel=4;
		
		if(noiseLevel==100) colIdxForNoiseLevel=5;
		if(noiseLevel==777) colIdxForNoiseLevel=7; //dummy
		return colIdxForNoiseLevel;
	}
	public static void main(String[] args) {
		SystemConfig config = new SystemConfig();
		System.out.println("n_ints:\t"+config.getNInts() +"\nn_reals:\t"+config.getNReals()+
				"\nn_RHS:\t"+config.getNRHS());
	}
	
	private static JSONObject readPrimaryInput (String fileName) {
		JSONObject jsonObj = null; 
		try {
			String content = new Scanner(new File(fileName)).useDelimiter("\\Z").next();
			jsonObj = new JSONObject(content);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObj;
	}
}
