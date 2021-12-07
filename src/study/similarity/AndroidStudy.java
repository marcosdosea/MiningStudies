package study.similarity;

import java.util.ArrayList;

import org.designroleminer.MetricReport;
import org.systemsimilarity.SimilarityManager;
import org.threshold.TechniqueExecutor;

public class AndroidStudy {

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "similarity\\";
		SimilarityManager gSimilarity = new SimilarityManager();
		TechniqueExecutor executor = new TechniqueExecutor();

		ArrayList<String> listAndroid = new ArrayList<String>();
		listAndroid.add("D:\\Projetos\\_Android\\bitcoin-wallet");
		MetricReport bitcoin = executor.getMetricsFromProjects(listAndroid, PASTA_RESULTADO, "");

		listAndroid = new ArrayList<String>();
		listAndroid.add("D:\\Projetos\\_Android\\Talon-for-Twitter");
		MetricReport k9 = executor.getMetricsFromProjects(listAndroid, PASTA_RESULTADO, "");
		System.out.println("======>>>> Bitcoin x Talon : " + gSimilarity.calculate(bitcoin.all(), k9.all()));
	}

}
