package study.refactoring.web;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class WeasisStudy {

	static Logger logger = LoggerFactory.getLogger(WeasisStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\Weasis";
		String urlRepository = "https://github.com/nroduit/Weasis.git";
		String initialCommit = "84c7519a765bd841cd2d46f53de2e1231ed15ca5"; // 1.0.6 - 2010.11.04
		String finalCommit = "b09647cb8f197cf3a17b85909d1ad56ed6fd701a"; // v3.5.4 - 2019.11.01
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\Weasis";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\Weasis"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
