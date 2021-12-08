package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class PhonographStudy {

	static Logger logger = LoggerFactory.getLogger(PhonographStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\Phonograph";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\Phonograph";
		String urlRepository = "https://github.com/fossasia/pslab-android.git";
		String finalCommit = "5b7e8d8f8cfd6e0a0a0e848ec473044f5d46392e"; // v1.3.4 - 2020.06.30
		String initialCommit = "3430a85ee9207eaa36b3ac195f39f117001969e0"; // v1.0 - 2018.05.01
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\Phonograph"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
