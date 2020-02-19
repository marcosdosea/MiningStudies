package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class DxaStudy {

	static Logger logger = LoggerFactory.getLogger(DxaStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\dxa-web-application-java";
		String urlRepository = "https://github.com/sdl/dxa-web-application-java.git";
		String initialCommit = "896ec935e7e99721d2e4dfd7795f4048fc59d8ca"; // 1.7.1 - 2018.02.26
		String finalCommit = "cff539333a0e13f53ed2d17c1ba6ec26cb02c3b0"; // 2.2.1 - 2019.09.19
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\dxa-web-application-java";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\dxa-web-application-java"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
