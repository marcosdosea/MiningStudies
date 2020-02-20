package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class SlideStudy {

	static Logger logger = LoggerFactory.getLogger(SlideStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\Slide";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\Slide";
		String urlRepository = "https://github.com/ccrama/Slide.git";
		String finalCommit = "57af904626d512972a93e88108cb0549baa5b051"; // 6.0.1 - 2018.11.30
		String initialCommit = "46b58c8a67b9a664304b5128ad90ed627964b77b"; // 5.3.6 - 2016.05.09
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\Slide"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
