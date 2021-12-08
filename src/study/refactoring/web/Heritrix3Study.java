package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class Heritrix3Study {

	static Logger logger = LoggerFactory.getLogger(Heritrix3Study.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\heritrix3";
		String urlRepository = "https://github.com/internetarchive/heritrix3.git";
		String initialCommit = "484b3574d751173439fe0ee0426c051fcec98101"; // 3.2.0 - 2018.07.04
		String finalCommit = "ef38dc08c357bcb2353bbfbcd00a2c3370aad9c7"; // 3.4.0-20200518 - 2020.05.18
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\heritrix3";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\heritrix3"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
