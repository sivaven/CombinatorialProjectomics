# CombinatorialProjectomics
 Quantification of Distinct Neuronal Projection Patterns from Retrograde Tracing

[I] Specify model configuration in input/primary_input.json
1.	nRegions correspond to the number of target regions
2.	nInjections correspond to the number of simultaneous injections
    (Note currently there is only functionality for 4 targets and triple (3) injections)
3.	nExpTrials represent the number of repetitions of triple injections to be performed
4.	mockupID refers to the name of the excel sheet (input/model_inputs.xlsx) where the model constraints are specified. These are the counts of cells expressing different combinations of colors. Counts must be specified according to the order of equations present in Equations_4C3/. 
5.	noiseLevel refers to subsequent columns in the same sheet that mockupID refers to. These correspond to noisy surrogate counts estimated from simulations of experiments. This is always ‘0’ for experimental counts or surrogate counts without noise. Simulated surrogated counts with 1% noise is specified in column index 1, 5% in column index 2, and 10% in column index 3.

[II] Specify model constraints in input/model_inputs.xlsx
1.	refer to steps 4 and 5 in [I] to list model inputs (constraints).
2.	The sheet m’0’ consists of a surrogate example (counts from simulated triple-injection experiments including repetitions). M’72’ corresponds to model constraints experimentally counted from MOp_ul. 721, 722 and 723 contains counts in MOp_ul corresponding to layers 2/3, 5 and 6 respectively.
3.	For the surrogate examples, one would start with a pre-defined counts for different projection patterns for a source region. These counts are first specified in column K (True Xi), L (sum of True Xi), and P (True real values, which correspond to the fractions of axons picking up tracers). 
(Step 3 is irrelevant for the experimental data)

[III] Specify population-level Evolutionary Strategies (ES) parameters such as the number of generations and population sizes in input/base_es.params and genome-level mutation/crossover parameters in eqnsolver_real.params. The genome size parameter in eqnsolver_real.params must be updated according to nExpTrials (see [I]-3). The genome size equals the sum of the number of unknown integers (counts of projection patterns) and the number of unknown real numbers (proportional to the number of injection experiments) plus one dummy gene. After step [I], one can also query SystemConfig.getNGenes() to identify the genome size.

[IV] The main program to solve the system of equations is src/ECJStarterForEqnSolver.java. This program will run several independent ES instances with random initial conditions. The outputs are written to the output/ directory. 

[V] Utility functions are available in src/PostECJ.java to go through the outputs generated from step [IV] and consolidate the results. The best solutions identified (counts of 15 projection patterns) will be written to Output/consolidated/m<mockupID>/XXX_acceptedSolns.csv

[VI] There is also functionality to generate models for any <nRegions> (n) and <nInjections> (k) in nCk_EqnGenerator.jar. However, this feature is untested. 
