package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class WordpressStudy {

	static Logger logger = LoggerFactory.getLogger(WordpressStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\WordPress-Android";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\WordPress-Android";
		String urlRepository = "https://github.com/wordpress-mobile/WordPress-Android.git";
		String finalCommit = "8331479eff89b8e2427bd95280ebb9e9cbc820ea"; // 14.1 - 2020.02.10
		String initialCommit = "bddfa71f80bdb3374bd6c4384df48c676168b5e9"; // 2.8.1 - 2015.12.01
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\WordPress-Android"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
