package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class FastHubStudy {

	static Logger logger = LoggerFactory.getLogger(FastHubStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\FastHub";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\FastHub";
		String urlRepository = "https://github.com/k0shk0sh/FastHub.git";
		String finalCommit = "990e150e7a83e9014835fbe803d30d01ed9016e2"; // 4.7.3 - 2019.12.29
		String initialCommit = "faa6be01eeaa86be9bfe84c4af447f303fbd40e4"; // 1.0.0 - 2017.02.24
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\FastHub"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
