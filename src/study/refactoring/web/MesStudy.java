package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class MesStudy {

	static Logger logger = LoggerFactory.getLogger(MesStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\mes";
		String urlRepository = "https://github.com/qcadoo/mes.git";
		String initialCommit = "f2d931c441f8fc8a9ebaa7aaf7cf4ed546060d71"; // 1.9.20 - 2018.11.30
		String finalCommit = "f7f82f5e5f751c9b23e361bb5e0a6757562ceee7"; // 2.1.1 - 2020.05.29
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
