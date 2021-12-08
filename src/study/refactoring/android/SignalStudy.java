package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class SignalStudy {

	static Logger logger = LoggerFactory.getLogger(SignalStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\Signal-Android";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\Signal-Android";
		String urlRepository = "https://github.com/signalapp/Signal-Android.git";
		String finalCommit = "4ea886d05afbf1ca250cfd2b7a6835748828d6ba"; // 4.56.1 - 2020.02.14
		String initialCommit = "f58f79a4593545278abc5abbf737ca1544544d81"; // 1.0 - 2013.08.16
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\Signal-Android"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
