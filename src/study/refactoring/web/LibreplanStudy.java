package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class LibreplanStudy {

	static Logger logger = LoggerFactory.getLogger(LibreplanStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\libreplan";
		String urlRepository = "https://github.com/LibrePlan/libreplan.git";
		String initialCommit = "0f107b60a55532a890b03afed7bcb3a81cde261b"; // 1.2.1 - 2012.01.19
		String finalCommit = "edf8f775e7dcb7f6c10a5441a87c268ba1f36bae"; // 1.4.1 - 2015.04.14
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\libreplan";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\libreplan"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}

}
