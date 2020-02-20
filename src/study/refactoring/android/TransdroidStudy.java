package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class TransdroidStudy {

	static Logger logger = LoggerFactory.getLogger(TransdroidStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\transdroid";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\transdroid";
		String urlRepository = "https://github.com/erickok/transdroid.git";
		String finalCommit = "3be3d6548104f38841623cc201656c220814a4c7"; // v2.5.17 - 2020.01.10
		String initialCommit = "de6cf7573c95d85a98a2552752db398056df021b"; // v2.0 - 2013.10.11
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\transdroid"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
