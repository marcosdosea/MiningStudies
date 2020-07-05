package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class MetlStudy {

	static Logger logger = LoggerFactory.getLogger(MetlStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\metl";
		String urlRepository = "https://github.com/JumpMind/metl.git";
		String initialCommit = "e93109a94bf069776ee422657be1bc825c163017"; // 1.0.0 - 2016.01.22
		String finalCommit = "84cca413c3e5d7c8c27dcc94d10ca7688eea8285"; // 3.6.1.r19 - 2019.12.06
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\metl";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\metl"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
