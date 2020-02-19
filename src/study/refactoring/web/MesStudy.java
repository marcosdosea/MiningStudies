package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class MesStudy {

	static Logger logger = LoggerFactory.getLogger(MesStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\mes";
		String urlRepository = "https://github.com/qcadoo/mes.git";
		String initialCommit = "508218fd7a5577b7883a091354a38c4bb3f27a1f"; // 1.1.0 - 2011.11.23
		String finalCommit = "c862e9e8ca1158d5e5a6288520be9ddb5adf132c"; // 1.10.20 - 2019.10.03
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\mes";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\mes"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
