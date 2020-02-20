package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class AmazeFileManagerStudy {

	static Logger logger = LoggerFactory.getLogger(AmazeFileManagerStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\AmazeFileManager";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\AmazeFileManager";
		String urlRepository = "https://github.com/TeamAmaze/AmazeFileManager.git";
		String finalCommit = "04d29df740931bf5322fc2db4c831fe7b55ba3fb"; // v3.4.3 - 2020.02.14
		String initialCommit = "0c2673d86e7d18164f16ffdd3968f1da59edfb39"; // v1.1 - 2014.12.03
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\AmazeFileManager"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
