package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class DroolsWBStudy {

	static Logger logger = LoggerFactory.getLogger(DroolsWBStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\drools-wb";
		String urlRepository = "https://github.com/kiegroup/drools-wb.git";
		String initialCommit = "8dd1e3c5de4b4676e10e1e42a666b753c4df2119"; // 6.0.0 - 2013.11.19
		String finalCommit = "564c064a7dede2ad9ea9422feffee2d731f44daf"; // 7.31.0.Final - 2019.12.09
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\aet";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\drools-wb"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
