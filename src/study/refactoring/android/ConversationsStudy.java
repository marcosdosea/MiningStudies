package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class ConversationsStudy {

	static Logger logger = LoggerFactory.getLogger(ConversationsStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\Conversations";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\Conversations";
		String urlRepository = "https://github.com/siacs/Conversations.git";
		String finalCommit = "12907a52e3bd159b6e96e64573e9d35d64a68067"; // 2.7.0 - 2020.02.19
		String initialCommit = "b5131bbd76b5f63a6d58d4b07e421065c1aa712c"; // 1.0.0 - 2015.02.01
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\Conversations"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
