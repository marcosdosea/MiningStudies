package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class WebofneedsStudy {

	static Logger logger = LoggerFactory.getLogger(WebofneedsStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\webofneeds";
		String urlRepository = "https://github.com/researchstudio-sat/webofneeds.git";
		String initialCommit = "9d16bcdd529d9ae2c757957a5b821ff8b1f62d8b"; // webofneeds-0.3 - 2018.09.05
		String finalCommit = "887b3b6852b8e63afe58303c79dfd7c0a75c42da"; // webofneeds-0.9 - 2020.02.17
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\webofneeds";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\webofneeds"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
