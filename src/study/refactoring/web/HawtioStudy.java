package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class HawtioStudy {

	static Logger logger = LoggerFactory.getLogger(HawtioStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\hawtio";
		String urlRepository = "https://github.com/hawtio/hawtio.git";
		String initialCommit = "37923c8d87e228d37409ed8a561597ab620e843f"; // 2.0.m1 - 2017.04.28
		String finalCommit = "8639e48f1ade6911cefb709768a597797f97aea2"; // 2.10.0 - 2020.04.13
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
