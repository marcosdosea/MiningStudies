package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class KeepassStudy {

	static Logger logger = LoggerFactory.getLogger(KeepassStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\keepass2android";
		String urlRepository = "https://github.com/PhilippC/keepass2android.git";
		String initialCommit = "c130e9697f6c60b21cc8a4a7ac91900004cd319b"; // 1.0.0 - 2016.08.20
		String finalCommit = "f2ca8460930b37bdfff25875c6e2aa4ca6fac1d1"; // 1.0.7 - 2019.10.21
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\keepass2android";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\keepass2android"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
