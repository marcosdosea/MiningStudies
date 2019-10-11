package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager;
import org.smellrefactored.SmellRefactoredResult;

public class SlackApiStudy {

	static Logger logger = LoggerFactory.getLogger(SlackApiStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\slack-api";
		String urlRepository = "https://github.com/allbegray/slack-api.git";
		String initialCommit = "26f7c03a6e2c7554587c65f7827c6f3f540d35b7"; // 1.0.2 - 2015.11.05
		String finalCommit = "dee2d67b162fbbe8519d6c1551ce5c66edf427f7"; // 1.7.0 - 2018.11.15

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2019\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2019\\slack-api"));
		SmellRefactoredResult result = SmellRefactoredManager.getSmellRefactoredBetweenCommit(urlRepository,
				localFolder, initialCommit, finalCommit, listThresholdsTechiniques);
		SmellRefactoredManager.storeResult(result,
				System.getProperty("user.dir") + "\\refactoring\\refactored-slack-api.csv", false);
	}
}
