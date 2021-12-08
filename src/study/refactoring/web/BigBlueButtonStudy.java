package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class BigBlueButtonStudy {

	static Logger logger = LoggerFactory.getLogger(BigBlueButtonStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\bigbluebutton";
		String urlRepository = "https://github.com/bigbluebutton/bigbluebutton.git";
		String initialCommit = "68e35c9d722e62892d2e885646a9eab3bf44f77d"; // 2.0.x-RC2 - 2018.07.07
		String finalCommit = "34fea22ccb96abfa09729f5331862eeec3272e2a"; // 2.2.16 - 2020.06.03
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\bigbluebutton";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\bigbluebutton"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
