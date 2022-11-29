import java.util.ArrayList;

/*
 * ToDo:
 *  - tighter coupling with SystemConfig.java
 *  		- remove hard declaration of Xi and Ai, and use the arrays in SystemConfig.java
 *  - Then, tighter coupling with EquationGenerator.java for variable declaration
 */
public class Equation {
	public static boolean POST_ECJ = false;
	public static SystemConfig sysConfig;
	
	int x1,x2,x3,x4,x5,x6,x7,x8,x9,x10,x11,x12,x13,x14,x15;
	double totalN;
	
	double a1, a2, a3;
	double b1, b2, b4;
	double c1, c3, c4;
	double d2, d3, d4;
	
	double a1_1, a2_1, a3_1;
	double b1_1, b2_1, b4_1;
	double c1_1, c3_1, c4_1;
	double d2_1, d3_1, d4_1;
	
	double a1_2, a2_2, a3_2;
	double b1_2, b2_2, b4_2;
	double c1_2, c3_2, c4_2;
	double d2_2, d3_2, d4_2;
	
	double a1_3, a2_3, a3_3;
	double b1_3, b2_3, b4_3;
	double c1_3, c3_3, c4_3;
	double d2_3, d3_3, d4_3;
	
	double a1_4, a2_4, a3_4;
	double b1_4, b2_4, b4_4;
	double c1_4, c3_4, c4_4;
	double d2_4, d3_4, d4_4;
	
	double a1_5, a2_5, a3_5;
	double b1_5, b2_5, b4_5;
	double c1_5, c3_5, c4_5;
	double d2_5, d3_5, d4_5;
	
	double a1_6, a2_6, a3_6;
	double b1_6, b2_6, b4_6;
	double c1_6, c3_6, c4_6;
	double d2_6, d3_6, d4_6;
	
	double a1_7, a2_7, a3_7;
	double b1_7, b2_7, b4_7;
	double c1_7, c3_7, c4_7;
	double d2_7, d3_7, d4_7;
	
	double a1_8, a2_8, a3_8;
	double b1_8, b2_8, b4_8;
	double c1_8, c3_8, c4_8;
	double d2_8, d3_8, d4_8;
	
	double a1_9, a2_9, a3_9;
	double b1_9, b2_9, b4_9;
	double c1_9, c3_9, c4_9;
	double d2_9, d3_9, d4_9;
	
	double a1_10, a2_10, a3_10;
	double b1_10, b2_10, b4_10;
	double c1_10, c3_10, c4_10;
	double d2_10, d3_10, d4_10;
	
	double a1_11, a2_11, a3_11;
	double b1_11, b2_11, b4_11;
	double c1_11, c3_11, c4_11;
	double d2_11, d3_11, d4_11;
	
	double a1_12, a2_12, a3_12;
	double b1_12, b2_12, b4_12;
	double c1_12, c3_12, c4_12;
	double d2_12, d3_12, d4_12;
	
	double a1_13, a2_13, a3_13;
	double b1_13, b2_13, b4_13;
	double c1_13, c3_13, c4_13;
	double d2_13, d3_13, d4_13;
	
	double a1_14, a2_14, a3_14;
	double b1_14, b2_14, b4_14;
	double c1_14, c3_14, c4_14;
	double d2_14, d3_14, d4_14;
	double reward;
	double[] falttened_rates;
	int[] xi;	
	double[] ai;
	
	public Equation(double[] genes, boolean display) {
		if(sysConfig==null) {
			throw new IllegalStateException("System Config is Null");
		}
		
		if(!POST_ECJ && sysConfig.isTrueVarsPopulated()) {
			throw new IllegalStateException("True vars should be only populated PostECJ");
		}
		totalN = (int)genes[0];

		falttened_rates = flattenedRatios(genes, 1);
		xi=new int[15];		
		
		x1=(int)Math.round(totalN*falttened_rates[0]);
		x2=(int)Math.round(totalN*falttened_rates[1]);
		x3=(int)Math.round(totalN*falttened_rates[2]);
		x4=(int)Math.round(totalN*falttened_rates[3]);
		x5=(int)Math.round(totalN*falttened_rates[4]);
		x6=(int)Math.round(totalN*falttened_rates[5]);
		x7=(int)Math.round(totalN*falttened_rates[6]);
		x8=(int)Math.round(totalN*falttened_rates[7]);
		x9=(int)Math.round(totalN*falttened_rates[8]);
		x10=(int)Math.round(totalN*falttened_rates[9]);
		x11=(int)Math.round(totalN*falttened_rates[10]);
		x12=(int)Math.round(totalN*falttened_rates[11]);
		x13=(int)Math.round(totalN*falttened_rates[12]);
		x14=(int)Math.round(totalN*falttened_rates[13]);
		x15=(int)Math.round(totalN*falttened_rates[14]);
		//x15=(int)Math.round(totalN*genes[15]);
		
		xi[0]=x1; xi[1]=x2; xi[2]=x3; xi[3]=x4; xi[4]=x5; xi[5]=x6; xi[6]=x7; xi[7]=x8; 
		xi[8]=x9; xi[9]=x10; xi[10]=x11; xi[11]=x12; xi[12]=x13; xi[13]=x14; xi[14]=x15; 
		
		ai = new double[genes.length-16];
		
		for(int i=0;i<ai.length;i++) {
			ai[i]=genes[i+16];
		}
		if(sysConfig.getNExpTrials()>=1) {		
			a1=genes[16];		a2=genes[17];		a3=genes[18];
			b1=genes[19];		b2=genes[20];		b4=genes[21];
			c1=genes[22];		c3=genes[23];		c4=genes[24];
			d2=genes[25];		d3=genes[26];		d4=genes[27];
			
			
		}
		if(sysConfig.getNExpTrials()>=2) {					
			a1_1=genes[28];		a2_1=genes[29];		a3_1=genes[30];
			b1_1=genes[31];		b2_1=genes[32];		b4_1=genes[33];
			c1_1=genes[34];		c3_1=genes[35];		c4_1=genes[36];
			d2_1=genes[37];		d3_1=genes[38];		d4_1=genes[39];
		}
		
		if(sysConfig.getNExpTrials()>=3) {	
			a1_2=genes[40];		a2_2=genes[41];		a3_2=genes[42];
			b1_2=genes[43];		b2_2=genes[44];		b4_2=genes[45];
			c1_2=genes[46];		c3_2=genes[47];		c4_2=genes[48];
			d2_2=genes[49];		d3_2=genes[50];		d4_2=genes[51];
		}
		
		if(sysConfig.getNExpTrials()>=4) {	
			a1_3=genes[52];		a2_3=genes[53];		a3_3=genes[54];
			b1_3=genes[55];		b2_3=genes[56];		b4_3=genes[57];
			c1_3=genes[58];		c3_3=genes[59];		c4_3=genes[60];
			d2_3=genes[61];		d3_3=genes[62];		d4_3=genes[63];
		}
		
		if(sysConfig.getNExpTrials()>=5) {	
			a1_4=genes[64];		a2_4=genes[65];		a3_4=genes[66];
			b1_4=genes[67];		b2_4=genes[68];		b4_4=genes[69];
			c1_4=genes[70];		c3_4=genes[71];		c4_4=genes[72];
			d2_4=genes[73];		d3_4=genes[74];		d4_4=genes[75];
		}
		
		if(sysConfig.getNExpTrials()>=6) {	
			a1_5=genes[76];		a2_5=genes[77];		a3_5=genes[78];
			b1_5=genes[79];		b2_5=genes[80];		b4_5=genes[81];
			c1_5=genes[82];		c3_5=genes[83];		c4_5=genes[84];
			d2_5=genes[85];		d3_5=genes[86];		d4_5=genes[87];
		}
		
		if(sysConfig.getNExpTrials()>=7) {	
			a1_6=genes[88];		a2_6=genes[89];		a3_6=genes[90];
			b1_6=genes[91];		b2_6=genes[92];		b4_6=genes[93];
			c1_6=genes[94];		c3_6=genes[95];		c4_6=genes[96];
			d2_6=genes[97];		d3_6=genes[98];		d4_6=genes[99];
		}
		
		if(sysConfig.getNExpTrials()>=8) {	
			a1_7=genes[100];		a2_7=genes[101];		a3_7=genes[102];
			b1_7=genes[103];		b2_7=genes[104];		b4_7=genes[105];
			c1_7=genes[106];		c3_7=genes[107];		c4_7=genes[108];
			d2_7=genes[109];		d3_7=genes[110];		d4_7=genes[111];
		}
		
		if(sysConfig.getNExpTrials()>=9) {	
			a1_8=genes[112];		a2_8=genes[113];		a3_8=genes[114];
			b1_8=genes[115];		b2_8=genes[116];		b4_8=genes[117];
			c1_8=genes[118];		c3_8=genes[119];		c4_8=genes[120];
			d2_8=genes[121];		d3_8=genes[122];		d4_8=genes[123];
		}
		if(sysConfig.getNExpTrials()>=10) {	
			a1_9=genes[124];		a2_9=genes[125];		a3_9=genes[126];
			b1_9=genes[127];		b2_9=genes[128];		b4_9=genes[129];
			c1_9=genes[130];		c3_9=genes[131];		c4_9=genes[132];
			d2_9=genes[133];		d3_9=genes[134];		d4_9=genes[135];
		}
		if(sysConfig.getNExpTrials()>=11) {	
			a1_10=genes[136];		a2_10=genes[137];		a3_10=genes[138];
			b1_10=genes[139];		b2_10=genes[140];		b4_10=genes[141];
			c1_10=genes[142];		c3_10=genes[143];		c4_10=genes[144];
			d2_10=genes[145];		d3_10=genes[146];		d4_10=genes[147];
		}
		if(sysConfig.getNExpTrials()>=12) {	
			a1_11=genes[148];		a2_11=genes[149];		a3_11=genes[150];
			b1_11=genes[151];		b2_11=genes[152];		b4_11=genes[153];
			c1_11=genes[154];		c3_11=genes[155];		c4_11=genes[156];
			d2_11=genes[157];		d3_11=genes[158];		d4_11=genes[159];
		}
		if(sysConfig.getNExpTrials()>=13) {	
			a1_12=genes[160];		a2_12=genes[161];		a3_12=genes[162];
			b1_12=genes[163];		b2_12=genes[164];		b4_12=genes[165];
			c1_12=genes[166];		c3_12=genes[167];		c4_12=genes[168];
			d2_12=genes[169];		d3_12=genes[170];		d4_12=genes[171];
		}
		if(sysConfig.getNExpTrials()>=14) {	
			a1_13=genes[172];		a2_13=genes[173];		a3_13=genes[174];
			b1_13=genes[175];		b2_13=genes[176];		b4_13=genes[177];
			c1_13=genes[178];		c3_13=genes[179];		c4_13=genes[180];
			d2_13=genes[181];		d3_13=genes[182];		d4_13=genes[183];
		}
		if(sysConfig.getNExpTrials()>=15) {	
			a1_14=genes[184];		a2_14=genes[185];		a3_14=genes[186];
			b1_14=genes[187];		b2_14=genes[188];		b4_14=genes[189];
			c1_14=genes[190];		c3_14=genes[191];		c4_14=genes[192];
			d2_14=genes[193];		d3_14=genes[194];		d4_14=genes[195];
		}

		if(display) {
			System.out.println("Total N:\t"+totalN+"\nrates:");			
			for(int i=0;i<falttened_rates.length;i++) {
				System.out.print(falttened_rates[i]+"\t"+(int)Math.round(totalN*falttened_rates[i])+"\n");
			}
			System.out.println("\nrealvals:");
			int realGene_start = sysConfig.getNInts()+1;
			int realGene_end = sysConfig.getNInts()+1+sysConfig.getNReals();			
			for(int i=realGene_start;i<realGene_end;i++) {
				System.out.print(genes[i]+"\n");
			}
		}
	}
	
	private double[] flattenedRatios(double[] genes, int startId) {
		double[] flatGenes = new double[sysConfig.getNInts()];
		int fgid=0;
		flatGenes[fgid++] = genes[startId];
		
		for(int i=startId+1;i<startId+sysConfig.getNInts();i++) {
			double remainingPercent = 0;
			for(int j=0;j<fgid;j++) {
				remainingPercent+= flatGenes[j];
			}
			if(i<startId+sysConfig.getNInts()-1) {
				flatGenes[fgid++] = (1d-remainingPercent)*genes[i];			
			}else {
				flatGenes[fgid++] = (1d-remainingPercent);
			}
		}
		return flatGenes;
	}
	
	
	public long[] calculatedValues() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1*(x1+x9))+Math.round( a1*(1-a2)*(x3+x11))+Math.round( a1*(1-a3)*(x5+x13))+Math.round( a1*(1-a2)*(1-a3)*(x7+x15));
		vals[i++]=Math.round( a2*(x2+x10))+Math.round( a2*(1-a1)*(x3+x11))+Math.round( a2*(1-a3)*(x6+x14))+Math.round( a2*(1-a3)*(1-a1)*(x7+x15));
		vals[i++]=Math.round( a1*a2*(x3+x11))+Math.round( a1*a2*(1-a3)*(x7+x15));
		vals[i++]=Math.round( a3*(x4+x12))+Math.round( a3*(1-a1)*(x5+x13))+Math.round( a3*(1-a2)*(x6+x14))+Math.round( a3*(1-a1)*(1-a2)*(x7+x15));
		vals[i++]=Math.round( a3*a1*(x5+x13))+Math.round( a3*a1*(1-a2)*(x7+x15));
		vals[i++]=Math.round( a3*a2*(x6+x14))+Math.round( a3*a2*(1-a1)*(x7+x15));
		vals[i++]=Math.round( a1*a2*a3*(x7+x15));
		vals[i++]=Math.round( b1*(x1+x5))+Math.round( b1*(1-b2)*(x3+x7))+Math.round( b1*(1-b4)*(x9+x13))+Math.round( b1*(1-b2)*(1-b4)*(x11+x15));
		vals[i++]=Math.round( b2*(x2+x6))+Math.round( b2*(1-b1)*(x3+x7))+Math.round( b2*(1-b4)*(x10+x14))+Math.round( b2*(1-b4)*(1-b1)*(x11+x15));
		vals[i++]=Math.round( b1*b2*(x3+x7))+Math.round( b1*b2*(1-b4)*(x11+x15));
		vals[i++]=Math.round( b4*(x12+x8))+Math.round( b4*(1-b1)*(x13+x9))+Math.round( b4*(1-b2)*(x10+x14))+Math.round( b4*(1-b1)*(1-b2)*(x11+x15));
		vals[i++]=Math.round( b4*b1*(x13+x9))+Math.round( b4*b1*(1-b2)*(x11+x15));
		vals[i++]=Math.round( b4*b2*(x14+x10))+Math.round( b4*b2*(1-b1)*(x11+x15));
		vals[i++]=Math.round( b1*b2*b4*(x11+x15));
		vals[i++]=Math.round(  c1*(x1+x3))+Math.round(  c1*(1- c3)*(x5+x7))+Math.round(  c1*(1- c4)*(x9+x11))+Math.round(  c1*(1- c3)*(1- c4)*(x13+x15));
		vals[i++]=Math.round(  c3*(x4+x6))+Math.round(  c3*(1- c1)*(x5+x7))+Math.round(  c3*(1- c4)*(x14+x12))+Math.round(  c3*(1- c4)*(1- c1)*(x13+x15));
		vals[i++]=Math.round(  c1* c3*(x5+x7))+Math.round(  c1* c3*(1- c4)*(x13+x15));
		vals[i++]=Math.round(  c4*(x8+x10))+Math.round(  c4*(1- c1)*(x9+x11))+Math.round(  c4*(1- c3)*(x14+x12))+Math.round(  c4*(1- c3)*(1- c1)*(x13+x15));
		vals[i++]=Math.round(  c1* c4*(x9+x11))+Math.round(  c1* c4*(1- c3)*(x13+x15));
		vals[i++]=Math.round(  c3* c4*(x12+x14))+Math.round(  c3* c4*(1- c1)*(x13+x15));
		vals[i++]=Math.round(  c1* c3* c4*(x13+x15));
		vals[i++]=Math.round( d2*(x3+x2))+Math.round( d2*(1-d3)*(x6+x7))+Math.round( d2*(1-d4)*(x10+x11))+Math.round( d2*(1-d3)*(1-d4)*(x14+x15));
		vals[i++]=Math.round( d3*(x4+x5))+Math.round( d3*(1-d2)*(x7+x6))+Math.round( d3*(1-d4)*(x13+x12))+Math.round( d3*(1-d4)*(1-d2)*(x15+x14));
		vals[i++]=Math.round( d2*d3*(x6+x7))+Math.round( d2*d3*(1-d4)*(x14+x15));
		vals[i++]=Math.round( d4*(x8+x9))+Math.round( d4*(1-d2)*(x11+x10))+Math.round( d4*(1-d3)*(x13+x12))+Math.round( d4*(1-d3)*(1-d2)*(x15+x14));
		vals[i++]=Math.round( d2*d4*(x10+x11))+Math.round( d2*d4*(1-d3)*(x14+x15));
		vals[i++]=Math.round( d4*d3*(x12+x13))+Math.round( d4*d3*(1-d2)*(x14+x15));
		vals[i++]=Math.round( d2*d3*d4*(x14+x15));
	return vals;
	}
	
	public long[] calculatedValuesForDuplicateExperiments_1() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_1*(x1+x9))+Math.round( a1_1*(1-a2_1)*(x3+x11))+Math.round( a1_1*(1-a3_1)*(x5+x13))+Math.round( a1_1*(1-a2_1)*(1-a3_1)*(x7+x15));
		vals[i++]=Math.round( a2_1*(x2+x10))+Math.round( a2_1*(1-a1_1)*(x3+x11))+Math.round( a2_1*(1-a3_1)*(x6+x14))+Math.round( a2_1*(1-a3_1)*(1-a1_1)*(x7+x15));
		vals[i++]=Math.round( a1_1*a2_1*(x3+x11))+Math.round( a1_1*a2_1*(1-a3_1)*(x7+x15));
		vals[i++]=Math.round( a3_1*(x4+x12))+Math.round( a3_1*(1-a1_1)*(x5+x13))+Math.round( a3_1*(1-a2_1)*(x6+x14))+Math.round( a3_1*(1-a1_1)*(1-a2_1)*(x7+x15));
		vals[i++]=Math.round( a3_1*a1_1*(x5+x13))+Math.round( a3_1*a1_1*(1-a2_1)*(x7+x15));
		vals[i++]=Math.round( a3_1*a2_1*(x6+x14))+Math.round( a3_1*a2_1*(1-a1_1)*(x7+x15));
		vals[i++]=Math.round( a1_1*a2_1*a3_1*(x7+x15));
		vals[i++]=Math.round( b1_1*(x1+x5))+Math.round( b1_1*(1-b2_1)*(x3+x7))+Math.round( b1_1*(1-b4_1)*(x9+x13))+Math.round( b1_1*(1-b2_1)*(1-b4_1)*(x11+x15));
		vals[i++]=Math.round( b2_1*(x2+x6))+Math.round( b2_1*(1-b1_1)*(x3+x7))+Math.round( b2_1*(1-b4_1)*(x10+x14))+Math.round( b2_1*(1-b4_1)*(1-b1_1)*(x11+x15));
		vals[i++]=Math.round( b1_1*b2_1*(x3+x7))+Math.round( b1_1*b2_1*(1-b4_1)*(x11+x15));
		vals[i++]=Math.round( b4_1*(x12+x8))+Math.round( b4_1*(1-b1_1)*(x13+x9))+Math.round( b4_1*(1-b2_1)*(x10+x14))+Math.round( b4_1*(1-b1_1)*(1-b2_1)*(x11+x15));
		vals[i++]=Math.round( b4_1*b1_1*(x13+x9))+Math.round( b4_1*b1_1*(1-b2_1)*(x11+x15));
		vals[i++]=Math.round( b4_1*b2_1*(x14+x10))+Math.round( b4_1*b2_1*(1-b1_1)*(x11+x15));
		vals[i++]=Math.round( b1_1*b2_1*b4_1*(x11+x15));
		vals[i++]=Math.round(  c1_1*(x1+x3))+Math.round(  c1_1*(1- c3_1)*(x5+x7))+Math.round(  c1_1*(1- c4_1)*(x9+x11))+Math.round(  c1_1*(1- c3_1)*(1- c4_1)*(x13+x15));
		vals[i++]=Math.round(  c3_1*(x4+x6))+Math.round(  c3_1*(1- c1_1)*(x5+x7))+Math.round(  c3_1*(1- c4_1)*(x14+x12))+Math.round(  c3_1*(1- c4_1)*(1- c1_1)*(x13+x15));
		vals[i++]=Math.round(  c1_1* c3_1*(x5+x7))+Math.round(  c1_1* c3_1*(1- c4_1)*(x13+x15));
		vals[i++]=Math.round(  c4_1*(x8+x10))+Math.round(  c4_1*(1- c1_1)*(x9+x11))+Math.round(  c4_1*(1- c3_1)*(x14+x12))+Math.round(  c4_1*(1- c3_1)*(1- c1_1)*(x13+x15));
		vals[i++]=Math.round(  c1_1* c4_1*(x9+x11))+Math.round(  c1_1* c4_1*(1- c3_1)*(x13+x15));
		vals[i++]=Math.round(  c3_1* c4_1*(x12+x14))+Math.round(  c3_1* c4_1*(1- c1_1)*(x13+x15));
		vals[i++]=Math.round(  c1_1* c3_1* c4_1*(x13+x15));
		vals[i++]=Math.round( d2_1*(x3+x2))+Math.round( d2_1*(1-d3_1)*(x6+x7))+Math.round( d2_1*(1-d4_1)*(x10+x11))+Math.round( d2_1*(1-d3_1)*(1-d4_1)*(x14+x15));
		vals[i++]=Math.round( d3_1*(x4+x5))+Math.round( d3_1*(1-d2_1)*(x7+x6))+Math.round( d3_1*(1-d4_1)*(x13+x12))+Math.round( d3_1*(1-d4_1)*(1-d2_1)*(x15+x14));
		vals[i++]=Math.round( d2_1*d3_1*(x6+x7))+Math.round( d2_1*d3_1*(1-d4_1)*(x14+x15));
		vals[i++]=Math.round( d4_1*(x8+x9))+Math.round( d4_1*(1-d2_1)*(x11+x10))+Math.round( d4_1*(1-d3_1)*(x13+x12))+Math.round( d4_1*(1-d3_1)*(1-d2_1)*(x15+x14));
		vals[i++]=Math.round( d2_1*d4_1*(x10+x11))+Math.round( d2_1*d4_1*(1-d3_1)*(x14+x15));
		vals[i++]=Math.round( d4_1*d3_1*(x12+x13))+Math.round( d4_1*d3_1*(1-d2_1)*(x14+x15));
		vals[i++]=Math.round( d2_1*d3_1*d4_1*(x14+x15));
	return vals;
	}
	public long[] calculatedValuesForDuplicateExperiments_2() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_2*(x1+x9))+Math.round( a1_2*(1-a2_2)*(x3+x11))+Math.round( a1_2*(1-a3_2)*(x5+x13))+Math.round( a1_2*(1-a2_2)*(1-a3_2)*(x7+x15));
		vals[i++]=Math.round( a2_2*(x2+x10))+Math.round( a2_2*(1-a1_2)*(x3+x11))+Math.round( a2_2*(1-a3_2)*(x6+x14))+Math.round( a2_2*(1-a3_2)*(1-a1_2)*(x7+x15));
		vals[i++]=Math.round( a1_2*a2_2*(x3+x11))+Math.round( a1_2*a2_2*(1-a3_2)*(x7+x15));
		vals[i++]=Math.round( a3_2*(x4+x12))+Math.round( a3_2*(1-a1_2)*(x5+x13))+Math.round( a3_2*(1-a2_2)*(x6+x14))+Math.round( a3_2*(1-a1_2)*(1-a2_2)*(x7+x15));
		vals[i++]=Math.round( a3_2*a1_2*(x5+x13))+Math.round( a3_2*a1_2*(1-a2_2)*(x7+x15));
		vals[i++]=Math.round( a3_2*a2_2*(x6+x14))+Math.round( a3_2*a2_2*(1-a1_2)*(x7+x15));
		vals[i++]=Math.round( a1_2*a2_2*a3_2*(x7+x15));
		vals[i++]=Math.round( b1_2*(x1+x5))+Math.round( b1_2*(1-b2_2)*(x3+x7))+Math.round( b1_2*(1-b4_2)*(x9+x13))+Math.round( b1_2*(1-b2_2)*(1-b4_2)*(x11+x15));
		vals[i++]=Math.round( b2_2*(x2+x6))+Math.round( b2_2*(1-b1_2)*(x3+x7))+Math.round( b2_2*(1-b4_2)*(x10+x14))+Math.round( b2_2*(1-b4_2)*(1-b1_2)*(x11+x15));
		vals[i++]=Math.round( b1_2*b2_2*(x3+x7))+Math.round( b1_2*b2_2*(1-b4_2)*(x11+x15));
		vals[i++]=Math.round( b4_2*(x12+x8))+Math.round( b4_2*(1-b1_2)*(x13+x9))+Math.round( b4_2*(1-b2_2)*(x10+x14))+Math.round( b4_2*(1-b1_2)*(1-b2_2)*(x11+x15));
		vals[i++]=Math.round( b4_2*b1_2*(x13+x9))+Math.round( b4_2*b1_2*(1-b2_2)*(x11+x15));
		vals[i++]=Math.round( b4_2*b2_2*(x14+x10))+Math.round( b4_2*b2_2*(1-b1_2)*(x11+x15));
		vals[i++]=Math.round( b1_2*b2_2*b4_2*(x11+x15));
		vals[i++]=Math.round(  c1_2*(x1+x3))+Math.round(  c1_2*(1- c3_2)*(x5+x7))+Math.round(  c1_2*(1- c4_2)*(x9+x11))+Math.round(  c1_2*(1- c3_2)*(1- c4_2)*(x13+x15));
		vals[i++]=Math.round(  c3_2*(x4+x6))+Math.round(  c3_2*(1- c1_2)*(x5+x7))+Math.round(  c3_2*(1- c4_2)*(x14+x12))+Math.round(  c3_2*(1- c4_2)*(1- c1_2)*(x13+x15));
		vals[i++]=Math.round(  c1_2* c3_2*(x5+x7))+Math.round(  c1_2* c3_2*(1- c4_2)*(x13+x15));
		vals[i++]=Math.round(  c4_2*(x8+x10))+Math.round(  c4_2*(1- c1_2)*(x9+x11))+Math.round(  c4_2*(1- c3_2)*(x14+x12))+Math.round(  c4_2*(1- c3_2)*(1- c1_2)*(x13+x15));
		vals[i++]=Math.round(  c1_2* c4_2*(x9+x11))+Math.round(  c1_2* c4_2*(1- c3_2)*(x13+x15));
		vals[i++]=Math.round(  c3_2* c4_2*(x12+x14))+Math.round(  c3_2* c4_2*(1- c1_2)*(x13+x15));
		vals[i++]=Math.round(  c1_2* c3_2* c4_2*(x13+x15));
		vals[i++]=Math.round( d2_2*(x3+x2))+Math.round( d2_2*(1-d3_2)*(x6+x7))+Math.round( d2_2*(1-d4_2)*(x10+x11))+Math.round( d2_2*(1-d3_2)*(1-d4_2)*(x14+x15));
		vals[i++]=Math.round( d3_2*(x4+x5))+Math.round( d3_2*(1-d2_2)*(x7+x6))+Math.round( d3_2*(1-d4_2)*(x13+x12))+Math.round( d3_2*(1-d4_2)*(1-d2_2)*(x15+x14));
		vals[i++]=Math.round( d2_2*d3_2*(x6+x7))+Math.round( d2_2*d3_2*(1-d4_2)*(x14+x15));
		vals[i++]=Math.round( d4_2*(x8+x9))+Math.round( d4_2*(1-d2_2)*(x11+x10))+Math.round( d4_2*(1-d3_2)*(x13+x12))+Math.round( d4_2*(1-d3_2)*(1-d2_2)*(x15+x14));
		vals[i++]=Math.round( d2_2*d4_2*(x10+x11))+Math.round( d2_2*d4_2*(1-d3_2)*(x14+x15));
		vals[i++]=Math.round( d4_2*d3_2*(x12+x13))+Math.round( d4_2*d3_2*(1-d2_2)*(x14+x15));
		vals[i++]=Math.round( d2_2*d3_2*d4_2*(x14+x15));
		return vals;
	}
	
	public long[] calculatedValuesForDuplicateExperiments_3() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_3*(x1+x9))+Math.round( a1_3*(1-a2_3)*(x3+x11))+Math.round( a1_3*(1-a3_3)*(x5+x13))+Math.round( a1_3*(1-a2_3)*(1-a3_3)*(x7+x15));
		vals[i++]=Math.round( a2_3*(x2+x10))+Math.round( a2_3*(1-a1_3)*(x3+x11))+Math.round( a2_3*(1-a3_3)*(x6+x14))+Math.round( a2_3*(1-a3_3)*(1-a1_3)*(x7+x15));
		vals[i++]=Math.round( a1_3*a2_3*(x3+x11))+Math.round( a1_3*a2_3*(1-a3_3)*(x7+x15));
		vals[i++]=Math.round( a3_3*(x4+x12))+Math.round( a3_3*(1-a1_3)*(x5+x13))+Math.round( a3_3*(1-a2_3)*(x6+x14))+Math.round( a3_3*(1-a1_3)*(1-a2_3)*(x7+x15));
		vals[i++]=Math.round( a3_3*a1_3*(x5+x13))+Math.round( a3_3*a1_3*(1-a2_3)*(x7+x15));
		vals[i++]=Math.round( a3_3*a2_3*(x6+x14))+Math.round( a3_3*a2_3*(1-a1_3)*(x7+x15));
		vals[i++]=Math.round( a1_3*a2_3*a3_3*(x7+x15));
		vals[i++]=Math.round( b1_3*(x1+x5))+Math.round( b1_3*(1-b2_3)*(x3+x7))+Math.round( b1_3*(1-b4_3)*(x9+x13))+Math.round( b1_3*(1-b2_3)*(1-b4_3)*(x11+x15));
		vals[i++]=Math.round( b2_3*(x2+x6))+Math.round( b2_3*(1-b1_3)*(x3+x7))+Math.round( b2_3*(1-b4_3)*(x10+x14))+Math.round( b2_3*(1-b4_3)*(1-b1_3)*(x11+x15));
		vals[i++]=Math.round( b1_3*b2_3*(x3+x7))+Math.round( b1_3*b2_3*(1-b4_3)*(x11+x15));
		vals[i++]=Math.round( b4_3*(x12+x8))+Math.round( b4_3*(1-b1_3)*(x13+x9))+Math.round( b4_3*(1-b2_3)*(x10+x14))+Math.round( b4_3*(1-b1_3)*(1-b2_3)*(x11+x15));
		vals[i++]=Math.round( b4_3*b1_3*(x13+x9))+Math.round( b4_3*b1_3*(1-b2_3)*(x11+x15));
		vals[i++]=Math.round( b4_3*b2_3*(x14+x10))+Math.round( b4_3*b2_3*(1-b1_3)*(x11+x15));
		vals[i++]=Math.round( b1_3*b2_3*b4_3*(x11+x15));
		vals[i++]=Math.round(  c1_3*(x1+x3))+Math.round(  c1_3*(1- c3_3)*(x5+x7))+Math.round(  c1_3*(1- c4_3)*(x9+x11))+Math.round(  c1_3*(1- c3_3)*(1- c4_3)*(x13+x15));
		vals[i++]=Math.round(  c3_3*(x4+x6))+Math.round(  c3_3*(1- c1_3)*(x5+x7))+Math.round(  c3_3*(1- c4_3)*(x14+x12))+Math.round(  c3_3*(1- c4_3)*(1- c1_3)*(x13+x15));
		vals[i++]=Math.round(  c1_3* c3_3*(x5+x7))+Math.round(  c1_3* c3_3*(1- c4_3)*(x13+x15));
		vals[i++]=Math.round(  c4_3*(x8+x10))+Math.round(  c4_3*(1- c1_3)*(x9+x11))+Math.round(  c4_3*(1- c3_3)*(x14+x12))+Math.round(  c4_3*(1- c3_3)*(1- c1_3)*(x13+x15));
		vals[i++]=Math.round(  c1_3* c4_3*(x9+x11))+Math.round(  c1_3* c4_3*(1- c3_3)*(x13+x15));
		vals[i++]=Math.round(  c3_3* c4_3*(x12+x14))+Math.round(  c3_3* c4_3*(1- c1_3)*(x13+x15));
		vals[i++]=Math.round(  c1_3* c3_3* c4_3*(x13+x15));
		vals[i++]=Math.round( d2_3*(x3+x2))+Math.round( d2_3*(1-d3_3)*(x6+x7))+Math.round( d2_3*(1-d4_3)*(x10+x11))+Math.round( d2_3*(1-d3_3)*(1-d4_3)*(x14+x15));
		vals[i++]=Math.round( d3_3*(x4+x5))+Math.round( d3_3*(1-d2_3)*(x7+x6))+Math.round( d3_3*(1-d4_3)*(x13+x12))+Math.round( d3_3*(1-d4_3)*(1-d2_3)*(x15+x14));
		vals[i++]=Math.round( d2_3*d3_3*(x6+x7))+Math.round( d2_3*d3_3*(1-d4_3)*(x14+x15));
		vals[i++]=Math.round( d4_3*(x8+x9))+Math.round( d4_3*(1-d2_3)*(x11+x10))+Math.round( d4_3*(1-d3_3)*(x13+x12))+Math.round( d4_3*(1-d3_3)*(1-d2_3)*(x15+x14));
		vals[i++]=Math.round( d2_3*d4_3*(x10+x11))+Math.round( d2_3*d4_3*(1-d3_3)*(x14+x15));
		vals[i++]=Math.round( d4_3*d3_3*(x12+x13))+Math.round( d4_3*d3_3*(1-d2_3)*(x14+x15));
		vals[i++]=Math.round( d2_3*d3_3*d4_3*(x14+x15));
		return vals;
	}
	public long[] calculatedValuesForDuplicateExperiments_4() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_4*(x1+x9))+Math.round( a1_4*(1-a2_4)*(x3+x11))+Math.round( a1_4*(1-a3_4)*(x5+x13))+Math.round( a1_4*(1-a2_4)*(1-a3_4)*(x7+x15));
		vals[i++]=Math.round( a2_4*(x2+x10))+Math.round( a2_4*(1-a1_4)*(x3+x11))+Math.round( a2_4*(1-a3_4)*(x6+x14))+Math.round( a2_4*(1-a3_4)*(1-a1_4)*(x7+x15));
		vals[i++]=Math.round( a1_4*a2_4*(x3+x11))+Math.round( a1_4*a2_4*(1-a3_4)*(x7+x15));
		vals[i++]=Math.round( a3_4*(x4+x12))+Math.round( a3_4*(1-a1_4)*(x5+x13))+Math.round( a3_4*(1-a2_4)*(x6+x14))+Math.round( a3_4*(1-a1_4)*(1-a2_4)*(x7+x15));
		vals[i++]=Math.round( a3_4*a1_4*(x5+x13))+Math.round( a3_4*a1_4*(1-a2_4)*(x7+x15));
		vals[i++]=Math.round( a3_4*a2_4*(x6+x14))+Math.round( a3_4*a2_4*(1-a1_4)*(x7+x15));
		vals[i++]=Math.round( a1_4*a2_4*a3_4*(x7+x15));
		vals[i++]=Math.round( b1_4*(x1+x5))+Math.round( b1_4*(1-b2_4)*(x3+x7))+Math.round( b1_4*(1-b4_4)*(x9+x13))+Math.round( b1_4*(1-b2_4)*(1-b4_4)*(x11+x15));
		vals[i++]=Math.round( b2_4*(x2+x6))+Math.round( b2_4*(1-b1_4)*(x3+x7))+Math.round( b2_4*(1-b4_4)*(x10+x14))+Math.round( b2_4*(1-b4_4)*(1-b1_4)*(x11+x15));
		vals[i++]=Math.round( b1_4*b2_4*(x3+x7))+Math.round( b1_4*b2_4*(1-b4_4)*(x11+x15));
		vals[i++]=Math.round( b4_4*(x12+x8))+Math.round( b4_4*(1-b1_4)*(x13+x9))+Math.round( b4_4*(1-b2_4)*(x10+x14))+Math.round( b4_4*(1-b1_4)*(1-b2_4)*(x11+x15));
		vals[i++]=Math.round( b4_4*b1_4*(x13+x9))+Math.round( b4_4*b1_4*(1-b2_4)*(x11+x15));
		vals[i++]=Math.round( b4_4*b2_4*(x14+x10))+Math.round( b4_4*b2_4*(1-b1_4)*(x11+x15));
		vals[i++]=Math.round( b1_4*b2_4*b4_4*(x11+x15));
		vals[i++]=Math.round(  c1_4*(x1+x3))+Math.round(  c1_4*(1- c3_4)*(x5+x7))+Math.round(  c1_4*(1- c4_4)*(x9+x11))+Math.round(  c1_4*(1- c3_4)*(1- c4_4)*(x13+x15));
		vals[i++]=Math.round(  c3_4*(x4+x6))+Math.round(  c3_4*(1- c1_4)*(x5+x7))+Math.round(  c3_4*(1- c4_4)*(x14+x12))+Math.round(  c3_4*(1- c4_4)*(1- c1_4)*(x13+x15));
		vals[i++]=Math.round(  c1_4* c3_4*(x5+x7))+Math.round(  c1_4* c3_4*(1- c4_4)*(x13+x15));
		vals[i++]=Math.round(  c4_4*(x8+x10))+Math.round(  c4_4*(1- c1_4)*(x9+x11))+Math.round(  c4_4*(1- c3_4)*(x14+x12))+Math.round(  c4_4*(1- c3_4)*(1- c1_4)*(x13+x15));
		vals[i++]=Math.round(  c1_4* c4_4*(x9+x11))+Math.round(  c1_4* c4_4*(1- c3_4)*(x13+x15));
		vals[i++]=Math.round(  c3_4* c4_4*(x12+x14))+Math.round(  c3_4* c4_4*(1- c1_4)*(x13+x15));
		vals[i++]=Math.round(  c1_4* c3_4* c4_4*(x13+x15));
		vals[i++]=Math.round( d2_4*(x3+x2))+Math.round( d2_4*(1-d3_4)*(x6+x7))+Math.round( d2_4*(1-d4_4)*(x10+x11))+Math.round( d2_4*(1-d3_4)*(1-d4_4)*(x14+x15));
		vals[i++]=Math.round( d3_4*(x4+x5))+Math.round( d3_4*(1-d2_4)*(x7+x6))+Math.round( d3_4*(1-d4_4)*(x13+x12))+Math.round( d3_4*(1-d4_4)*(1-d2_4)*(x15+x14));
		vals[i++]=Math.round( d2_4*d3_4*(x6+x7))+Math.round( d2_4*d3_4*(1-d4_4)*(x14+x15));
		vals[i++]=Math.round( d4_4*(x8+x9))+Math.round( d4_4*(1-d2_4)*(x11+x10))+Math.round( d4_4*(1-d3_4)*(x13+x12))+Math.round( d4_4*(1-d3_4)*(1-d2_4)*(x15+x14));
		vals[i++]=Math.round( d2_4*d4_4*(x10+x11))+Math.round( d2_4*d4_4*(1-d3_4)*(x14+x15));
		vals[i++]=Math.round( d4_4*d3_4*(x12+x13))+Math.round( d4_4*d3_4*(1-d2_4)*(x14+x15));
		vals[i++]=Math.round( d2_4*d3_4*d4_4*(x14+x15));
		return vals;
	}
	public long[] calculatedValuesForDuplicateExperiments_5() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_5*(x1+x9))+Math.round( a1_5*(1-a2_5)*(x3+x11))+Math.round( a1_5*(1-a3_5)*(x5+x13))+Math.round( a1_5*(1-a2_5)*(1-a3_5)*(x7+x15));
		vals[i++]=Math.round( a2_5*(x2+x10))+Math.round( a2_5*(1-a1_5)*(x3+x11))+Math.round( a2_5*(1-a3_5)*(x6+x14))+Math.round( a2_5*(1-a3_5)*(1-a1_5)*(x7+x15));
		vals[i++]=Math.round( a1_5*a2_5*(x3+x11))+Math.round( a1_5*a2_5*(1-a3_5)*(x7+x15));
		vals[i++]=Math.round( a3_5*(x4+x12))+Math.round( a3_5*(1-a1_5)*(x5+x13))+Math.round( a3_5*(1-a2_5)*(x6+x14))+Math.round( a3_5*(1-a1_5)*(1-a2_5)*(x7+x15));
		vals[i++]=Math.round( a3_5*a1_5*(x5+x13))+Math.round( a3_5*a1_5*(1-a2_5)*(x7+x15));
		vals[i++]=Math.round( a3_5*a2_5*(x6+x14))+Math.round( a3_5*a2_5*(1-a1_5)*(x7+x15));
		vals[i++]=Math.round( a1_5*a2_5*a3_5*(x7+x15));
		vals[i++]=Math.round( b1_5*(x1+x5))+Math.round( b1_5*(1-b2_5)*(x3+x7))+Math.round( b1_5*(1-b4_5)*(x9+x13))+Math.round( b1_5*(1-b2_5)*(1-b4_5)*(x11+x15));
		vals[i++]=Math.round( b2_5*(x2+x6))+Math.round( b2_5*(1-b1_5)*(x3+x7))+Math.round( b2_5*(1-b4_5)*(x10+x14))+Math.round( b2_5*(1-b4_5)*(1-b1_5)*(x11+x15));
		vals[i++]=Math.round( b1_5*b2_5*(x3+x7))+Math.round( b1_5*b2_5*(1-b4_5)*(x11+x15));
		vals[i++]=Math.round( b4_5*(x12+x8))+Math.round( b4_5*(1-b1_5)*(x13+x9))+Math.round( b4_5*(1-b2_5)*(x10+x14))+Math.round( b4_5*(1-b1_5)*(1-b2_5)*(x11+x15));
		vals[i++]=Math.round( b4_5*b1_5*(x13+x9))+Math.round( b4_5*b1_5*(1-b2_5)*(x11+x15));
		vals[i++]=Math.round( b4_5*b2_5*(x14+x10))+Math.round( b4_5*b2_5*(1-b1_5)*(x11+x15));
		vals[i++]=Math.round( b1_5*b2_5*b4_5*(x11+x15));
		vals[i++]=Math.round(  c1_5*(x1+x3))+Math.round(  c1_5*(1- c3_5)*(x5+x7))+Math.round(  c1_5*(1- c4_5)*(x9+x11))+Math.round(  c1_5*(1- c3_5)*(1- c4_5)*(x13+x15));
		vals[i++]=Math.round(  c3_5*(x4+x6))+Math.round(  c3_5*(1- c1_5)*(x5+x7))+Math.round(  c3_5*(1- c4_5)*(x14+x12))+Math.round(  c3_5*(1- c4_5)*(1- c1_5)*(x13+x15));
		vals[i++]=Math.round(  c1_5* c3_5*(x5+x7))+Math.round(  c1_5* c3_5*(1- c4_5)*(x13+x15));
		vals[i++]=Math.round(  c4_5*(x8+x10))+Math.round(  c4_5*(1- c1_5)*(x9+x11))+Math.round(  c4_5*(1- c3_5)*(x14+x12))+Math.round(  c4_5*(1- c3_5)*(1- c1_5)*(x13+x15));
		vals[i++]=Math.round(  c1_5* c4_5*(x9+x11))+Math.round(  c1_5* c4_5*(1- c3_5)*(x13+x15));
		vals[i++]=Math.round(  c3_5* c4_5*(x12+x14))+Math.round(  c3_5* c4_5*(1- c1_5)*(x13+x15));
		vals[i++]=Math.round(  c1_5* c3_5* c4_5*(x13+x15));
		vals[i++]=Math.round( d2_5*(x3+x2))+Math.round( d2_5*(1-d3_5)*(x6+x7))+Math.round( d2_5*(1-d4_5)*(x10+x11))+Math.round( d2_5*(1-d3_5)*(1-d4_5)*(x14+x15));
		vals[i++]=Math.round( d3_5*(x4+x5))+Math.round( d3_5*(1-d2_5)*(x7+x6))+Math.round( d3_5*(1-d4_5)*(x13+x12))+Math.round( d3_5*(1-d4_5)*(1-d2_5)*(x15+x14));
		vals[i++]=Math.round( d2_5*d3_5*(x6+x7))+Math.round( d2_5*d3_5*(1-d4_5)*(x14+x15));
		vals[i++]=Math.round( d4_5*(x8+x9))+Math.round( d4_5*(1-d2_5)*(x11+x10))+Math.round( d4_5*(1-d3_5)*(x13+x12))+Math.round( d4_5*(1-d3_5)*(1-d2_5)*(x15+x14));
		vals[i++]=Math.round( d2_5*d4_5*(x10+x11))+Math.round( d2_5*d4_5*(1-d3_5)*(x14+x15));
		vals[i++]=Math.round( d4_5*d3_5*(x12+x13))+Math.round( d4_5*d3_5*(1-d2_5)*(x14+x15));
		vals[i++]=Math.round( d2_5*d3_5*d4_5*(x14+x15));
		return vals;
	}
	
	public long[] calculatedValuesForDuplicateExperiments_6() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_6*(x1+x9))+Math.round( a1_6*(1-a2_6)*(x3+x11))+Math.round( a1_6*(1-a3_6)*(x5+x13))+Math.round( a1_6*(1-a2_6)*(1-a3_6)*(x7+x15));
		vals[i++]=Math.round( a2_6*(x2+x10))+Math.round( a2_6*(1-a1_6)*(x3+x11))+Math.round( a2_6*(1-a3_6)*(x6+x14))+Math.round( a2_6*(1-a3_6)*(1-a1_6)*(x7+x15));
		vals[i++]=Math.round( a1_6*a2_6*(x3+x11))+Math.round( a1_6*a2_6*(1-a3_6)*(x7+x15));
		vals[i++]=Math.round( a3_6*(x4+x12))+Math.round( a3_6*(1-a1_6)*(x5+x13))+Math.round( a3_6*(1-a2_6)*(x6+x14))+Math.round( a3_6*(1-a1_6)*(1-a2_6)*(x7+x15));
		vals[i++]=Math.round( a3_6*a1_6*(x5+x13))+Math.round( a3_6*a1_6*(1-a2_6)*(x7+x15));
		vals[i++]=Math.round( a3_6*a2_6*(x6+x14))+Math.round( a3_6*a2_6*(1-a1_6)*(x7+x15));
		vals[i++]=Math.round( a1_6*a2_6*a3_6*(x7+x15));
		vals[i++]=Math.round( b1_6*(x1+x5))+Math.round( b1_6*(1-b2_6)*(x3+x7))+Math.round( b1_6*(1-b4_6)*(x9+x13))+Math.round( b1_6*(1-b2_6)*(1-b4_6)*(x11+x15));
		vals[i++]=Math.round( b2_6*(x2+x6))+Math.round( b2_6*(1-b1_6)*(x3+x7))+Math.round( b2_6*(1-b4_6)*(x10+x14))+Math.round( b2_6*(1-b4_6)*(1-b1_6)*(x11+x15));
		vals[i++]=Math.round( b1_6*b2_6*(x3+x7))+Math.round( b1_6*b2_6*(1-b4_6)*(x11+x15));
		vals[i++]=Math.round( b4_6*(x12+x8))+Math.round( b4_6*(1-b1_6)*(x13+x9))+Math.round( b4_6*(1-b2_6)*(x10+x14))+Math.round( b4_6*(1-b1_6)*(1-b2_6)*(x11+x15));
		vals[i++]=Math.round( b4_6*b1_6*(x13+x9))+Math.round( b4_6*b1_6*(1-b2_6)*(x11+x15));
		vals[i++]=Math.round( b4_6*b2_6*(x14+x10))+Math.round( b4_6*b2_6*(1-b1_6)*(x11+x15));
		vals[i++]=Math.round( b1_6*b2_6*b4_6*(x11+x15));
		vals[i++]=Math.round(  c1_6*(x1+x3))+Math.round(  c1_6*(1- c3_6)*(x5+x7))+Math.round(  c1_6*(1- c4_6)*(x9+x11))+Math.round(  c1_6*(1- c3_6)*(1- c4_6)*(x13+x15));
		vals[i++]=Math.round(  c3_6*(x4+x6))+Math.round(  c3_6*(1- c1_6)*(x5+x7))+Math.round(  c3_6*(1- c4_6)*(x14+x12))+Math.round(  c3_6*(1- c4_6)*(1- c1_6)*(x13+x15));
		vals[i++]=Math.round(  c1_6* c3_6*(x5+x7))+Math.round(  c1_6* c3_6*(1- c4_6)*(x13+x15));
		vals[i++]=Math.round(  c4_6*(x8+x10))+Math.round(  c4_6*(1- c1_6)*(x9+x11))+Math.round(  c4_6*(1- c3_6)*(x14+x12))+Math.round(  c4_6*(1- c3_6)*(1- c1_6)*(x13+x15));
		vals[i++]=Math.round(  c1_6* c4_6*(x9+x11))+Math.round(  c1_6* c4_6*(1- c3_6)*(x13+x15));
		vals[i++]=Math.round(  c3_6* c4_6*(x12+x14))+Math.round(  c3_6* c4_6*(1- c1_6)*(x13+x15));
		vals[i++]=Math.round(  c1_6* c3_6* c4_6*(x13+x15));
		vals[i++]=Math.round( d2_6*(x3+x2))+Math.round( d2_6*(1-d3_6)*(x6+x7))+Math.round( d2_6*(1-d4_6)*(x10+x11))+Math.round( d2_6*(1-d3_6)*(1-d4_6)*(x14+x15));
		vals[i++]=Math.round( d3_6*(x4+x5))+Math.round( d3_6*(1-d2_6)*(x7+x6))+Math.round( d3_6*(1-d4_6)*(x13+x12))+Math.round( d3_6*(1-d4_6)*(1-d2_6)*(x15+x14));
		vals[i++]=Math.round( d2_6*d3_6*(x6+x7))+Math.round( d2_6*d3_6*(1-d4_6)*(x14+x15));
		vals[i++]=Math.round( d4_6*(x8+x9))+Math.round( d4_6*(1-d2_6)*(x11+x10))+Math.round( d4_6*(1-d3_6)*(x13+x12))+Math.round( d4_6*(1-d3_6)*(1-d2_6)*(x15+x14));
		vals[i++]=Math.round( d2_6*d4_6*(x10+x11))+Math.round( d2_6*d4_6*(1-d3_6)*(x14+x15));
		vals[i++]=Math.round( d4_6*d3_6*(x12+x13))+Math.round( d4_6*d3_6*(1-d2_6)*(x14+x15));
		vals[i++]=Math.round( d2_6*d3_6*d4_6*(x14+x15));
		return vals;
	}
	
	public long[] calculatedValuesForDuplicateExperiments_7() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_7*(x1+x9))+Math.round( a1_7*(1-a2_7)*(x3+x11))+Math.round( a1_7*(1-a3_7)*(x5+x13))+Math.round( a1_7*(1-a2_7)*(1-a3_7)*(x7+x15));
		vals[i++]=Math.round( a2_7*(x2+x10))+Math.round( a2_7*(1-a1_7)*(x3+x11))+Math.round( a2_7*(1-a3_7)*(x6+x14))+Math.round( a2_7*(1-a3_7)*(1-a1_7)*(x7+x15));
		vals[i++]=Math.round( a1_7*a2_7*(x3+x11))+Math.round( a1_7*a2_7*(1-a3_7)*(x7+x15));
		vals[i++]=Math.round( a3_7*(x4+x12))+Math.round( a3_7*(1-a1_7)*(x5+x13))+Math.round( a3_7*(1-a2_7)*(x6+x14))+Math.round( a3_7*(1-a1_7)*(1-a2_7)*(x7+x15));
		vals[i++]=Math.round( a3_7*a1_7*(x5+x13))+Math.round( a3_7*a1_7*(1-a2_7)*(x7+x15));
		vals[i++]=Math.round( a3_7*a2_7*(x6+x14))+Math.round( a3_7*a2_7*(1-a1_7)*(x7+x15));
		vals[i++]=Math.round( a1_7*a2_7*a3_7*(x7+x15));
		vals[i++]=Math.round( b1_7*(x1+x5))+Math.round( b1_7*(1-b2_7)*(x3+x7))+Math.round( b1_7*(1-b4_7)*(x9+x13))+Math.round( b1_7*(1-b2_7)*(1-b4_7)*(x11+x15));
		vals[i++]=Math.round( b2_7*(x2+x6))+Math.round( b2_7*(1-b1_7)*(x3+x7))+Math.round( b2_7*(1-b4_7)*(x10+x14))+Math.round( b2_7*(1-b4_7)*(1-b1_7)*(x11+x15));
		vals[i++]=Math.round( b1_7*b2_7*(x3+x7))+Math.round( b1_7*b2_7*(1-b4_7)*(x11+x15));
		vals[i++]=Math.round( b4_7*(x12+x8))+Math.round( b4_7*(1-b1_7)*(x13+x9))+Math.round( b4_7*(1-b2_7)*(x10+x14))+Math.round( b4_7*(1-b1_7)*(1-b2_7)*(x11+x15));
		vals[i++]=Math.round( b4_7*b1_7*(x13+x9))+Math.round( b4_7*b1_7*(1-b2_7)*(x11+x15));
		vals[i++]=Math.round( b4_7*b2_7*(x14+x10))+Math.round( b4_7*b2_7*(1-b1_7)*(x11+x15));
		vals[i++]=Math.round( b1_7*b2_7*b4_7*(x11+x15));
		vals[i++]=Math.round(  c1_7*(x1+x3))+Math.round(  c1_7*(1- c3_7)*(x5+x7))+Math.round(  c1_7*(1- c4_7)*(x9+x11))+Math.round(  c1_7*(1- c3_7)*(1- c4_7)*(x13+x15));
		vals[i++]=Math.round(  c3_7*(x4+x6))+Math.round(  c3_7*(1- c1_7)*(x5+x7))+Math.round(  c3_7*(1- c4_7)*(x14+x12))+Math.round(  c3_7*(1- c4_7)*(1- c1_7)*(x13+x15));
		vals[i++]=Math.round(  c1_7* c3_7*(x5+x7))+Math.round(  c1_7* c3_7*(1- c4_7)*(x13+x15));
		vals[i++]=Math.round(  c4_7*(x8+x10))+Math.round(  c4_7*(1- c1_7)*(x9+x11))+Math.round(  c4_7*(1- c3_7)*(x14+x12))+Math.round(  c4_7*(1- c3_7)*(1- c1_7)*(x13+x15));
		vals[i++]=Math.round(  c1_7* c4_7*(x9+x11))+Math.round(  c1_7* c4_7*(1- c3_7)*(x13+x15));
		vals[i++]=Math.round(  c3_7* c4_7*(x12+x14))+Math.round(  c3_7* c4_7*(1- c1_7)*(x13+x15));
		vals[i++]=Math.round(  c1_7* c3_7* c4_7*(x13+x15));
		vals[i++]=Math.round( d2_7*(x3+x2))+Math.round( d2_7*(1-d3_7)*(x6+x7))+Math.round( d2_7*(1-d4_7)*(x10+x11))+Math.round( d2_7*(1-d3_7)*(1-d4_7)*(x14+x15));
		vals[i++]=Math.round( d3_7*(x4+x5))+Math.round( d3_7*(1-d2_7)*(x7+x6))+Math.round( d3_7*(1-d4_7)*(x13+x12))+Math.round( d3_7*(1-d4_7)*(1-d2_7)*(x15+x14));
		vals[i++]=Math.round( d2_7*d3_7*(x6+x7))+Math.round( d2_7*d3_7*(1-d4_7)*(x14+x15));
		vals[i++]=Math.round( d4_7*(x8+x9))+Math.round( d4_7*(1-d2_7)*(x11+x10))+Math.round( d4_7*(1-d3_7)*(x13+x12))+Math.round( d4_7*(1-d3_7)*(1-d2_7)*(x15+x14));
		vals[i++]=Math.round( d2_7*d4_7*(x10+x11))+Math.round( d2_7*d4_7*(1-d3_7)*(x14+x15));
		vals[i++]=Math.round( d4_7*d3_7*(x12+x13))+Math.round( d4_7*d3_7*(1-d2_7)*(x14+x15));
		vals[i++]=Math.round( d2_7*d3_7*d4_7*(x14+x15));
		return vals;
	}
	
	public long[] calculatedValuesForDuplicateExperiments_8() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_8*(x1+x9))+Math.round( a1_8*(1-a2_8)*(x3+x11))+Math.round( a1_8*(1-a3_8)*(x5+x13))+Math.round( a1_8*(1-a2_8)*(1-a3_8)*(x7+x15));
		vals[i++]=Math.round( a2_8*(x2+x10))+Math.round( a2_8*(1-a1_8)*(x3+x11))+Math.round( a2_8*(1-a3_8)*(x6+x14))+Math.round( a2_8*(1-a3_8)*(1-a1_8)*(x7+x15));
		vals[i++]=Math.round( a1_8*a2_8*(x3+x11))+Math.round( a1_8*a2_8*(1-a3_8)*(x7+x15));
		vals[i++]=Math.round( a3_8*(x4+x12))+Math.round( a3_8*(1-a1_8)*(x5+x13))+Math.round( a3_8*(1-a2_8)*(x6+x14))+Math.round( a3_8*(1-a1_8)*(1-a2_8)*(x7+x15));
		vals[i++]=Math.round( a3_8*a1_8*(x5+x13))+Math.round( a3_8*a1_8*(1-a2_8)*(x7+x15));
		vals[i++]=Math.round( a3_8*a2_8*(x6+x14))+Math.round( a3_8*a2_8*(1-a1_8)*(x7+x15));
		vals[i++]=Math.round( a1_8*a2_8*a3_8*(x7+x15));
		vals[i++]=Math.round( b1_8*(x1+x5))+Math.round( b1_8*(1-b2_8)*(x3+x7))+Math.round( b1_8*(1-b4_8)*(x9+x13))+Math.round( b1_8*(1-b2_8)*(1-b4_8)*(x11+x15));
		vals[i++]=Math.round( b2_8*(x2+x6))+Math.round( b2_8*(1-b1_8)*(x3+x7))+Math.round( b2_8*(1-b4_8)*(x10+x14))+Math.round( b2_8*(1-b4_8)*(1-b1_8)*(x11+x15));
		vals[i++]=Math.round( b1_8*b2_8*(x3+x7))+Math.round( b1_8*b2_8*(1-b4_8)*(x11+x15));
		vals[i++]=Math.round( b4_8*(x12+x8))+Math.round( b4_8*(1-b1_8)*(x13+x9))+Math.round( b4_8*(1-b2_8)*(x10+x14))+Math.round( b4_8*(1-b1_8)*(1-b2_8)*(x11+x15));
		vals[i++]=Math.round( b4_8*b1_8*(x13+x9))+Math.round( b4_8*b1_8*(1-b2_8)*(x11+x15));
		vals[i++]=Math.round( b4_8*b2_8*(x14+x10))+Math.round( b4_8*b2_8*(1-b1_8)*(x11+x15));
		vals[i++]=Math.round( b1_8*b2_8*b4_8*(x11+x15));
		vals[i++]=Math.round(  c1_8*(x1+x3))+Math.round(  c1_8*(1- c3_8)*(x5+x7))+Math.round(  c1_8*(1- c4_8)*(x9+x11))+Math.round(  c1_8*(1- c3_8)*(1- c4_8)*(x13+x15));
		vals[i++]=Math.round(  c3_8*(x4+x6))+Math.round(  c3_8*(1- c1_8)*(x5+x7))+Math.round(  c3_8*(1- c4_8)*(x14+x12))+Math.round(  c3_8*(1- c4_8)*(1- c1_8)*(x13+x15));
		vals[i++]=Math.round(  c1_8* c3_8*(x5+x7))+Math.round(  c1_8* c3_8*(1- c4_8)*(x13+x15));
		vals[i++]=Math.round(  c4_8*(x8+x10))+Math.round(  c4_8*(1- c1_8)*(x9+x11))+Math.round(  c4_8*(1- c3_8)*(x14+x12))+Math.round(  c4_8*(1- c3_8)*(1- c1_8)*(x13+x15));
		vals[i++]=Math.round(  c1_8* c4_8*(x9+x11))+Math.round(  c1_8* c4_8*(1- c3_8)*(x13+x15));
		vals[i++]=Math.round(  c3_8* c4_8*(x12+x14))+Math.round(  c3_8* c4_8*(1- c1_8)*(x13+x15));
		vals[i++]=Math.round(  c1_8* c3_8* c4_8*(x13+x15));
		vals[i++]=Math.round( d2_8*(x3+x2))+Math.round( d2_8*(1-d3_8)*(x6+x7))+Math.round( d2_8*(1-d4_8)*(x10+x11))+Math.round( d2_8*(1-d3_8)*(1-d4_8)*(x14+x15));
		vals[i++]=Math.round( d3_8*(x4+x5))+Math.round( d3_8*(1-d2_8)*(x7+x6))+Math.round( d3_8*(1-d4_8)*(x13+x12))+Math.round( d3_8*(1-d4_8)*(1-d2_8)*(x15+x14));
		vals[i++]=Math.round( d2_8*d3_8*(x6+x7))+Math.round( d2_8*d3_8*(1-d4_8)*(x14+x15));
		vals[i++]=Math.round( d4_8*(x8+x9))+Math.round( d4_8*(1-d2_8)*(x11+x10))+Math.round( d4_8*(1-d3_8)*(x13+x12))+Math.round( d4_8*(1-d3_8)*(1-d2_8)*(x15+x14));
		vals[i++]=Math.round( d2_8*d4_8*(x10+x11))+Math.round( d2_8*d4_8*(1-d3_8)*(x14+x15));
		vals[i++]=Math.round( d4_8*d3_8*(x12+x13))+Math.round( d4_8*d3_8*(1-d2_8)*(x14+x15));
		vals[i++]=Math.round( d2_8*d3_8*d4_8*(x14+x15));
		return vals;
	}
	
	public long[] calculatedValuesForDuplicateExperiments_9() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_9*(x1+x9))+Math.round( a1_9*(1-a2_9)*(x3+x11))+Math.round( a1_9*(1-a3_9)*(x5+x13))+Math.round( a1_9*(1-a2_9)*(1-a3_9)*(x7+x15));
		vals[i++]=Math.round( a2_9*(x2+x10))+Math.round( a2_9*(1-a1_9)*(x3+x11))+Math.round( a2_9*(1-a3_9)*(x6+x14))+Math.round( a2_9*(1-a3_9)*(1-a1_9)*(x7+x15));
		vals[i++]=Math.round( a1_9*a2_9*(x3+x11))+Math.round( a1_9*a2_9*(1-a3_9)*(x7+x15));
		vals[i++]=Math.round( a3_9*(x4+x12))+Math.round( a3_9*(1-a1_9)*(x5+x13))+Math.round( a3_9*(1-a2_9)*(x6+x14))+Math.round( a3_9*(1-a1_9)*(1-a2_9)*(x7+x15));
		vals[i++]=Math.round( a3_9*a1_9*(x5+x13))+Math.round( a3_9*a1_9*(1-a2_9)*(x7+x15));
		vals[i++]=Math.round( a3_9*a2_9*(x6+x14))+Math.round( a3_9*a2_9*(1-a1_9)*(x7+x15));
		vals[i++]=Math.round( a1_9*a2_9*a3_9*(x7+x15));
		vals[i++]=Math.round( b1_9*(x1+x5))+Math.round( b1_9*(1-b2_9)*(x3+x7))+Math.round( b1_9*(1-b4_9)*(x9+x13))+Math.round( b1_9*(1-b2_9)*(1-b4_9)*(x11+x15));
		vals[i++]=Math.round( b2_9*(x2+x6))+Math.round( b2_9*(1-b1_9)*(x3+x7))+Math.round( b2_9*(1-b4_9)*(x10+x14))+Math.round( b2_9*(1-b4_9)*(1-b1_9)*(x11+x15));
		vals[i++]=Math.round( b1_9*b2_9*(x3+x7))+Math.round( b1_9*b2_9*(1-b4_9)*(x11+x15));
		vals[i++]=Math.round( b4_9*(x12+x8))+Math.round( b4_9*(1-b1_9)*(x13+x9))+Math.round( b4_9*(1-b2_9)*(x10+x14))+Math.round( b4_9*(1-b1_9)*(1-b2_9)*(x11+x15));
		vals[i++]=Math.round( b4_9*b1_9*(x13+x9))+Math.round( b4_9*b1_9*(1-b2_9)*(x11+x15));
		vals[i++]=Math.round( b4_9*b2_9*(x14+x10))+Math.round( b4_9*b2_9*(1-b1_9)*(x11+x15));
		vals[i++]=Math.round( b1_9*b2_9*b4_9*(x11+x15));
		vals[i++]=Math.round(  c1_9*(x1+x3))+Math.round(  c1_9*(1- c3_9)*(x5+x7))+Math.round(  c1_9*(1- c4_9)*(x9+x11))+Math.round(  c1_9*(1- c3_9)*(1- c4_9)*(x13+x15));
		vals[i++]=Math.round(  c3_9*(x4+x6))+Math.round(  c3_9*(1- c1_9)*(x5+x7))+Math.round(  c3_9*(1- c4_9)*(x14+x12))+Math.round(  c3_9*(1- c4_9)*(1- c1_9)*(x13+x15));
		vals[i++]=Math.round(  c1_9* c3_9*(x5+x7))+Math.round(  c1_9* c3_9*(1- c4_9)*(x13+x15));
		vals[i++]=Math.round(  c4_9*(x8+x10))+Math.round(  c4_9*(1- c1_9)*(x9+x11))+Math.round(  c4_9*(1- c3_9)*(x14+x12))+Math.round(  c4_9*(1- c3_9)*(1- c1_9)*(x13+x15));
		vals[i++]=Math.round(  c1_9* c4_9*(x9+x11))+Math.round(  c1_9* c4_9*(1- c3_9)*(x13+x15));
		vals[i++]=Math.round(  c3_9* c4_9*(x12+x14))+Math.round(  c3_9* c4_9*(1- c1_9)*(x13+x15));
		vals[i++]=Math.round(  c1_9* c3_9* c4_9*(x13+x15));
		vals[i++]=Math.round( d2_9*(x3+x2))+Math.round( d2_9*(1-d3_9)*(x6+x7))+Math.round( d2_9*(1-d4_9)*(x10+x11))+Math.round( d2_9*(1-d3_9)*(1-d4_9)*(x14+x15));
		vals[i++]=Math.round( d3_9*(x4+x5))+Math.round( d3_9*(1-d2_9)*(x7+x6))+Math.round( d3_9*(1-d4_9)*(x13+x12))+Math.round( d3_9*(1-d4_9)*(1-d2_9)*(x15+x14));
		vals[i++]=Math.round( d2_9*d3_9*(x6+x7))+Math.round( d2_9*d3_9*(1-d4_9)*(x14+x15));
		vals[i++]=Math.round( d4_9*(x8+x9))+Math.round( d4_9*(1-d2_9)*(x11+x10))+Math.round( d4_9*(1-d3_9)*(x13+x12))+Math.round( d4_9*(1-d3_9)*(1-d2_9)*(x15+x14));
		vals[i++]=Math.round( d2_9*d4_9*(x10+x11))+Math.round( d2_9*d4_9*(1-d3_9)*(x14+x15));
		vals[i++]=Math.round( d4_9*d3_9*(x12+x13))+Math.round( d4_9*d3_9*(1-d2_9)*(x14+x15));
		vals[i++]=Math.round( d2_9*d3_9*d4_9*(x14+x15));
		return vals;
	}
	public long[] calculatedValuesForDuplicateExperiments_10() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_10*(x1+x9))+Math.round( a1_10*(1-a2_10)*(x3+x11))+Math.round( a1_10*(1-a3_10)*(x5+x13))+Math.round( a1_10*(1-a2_10)*(1-a3_10)*(x7+x15));
		vals[i++]=Math.round( a2_10*(x2+x10))+Math.round( a2_10*(1-a1_10)*(x3+x11))+Math.round( a2_10*(1-a3_10)*(x6+x14))+Math.round( a2_10*(1-a3_10)*(1-a1_10)*(x7+x15));
		vals[i++]=Math.round( a1_10*a2_10*(x3+x11))+Math.round( a1_10*a2_10*(1-a3_10)*(x7+x15));
		vals[i++]=Math.round( a3_10*(x4+x12))+Math.round( a3_10*(1-a1_10)*(x5+x13))+Math.round( a3_10*(1-a2_10)*(x6+x14))+Math.round( a3_10*(1-a1_10)*(1-a2_10)*(x7+x15));
		vals[i++]=Math.round( a3_10*a1_10*(x5+x13))+Math.round( a3_10*a1_10*(1-a2_10)*(x7+x15));
		vals[i++]=Math.round( a3_10*a2_10*(x6+x14))+Math.round( a3_10*a2_10*(1-a1_10)*(x7+x15));
		vals[i++]=Math.round( a1_10*a2_10*a3_10*(x7+x15));
		vals[i++]=Math.round( b1_10*(x1+x5))+Math.round( b1_10*(1-b2_10)*(x3+x7))+Math.round( b1_10*(1-b4_10)*(x9+x13))+Math.round( b1_10*(1-b2_10)*(1-b4_10)*(x11+x15));
		vals[i++]=Math.round( b2_10*(x2+x6))+Math.round( b2_10*(1-b1_10)*(x3+x7))+Math.round( b2_10*(1-b4_10)*(x10+x14))+Math.round( b2_10*(1-b4_10)*(1-b1_10)*(x11+x15));
		vals[i++]=Math.round( b1_10*b2_10*(x3+x7))+Math.round( b1_10*b2_10*(1-b4_10)*(x11+x15));
		vals[i++]=Math.round( b4_10*(x12+x8))+Math.round( b4_10*(1-b1_10)*(x13+x9))+Math.round( b4_10*(1-b2_10)*(x10+x14))+Math.round( b4_10*(1-b1_10)*(1-b2_10)*(x11+x15));
		vals[i++]=Math.round( b4_10*b1_10*(x13+x9))+Math.round( b4_10*b1_10*(1-b2_10)*(x11+x15));
		vals[i++]=Math.round( b4_10*b2_10*(x14+x10))+Math.round( b4_10*b2_10*(1-b1_10)*(x11+x15));
		vals[i++]=Math.round( b1_10*b2_10*b4_10*(x11+x15));
		vals[i++]=Math.round(  c1_10*(x1+x3))+Math.round(  c1_10*(1- c3_10)*(x5+x7))+Math.round(  c1_10*(1- c4_10)*(x9+x11))+Math.round(  c1_10*(1- c3_10)*(1- c4_10)*(x13+x15));
		vals[i++]=Math.round(  c3_10*(x4+x6))+Math.round(  c3_10*(1- c1_10)*(x5+x7))+Math.round(  c3_10*(1- c4_10)*(x14+x12))+Math.round(  c3_10*(1- c4_10)*(1- c1_10)*(x13+x15));
		vals[i++]=Math.round(  c1_10* c3_10*(x5+x7))+Math.round(  c1_10* c3_10*(1- c4_10)*(x13+x15));
		vals[i++]=Math.round(  c4_10*(x8+x10))+Math.round(  c4_10*(1- c1_10)*(x9+x11))+Math.round(  c4_10*(1- c3_10)*(x14+x12))+Math.round(  c4_10*(1- c3_10)*(1- c1_10)*(x13+x15));
		vals[i++]=Math.round(  c1_10* c4_10*(x9+x11))+Math.round(  c1_10* c4_10*(1- c3_10)*(x13+x15));
		vals[i++]=Math.round(  c3_10* c4_10*(x12+x14))+Math.round(  c3_10* c4_10*(1- c1_10)*(x13+x15));
		vals[i++]=Math.round(  c1_10* c3_10* c4_10*(x13+x15));
		vals[i++]=Math.round( d2_10*(x3+x2))+Math.round( d2_10*(1-d3_10)*(x6+x7))+Math.round( d2_10*(1-d4_10)*(x10+x11))+Math.round( d2_10*(1-d3_10)*(1-d4_10)*(x14+x15));
		vals[i++]=Math.round( d3_10*(x4+x5))+Math.round( d3_10*(1-d2_10)*(x7+x6))+Math.round( d3_10*(1-d4_10)*(x13+x12))+Math.round( d3_10*(1-d4_10)*(1-d2_10)*(x15+x14));
		vals[i++]=Math.round( d2_10*d3_10*(x6+x7))+Math.round( d2_10*d3_10*(1-d4_10)*(x14+x15));
		vals[i++]=Math.round( d4_10*(x8+x9))+Math.round( d4_10*(1-d2_10)*(x11+x10))+Math.round( d4_10*(1-d3_10)*(x13+x12))+Math.round( d4_10*(1-d3_10)*(1-d2_10)*(x15+x14));
		vals[i++]=Math.round( d2_10*d4_10*(x10+x11))+Math.round( d2_10*d4_10*(1-d3_10)*(x14+x15));
		vals[i++]=Math.round( d4_10*d3_10*(x12+x13))+Math.round( d4_10*d3_10*(1-d2_10)*(x14+x15));
		vals[i++]=Math.round( d2_10*d3_10*d4_10*(x14+x15));
		return vals;
	}
	public long[] calculatedValuesForDuplicateExperiments_11() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_11*(x1+x9))+Math.round( a1_11*(1-a2_11)*(x3+x11))+Math.round( a1_11*(1-a3_11)*(x5+x13))+Math.round( a1_11*(1-a2_11)*(1-a3_11)*(x7+x15));
		vals[i++]=Math.round( a2_11*(x2+x10))+Math.round( a2_11*(1-a1_11)*(x3+x11))+Math.round( a2_11*(1-a3_11)*(x6+x14))+Math.round( a2_11*(1-a3_11)*(1-a1_11)*(x7+x15));
		vals[i++]=Math.round( a1_11*a2_11*(x3+x11))+Math.round( a1_11*a2_11*(1-a3_11)*(x7+x15));
		vals[i++]=Math.round( a3_11*(x4+x12))+Math.round( a3_11*(1-a1_11)*(x5+x13))+Math.round( a3_11*(1-a2_11)*(x6+x14))+Math.round( a3_11*(1-a1_11)*(1-a2_11)*(x7+x15));
		vals[i++]=Math.round( a3_11*a1_11*(x5+x13))+Math.round( a3_11*a1_11*(1-a2_11)*(x7+x15));
		vals[i++]=Math.round( a3_11*a2_11*(x6+x14))+Math.round( a3_11*a2_11*(1-a1_11)*(x7+x15));
		vals[i++]=Math.round( a1_11*a2_11*a3_11*(x7+x15));
		vals[i++]=Math.round( b1_11*(x1+x5))+Math.round( b1_11*(1-b2_11)*(x3+x7))+Math.round( b1_11*(1-b4_11)*(x9+x13))+Math.round( b1_11*(1-b2_11)*(1-b4_11)*(x11+x15));
		vals[i++]=Math.round( b2_11*(x2+x6))+Math.round( b2_11*(1-b1_11)*(x3+x7))+Math.round( b2_11*(1-b4_11)*(x10+x14))+Math.round( b2_11*(1-b4_11)*(1-b1_11)*(x11+x15));
		vals[i++]=Math.round( b1_11*b2_11*(x3+x7))+Math.round( b1_11*b2_11*(1-b4_11)*(x11+x15));
		vals[i++]=Math.round( b4_11*(x12+x8))+Math.round( b4_11*(1-b1_11)*(x13+x9))+Math.round( b4_11*(1-b2_11)*(x10+x14))+Math.round( b4_11*(1-b1_11)*(1-b2_11)*(x11+x15));
		vals[i++]=Math.round( b4_11*b1_11*(x13+x9))+Math.round( b4_11*b1_11*(1-b2_11)*(x11+x15));
		vals[i++]=Math.round( b4_11*b2_11*(x14+x10))+Math.round( b4_11*b2_11*(1-b1_11)*(x11+x15));
		vals[i++]=Math.round( b1_11*b2_11*b4_11*(x11+x15));
		vals[i++]=Math.round(  c1_11*(x1+x3))+Math.round(  c1_11*(1- c3_11)*(x5+x7))+Math.round(  c1_11*(1- c4_11)*(x9+x11))+Math.round(  c1_11*(1- c3_11)*(1- c4_11)*(x13+x15));
		vals[i++]=Math.round(  c3_11*(x4+x6))+Math.round(  c3_11*(1- c1_11)*(x5+x7))+Math.round(  c3_11*(1- c4_11)*(x14+x12))+Math.round(  c3_11*(1- c4_11)*(1- c1_11)*(x13+x15));
		vals[i++]=Math.round(  c1_11* c3_11*(x5+x7))+Math.round(  c1_11* c3_11*(1- c4_11)*(x13+x15));
		vals[i++]=Math.round(  c4_11*(x8+x10))+Math.round(  c4_11*(1- c1_11)*(x9+x11))+Math.round(  c4_11*(1- c3_11)*(x14+x12))+Math.round(  c4_11*(1- c3_11)*(1- c1_11)*(x13+x15));
		vals[i++]=Math.round(  c1_11* c4_11*(x9+x11))+Math.round(  c1_11* c4_11*(1- c3_11)*(x13+x15));
		vals[i++]=Math.round(  c3_11* c4_11*(x12+x14))+Math.round(  c3_11* c4_11*(1- c1_11)*(x13+x15));
		vals[i++]=Math.round(  c1_11* c3_11* c4_11*(x13+x15));
		vals[i++]=Math.round( d2_11*(x3+x2))+Math.round( d2_11*(1-d3_11)*(x6+x7))+Math.round( d2_11*(1-d4_11)*(x10+x11))+Math.round( d2_11*(1-d3_11)*(1-d4_11)*(x14+x15));
		vals[i++]=Math.round( d3_11*(x4+x5))+Math.round( d3_11*(1-d2_11)*(x7+x6))+Math.round( d3_11*(1-d4_11)*(x13+x12))+Math.round( d3_11*(1-d4_11)*(1-d2_11)*(x15+x14));
		vals[i++]=Math.round( d2_11*d3_11*(x6+x7))+Math.round( d2_11*d3_11*(1-d4_11)*(x14+x15));
		vals[i++]=Math.round( d4_11*(x8+x9))+Math.round( d4_11*(1-d2_11)*(x11+x10))+Math.round( d4_11*(1-d3_11)*(x13+x12))+Math.round( d4_11*(1-d3_11)*(1-d2_11)*(x15+x14));
		vals[i++]=Math.round( d2_11*d4_11*(x10+x11))+Math.round( d2_11*d4_11*(1-d3_11)*(x14+x15));
		vals[i++]=Math.round( d4_11*d3_11*(x12+x13))+Math.round( d4_11*d3_11*(1-d2_11)*(x14+x15));
		vals[i++]=Math.round( d2_11*d3_11*d4_11*(x14+x15));
		return vals;
	}
	public long[] calculatedValuesForDuplicateExperiments_12() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_12*(x1+x9))+Math.round( a1_12*(1-a2_12)*(x3+x11))+Math.round( a1_12*(1-a3_12)*(x5+x13))+Math.round( a1_12*(1-a2_12)*(1-a3_12)*(x7+x15));
		vals[i++]=Math.round( a2_12*(x2+x10))+Math.round( a2_12*(1-a1_12)*(x3+x11))+Math.round( a2_12*(1-a3_12)*(x6+x14))+Math.round( a2_12*(1-a3_12)*(1-a1_12)*(x7+x15));
		vals[i++]=Math.round( a1_12*a2_12*(x3+x11))+Math.round( a1_12*a2_12*(1-a3_12)*(x7+x15));
		vals[i++]=Math.round( a3_12*(x4+x12))+Math.round( a3_12*(1-a1_12)*(x5+x13))+Math.round( a3_12*(1-a2_12)*(x6+x14))+Math.round( a3_12*(1-a1_12)*(1-a2_12)*(x7+x15));
		vals[i++]=Math.round( a3_12*a1_12*(x5+x13))+Math.round( a3_12*a1_12*(1-a2_12)*(x7+x15));
		vals[i++]=Math.round( a3_12*a2_12*(x6+x14))+Math.round( a3_12*a2_12*(1-a1_12)*(x7+x15));
		vals[i++]=Math.round( a1_12*a2_12*a3_12*(x7+x15));
		vals[i++]=Math.round( b1_12*(x1+x5))+Math.round( b1_12*(1-b2_12)*(x3+x7))+Math.round( b1_12*(1-b4_12)*(x9+x13))+Math.round( b1_12*(1-b2_12)*(1-b4_12)*(x11+x15));
		vals[i++]=Math.round( b2_12*(x2+x6))+Math.round( b2_12*(1-b1_12)*(x3+x7))+Math.round( b2_12*(1-b4_12)*(x10+x14))+Math.round( b2_12*(1-b4_12)*(1-b1_12)*(x11+x15));
		vals[i++]=Math.round( b1_12*b2_12*(x3+x7))+Math.round( b1_12*b2_12*(1-b4_12)*(x11+x15));
		vals[i++]=Math.round( b4_12*(x12+x8))+Math.round( b4_12*(1-b1_12)*(x13+x9))+Math.round( b4_12*(1-b2_12)*(x10+x14))+Math.round( b4_12*(1-b1_12)*(1-b2_12)*(x11+x15));
		vals[i++]=Math.round( b4_12*b1_12*(x13+x9))+Math.round( b4_12*b1_12*(1-b2_12)*(x11+x15));
		vals[i++]=Math.round( b4_12*b2_12*(x14+x10))+Math.round( b4_12*b2_12*(1-b1_12)*(x11+x15));
		vals[i++]=Math.round( b1_12*b2_12*b4_12*(x11+x15));
		vals[i++]=Math.round(  c1_12*(x1+x3))+Math.round(  c1_12*(1- c3_12)*(x5+x7))+Math.round(  c1_12*(1- c4_12)*(x9+x11))+Math.round(  c1_12*(1- c3_12)*(1- c4_12)*(x13+x15));
		vals[i++]=Math.round(  c3_12*(x4+x6))+Math.round(  c3_12*(1- c1_12)*(x5+x7))+Math.round(  c3_12*(1- c4_12)*(x14+x12))+Math.round(  c3_12*(1- c4_12)*(1- c1_12)*(x13+x15));
		vals[i++]=Math.round(  c1_12* c3_12*(x5+x7))+Math.round(  c1_12* c3_12*(1- c4_12)*(x13+x15));
		vals[i++]=Math.round(  c4_12*(x8+x10))+Math.round(  c4_12*(1- c1_12)*(x9+x11))+Math.round(  c4_12*(1- c3_12)*(x14+x12))+Math.round(  c4_12*(1- c3_12)*(1- c1_12)*(x13+x15));
		vals[i++]=Math.round(  c1_12* c4_12*(x9+x11))+Math.round(  c1_12* c4_12*(1- c3_12)*(x13+x15));
		vals[i++]=Math.round(  c3_12* c4_12*(x12+x14))+Math.round(  c3_12* c4_12*(1- c1_12)*(x13+x15));
		vals[i++]=Math.round(  c1_12* c3_12* c4_12*(x13+x15));
		vals[i++]=Math.round( d2_12*(x3+x2))+Math.round( d2_12*(1-d3_12)*(x6+x7))+Math.round( d2_12*(1-d4_12)*(x10+x11))+Math.round( d2_12*(1-d3_12)*(1-d4_12)*(x14+x15));
		vals[i++]=Math.round( d3_12*(x4+x5))+Math.round( d3_12*(1-d2_12)*(x7+x6))+Math.round( d3_12*(1-d4_12)*(x13+x12))+Math.round( d3_12*(1-d4_12)*(1-d2_12)*(x15+x14));
		vals[i++]=Math.round( d2_12*d3_12*(x6+x7))+Math.round( d2_12*d3_12*(1-d4_12)*(x14+x15));
		vals[i++]=Math.round( d4_12*(x8+x9))+Math.round( d4_12*(1-d2_12)*(x11+x10))+Math.round( d4_12*(1-d3_12)*(x13+x12))+Math.round( d4_12*(1-d3_12)*(1-d2_12)*(x15+x14));
		vals[i++]=Math.round( d2_12*d4_12*(x10+x11))+Math.round( d2_12*d4_12*(1-d3_12)*(x14+x15));
		vals[i++]=Math.round( d4_12*d3_12*(x12+x13))+Math.round( d4_12*d3_12*(1-d2_12)*(x14+x15));
		vals[i++]=Math.round( d2_12*d3_12*d4_12*(x14+x15));
		return vals;
	}
	public long[] calculatedValuesForDuplicateExperiments_13() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_13*(x1+x9))+Math.round( a1_13*(1-a2_13)*(x3+x11))+Math.round( a1_13*(1-a3_13)*(x5+x13))+Math.round( a1_13*(1-a2_13)*(1-a3_13)*(x7+x15));
		vals[i++]=Math.round( a2_13*(x2+x10))+Math.round( a2_13*(1-a1_13)*(x3+x11))+Math.round( a2_13*(1-a3_13)*(x6+x14))+Math.round( a2_13*(1-a3_13)*(1-a1_13)*(x7+x15));
		vals[i++]=Math.round( a1_13*a2_13*(x3+x11))+Math.round( a1_13*a2_13*(1-a3_13)*(x7+x15));
		vals[i++]=Math.round( a3_13*(x4+x12))+Math.round( a3_13*(1-a1_13)*(x5+x13))+Math.round( a3_13*(1-a2_13)*(x6+x14))+Math.round( a3_13*(1-a1_13)*(1-a2_13)*(x7+x15));
		vals[i++]=Math.round( a3_13*a1_13*(x5+x13))+Math.round( a3_13*a1_13*(1-a2_13)*(x7+x15));
		vals[i++]=Math.round( a3_13*a2_13*(x6+x14))+Math.round( a3_13*a2_13*(1-a1_13)*(x7+x15));
		vals[i++]=Math.round( a1_13*a2_13*a3_13*(x7+x15));
		vals[i++]=Math.round( b1_13*(x1+x5))+Math.round( b1_13*(1-b2_13)*(x3+x7))+Math.round( b1_13*(1-b4_13)*(x9+x13))+Math.round( b1_13*(1-b2_13)*(1-b4_13)*(x11+x15));
		vals[i++]=Math.round( b2_13*(x2+x6))+Math.round( b2_13*(1-b1_13)*(x3+x7))+Math.round( b2_13*(1-b4_13)*(x10+x14))+Math.round( b2_13*(1-b4_13)*(1-b1_13)*(x11+x15));
		vals[i++]=Math.round( b1_13*b2_13*(x3+x7))+Math.round( b1_13*b2_13*(1-b4_13)*(x11+x15));
		vals[i++]=Math.round( b4_13*(x12+x8))+Math.round( b4_13*(1-b1_13)*(x13+x9))+Math.round( b4_13*(1-b2_13)*(x10+x14))+Math.round( b4_13*(1-b1_13)*(1-b2_13)*(x11+x15));
		vals[i++]=Math.round( b4_13*b1_13*(x13+x9))+Math.round( b4_13*b1_13*(1-b2_13)*(x11+x15));
		vals[i++]=Math.round( b4_13*b2_13*(x14+x10))+Math.round( b4_13*b2_13*(1-b1_13)*(x11+x15));
		vals[i++]=Math.round( b1_13*b2_13*b4_13*(x11+x15));
		vals[i++]=Math.round(  c1_13*(x1+x3))+Math.round(  c1_13*(1- c3_13)*(x5+x7))+Math.round(  c1_13*(1- c4_13)*(x9+x11))+Math.round(  c1_13*(1- c3_13)*(1- c4_13)*(x13+x15));
		vals[i++]=Math.round(  c3_13*(x4+x6))+Math.round(  c3_13*(1- c1_13)*(x5+x7))+Math.round(  c3_13*(1- c4_13)*(x14+x12))+Math.round(  c3_13*(1- c4_13)*(1- c1_13)*(x13+x15));
		vals[i++]=Math.round(  c1_13* c3_13*(x5+x7))+Math.round(  c1_13* c3_13*(1- c4_13)*(x13+x15));
		vals[i++]=Math.round(  c4_13*(x8+x10))+Math.round(  c4_13*(1- c1_13)*(x9+x11))+Math.round(  c4_13*(1- c3_13)*(x14+x12))+Math.round(  c4_13*(1- c3_13)*(1- c1_13)*(x13+x15));
		vals[i++]=Math.round(  c1_13* c4_13*(x9+x11))+Math.round(  c1_13* c4_13*(1- c3_13)*(x13+x15));
		vals[i++]=Math.round(  c3_13* c4_13*(x12+x14))+Math.round(  c3_13* c4_13*(1- c1_13)*(x13+x15));
		vals[i++]=Math.round(  c1_13* c3_13* c4_13*(x13+x15));
		vals[i++]=Math.round( d2_13*(x3+x2))+Math.round( d2_13*(1-d3_13)*(x6+x7))+Math.round( d2_13*(1-d4_13)*(x10+x11))+Math.round( d2_13*(1-d3_13)*(1-d4_13)*(x14+x15));
		vals[i++]=Math.round( d3_13*(x4+x5))+Math.round( d3_13*(1-d2_13)*(x7+x6))+Math.round( d3_13*(1-d4_13)*(x13+x12))+Math.round( d3_13*(1-d4_13)*(1-d2_13)*(x15+x14));
		vals[i++]=Math.round( d2_13*d3_13*(x6+x7))+Math.round( d2_13*d3_13*(1-d4_13)*(x14+x15));
		vals[i++]=Math.round( d4_13*(x8+x9))+Math.round( d4_13*(1-d2_13)*(x11+x10))+Math.round( d4_13*(1-d3_13)*(x13+x12))+Math.round( d4_13*(1-d3_13)*(1-d2_13)*(x15+x14));
		vals[i++]=Math.round( d2_13*d4_13*(x10+x11))+Math.round( d2_13*d4_13*(1-d3_13)*(x14+x15));
		vals[i++]=Math.round( d4_13*d3_13*(x12+x13))+Math.round( d4_13*d3_13*(1-d2_13)*(x14+x15));
		vals[i++]=Math.round( d2_13*d3_13*d4_13*(x14+x15));
		return vals;
	}
	public long[] calculatedValuesForDuplicateExperiments_14() {
		long[] vals = new long[28];
		int i=0;
		vals[i++]=Math.round( a1_14*(x1+x9))+Math.round( a1_14*(1-a2_14)*(x3+x11))+Math.round( a1_14*(1-a3_14)*(x5+x13))+Math.round( a1_14*(1-a2_14)*(1-a3_14)*(x7+x15));
		vals[i++]=Math.round( a2_14*(x2+x10))+Math.round( a2_14*(1-a1_14)*(x3+x11))+Math.round( a2_14*(1-a3_14)*(x6+x14))+Math.round( a2_14*(1-a3_14)*(1-a1_14)*(x7+x15));
		vals[i++]=Math.round( a1_14*a2_14*(x3+x11))+Math.round( a1_14*a2_14*(1-a3_14)*(x7+x15));
		vals[i++]=Math.round( a3_14*(x4+x12))+Math.round( a3_14*(1-a1_14)*(x5+x13))+Math.round( a3_14*(1-a2_14)*(x6+x14))+Math.round( a3_14*(1-a1_14)*(1-a2_14)*(x7+x15));
		vals[i++]=Math.round( a3_14*a1_14*(x5+x13))+Math.round( a3_14*a1_14*(1-a2_14)*(x7+x15));
		vals[i++]=Math.round( a3_14*a2_14*(x6+x14))+Math.round( a3_14*a2_14*(1-a1_14)*(x7+x15));
		vals[i++]=Math.round( a1_14*a2_14*a3_14*(x7+x15));
		vals[i++]=Math.round( b1_14*(x1+x5))+Math.round( b1_14*(1-b2_14)*(x3+x7))+Math.round( b1_14*(1-b4_14)*(x9+x13))+Math.round( b1_14*(1-b2_14)*(1-b4_14)*(x11+x15));
		vals[i++]=Math.round( b2_14*(x2+x6))+Math.round( b2_14*(1-b1_14)*(x3+x7))+Math.round( b2_14*(1-b4_14)*(x10+x14))+Math.round( b2_14*(1-b4_14)*(1-b1_14)*(x11+x15));
		vals[i++]=Math.round( b1_14*b2_14*(x3+x7))+Math.round( b1_14*b2_14*(1-b4_14)*(x11+x15));
		vals[i++]=Math.round( b4_14*(x12+x8))+Math.round( b4_14*(1-b1_14)*(x13+x9))+Math.round( b4_14*(1-b2_14)*(x10+x14))+Math.round( b4_14*(1-b1_14)*(1-b2_14)*(x11+x15));
		vals[i++]=Math.round( b4_14*b1_14*(x13+x9))+Math.round( b4_14*b1_14*(1-b2_14)*(x11+x15));
		vals[i++]=Math.round( b4_14*b2_14*(x14+x10))+Math.round( b4_14*b2_14*(1-b1_14)*(x11+x15));
		vals[i++]=Math.round( b1_14*b2_14*b4_14*(x11+x15));
		vals[i++]=Math.round(  c1_14*(x1+x3))+Math.round(  c1_14*(1- c3_14)*(x5+x7))+Math.round(  c1_14*(1- c4_14)*(x9+x11))+Math.round(  c1_14*(1- c3_14)*(1- c4_14)*(x13+x15));
		vals[i++]=Math.round(  c3_14*(x4+x6))+Math.round(  c3_14*(1- c1_14)*(x5+x7))+Math.round(  c3_14*(1- c4_14)*(x14+x12))+Math.round(  c3_14*(1- c4_14)*(1- c1_14)*(x13+x15));
		vals[i++]=Math.round(  c1_14* c3_14*(x5+x7))+Math.round(  c1_14* c3_14*(1- c4_14)*(x13+x15));
		vals[i++]=Math.round(  c4_14*(x8+x10))+Math.round(  c4_14*(1- c1_14)*(x9+x11))+Math.round(  c4_14*(1- c3_14)*(x14+x12))+Math.round(  c4_14*(1- c3_14)*(1- c1_14)*(x13+x15));
		vals[i++]=Math.round(  c1_14* c4_14*(x9+x11))+Math.round(  c1_14* c4_14*(1- c3_14)*(x13+x15));
		vals[i++]=Math.round(  c3_14* c4_14*(x12+x14))+Math.round(  c3_14* c4_14*(1- c1_14)*(x13+x15));
		vals[i++]=Math.round(  c1_14* c3_14* c4_14*(x13+x15));
		vals[i++]=Math.round( d2_14*(x3+x2))+Math.round( d2_14*(1-d3_14)*(x6+x7))+Math.round( d2_14*(1-d4_14)*(x10+x11))+Math.round( d2_14*(1-d3_14)*(1-d4_14)*(x14+x15));
		vals[i++]=Math.round( d3_14*(x4+x5))+Math.round( d3_14*(1-d2_14)*(x7+x6))+Math.round( d3_14*(1-d4_14)*(x13+x12))+Math.round( d3_14*(1-d4_14)*(1-d2_14)*(x15+x14));
		vals[i++]=Math.round( d2_14*d3_14*(x6+x7))+Math.round( d2_14*d3_14*(1-d4_14)*(x14+x15));
		vals[i++]=Math.round( d4_14*(x8+x9))+Math.round( d4_14*(1-d2_14)*(x11+x10))+Math.round( d4_14*(1-d3_14)*(x13+x12))+Math.round( d4_14*(1-d3_14)*(1-d2_14)*(x15+x14));
		vals[i++]=Math.round( d2_14*d4_14*(x10+x11))+Math.round( d2_14*d4_14*(1-d3_14)*(x14+x15));
		vals[i++]=Math.round( d4_14*d3_14*(x12+x13))+Math.round( d4_14*d3_14*(1-d2_14)*(x14+x15));
		vals[i++]=Math.round( d2_14*d3_14*d4_14*(x14+x15));
		return vals;
	}
	
	
	public long[] calculateValuesForNExpTrials() {
		long[] vals1 = null; // will always be populated
		long[] vals2 = new long[0];
		long[] vals3 = new long[0];
		long[] vals4 = new long[0];
		long[] vals5 = new long[0];
		long[] vals6 = new long[0];
		long[] vals7 = new long[0];
		long[] vals8 = new long[0];
		long[] vals9 = new long[0];
		long[] vals10 = new long[0];
		long[] vals11 = new long[0];
		long[] vals12 = new long[0];
		long[] vals13 = new long[0];
		long[] vals14 = new long[0];
		long[] vals15 = new long[0];
		
		if(sysConfig.getNExpTrials()>=1) {	
			vals1 = this.calculatedValues();
		}
		
		if(sysConfig.getNExpTrials()>=2) {	
			vals2 = this.calculatedValuesForDuplicateExperiments_1();
		}
		
		if(sysConfig.getNExpTrials()>=3) {	
			vals3 = this.calculatedValuesForDuplicateExperiments_2();
		}
		
		if(sysConfig.getNExpTrials()>=4) {	
			vals4 = this.calculatedValuesForDuplicateExperiments_3();
		}
		if(sysConfig.getNExpTrials()>=5) {	
			vals5 = this.calculatedValuesForDuplicateExperiments_4();
		}
		if(sysConfig.getNExpTrials()>=6) {	
			vals6 = this.calculatedValuesForDuplicateExperiments_5();
		}
		if(sysConfig.getNExpTrials()>=7) {	
			vals7 = this.calculatedValuesForDuplicateExperiments_6();
		}
		if(sysConfig.getNExpTrials()>=8) {	
			vals8 = this.calculatedValuesForDuplicateExperiments_7();
		}
		
		if(sysConfig.getNExpTrials()>=9) {	
			vals9 = this.calculatedValuesForDuplicateExperiments_8();
		}
		if(sysConfig.getNExpTrials()>=10) {	
			vals10 = this.calculatedValuesForDuplicateExperiments_9();
		}
		if(sysConfig.getNExpTrials()>=11) {	
			vals11 = this.calculatedValuesForDuplicateExperiments_10();
		}
		if(sysConfig.getNExpTrials()>=12) {	
			vals12 = this.calculatedValuesForDuplicateExperiments_11();
		}
		if(sysConfig.getNExpTrials()>=13) {	
			vals13 = this.calculatedValuesForDuplicateExperiments_12();
		}
		if(sysConfig.getNExpTrials()>=14) {	
			vals14 = this.calculatedValuesForDuplicateExperiments_13();
		}
		if(sysConfig.getNExpTrials()>=15) {	
			vals15 = this.calculatedValuesForDuplicateExperiments_14();
		}
		
		long[] combined = new long[vals1.length+vals2.length+vals3.length+vals4.length
		                           +vals5.length+vals6.length+vals7.length+vals8.length
		                           +vals9.length+vals10.length+vals11.length+vals12.length
		                           +vals13.length+vals14.length+vals15.length];
		int idx=0;
		for(int i=0;i<vals1.length;i++) {
			combined[idx++]=vals1[i];
		}
		for(int i=0;i<vals2.length;i++) {
			combined[idx++]=vals2[i];
		}
		for(int i=0;i<vals3.length;i++) {
			combined[idx++]=vals3[i];
		}
		for(int i=0;i<vals4.length;i++) {
			combined[idx++]=vals4[i];
		}
		
		for(int i=0;i<vals5.length;i++) {
			combined[idx++]=vals5[i];
		}
		for(int i=0;i<vals6.length;i++) {
			combined[idx++]=vals6[i];
		}
		for(int i=0;i<vals7.length;i++) {
			combined[idx++]=vals7[i];
		}
		for(int i=0;i<vals8.length;i++) {
			combined[idx++]=vals8[i];
		}
		
		for(int i=0;i<vals9.length;i++) {
			combined[idx++]=vals9[i];
		}
		for(int i=0;i<vals10.length;i++) {
			combined[idx++]=vals10[i];
		}
		for(int i=0;i<vals11.length;i++) {
			combined[idx++]=vals11[i];
		}
		for(int i=0;i<vals12.length;i++) {
			combined[idx++]=vals12[i];
		}
		for(int i=0;i<vals13.length;i++) {
			combined[idx++]=vals13[i];
		}
		for(int i=0;i<vals14.length;i++) {
			combined[idx++]=vals14[i];
		}
		for(int i=0;i<vals15.length;i++) {
			combined[idx++]=vals15[i];
		}
		
		return combined;
	}
	public double fitnessRel(boolean display) {
		
		long[] combined = calculateValuesForNExpTrials();
		double error = sysConfig.calculateEAerror(combined);
		if(display) {			
			System.out.println("\n\nRHS Error:\t"+error);
		}
		return error;
	}
	

}
