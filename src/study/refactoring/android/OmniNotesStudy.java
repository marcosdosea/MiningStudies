package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class OmniNotesStudy {

	static Logger logger = LoggerFactory.getLogger(OmniNotesStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\Omni-Notes";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\Omni-Notes";
		String urlRepository = "https://github.com/federicoiosue/Omni-Notes.git";
		String finalCommit = "68d074acc7e3e8acda7709b88f007820e81923cd"; // 6.0.5 - 2019.11.17
		String initialCommit = "ed135ce9291d60a9cbddc4c68f5a2e842ef0dc1f"; // 3.0.0 - 2013.11.13
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\Omni-Notes"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
