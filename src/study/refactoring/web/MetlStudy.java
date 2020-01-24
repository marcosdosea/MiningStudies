package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager2;

public class MetlStudy {

	static Logger logger = LoggerFactory.getLogger(MetlStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\metl";
		String urlRepository = "https://github.com/JumpMind/metl.git";
		String initialCommit = "e93109a94bf069776ee422657be1bc825c163017"; // 1.0.0 - 2016.01.22
		String finalCommit = "57d3f3879ba4aae3c13504384bf92728a4e33fc1"; // 3.5.1.r15 - 2019.09.10
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\metl";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\metl"));

		SmellRefactoredManager2 manager = new SmellRefactoredManager2(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
