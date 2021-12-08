package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class TelegramStudy {

	static Logger logger = LoggerFactory.getLogger(TelegramStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\Telegram";
		String urlRepository = "https://github.com/DrKLO/Telegram.git";
		String finalCommit = "df90eface5ebd755ea86c3a4eec66fe5b6e29041"; // release-5.15.0_1869 - 2020.02.15
		String initialCommit = "f41b228a111e304c2505a86c7cc8b448eaecaf6f"; // release-5.13.0_1818 - 2019.12.31
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\Telegram";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\Telegram"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
