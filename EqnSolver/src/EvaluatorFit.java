import ec.EvolutionState;
import ec.Individual;
import ec.Problem;
import ec.simple.SimpleFitness;
import ec.simple.SimpleProblemForm;
import ec.vector.DoubleVectorIndividual;

public class EvaluatorFit extends Problem implements SimpleProblemForm {


	@Override
	public void evaluate(EvolutionState state, Individual ind, int arg2, int arg3) {
		if (ind.evaluated) return;
	       
        if (!(ind instanceof DoubleVectorIndividual))
            state.output.fatal("Whoa!  It's not a DoubleVectorIndividual!!!",null);
        
        DoubleVectorIndividual ind2 = (DoubleVectorIndividual)ind;    
        double[] genes = ind2.genome;
		for(int i=0;i<genes.length;i++)
			if(genes[i]<0)
				genes[i]=0;
        boolean shouldStop = false;
        
        Equation eqn = new Equation(genes, false);
        
        double error=Double.MAX_VALUE;
        
        error = eqn.fitnessRel(false);
        
        if(Double.isNaN(error))
        	error = Double.MAX_VALUE;
        double fitness = 0-error;
        if(fitness>-0.0000000001) shouldStop=true;
        
        if (!(ind2.fitness instanceof SimpleFitness))
            state.output.fatal("Whoa!  It's not a SimpleFitness!!!",null);
        ((SimpleFitness)ind2.fitness).setFitness(state,
            fitness,
            shouldStop);
        ind2.evaluated = true;
    eqn=null;
	}
	
	

}
