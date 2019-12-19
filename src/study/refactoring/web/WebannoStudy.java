package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager;

public class WebannoStudy {

	static Logger logger = LoggerFactory.getLogger(WebannoStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\webanno";
		String urlRepository = "https://github.com/webanno/webanno.git";
		String initialCommit = "b882eafde3e54f2e7cf3ecec04e7c274eadb82bf"; // webanno-1.0.0 - 2013.12.05
		String finalCommit = "abf4483e8de574283d60e7c572b8dbe86326ed0e"; // webanno-3.6.4 - 2019.12.15
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\webanno";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\webofneeds"));

		SmellRefactoredManager manager = new SmellRefactoredManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredBetweenCommit();
	}
}
