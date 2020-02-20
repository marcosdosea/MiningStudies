package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class HavenStudy {

	static Logger logger = LoggerFactory.getLogger(HavenStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\haven";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\haven";
		String urlRepository = "https://github.com/guardianproject/haven.git";
		String finalCommit = "9e929bb1eb7ca79981ba5d548bf135e054789bd4"; // 0.2.0-RC-1 - 2019.12.07
		String initialCommit = "8d4c48ef728415d8f50fadca7a0ed26116c7cc46"; // 0.0.11 - 2017.10.30
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\haven"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
