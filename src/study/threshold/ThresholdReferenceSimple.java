package study.threshold;

import java.util.ArrayList;
import java.util.Collection;

import org.designroleminer.ClassMetricResult;
import org.designroleminer.threshold.AlvesTechnique;
import org.designroleminer.threshold.AnicheTechnique;
import org.designroleminer.threshold.DesignRoleTechnique;
import org.designroleminer.threshold.DoseaDesignRoleTechnique;
import org.designroleminer.threshold.DoseaReferenceTechnique;
import org.designroleminer.threshold.TechniqueExecutor;
import org.designroleminer.threshold.ValeTechnique;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThresholdReferenceSimple {

	static Logger logger = LoggerFactory.getLogger(ThresholdReferenceSimple.class);

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "thresholds\\simple\\";
		TechniqueExecutor gLimiares = new TechniqueExecutor(new DesignRoleTechnique());

		logger.info("Iniciando a coleta de métricas do projeto referencia...");
		ArrayList<String> projetosReferencia = gLimiares.lerProjetos("BenchmarkSimple.txt");
		Collection<ClassMetricResult> metricasProjetosReferencia = gLimiares.getMetricsFromProjects(projetosReferencia,
				PASTA_RESULTADO, "").all();

		logger.info("Gerando Limiares por Dosea apontando para projetos Referencia...");
		gLimiares.setTechinique(new DoseaReferenceTechnique());
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "R.csv");

		logger.info("Gerando Limiares por Dosea Referencia e Design Role...");
		gLimiares.setTechinique(new DoseaDesignRoleTechnique());
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "D.csv");

		logger.info("Gerando Limiares por Alves...");
		gLimiares.setTechinique(new AlvesTechnique());
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "A.csv");

		logger.info("Gerando Limiares por Vale...");
		gLimiares.setTechinique(new ValeTechnique());
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "V.csv");

		logger.info("Gerando Limiares por Aniche...");
		gLimiares.setTechinique(new AnicheTechnique());
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "X.csv");
	}

}
