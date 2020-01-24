package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager2;

public class WebprotegeStudy {

	static Logger logger = LoggerFactory.getLogger(WebprotegeStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\webprotege";
		String urlRepository = "https://github.com/protegeproject/webprotege.git";
		String initialCommit = "ced8c5a2e522dbd590d01c46296f3ed0528e6573"; // 2.5.0 - 2014.07.08
		String finalCommit = "945c863ff39c349b61087fa0fdfe0238584c2a6e"; // 4.0.0-beta-2 - 2019.08.12
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\webprotege";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\webprotege"));

		SmellRefactoredManager2 manager = new SmellRefactoredManager2(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
