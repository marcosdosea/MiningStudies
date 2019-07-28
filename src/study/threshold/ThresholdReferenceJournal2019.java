package study.threshold;

import java.util.ArrayList;

import org.designroleminer.ClassMetricResult;
import org.designroleminer.threshold.AlvesTechnique;
import org.designroleminer.threshold.AnicheTechnique;
import org.designroleminer.threshold.DesignRoleTechnique;
import org.designroleminer.threshold.DoseaDesignRoleTechnique;
import org.designroleminer.threshold.DoseaReferenceTechnique;
import org.designroleminer.threshold.TechniqueExecutor;
import org.designroleminer.threshold.ValeTechnique;

public class ThresholdReferenceJournal2019 {

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "thresholds\\2019\\";
		TechniqueExecutor gLimiares = new TechniqueExecutor(new DesignRoleTechnique());

		System.out.println("Iniciando a coleta de métricas do projeto referencia...");
		ArrayList<String> projetosReferencia = gLimiares.lerProjetos("Benchmark2019.txt");
		ArrayList<ClassMetricResult> metricasProjetosBenchmark = gLimiares.getMetricsFromProjects(projetosReferencia, PASTA_RESULTADO);

		System.out.println("Gerando Limiares por Alves usando benchmark...");
		gLimiares.setTechinique(new AlvesTechnique());
		gLimiares.execute(metricasProjetosBenchmark, PASTA_RESULTADO + "A.csv");

		System.out.println("Gerando Limiares por Vale usando benchmark...");
		gLimiares.setTechinique(new ValeTechnique());
		gLimiares.execute(metricasProjetosBenchmark, PASTA_RESULTADO + "V.csv");

		System.out.println("Gerando Limiares por Aniche...");
		gLimiares.setTechinique(new AnicheTechnique());
		gLimiares.execute(metricasProjetosBenchmark, PASTA_RESULTADO + "X.csv");

		System.out.println("Gerando Limiares por Dosea Referencia e Design Role...");
		gLimiares.setTechinique(new DoseaDesignRoleTechnique());
		gLimiares.execute(metricasProjetosBenchmark, PASTA_RESULTADO + "D.csv");

		System.out.println("Gerando Limiares por Dosea Referencia...");
		gLimiares.setTechinique(new DoseaReferenceTechnique());
		gLimiares.execute(metricasProjetosBenchmark, PASTA_RESULTADO + "R.csv");

		System.out.println("Limiares gravados na pasta " + PASTA_RESULTADO + " com sucesso!");
	}

}
