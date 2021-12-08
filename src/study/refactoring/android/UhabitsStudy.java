package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class UhabitsStudy {

	static Logger logger = LoggerFactory.getLogger(UhabitsStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\uhabits";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\uhabits";
		String urlRepository = "https://github.com/iSoron/uhabits.git";
		String finalCommit = "957a5b7c17ff14737253fcee26b8d5ac357aa67e"; // v1.7.11 - 2019.12.29
		String initialCommit = "21a3ab1903777842b657fac94bffd41368ed22c7"; // v1.0.0 - 2016.02.19
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\uhabits"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
