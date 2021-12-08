package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class OpenmpfStudy {

	static Logger logger = LoggerFactory.getLogger(OpenmpfStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\openmpf";
		String urlRepository = "https://github.com/openmpf/openmpf.git";
		String initialCommit = "9a9061aeea57a6d96d55e2501e598d4b714a8f86"; // R1.0.0 - 2017.11.29
		String finalCommit = "bf13c01cc164daffd9f76e360595ba8f0f427f73"; // R4.1.0- 2019.11.19
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\openmpf";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\openmpf"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
