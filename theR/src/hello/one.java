package hello;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngine;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import edu.cornell.med.icb.R.script.RDataObjectType;
import edu.cornell.med.icb.R.script.RScript;

public class one {
	public static void main(String[] args) throws RserveException, REXPMismatchException, REngineException  {
		final String ksTest = "q <- ks.test(x,y)\n"  
	            + "p_value <- q$p.value\n"  
	            + "test_statistic <- q$statistic[[1]]"; 
	
      final RScript rscript=RScript.createFromScriptString(ksTest);	 
      final double[] xValues = new double[] {0.1, 0.2, 0.3, 0.4, 0.5};  
      final double[] yValues = new double[] {0.6, 0.7, 0.8, 0.9, 1.0};  
      // Ϊ�ű�ָ��������������ֺ�ֵ  
      rscript.setInput("x", xValues);  
      rscript.setInput("y", yValues);  
      // Ϊ�ű����ָ��������������, ��������ڽű�ִ��ǰָ��  
      rscript.setOutput("p_value", RDataObjectType.Double);  
      rscript.setOutput("test_statistic", RDataObjectType.Double);
   
      rscript.execute();  
      final double pvalue = rscript.getOutputDouble("p_value");  
      final double testStat = rscript.getOutputDouble("test_statistic");  
      System.out.println(pvalue);
      System.out.println(testStat);
}
}