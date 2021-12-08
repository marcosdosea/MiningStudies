package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class VanillaStudy {

	static Logger logger = LoggerFactory.getLogger(VanillaStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\vanilla";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\vanilla";
		String urlRepository = "https://github.com/vanilla-music/vanilla.git";
		String finalCommit = "3c58f77bddb04d3b50d5173ac49a05339c9ba61f"; // 1.0.84 - 2019.09.08
		String initialCommit = "28051cf4507cdd65468c0b4468817f8f919ea4ad"; // 1.0.0 - 2015.05.04
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\vanilla"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
