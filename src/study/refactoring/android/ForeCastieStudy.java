package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class ForeCastieStudy {

	static Logger logger = LoggerFactory.getLogger(ForeCastieStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\forecastie";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\forecastie";
		String urlRepository = "https://github.com/martykan/forecastie.git";
		String finalCommit = "78ed3ee994847d2910d8dc7654d6b60c2250f22e"; // v1.13.2 - 2020.01.24
		String initialCommit = "66d69dd1e6a7cd73d201f088a4d39a6ce9040e76"; // v1.0 - 2016.04.20
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\forecastie"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
