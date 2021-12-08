package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class BonitaWebStudy {

	static Logger logger = LoggerFactory.getLogger(BonitaWebStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\bonita-web";
		String urlRepository = "https://github.com/bonitasoft/bonita-web.git";
		String initialCommit = "0d17b82f8e2819b671bd342b0a8d6ea4304247b7"; // 6.0.3 - 2013.08.01
		String finalCommit = "8587d679294e628c5cc515ff88535316c62d85ec"; // 7.11.0 - 2020.06.04
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\bonita-web";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\bonita-web"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
