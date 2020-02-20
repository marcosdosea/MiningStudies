package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class TalonStudy {

	static Logger logger = LoggerFactory.getLogger(TalonStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\talon-for-twitter-android";
		String urlRepository = "https://github.com/klinker-apps/talon-for-twitter-android.git";
		String initialCommit = "aa7542fb20109fb116259635a55ee2d565f460b6"; // 7.3.0 - 2018.06.16
		String finalCommit = "45bdf2f94f60a75fbe30f48cd44d84c86a3e39c1"; // master - 2020.02.09
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\talon-for-twitter-android";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\talon-for-twitter-android"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
