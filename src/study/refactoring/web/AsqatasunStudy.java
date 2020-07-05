package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class AsqatasunStudy {

	static Logger logger = LoggerFactory.getLogger(AsqatasunStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\Asqatasun";
		String urlRepository = "https://github.com/Asqatasun/Asqatasun.git";
		String initialCommit = "ebf86a8466a17021ad9d468a0aa98e8cd1299253"; // 3.0.1 - 2014.04.24
		String finalCommit = "2097219ea1c4 va6d55e52d973161830fb7c337d51"; // v4.1.0 - 2020.04.03
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\Asqatasun";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\Asqatasun"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
