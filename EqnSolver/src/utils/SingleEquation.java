package utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LHS of A single equation (1/15)of35 for 7c4
public class SingleEquation {
	int nRegions;
	String[] experiment;
	String[] nonInjectedRegions;
	boolean[] expression;
	String[] nonExpressedRegions;
	String[] expressedRegions;
	
	int nSets;
	

	public SingleEquation(String[] experiment, boolean[] expression, int nRegions) {
		if(experiment.length!=expression.length) {
			System.out.println("length mismatch! in SingleEquation()");			
			System.exit(-1);
		}
		this.nRegions=nRegions;
		this.experiment=experiment;
		this.expression=expression;
		this.nSets=nSets();
		this.nonInjectedRegions=nonInjectedRegions();
		this.nonExpressedRegions=nonExpressedRegions();
		this.expressedRegions=expressedRegions();
	}
	
	private int nSets() {
		//An equation has n sets, where n=2^(no. of falses)
		int count =0;
		for(boolean b:expression) {
			if(!b) count++;
		}
		return (int)Math.pow(2, count);
	}
	
	private String[] nonInjectedRegions() {
		 String[] nonIR=new String[nRegions - experiment.length];
		 int idx=0;
		for(int i=1;i<=nRegions;i++) {
			boolean found = false;
			for(int j=0;j<experiment.length;j++) {
				if(experiment[j].equals(Integer.toString(i))) {
					found = true;
					break;
				}
			}
			if(!found) {
				nonIR[idx++]=Integer.toString(i);
			}
		}
		return nonIR;
	}
	
	private String[] nonExpressedRegions() {
		int count_ne=0;
		for(int i=0;i<expression.length;i++) {
			if(!expression[i])
				count_ne++;
		}
		String[] neR=new String[count_ne];
		int idx=0;
		for(int i=0;i<expression.length;i++) {
			if(!expression[i])
				neR[idx++]=experiment[i];
		}
		return neR;
	}
	private String[] expressedRegions() {
		int count_ne=0;
		for(int i=0;i<expression.length;i++) {
			if(expression[i])
				count_ne++;
		}
		String[] eR=new String[count_ne];
		int idx=0;
		for(int i=0;i<expression.length;i++) {
			if(expression[i])
				eR[idx++]=experiment[i];
		}
		return eR;
	}
	private String eqnSet(String[] neuronTypes, String[] realVars) {
		String eqnSet=" ( ";
		for(int i=0;i<neuronTypes.length;i++) {
			if(i!=neuronTypes.length-1)
				eqnSet=eqnSet+ neuronTypes[i] +" + ";
			else
				eqnSet=eqnSet+ neuronTypes[i] +" ) ";
		}
		eqnSet = eqnSet + "\n*\n(";
		for(int i=0;i<realVars.length;i++) {
			if(i!=realVars.length-1)
				eqnSet = eqnSet+ realVars[i] + " * "; 
			else
				eqnSet = eqnSet+ realVars[i] + " )\n"; 
		}
		return eqnSet;
	}
	
	private String[] identifyProjectionTypesForSingleSet(String[] projectionRegions) {
	
		String[] projectionTypes = new String[(int)Math.pow(2, (nRegions-experiment.length))];
		for(int i=0;i<projectionTypes.length;i++) {
			projectionTypes[i] = nt(projectionRegions, nonInjectedPossibility(i));
		}
		return projectionTypes;
	}
	
	private String[] identifyRealVarsForSingleSet(String[] negativeFractions) {
	
		String[] realVars = new String[expressedRegions.length+negativeFractions.length];
		int idx=0;
		for(int i=0;i<expressedRegions.length;i++) {
			realVars[idx++] = exp(this.experiment, expressedRegions[i]);
		}
		for(int i=0;i<negativeFractions.length;i++) {
			realVars[idx++] = "(1-"+exp(this.experiment, negativeFractions[i])+")";
		}
		return realVars;
	}
	
	private String[] nonInjectedPossibility(int integer) {
		//for 7c4 -> with 4 inections, 3 regions remain unknown creating 8 possibilities..
		//parameter i in range (0, 7)
		//convert i to binary (to mask) to get one possibility
		List<String> nip= new ArrayList<>();
		
		String binary = Integer.toString(integer, 2);		
		boolean[] mask = new boolean[this.nonInjectedRegions.length];		
		int mskI=0;
		for(int i=0;i<(mask.length-binary.length());i++) {
			mask[mskI++]=false;
		}
		for(int i=0; i<binary.length();i++) {
			if(binary.charAt(i)=='1') {
				mask[mskI++]=true;
			}else
				mask[mskI++]=false;
		}
		
		for(int i=0;i<nonInjectedRegions.length;i++) {
			if(mask[i])
				nip.add(nonInjectedRegions[i]);
		}
		String[] niPossibility= new String[nip.size()];
		for(int i=0;i<niPossibility.length;i++) {
			niPossibility[i]=nip.get(i);
		}
		
		return niPossibility;
	}
	
	private String[] projectionRegionPossibilityForSingleSet(int integer) {
		//inetger is the set number: 2^(no. of falses/non-expressions)
		//conver to binary -- and use it as mask to iterate through non-expressed regions
		List<String> prp= new ArrayList<>();
		
		for(int i=0;i<this.expression.length;i++) {
			if(expression[i])
				prp.add(experiment[i]);
		}
		
		
		String binary = Integer.toString(integer, 2);		
		
		if(this.nonExpressedRegions.length>0) {
			boolean[] mask = new boolean[this.nonExpressedRegions.length];		
			
			int mskI=0;
			for(int i=0;i<(mask.length-binary.length());i++) {
				mask[mskI++]=false;
			}
			for(int i=0; i<binary.length();i++) {
				if(binary.charAt(i)=='1') {
					mask[mskI++]=true;
				}else
					mask[mskI++]=false;
			}
			
			for(int i=0;i<nonExpressedRegions.length;i++) {
				if(mask[i])
					prp.add(nonExpressedRegions[i]);
			}		
		}
		
		String[] regions = new String[prp.size()];
		for(int i=0;i<regions.length;i++) {
			regions[i]=prp.get(i);
		}
		
		return regions;
	}
	
	private String[] identifyNegativeFractions(String[] possibleProjectionRegions) {
		//identify projection regions considered as possibilities, but not expressed
		List<String> nfr = new ArrayList<>();
		for(int i=0;i<this.nonExpressedRegions.length;i++) {
			for(int j=0;j<possibleProjectionRegions.length;j++) {
				if(nonExpressedRegions[i].equals(possibleProjectionRegions[j])) {
					nfr.add(nonExpressedRegions[i]);
				}
			}
		}
		String[] negativeFractionRegions = new String[nfr.size()];
		for(int i=0;i<negativeFractionRegions.length;i++) {
			negativeFractionRegions[i]=nfr.get(i);
		}
		return negativeFractionRegions;
	}
	
	public String getSingleEquation() {
		String eqn="(";
		for(int j=0;j<nSets;j++) {		
			
			String[] possibleProjectionRegions=projectionRegionPossibilityForSingleSet(j);
			String[] negativeFractions=identifyNegativeFractions(possibleProjectionRegions);
			
			String[] neuronTypes=identifyProjectionTypesForSingleSet(possibleProjectionRegions);
			String[] realVars=identifyRealVarsForSingleSet( negativeFractions);
			
			
			String set = eqnSet(neuronTypes, realVars);		
		
			if(j!=nSets-1)
				eqn=eqn+set+ ")\n+\n(";
			else
				eqn=eqn + set + ")\n";
		}
		return eqn;
	}
	private  String nt(String[] projRegions) {
		String label="N";
		int[] projReg = new int[projRegions.length];
		for(int i=0;i<projReg.length;i++) {
			projReg[i]=Integer.valueOf(projRegions[i]);
		}
		Arrays.sort(projReg);
		
		for(int i=0;i<projReg.length;i++) {
			label+=projReg[i];
		}
		return label;
	}
	
	private  String nt(String[] projRegions1, String[] projRegions2) {
		String label="N";
		int[] projReg = new int[projRegions1.length + projRegions2.length];
		int idx=0;
		for(int i=0;i<projRegions1.length;i++) {
			projReg[idx++]=Integer.valueOf(projRegions1[i]);
		}
		for(int i=0;i<projRegions2.length;i++) {
			projReg[idx++]=Integer.valueOf(projRegions2[i]);
		}
		
		Arrays.sort(projReg);
		
		for(int i=0;i<projReg.length;i++) {
			label+=projReg[i];
		}
		return label;
	}
	
	private  String exp(String[] experiment, String region) {
		String label="e";
		for(int i=0;i<experiment.length;i++) {
			label+=experiment[i];
		}
		label=label+"_"+region;
		return label;
	}
	
	
	private static void test() {
	}
	private static void dispError(String function, String message) {
		System.out.println("in "+function+" :\t"+message);
		System.exit(-1);
	}

}
