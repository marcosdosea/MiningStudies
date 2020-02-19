package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class HawtioStudy {

	static Logger logger = LoggerFactory.getLogger(HawtioStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\hawtio";
		String urlRepository = "https://github.com/hawtio/hawtio.git";
		String initialCommit = "55190623626bd0e892c4e6d4bc0838ac62bfdeb1"; // 1.0.0 - 2013.03.05
		String finalCommit = "932eea9587a5daeb6d22e06a96491ba6513584dd"; // 2.8.0 - 2019.10.17
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\hawtio";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\hawtio"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
