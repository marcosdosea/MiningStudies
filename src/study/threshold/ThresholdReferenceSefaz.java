package study.threshold;

import java.util.ArrayList;
import java.util.Collection;

import org.designroleminer.ClassMetricResult;
import org.designroleminer.threshold.AlvesTechnique;
import org.designroleminer.threshold.DesignRoleTechnique;
import org.designroleminer.threshold.DoseaDesignRoleTechnique;
import org.designroleminer.threshold.TechniqueExecutor;

public class ThresholdReferenceSefaz {

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "thresholds\\sefaz\\";
		TechniqueExecutor gLimiares = new TechniqueExecutor(new DesignRoleTechnique());

		System.out.println("Iniciando a coleta de métricas do projeto referencia...");
		ArrayList<String> projetosReferencia = gLimiares.lerProjetos("BenchmarkSefaz.txt");
		Collection<ClassMetricResult> metricasProjetosReferencia = gLimiares
				.getMetricsFromProjects(projetosReferencia, PASTA_RESULTADO, false).all();

		System.out.println("Gerando Limiares por Alves apontando para projetos Referencia...");
		gLimiares.setTechinique(new AlvesTechnique());
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "R.csv");

		System.out.println("Gerando Limiares por Dosea Referencia e Design Role...");
		gLimiares.setTechinique(new DoseaDesignRoleTechnique());
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "D.csv");

		System.out.println("Limiares gravados na pasta " + PASTA_RESULTADO + " com sucesso!");
	}

}
