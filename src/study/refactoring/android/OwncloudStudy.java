package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class OwncloudStudy {

	static Logger logger = LoggerFactory.getLogger(OwncloudStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\owncloud";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\owncloud";
		String urlRepository = "https://github.com/AntennaPod/AntennaPod.git";
		String finalCommit = "fe23fedb417ee214f952889b7cfc3915e521e538"; // 2.14.2 - 2020.01.27
		String initialCommit = "7c8a60c1c35e580ae4d1ba0efb2b19f4f5d081c7"; // 2.0.1 - 2016.06.08
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\owncloud"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
