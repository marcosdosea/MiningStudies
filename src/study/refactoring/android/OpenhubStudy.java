package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class OpenhubStudy {

	static Logger logger = LoggerFactory.getLogger(OpenhubStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\OpenHub";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\OpenHub";
		String urlRepository = "https://github.com/dmfs/opentasks.git";
		String finalCommit = "18f883c8420978e1796475a99d6e5b1aa4e86ebe"; // v3.1.0 - 2020.03.01
		String initialCommit = "ed0dadeedf68cf9672133bb78d597f64fb70c210"; // v1.0.0 - 2017.09.05
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\OpenHub"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
