package study.threshold;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.designroleminer.ClassMetricResult;
import org.designroleminer.threshold.AlvesTechnique;
import org.designroleminer.threshold.AnicheTechnique;
import org.designroleminer.threshold.DesignRoleTechnique;
import org.designroleminer.threshold.DoseaDesignRoleTechnique;
import org.designroleminer.threshold.DoseaReferenceTechnique;
import org.designroleminer.threshold.TechniqueExecutor;
import org.designroleminer.threshold.ValeTechnique;
import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.persistence.csv.CSVFile;
import org.systemsimilarity.SimilarityManager;
import org.systemsimilarity.SimilarityResult;

public class ThresholdJournal2019Web {

	private static SimilarityManager gSimilarity = new SimilarityManager();

	public static void main(String[] args) {
		final String PASTA_PROJECTS = "thresholds\\WEB2019\\PROJECTS\\";
		final String PASTA_THRESHOLDS = "thresholds\\WEB2019\\";

		TechniqueExecutor gLimiares = new TechniqueExecutor(new DesignRoleTechnique());

		System.out.println("Iniciando a coleta de métricas do projeto referencia...");
		ArrayList<String> projetosReferencia = gLimiares.lerProjetos("Benchmark2019.txt");
		ArrayList<ClassMetricResult> metricasProjetosBenchmark = gLimiares.getMetricsFromProjects(projetosReferencia,
				PASTA_PROJECTS, true);

		System.out.println("Gerando Limiares por Alves usando benchmark...");
		gLimiares.setTechinique(new AlvesTechnique());
		gLimiares.execute(metricasProjetosBenchmark, PASTA_THRESHOLDS + "A.csv");

		System.out.println("Gerando Limiares por Vale usando benchmark...");
		gLimiares.setTechinique(new ValeTechnique());
		gLimiares.execute(metricasProjetosBenchmark, PASTA_THRESHOLDS + "V.csv");

		System.out.println("Gerando Limiares por Aniche...");
		gLimiares.setTechinique(new AnicheTechnique());
		gLimiares.execute(metricasProjetosBenchmark, PASTA_THRESHOLDS + "X.csv");

		List<SimilarityResult> listSimilarity = gSimilarity.calculate(projetosReferencia, PASTA_PROJECTS);

		for (String projeto : projetosReferencia) {

			// Entra no benchmark qualquer projeto com similaridade > 0
			ArrayList<String> projetosSimilares = gSimilarity.filterSimilarProjects(projeto, listSimilarity, 0);
			metricasProjetosBenchmark = gLimiares.getMetricsFromProjects(projetosSimilares, PASTA_PROJECTS, true);

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
			// copia métricas dos projetos usado no benchmark do projeto
			PersistenceMechanism pm = new CSVFile(pastaThresholdsProjeto + "similar-projects.csv");
			for (String projetoSimilar : projetosSimilares) {
				pm.write(projetoSimilar);
			}

			System.out.println("Gerando Limiares por Dosea Referencia e Design Role...");
			gLimiares.setTechinique(new DoseaDesignRoleTechnique());
			gLimiares.execute(metricasProjetosBenchmark, pastaThresholdsProjeto + "D.csv");

			System.out.println("Gerando Limiares por Dosea Referencia...");
			gLimiares.setTechinique(new DoseaReferenceTechnique());
			gLimiares.execute(metricasProjetosBenchmark, pastaThresholdsProjeto + "R.csv");

			System.out.println("Limiares gravados na pasta " + pastaThresholdsProjeto + " com sucesso!");
		}
	}

}
