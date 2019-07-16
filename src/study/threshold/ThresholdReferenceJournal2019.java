package study.threshold;

import java.util.ArrayList;

import org.designroleminer.ClassMetricResult;
import org.designroleminer.technique.AlvesTechnique;
import org.designroleminer.technique.AnicheTechnique;
import org.designroleminer.technique.DesignRoleTechnique;
import org.designroleminer.technique.DoseaDesignRoleTechnique;
import org.designroleminer.technique.DoseaReferenceTechnique;
import org.designroleminer.technique.TechniqueExecutor;
import org.designroleminer.technique.ValeTechnique;

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
