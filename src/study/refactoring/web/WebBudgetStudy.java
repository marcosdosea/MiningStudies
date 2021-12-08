package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class WebBudgetStudy {

	static Logger logger = LoggerFactory.getLogger(WebBudgetStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\web-budget";
		String urlRepository = "https://github.com/arthurgregorio/web-budget.git";
		String initialCommit = "25302694d0d0a81eaf91cddac0d544e5e89f57f7"; // 1.1.0 - 2015.02.23
		String finalCommit = "43fb60e17a0010e0aa4c372e52416a4493ec1cfa"; // 3.0.2 - 2019.05.26
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\webbudget";
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\web-budget"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
