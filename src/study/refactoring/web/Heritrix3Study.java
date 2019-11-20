package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager;
import org.smellrefactored.SmellRefactoredResult;

public class Heritrix3Study {

	static Logger logger = LoggerFactory.getLogger(Heritrix3Study.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\heritrix3";
		String urlRepository = "https://github.com/internetarchive/heritrix3.git";
		String initialCommit = "484b3574d751173439fe0ee0426c051fcec98101"; // 3.2.0 - 2018.07.04
		String finalCommit = "c7c6141ee10967c171dcc3dc193973ed0e5d85a8"; // 3.4.0 - 2019.04.18

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\heritrix3"));

		SmellRefactoredManager manager = new SmellRefactoredManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques);
		SmellRefactoredResult result = manager.getSmellRefactoredBetweenCommit(
				System.getProperty("user.dir") + "\\refactoring\\refactored-heritrix3-evaluation.csv");

		// resultado + mensgens do commit
		manager.storeResult(result, System.getProperty("user.dir") + "\\refactoring\\refactored-heritrix3-message.csv",
				true);

	}
}
