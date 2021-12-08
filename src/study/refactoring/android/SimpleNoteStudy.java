package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class SimpleNoteStudy {

	static Logger logger = LoggerFactory.getLogger(SimpleNoteStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\simplenote-android";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\simplenote-android";
		String urlRepository = "https://github.com/Automattic/simplenote-android.git";
		String finalCommit = "50e5b5d586efb4bddbe8ced75eb35bdca8207e5c"; // 2.7.1 - 2020.06.30
		String initialCommit = "7926fb83153ad4dca7ef89c9b282d5e69ff1bec4"; // 1.0.0 - 2013.09.06
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\simplenote-android"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
