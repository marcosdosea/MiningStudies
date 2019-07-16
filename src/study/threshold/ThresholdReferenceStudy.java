package study.threshold;

import java.util.ArrayList;

import org.designroleminer.ClassMetricResult;
import org.designroleminer.technique.DesignRoleTechnique;
import org.designroleminer.technique.DoseaDesignRoleTechnique;
import org.designroleminer.technique.DoseaReferenceTechnique;
import org.designroleminer.technique.TechniqueExecutor;

public class ThresholdReferenceStudy {

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "thresholds\\";
		TechniqueExecutor gLimiares = new TechniqueExecutor(new DesignRoleTechnique());

		System.out.println("Iniciando a coleta de métricas do projeto referencia...");
		ArrayList<String> projetosReferencia = gLimiares.lerProjetos("Reference.txt");
		ArrayList<ClassMetricResult> metricasProjetosReferencia = gLimiares.getMetricsFromProjects(projetosReferencia,
				PASTA_RESULTADO);

		System.out.println("Gerando Limiares por Dosea apontando para projetos Referencia...");
		gLimiares.setTechinique(new DoseaReferenceTechnique());
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "R.csv");

		System.out.println("Gerando Limiares por Dosea Referencia e Design Role...");
		gLimiares.setTechinique(new DoseaDesignRoleTechnique());
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "D.csv");

		System.out.println("Limiares gravados na pasta " + PASTA_RESULTADO + " com sucesso!");
	}

}
