package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class BastillionStudy {

	static Logger logger = LoggerFactory.getLogger(BastillionStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\Bastillion";
		String urlRepository = "https://github.com/bastillion-io/Bastillion.git";
		String initialCommit = "eabc7cdecc1641db317a3d91021c9d2ee17cfa36"; // v1.08.20 - 2013.06.29
		String finalCommit = "897c48415243a5544a3d2901254ea7a9fc76f2df"; // v3.10.00 - 2020.05.23
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\Bastillion";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\Bastillion"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
