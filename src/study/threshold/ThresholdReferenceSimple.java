package study.threshold;

import java.util.ArrayList;
import java.util.Collection;

import org.designroleminer.ClassMetricResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threshold.AlvesTechnique;
import org.threshold.AnicheTechnique;
import org.threshold.DoseaDesignRoleTechnique;
import org.threshold.DoseaReferenceTechnique;
import org.threshold.TechniqueExecutor;
import org.threshold.ValeTechnique;

public class ThresholdReferenceSimple {

	static Logger logger = LoggerFactory.getLogger(ThresholdReferenceSimple.class);

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "thresholds\\simple\\";
		TechniqueExecutor gLimiares = new TechniqueExecutor();

		logger.info("Iniciando a coleta de métricas do projeto referencia...");
		ArrayList<String> projetosReferencia = gLimiares.lerProjetos("BenchmarkSimple.txt");
		Collection<ClassMetricResult> metricasProjetosReferencia = gLimiares
				.getMetricsFromProjects(projetosReferencia, PASTA_RESULTADO, "efdc59004cd254692aa749fab3b1c35aa6680a9d").all();

		logger.info("Gerando Limiares por Dosea apontando para projetos Referencia...");
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "R.csv", new DoseaReferenceTechnique());

		logger.info("Gerando Limiares por Dosea Referencia e Design Role...");
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "D.csv", new DoseaDesignRoleTechnique(metricasProjetosReferencia));

		logger.info("Gerando Limiares por Alves...");
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "A.csv", new AlvesTechnique());

		logger.info("Gerando Limiares por Vale...");
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "V.csv", new ValeTechnique());

		logger.info("Gerando Limiares por Aniche...");
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "X.csv", new AnicheTechnique());
	}

}
