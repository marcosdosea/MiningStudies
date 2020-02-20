package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class OpenEventStudy {

	static Logger logger = LoggerFactory.getLogger(OpenEventStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\open-event-organizer-android";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\open-event-organizer-android";
		String urlRepository = "https://github.com/fossasia/open-event-organizer-android.git";
		String finalCommit = "8df1905234aad4f8c37aed9d2aeea46b747a1406"; // v1.7.0 - 2019.09.22
		String initialCommit = "9a741d9e5b921485de9591a4e06c7c4e98e1e36c"; // v1.1.0 - 2019.04.04
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\open-event-organizer-android"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
