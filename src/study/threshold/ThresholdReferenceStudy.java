package study.threshold;

import java.util.ArrayList;
import java.util.Collection;

import org.designroleminer.ClassMetricResult;
import org.designroleminer.threshold.DoseaDesignRoleTechnique;
import org.designroleminer.threshold.DoseaReferenceTechnique;
import org.designroleminer.threshold.TechniqueExecutor;

public class ThresholdReferenceStudy {

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "thresholds\\";
		TechniqueExecutor gLimiares = new TechniqueExecutor();

		System.out.println("Iniciando a coleta de métricas do projeto referencia...");
		ArrayList<String> projetosReferencia = gLimiares.lerProjetos("Reference.txt");
		Collection<ClassMetricResult> metricasProjetosReferencia = gLimiares
				.getMetricsFromProjects(projetosReferencia, PASTA_RESULTADO, "").all();

		System.out.println("Gerando Limiares por Dosea apontando para projetos Referencia...");
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "R.csv", new DoseaReferenceTechnique());

		System.out.println("Gerando Limiares por Dosea Referencia e Design Role...");
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "D.csv", new DoseaDesignRoleTechnique(metricasProjetosReferencia));

		System.out.println("Limiares gravados na pasta " + PASTA_RESULTADO + " com sucesso!");
	}

}
