package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class PockethubStudy {

	static Logger logger = LoggerFactory.getLogger(PockethubStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\PocketHub";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\PocketHub";
		String urlRepository = "https://github.com/pockethub/PocketHub.git";
		String finalCommit = "9d490829b944d3a2c77dbd0010ec7a0bfe2efaee"; // 1.9 - 2014.02.20
		String initialCommit = "9b57e85d60d37acac16f62c24145bb105d12ae70"; // 1.0 - 2012.07.09
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\PocketHub"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
