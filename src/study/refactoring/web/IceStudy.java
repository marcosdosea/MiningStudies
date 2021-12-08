package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class IceStudy {

	static Logger logger = LoggerFactory.getLogger(IceStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\ice";
		String urlRepository = "https://github.com/JBEI/ice.git";
		String initialCommit = "b3f9a0784b9a61ad713675aac3543e0035345e85"; // 3.3 - 2013-04-01
		String finalCommit = "fe2b16d3ceea866114cf0653f68a999d84405df9"; // 5.6.3 - 2019.12.16
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\ice";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\ice"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
