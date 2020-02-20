package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class SmartYoutubeTVStudy {

	static Logger logger = LoggerFactory.getLogger(SmartYoutubeTVStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\SmartYouTubeTV";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\SmartYouTubeTV";
		String urlRepository = "https://github.com/yuliskov/SmartYouTubeTV.git";
		String finalCommit = "a319d28cabe526abe92176bff2a2ad7f530dacc2"; // 6.17.371 - 2020.02.12
		String initialCommit = "5c1a434333fe11442a83dff911a95860277b35bc"; // 6.8.6 - 2017.05.17
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\SmartYouTubeTV"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
