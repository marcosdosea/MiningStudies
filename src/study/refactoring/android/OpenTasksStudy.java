package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class OpenTasksStudy {

	static Logger logger = LoggerFactory.getLogger(OpenTasksStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\opentasks";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\opentasks";
		String urlRepository = "https://github.com/dmfs/opentasks.git";
		String finalCommit = "e750aca2d1e6134e165a00d18f732d1ea540507d"; // 1.2.4 - 2020.01.31
		String initialCommit = "03fd00742766bb2b19b2fbc8a336cc3bdf3d8185"; // 1.0.2 - 2013.06.11
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\opentasks"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
