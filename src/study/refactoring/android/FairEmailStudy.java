package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class FairEmailStudy {

	static Logger logger = LoggerFactory.getLogger(FairEmailStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\FairEmail";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\FairEmail";
		String urlRepository = "https://github.com/M66B/FairEmail.git";
		String finalCommit = "c1f95b261b594a0dc05c7ad9cff5fc83ef434486"; // 1.971 - 2020.02.16
		String initialCommit = "163bc9f5a1f629336e46e23df25975a73cac90b1"; // 1.74 - 2018.09.30
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\FairEmail"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
