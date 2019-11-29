package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager;

public class BigBlueButtonStudy {

	static Logger logger = LoggerFactory.getLogger(BigBlueButtonStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\bigbluebutton";
		String urlRepository = "https://github.com/bigbluebutton/bigbluebutton.git";
		String initialCommit = "73db36bc9d8ede10e531265809cda62b0e59ae5b"; // 2.0.x-RC2 - 2018.07.07
		String finalCommit = "b7d44d21e6cecf309ee1704dcfef264f2dc57639"; // 2.0.0 - 2019.04.08
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\bigbluebutton";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\bigbluebutton"));

		SmellRefactoredManager manager = new SmellRefactoredManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredBetweenCommit();
	}
}
