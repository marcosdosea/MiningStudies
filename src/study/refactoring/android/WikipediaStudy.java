package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class WikipediaStudy {

	static Logger logger = LoggerFactory.getLogger(WikipediaStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\apps-android-wikipedia";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\apps-android-wikipedia";
		String urlRepository = "https://github.com/wikimedia/apps-android-wikipedia.git";
		String finalCommit = "ad6ff73390d5329bc61ff80fb0e44da5de8efa0b"; // latest - 2020.02.18
		String initialCommit = "e720d87faf11dbe75de6390f0eef9477af3e6c0b"; // 2.0 - 2015.03.23
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\apps-android-wikipedia"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
