package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class WebKarmaStudy {

	static Logger logger = LoggerFactory.getLogger(WebKarmaStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\Web-Karma";
		String urlRepository = "https://github.com/usc-isi-i2/Web-Karma.git";
		String initialCommit = "b416e556994ceb200bc6f5af2c19a4f85844e4c9"; // v1.197 - 2013.12.27
		String finalCommit = "ba93c8f021ebf10f78f6052c96ecfa249dc2ebd3"; // v2.3 - 2020.05.29
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\Web-Karma";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\Web-Karma"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
