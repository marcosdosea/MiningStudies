package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager;
import org.smellrefactored.SmellRefactoredResult;

public class WebBudgetStudy {

	static Logger logger = LoggerFactory.getLogger(WebBudgetStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\web-budget";
		String urlRepository = "https://github.com/arthurgregorio/web-budget.git";
		String initialCommit = "25302694d0d0a81eaf91cddac0d544e5e89f57f7"; // 1.1.0 - 2015.02.23
		String finalCommit = "321e99e30dbbf6d2f1c740967c7b9aaff4841748"; // 3.0.2 - 2019.05.26

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\web-budget"));
		SmellRefactoredResult result = SmellRefactoredManager.getSmellRefactoredBetweenCommit(urlRepository,
				localFolder, initialCommit, finalCommit, listThresholdsTechiniques);
		SmellRefactoredManager.storeResult(result,
				System.getProperty("user.dir") + "\\refactoring\\refactored-webbudget.csv", false);
		
		SmellRefactoredManager.storeResult(result,
				System.getProperty("user.dir") + "\\refactoring\\refactored-webbudget-message.csv", true);
				
	
		SmellRefactoredManager.evaluateStoreResults(result, System.getProperty("user.dir") + "\\refactoring\\refactored-webbudget-evaluation.csv");
	}
}
