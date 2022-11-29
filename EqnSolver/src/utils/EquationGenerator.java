package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.commons.math3.util.Combinations;


public class EquationGenerator {

	int regions;
	int injections;
	int experiments;
	
	EquationGenerator(int regions, int injections){
		this.regions=regions;
		this.injections=injections;
		this.experiments = choose(regions, injections);
		System.out.println("#of experiments " + experiments);
	}
	
	void generateEquation(String[] experiment) {
		if(experiment.length != injections) {
			dispError("generateEquation()", "experiment labels and number of injections do not match!");
		}
		String exp_label="";
		for(int i=0;i<experiment.length;i++) {
			exp_label+=experiment[i];
		}
		
		try {
			FileWriter fw = new FileWriter("Equations_"+this.regions+"C"+this.injections+"/exp_"+exp_label);
			
			int nPossibleExpressions = (int)Math.pow(2, injections)-1;
			
			for(int i=1; i<=nPossibleExpressions; i++) 
			{
				//int i=6;	
				boolean[] expression = getExpression(Integer.toString(i,2), injections);
				
				SingleEquation equation = new SingleEquation(experiment, expression, regions);
				String singleEquation = equation.getSingleEquation();
				fw.write("exp_"+exp_label);
				
				fw.write("_obs_"+i+" = \n"+singleEquation);
				fw.write("\n");
				fw.flush();
			}
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void generateEquations() {
		//String[] experiment = new String[] {"2", "3", "4", "6"};		
		
		for (Iterator<int[]> iter = new Combinations(this.regions, this.injections).iterator(); iter.hasNext();) {
			int[] exp = iter.next();
			String[] exper = new String[exp.length];
			for(int i=0;i<exp.length;i++) {
				exper[i]=Integer.toString(exp[i]+1);
			}				
            System.out.println("Generating equations for Experiment: "+Arrays.toString(exper));
			generateEquation(exper);
        }		
		//
	}
	
	public static void main(String[] args) {
		int n=0;
		int k=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("nCk.in"));
			n = Integer.valueOf(br.readLine());	
			k = Integer.valueOf(br.readLine());				
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		
		//int n=4;
		//int k=3;
		File f=new File("Equations_"+n+"C"+k);
		if(f.exists()) {
			f.delete();
		}
		f.mkdir();
		
		EquationGenerator eGen = new EquationGenerator(n, k);
		eGen.generateEquations();	
		System.out.println("Equations for "+eGen.experiments+ " experiments written to "+f.getAbsolutePath());
	}
	
	
	
	
	
	private static boolean[] getExpression(String binary, int expLength) {
		if(binary.length()>expLength) {
			dispError("getMask()","length error");
		}
		
		boolean[] mask = new boolean[expLength];
		
		int mskI=0;
		for(int i=0;i<(expLength-binary.length());i++) {
			mask[mskI++]=false;
		}
		for(int i=0; i<binary.length();i++) {
			if(binary.charAt(i)=='1') {
				mask[mskI++]=true;
			}else
				mask[mskI++]=false;
		}
		
		return mask;
	}
	
	
	private static void dispError(String function, String message) {
		System.out.println("in "+function+" :\t"+message);
		System.exit(-1);
	}
	
	public static int choose(int x, int y) {
	    if (y < 0 || y > x) return 0;
	    if (y > x/2) {
	        // choose(n,k) == choose(n,n-k), 
	        // so this could save a little effort
	        y = x - y;
	    }

	    int denominator = 1, numerator = 1;
	    for (int i = 1; i <= y; i++) {
	        denominator *= i;
	        numerator *= (x + 1 - i);
	    }
	    return numerator / denominator;
	}
	
	private static void display(boolean[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
