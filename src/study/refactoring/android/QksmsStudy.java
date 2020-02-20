package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class QksmsStudy {

	static Logger logger = LoggerFactory.getLogger(QksmsStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\qksms";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\qksms";
		String urlRepository = "https://github.com/moezbhatti/qksms.git";
		String finalCommit = "9dfc9129613b0526c9b9d0fe00dc9956dd3c3fed"; // v3.8.1 - 2020.01.27
		String initialCommit = "fb4a6ae43682b88c73976061e8ef180554a307ca"; // v2.1.0- 2015.09.01
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\qksms"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
