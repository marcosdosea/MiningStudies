package study.similarity;

import java.util.ArrayList;
import java.util.List;

import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.persistence.csv.CSVFile;
import org.systemsimilarity.SimilarityManager;
import org.systemsimilarity.SimilarityResult;
import org.threshold.TechniqueExecutor;

public class Journal2019WebStudy {

	private static SimilarityManager gSimilarity = new SimilarityManager();

	public static void main(String[] args) {
		final String PASTA_METRICAS = "thresholds\\web2019\\projects\\";
		TechniqueExecutor executor = new TechniqueExecutor();
		ArrayList<String> projetosReferencia = executor.lerProjetos("Benchmark2019.txt");
		List<SimilarityResult> listSimilarity = gSimilarity.calculate(projetosReferencia, PASTA_METRICAS);

		PersistenceMechanism pm = new CSVFile(System.getProperty("user.dir") + "\\similarity\\similarity-web.csv");
		pm.write("Project 01", "Project 02", "SimilarityResult [0-1]");

		for (SimilarityResult similarity : listSimilarity) {
			pm.write(similarity.getProject1(), similarity.getProject2(),
					String.format("%.2f", similarity.getSimilarity()));
		}
	}

}
