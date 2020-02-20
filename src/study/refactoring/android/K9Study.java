package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class K9Study {

	static Logger logger = LoggerFactory.getLogger(K9Study.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\k-9";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\k-9";
		String urlRepository = "https://github.com/k9mail/k-9.git";
		String finalCommit = "af7887d20d6d77e591eeb9b38ce2b46038eed143"; // 5.705 - 2020.02.06
		String initialCommit = "7aebe52ed1327420891aabc9c1d9b2f9fa6e3dfd"; // 2.102 - 2009.11.24
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\k-9"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
