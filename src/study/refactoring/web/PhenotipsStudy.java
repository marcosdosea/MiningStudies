package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class PhenotipsStudy {

	static Logger logger = LoggerFactory.getLogger(PhenotipsStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\phenotips";
		String urlRepository = "https://github.com/phenotips/phenotips.git";
		String initialCommit = "7c210afb0c146565564d879025c4b268f334ce38"; // phenotips-1.0 - 2014.10.07
		String finalCommit = "43659dfc02e7786fb4f05fb4bdd423b1b46ed1ff"; // phenotips-1.4.9 - 2019.07.30
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\phenotips";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\phenotips"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
