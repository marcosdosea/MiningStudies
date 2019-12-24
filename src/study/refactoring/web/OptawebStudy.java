package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager;

public class OptawebStudy {

	static Logger logger = LoggerFactory.getLogger(OptawebStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\optaweb-vehicle-routing";
		String urlRepository = "https://github.com/kiegroup/optaweb-vehicle-routing.git";
		String initialCommit = "37b23c4c07cdcef49715ffd8fe827a9746c38f2f"; // 7.25.0.Final - 2019.09.07
		String finalCommit = "dbbfa5f5abe7e0d80a77a2b9a2e6fc68607b20f2"; // 7.29.0.Final - 2019.10.30
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\optaweb-vehicle-routing";
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");
	
		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\optaweb-vehicle-routing"));

		SmellRefactoredManager manager = new SmellRefactoredManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
