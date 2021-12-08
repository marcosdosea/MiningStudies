package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class DroolsWBStudy {

	static Logger logger = LoggerFactory.getLogger(DroolsWBStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\drools-wb";
		String urlRepository = "https://github.com/kiegroup/drools-wb.git";
		String initialCommit = "8dd1e3c5de4b4676e10e1e42a666b753c4df2119"; // 6.0.0.Final - 2013.11.19
		String finalCommit = "4c0285f3a99c96a84d96a30e33037a4da9643ff4"; // 7.38.0.Final - 2020.05.25
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\drools-wb";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\drools-wb"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
