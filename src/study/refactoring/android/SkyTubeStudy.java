package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class SkyTubeStudy {

	static Logger logger = LoggerFactory.getLogger(SkyTubeStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\SkyTube";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\SkyTube";
		String urlRepository = "https://github.com/ram-on/SkyTube.git";
		String finalCommit = "3bae84ea36de271f372f1a89db0764c7070aa034"; // v2.970 - 2020.01.26
		String initialCommit = "921a496733b1843b234c2324ddd8a565d967f688"; // v1.0 - 2016.02.24
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\SkyTube"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
