package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager;

public class BamboobscStudy {

	static Logger logger = LoggerFactory.getLogger(BamboobscStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\bamboobsc";
		String urlRepository = "https://github.com/billchen198318/bamboobsc.git";
		String initialCommit = "8d562bf3635babfe5b7e3ffc41c74e012e770a8c"; // 0.7.6 RELEASE - 2018.12.31
		String finalCommit = "761b8837f7890372ad6523ab44511b51e35b6197"; // 0.7.7 RELEASE - 2019.03.23
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\bamboobsc";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\bamboobsc"));

		SmellRefactoredManager manager = new SmellRefactoredManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredBetweenCommit();
	}
}
