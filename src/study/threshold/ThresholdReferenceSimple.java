package study.threshold;

import java.util.ArrayList;

import org.designroleminer.ClassMetricResult;
import org.designroleminer.technique.AlvesTechnique;
import org.designroleminer.technique.DesignRoleTechnique;
import org.designroleminer.technique.DoseaTechnique;
import org.designroleminer.technique.TechniqueExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThresholdReferenceSimple {

	static Logger logger = LoggerFactory.getLogger(ThresholdReferenceSimple.class);
	public static void main(String[] args) {
		final String PASTA_RESULTADO = "thresholds\\";
		TechniqueExecutor gLimiares = new TechniqueExecutor(new DesignRoleTechnique());

		logger.info("Iniciando a coleta de métricas do projeto referencia...");
		ArrayList<String> projetosReferencia = gLimiares.lerProjetos("BenchmarkSimple.txt");
		ArrayList<ClassMetricResult> metricasProjetosReferencia = gLimiares.getMetricsFromProjects(projetosReferencia);

		logger.info("Gerando Limiares por Alves apontando para projetos Referencia...");
		gLimiares.setTechinique(new AlvesTechnique());
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "R.csv");

		logger.info("Gerando Limiares por Dosea Referencia e Design Role...");
		gLimiares.setTechinique(new DoseaTechnique());
		gLimiares.execute(metricasProjetosReferencia, PASTA_RESULTADO + "D.csv");
	}

}
