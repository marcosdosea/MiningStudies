package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class OpenMRSStudy {

	static Logger logger = LoggerFactory.getLogger(OpenMRSStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\openmrs-core";
		String urlRepository = "https://github.com/openmrs/openmrs-core.git";
		String initialCommit = "e059dac046f9d75d55e24d585acce10010602d5f"; // 1.1.0 - 2012.07.25
		String finalCommit = "ab94ff41fd52f8a7d3d2b9d2d9ef9af1af30ea8c"; // 2.2.0 - 2019.03.21
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\openmrs";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\openmrs-core"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
