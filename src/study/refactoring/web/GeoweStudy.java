package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class GeoweStudy {

	static Logger logger = LoggerFactory.getLogger(GeoweStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\geowe-core";
		String urlRepository = "https://github.com/geowe/geowe-core.git";
		String initialCommit = "e2075f4848084aafabee03f752bd4d4c61831370"; // 1.7.1 - 2018.02.26
		String finalCommit = "a5ac5cfd2cf06484bf44a705d6d050e8ea44f620"; // 2.2.1 - 2019.09.19
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\geowe-core";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\geowe-core"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
