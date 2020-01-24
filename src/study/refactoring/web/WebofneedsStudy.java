package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager2;

public class WebofneedsStudy {

	static Logger logger = LoggerFactory.getLogger(WebofneedsStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\webofneeds";
		String urlRepository = "https://github.com/researchstudio-sat/webofneeds.git";
		String initialCommit = "13cfee5bcce45dcab53f26bfdd9288bfc0929848"; // 0.1 - 2014.12.19
		String finalCommit = "8543b0dc2702a89ba683069fe01d35c1ed0acf30"; // webofneeds-0.6 - 2019.10.23
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\webofneeds";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\webofneeds"));

		SmellRefactoredManager2 manager = new SmellRefactoredManager2(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
