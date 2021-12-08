package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class WebAnnoStudy {

	static Logger logger = LoggerFactory.getLogger(WebAnnoStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\webanno";
		String urlRepository = "https://github.com/webanno/webanno.git";
		String initialCommit = "4825d913ba9b3250594738cd81779ed0c339c343"; // webanno-2.0.0 - 2014-07-30
		String finalCommit = "4ac3ee90460e0bd75e6668dbdd45d56e72fceae6"; // webanno-4.0.0 - 2020.05.13
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\webanno";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\webanno"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
