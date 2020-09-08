package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class ShuttleStudy {

	static Logger logger = LoggerFactory.getLogger(ShuttleStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\Shuttle";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\Shuttle";
		String urlRepository = "https://github.com/timusus/Shuttle.git";
		String finalCommit = "ed08889d63a9cb72a61f77764a0f01c35756c532"; // v2.0.17 - 2020.07.12
		String initialCommit = "3707288e037a65b6a8763c7327561fbde9ee971f"; // v1.6.5 - 2017.04.12
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\Shuttle"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
