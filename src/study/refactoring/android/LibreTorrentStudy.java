package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class LibreTorrentStudy {

	static Logger logger = LoggerFactory.getLogger(LibreTorrentStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\libretorrent";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\libretorrent";
		String urlRepository = "https://github.com/proninyaroslav/libretorrent.git";
		String finalCommit = "3d3b8bafe6e0071dcf0aa9aa62c1ae69566c94e5"; // 1.9.1 - 2018.12.06
		String initialCommit = "759eb4e8dd44bbb78e9b43f3450d459ced5ec52f"; // 1.0 - 2016.10.18
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\libretorrent"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
