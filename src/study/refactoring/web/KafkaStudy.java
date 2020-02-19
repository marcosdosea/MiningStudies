package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class KafkaStudy {

	static Logger logger = LoggerFactory.getLogger(KafkaStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\kafka-webview";
		String urlRepository = "https://github.com/SourceLabOrg/kafka-webview.git";
		String initialCommit = "256efabbd913f5a3ac76907569d41ed6a5a42b47"; // 1.0.0 - 2018.01.06
		String finalCommit = "bc038be255455438626270ee64a2569d29adfefd"; // 2.5.0 - 2019.11.18
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\kafka-webview";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\kafka-webview"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
