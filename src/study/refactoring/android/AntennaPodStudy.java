package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class AntennaPodStudy {

	static Logger logger = LoggerFactory.getLogger(AntennaPodStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\AntennaPod";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\AntennaPod";
		String urlRepository = "https://github.com/AntennaPod/AntennaPod.git";
		String finalCommit = "6e6a64f5024e09c42dc0710090a1fa4cbaa21372"; // 1.8.1 - 2020.02.05
		String initialCommit = "c9e8af52c24b405c65fc9220a6c5c573574df672"; // 1.0.0 - 2015.08.30
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\AntennaPod"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
