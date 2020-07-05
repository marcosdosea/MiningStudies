package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class VivoStudy {

	static Logger logger = LoggerFactory.getLogger(VivoStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\vivo";
		String urlRepository = "https://github.com/vivo-project/VIVO.git";
		String initialCommit = "7256c3c8818072f5ff489edbb16bbe64d830cdda"; // 0.9 - 2010.01.29
		String finalCommit = "cad6a66f396786312d6cbc3968b8d8b35d875427"; // vivo-1.11.1 - 2020.03.07
		
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\vivo";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\vivo"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
