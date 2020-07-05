package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class NgbStudy {

	static Logger logger = LoggerFactory.getLogger(NgbStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\ngb";
		String urlRepository = "https://github.com/epam/NGB.git";
		String initialCommit = "f4fdadba1fa22dad0492caac941b24f16f069eb7"; // 2.1 - 2017.01.27
		String finalCommit = "340504529fc576eeec92fbae636e437ce486cc4a"; // 2.5.1 - 2017.09.27
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\ngb";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\ngb"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
