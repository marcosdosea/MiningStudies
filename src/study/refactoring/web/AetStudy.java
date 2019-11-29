package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager;

public class AetStudy {

	static Logger logger = LoggerFactory.getLogger(AetStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\aet";
		String urlRepository = "https://github.com/Cognifide/aet.git";
		String initialCommit = "b787aa4d4342673e4195c7567d90895f15720cd3"; // 1.3.2 - 2016.06.09
		String finalCommit = "401b73220c482d44240ed9179f82c2dd88f83552"; // 3.3.0 - 2019.08.19
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\aet";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\aet"));

		SmellRefactoredManager manager = new SmellRefactoredManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredBetweenCommit();
	}
}
