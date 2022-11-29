import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.math3.random.MersenneTwister;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ec.util.MersenneTwisterFast;

public class PreECJ {
	private static final String mockupSheetFileName="input/model_inputs.xlsx";
	private static final int N_HEADER_ROWS = 1;
	
	private static final int TRUE_RHS_COL=0;
	private static final int TRUE_XI_COL=10;
	private static final int TRUE_XI_SUM_COL=11;
	private static final int TRUE_XI_GENE_COL=13;
	private static final int TRUE_XI_FLAT_COL=14;
	private static final int TRUE_AI_COL=15;
	
	
	private static double[] flattenedRatios(double[] Xi, double sum) {
		double[] genes = new double[28];
		
		int geneIDx = 0;
		genes[geneIDx++]=sum;
		
		for(int i=0;i<Xi.length;i++) {
			genes[geneIDx++]= Xi[i];
		}
		genes[geneIDx++]=-1;//dummy;
		
		Equation eqn = new Equation(genes, false);
		return eqn.falttened_rates;
	}
	
	private static double[] trueXiRatiosAsGenes(double[] flattenedXis) {
		double[] trueXisAsGenes = new double[flattenedXis.length-1];
		
		trueXisAsGenes[0]=flattenedXis[0];
		double sum=flattenedXis[0];
		
		for(int i=1;i<trueXisAsGenes.length;i++) {
			trueXisAsGenes[i]= flattenedXis[i]/(1-sum);
			sum +=flattenedXis[i];
		}
		return trueXisAsGenes;
	}
	private static long[] generateInts(int n, int max_val) {
		long[] mockupInts = new long[n];
		int cnt=0;
		
		MersenneTwisterFast mtf = new MersenneTwisterFast(System.currentTimeMillis());		
		for(int i=0;i<n;i++) {
			int randomInt = mtf.nextInt(max_val);
			mockupInts[cnt++]=randomInt;
		}
		return mockupInts;
	}
	
	private static double[] generateDoubles(int n) {
		double[] mockupAis = new double[n];
		int cnt=0;
		
		MersenneTwisterFast mtf = new MersenneTwisterFast(System.currentTimeMillis());		
		for(int i=0;i<n;i++) {
			double randomDouble = mtf.nextDouble();			
			if(randomDouble < 0.2) {i--; continue;}
			if(randomDouble > 0.95) {i--; continue;}
			mockupAis[cnt++]=randomDouble;
		}
		return mockupAis;
	}
	
	
	public static void constructTrueIntsAndReals() {
		//construct_trueInts();
		//construct_trueReals(int n_exp_trials);
		//populate columns N and P and L
	}	
	
	public static void CalculateRHSFromMockup() {
		double trueXiSum = readMockupSheet(1, TRUE_XI_SUM_COL)[0];
		double[] trueXiGene = readMockupSheet(Equation.sysConfig.getNInts()-1, TRUE_XI_GENE_COL);
		double[] trueAi = readMockupSheet(Equation.sysConfig.getNReals(), TRUE_AI_COL);
		
		double[] eaGenes = new double[Equation.sysConfig.getNGenes()];
		int idx=0;
		eaGenes[idx++] = trueXiSum;
		for(int i=0;i<trueXiGene.length;i++) {
			eaGenes[idx++] = trueXiGene[i]; 
		}
		eaGenes[idx++] = -1; //dummy
		for(int i=0;i<trueAi.length;i++) {
			eaGenes[idx++] = trueAi[i]; 
		}
		Equation eqn = new Equation(eaGenes, true);
		long[] rhsValues = eqn.calculateValuesForNExpTrials();
		long old_rhs, new_rhs, rand;
		int rand_int;
		double rand_double;
		MersenneTwister mt = new MersenneTwister(System.currentTimeMillis());		
		System.out.println("\nRHS:");
		for(int i=0;i<rhsValues.length;i++) {
			
			old_rhs = rhsValues[i];
			while(true) {
				// relative noise
				if(mt.nextBoolean()) {
					rand_double = old_rhs*((Equation.sysConfig.getNoiseLevel()*1d)/100d);
				}else {
					rand_double = -old_rhs*((Equation.sysConfig.getNoiseLevel()*1d)/100d);
				}				
				new_rhs = Math.round(old_rhs + rand_double);	
				
				if(Math.abs(new_rhs-old_rhs) < 1 && Equation.sysConfig.getNoiseLevel()!=0) {
					if(mt.nextBoolean()) {
						new_rhs=old_rhs+1;
					}else {
						new_rhs=old_rhs-1;
					}				
				}
				
				if(new_rhs<0) {
					new_rhs=0;
				}
				if(new_rhs>=0)
					break;
				
				
			}
			rhsValues[i] = new_rhs;	//temp comment!!!!			
			System.out.println(rhsValues[i]);
		}		
		
	}
	
	//invoked post-ecj
	public static void populateSysConfigTrueVarsFromSheet() {
		double[] trueXi = readMockupSheet(Equation.sysConfig.getNInts(), TRUE_XI_COL);
		double[] trueAi = readMockupSheet(Equation.sysConfig.getNReals(), TRUE_AI_COL);
		Equation.sysConfig.populateTrueVars(trueXi, trueAi);
	}
	
	//invoked pre-ecj
	public static void populateSysConfigTrueRHSFromSheet() {
		double[] trueRHS = readMockupSheet(Equation.sysConfig.getNRHS(), Equation.sysConfig.getColIdxForNoiseLevel());
		Equation.sysConfig.populateTrueRHS(trueRHS);
	}
	
	private static double[] readMockupSheet(int n_rows, int colIdx) {			
		double[] column = new double[n_rows];
		 try {
	            FileInputStream fis = new FileInputStream(mockupSheetFileName);	             
	            Workbook workbook = null;
	            if(mockupSheetFileName.toLowerCase().endsWith("xlsx")){
	                workbook = new XSSFWorkbook(fis);
	            }else if(mockupSheetFileName.toLowerCase().endsWith("xls")){
	                workbook = new HSSFWorkbook(fis);
	            }  
	            
	            Sheet sheet = workbook.getSheet("m"+Equation.sysConfig.getMockupID());                 
	            Iterator<Row> rowIterator = sheet.iterator();    
	            Row row = null;
	            int rowIdx=0;
	            while(rowIdx<n_rows){     			
	                row = rowIterator.next();
	                if(row.getRowNum()<N_HEADER_ROWS) { //headerrow
	                	continue;
	                }
	                column[rowIdx++] = readDouble(row, colIdx);	                
	            }
	            fis.close();
		 }catch (IOException e) {
	            e.printStackTrace();
	     }
		 return column;
	}
	
	
	private static double readDouble(Row row, int colIdx){
		//System.out.println(row.getRowNum() +", "+colIdx);
    	double item = Double.NaN;
    	try{
	    	Cell cell = row.getCell(colIdx);
	    	if(cell == null || cell.getCellType()==cell.CELL_TYPE_BLANK){
            	return item;
            }
        	if(cell.getCellType()==cell.CELL_TYPE_NUMERIC){
        		item = (double) cell.getNumericCellValue();
        	}else{
        		item = Double.valueOf((double) cell.getNumericCellValue());
        	}
        	
    	}catch(IllegalStateException e){
    		System.out.println(row.getRowNum() +", "+colIdx);
    		e.printStackTrace();
    	}
        return item;
    }
		
	
}
