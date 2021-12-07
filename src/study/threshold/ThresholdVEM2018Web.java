package study.threshold;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.designroleminer.ClassMetricResult;
import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.persistence.csv.CSVFile;
import org.systemsimilarity.SimilarityManager;
import org.systemsimilarity.SimilarityResult;
import org.threshold.AlvesTechnique;
import org.threshold.AnicheTechnique;
import org.threshold.DoseaDesignRoleTechnique;
import org.threshold.DoseaReferenceTechnique;
import org.threshold.TechniqueExecutor;
import org.threshold.ValeTechnique;

public class ThresholdVEM2018Web {

	private static SimilarityManager gSimilarity = new SimilarityManager();

	public static void main(String[] args) {
		final String PASTA_PROJECTS = "thresholds\\WEB2018\\PROJECTS\\";
		final String PASTA_THRESHOLDS = "thresholds\\WEB2018\\";

		TechniqueExecutor gLimiares = new TechniqueExecutor();

		System.out.println("Iniciando a coleta de m�tricas do projeto referencia...");
		ArrayList<String> projetosReferencia = gLimiares.lerProjetos("Benchmark2018.txt");
		Collection<ClassMetricResult> metricasProjetosBenchmark = gLimiares
				.getMetricsFromProjects(projetosReferencia, PASTA_PROJECTS, "").all();

		System.out.println("Gerando Limiares por Alves usando benchmark...");
		gLimiares.execute(metricasProjetosBenchmark, PASTA_THRESHOLDS + "A.csv", new AlvesTechnique());

		System.out.println("Gerando Limiares por Vale usando benchmark...");
		gLimiares.execute(metricasProjetosBenchmark, PASTA_THRESHOLDS + "V.csv", new ValeTechnique());

		System.out.println("Gerando Limiares por Aniche...");
		gLimiares.execute(metricasProjetosBenchmark, PASTA_THRESHOLDS + "X.csv", new AnicheTechnique());

		List<SimilarityResult> listSimilarity = gSimilarity.calculate(projetosReferencia, PASTA_PROJECTS);

		for (String projeto : projetosReferencia) {

			ArrayList<String> projetoAnalisado = new ArrayList<String>();
			projetoAnalisado.add(projeto);
			Collection<ClassMetricResult> metricasProjetosAnalisado = gLimiares
					.getMetricsFromProjects(projetoAnalisado, PASTA_PROJECTS, "").all();

			// Entra no benchmark qualquer projeto com similaridade > 0
			ArrayList<String> projetosSimilares = gSimilarity.filterSimilarProjects(projeto, listSimilarity, 0);
			Collection<ClassMetricResult> metricasProjetosBenchmarkSimilares = gLimiares
					.getMetricsFromProjects(projetosSimilares, PASTA_PROJECTS, "").all();

			String nomeProjeto = projeto.substring(projeto.lastIndexOf("\\") + 1);
			String pastaThresholdsProjeto = PASTA_THRESHOLDS + "\\" + nomeProjeto + "\\";
			// cria nova pasta
			File directory = new File(pastaThresholdsProjeto);
			if (!directory.exists())
				directory.mkdir();
			// exclui todos arquivos da pasta
			File[] arquivos = directory.listFiles();
			for (File arquivo : arquivos) {
				arquivo.delete();
			}
			// copia m�tricas dos projetos usado no benchmark do projeto
			PersistenceMechanism pm = new CSVFile(pastaThresholdsProjeto + "similar-projects.csv");
			for (String projetoSimilar : projetosSimilares) {
				pm.write(projetoSimilar);
			}

			System.out.println("Gerando Limiares por Dosea Referencia e Design Role...");
			gLimiares.execute(metricasProjetosBenchmarkSimilares, pastaThresholdsProjeto + "D.csv",
					new DoseaDesignRoleTechnique(metricasProjetosAnalisado));

			System.out.println("Gerando Limiares por Dosea Referencia...");
			gLimiares.execute(metricasProjetosBenchmark, pastaThresholdsProjeto + "R.csv",
					new DoseaReferenceTechnique());

			System.out.println("Limiares gravados na pasta " + pastaThresholdsProjeto + " com sucesso!");
		}
	}

}
