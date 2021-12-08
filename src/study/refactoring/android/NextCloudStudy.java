package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class NextCloudStudy {

	static Logger logger = LoggerFactory.getLogger(NextCloudStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\nextcloud";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\nextcloud";
		String urlRepository = "https://github.com/nextcloud/android.git";
		String finalCommit = "e0effa3098dee1252509dbdbb5985f2f5b930efb"; // stable-3.10.1 - 2020.02.05
		String initialCommit = "6af7558a7df4919dd3a3b31c9f110b1c930468f0"; // stable-1.0.0 - 2012.06.16
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\nextcloud"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
