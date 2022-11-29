import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class ECJSolution {

	int[] Xi;
	double[] Ai;
	double eaError;
	double intError;
	
	String set;
	int jobIdx;
	
	ECJSolution(int[] xi, double[] ai, double ea_error, double int_error, String _set, int job_idx){
		Xi = xi;
		Ai= ai;
		eaError = ea_error;
		intError = int_error;
		set = _set;
		jobIdx= job_idx;
	}
	static double[] getApproximationFromAllSolutionsForThreshold(List<ECJSolution> solutions, double eaErrorThresh, FileWriter fw) throws IOException {
		double[] medians = new double[solutions.get(0).Xi.length];
		List<Integer[]> acceptedSolutions = new ArrayList<>();
		List<Double> eaErrors = new ArrayList<>();
		List<String> set = new ArrayList<>();
		List<Integer> jobIdx = new ArrayList<>();
		for(int i=0;i<solutions.size();i++) {
			if(solutions.get(i).eaError <= eaErrorThresh) {
				acceptedSolutions.add(solutions.get(i).getIntegerObject());
				eaErrors.add(solutions.get(i).eaError);
				set.add(solutions.get(i).set);
				jobIdx.add(solutions.get(i).jobIdx);
			}				
		}
		
		for(int j=0;j<acceptedSolutions.size();j++) {
			Integer[] xi = acceptedSolutions.get(j);
			fw.write(set.get(j)+","+jobIdx.get(j)+","+eaErrors.get(j));
			for(int i=0;i<xi.length;i++) {
				fw.write(","+xi[i]);
			}
			fw.write("\n");
		}
		fw.close();
		
		double[] column = new double[acceptedSolutions.size()];
		for(int i=0;i<medians.length;i++) {
			for(int j=0;j<acceptedSolutions.size();j++) {
				column[j] = acceptedSolutions.get(j)[i];
			}
			medians[i] = getMedian(column);
		}
		return medians;
	}
	static void getAisFromAllSolutionsForThreshold(List<ECJSolution> solutions, double eaErrorThresh, FileWriter fw) throws IOException {
		
		List<Double> ais = new ArrayList<>();
		for(int i=0;i<solutions.size();i++) {
			if(solutions.get(i).eaError <= eaErrorThresh) {
				for(int ii=0;ii<solutions.get(i).Ai.length;ii++)
				{
					ais.add(solutions.get(i).Ai[ii]);
				}				
			}				
		}
		
		for(int i=0;i<ais.size();i++) {
			fw.write(""+ais.get(i)+"\n");
		}
		fw.close();
	}
	
	static void writeAllEAerrors(List<ECJSolution> solutions, String filename) throws IOException {
		FileWriter fw = new FileWriter(filename);
		for(ECJSolution soln: solutions) {
			fw.write(""+soln.eaError+"\n");
		}	
		fw.close();		
	}
	static double[] getApproximationFromAllSolutions_FromTopN(List<ECJSolution> solutions, double p, FileWriter fw) throws IOException {			
		List<Double> list = new ArrayList<>();
		for(ECJSolution soln: solutions) {
			list.add(soln.eaError);
		}			
		double errThresh = errThreshForTopNpercentile(list, p);
		return getApproximationFromAllSolutionsForThreshold(solutions, errThresh, fw);
	}
	
	static void getAisFromAllSolutions_FromTopN(List<ECJSolution> solutions, double p, FileWriter fw) throws IOException {			
		List<Double> list = new ArrayList<>();
		for(ECJSolution soln: solutions) {
			list.add(soln.eaError);
		}			
		double errThresh = errThreshForTopNpercentile(list, p);
		getAisFromAllSolutionsForThreshold(solutions, errThresh, fw);
	}
	Integer[] getIntegerObject() {
		Integer[] xi = new Integer[Xi.length];
		for(int i=0;i<xi.length;i++) {
			xi[i]=Xi[i];
		}
		return xi;
	}

	static double getMedian(double[] array) {
		DescriptiveStatistics ds = new DescriptiveStatistics(array);
		return ds.getPercentile(50);
	}
	static double getMean(double[] array) {
		DescriptiveStatistics ds = new DescriptiveStatistics(array);
		return ds.getMean();
	}
	
	static double errThreshForTopNpercentile(List<Double> list, double p) {
		Collections.sort(list);
		double[] array = new double[list.size()];
		for(int i=0;i<array.length;i++) {
			array[i]=list.get(i);
		}
		DescriptiveStatistics ds = new DescriptiveStatistics(array);
		return ds.getPercentile(p);
	}
	
	public static void main(String[] args) {
		List<Double> list = new ArrayList<>();
		MersenneTwister mt = new MersenneTwister();
		for(int i=0;i<100;i++) {			
			list.add(mt.nextDouble());
		}
		
		System.out.println(list);
		double p = errThreshForTopNpercentile(list, 5);
		System.out.println(list);
		System.out.println(p);
	}
}
