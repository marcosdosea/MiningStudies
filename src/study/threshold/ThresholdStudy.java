package study.threshold;

import java.util.ArrayList;
import java.util.Collection;

import org.designroleminer.ClassMetricResult;
import org.designroleminer.threshold.AlvesTechnique;
import org.designroleminer.threshold.AnicheTechnique;
import org.designroleminer.threshold.TechniqueExecutor;
import org.designroleminer.threshold.ValeTechnique;

public class ThresholdStudy {

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "thresholds\\";
		TechniqueExecutor gLimiares = new TechniqueExecutor();

		System.out.println("Iniciando a coleta de métricas dos projetos WEB...");
		ArrayList<String> projetosBenchmark = gLimiares.lerProjetos("Benchmark.txt");
		Collection<ClassMetricResult> metricasProjetosBenchmark = gLimiares
				.getMetricsFromProjects(projetosBenchmark, PASTA_RESULTADO, "").all();

		System.out.println("Gerando Limiares por Alves usando benchmark...");
		gLimiares.execute(metricasProjetosBenchmark, PASTA_RESULTADO + "A.csv", new AlvesTechnique());

		System.out.println("Gerando Limiares por Vale usando benchmark...");
		gLimiares.execute(metricasProjetosBenchmark, PASTA_RESULTADO + "V.csv", new ValeTechnique());

		System.out.println("Gerando Limiares por Aniche...");
		gLimiares.execute(metricasProjetosBenchmark, PASTA_RESULTADO + "X.csv", new AnicheTechnique());

		System.out.println("Limiares gravados na pasta " + PASTA_RESULTADO + " com sucesso!");
	}
}
