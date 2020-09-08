package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class AnExplorerStudy {

	static Logger logger = LoggerFactory.getLogger(AnExplorerStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\AnExplorer";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\AnExplorer";
		String urlRepository = "https://github.com/1hakr/AnExplorer.git";
		String finalCommit = "933fbbd95b050353aee40f618cc6d89a5d7407d6"; // v4.1.1 - 2019.07.11
		String initialCommit = "9128244a33e4cbc36224e01f186d146db929dbc1"; // 3.4 - 2017.01.07
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\AnExplorer"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
