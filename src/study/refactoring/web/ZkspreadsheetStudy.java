package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class ZkspreadsheetStudy {

	static Logger logger = LoggerFactory.getLogger(ZkspreadsheetStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\zkspreadsheet";
		String urlRepository = "https://github.com/zkoss/zkspreadsheet.git";
		String initialCommit = "153bd00fca262911cb19cbbc8b36dba17cba0c2c"; // 3.0.0 - 2013.11.05
		String finalCommit = "d4a2eaf1dd6955c79f71dc07f6a55925802a9b34"; // 3.9.6 - 2019.11.22
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\zkspreadsheet";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\zkspreadsheet"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
