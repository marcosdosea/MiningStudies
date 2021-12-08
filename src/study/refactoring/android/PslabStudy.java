package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class PslabStudy {

	static Logger logger = LoggerFactory.getLogger(PslabStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\pslab-android";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\pslab-android";
		String urlRepository = "https://github.com/fossasia/pslab-android.git";
		String finalCommit = "8bd5fdf38903a69e43ebb962acb2b227e2b1b38e"; // v2.0.20 - 2019.10.18
		String initialCommit = "50408c377dc75a21394776bac6ad5116e3b81c95"; // v2.0.0 - 2018.08.05
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\pslab-android"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
