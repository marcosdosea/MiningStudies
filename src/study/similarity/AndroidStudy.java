package study.similarity;

import java.util.ArrayList;

import org.designroleminer.ClassMetricResult;
import org.designroleminer.threshold.DesignRoleTechnique;
import org.designroleminer.threshold.TechniqueExecutor;
import org.systemsimilarity.SimilarityManager;

public class AndroidStudy {

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "similarity\\";
		SimilarityManager gSimilarity = new SimilarityManager();
		TechniqueExecutor executor = new TechniqueExecutor(new DesignRoleTechnique());

		ArrayList<String> listAndroid = new ArrayList<String>();
		listAndroid.add("D:\\Projetos\\_Android\\bitcoin-wallet");
		ArrayList<ClassMetricResult> bitcoin = executor.getMetricsFromProjects(listAndroid, PASTA_RESULTADO);

		listAndroid = new ArrayList<String>();
		listAndroid.add("D:\\Projetos\\_Android\\Talon-for-Twitter");
		ArrayList<ClassMetricResult> k9 = executor.getMetricsFromProjects(listAndroid, PASTA_RESULTADO);
		System.out.println("======>>>> Bitcoin x Talon : " + gSimilarity.calculate(bitcoin, k9));
	}

}
