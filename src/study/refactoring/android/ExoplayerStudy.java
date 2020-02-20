package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class ExoplayerStudy {

	static Logger logger = LoggerFactory.getLogger(ExoplayerStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\ExoPlayer";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\ExoPlayer";
		String urlRepository = "https://github.com/google/ExoPlayer.git";
		String finalCommit = "49910fe72579c4e55e14b47b0cf3d3ced9474219"; // 2.11.3 - 2020.02.18
		String initialCommit = "27ab5c83a604407e8649aa4cca1cda0e101b9aab"; // 1.0.10 - 2014.07.16
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\ExoPlayer"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
