package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager2;

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

		SmellRefactoredManager2 manager = new SmellRefactoredManager2(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
