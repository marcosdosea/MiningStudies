package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class KafdropStudy {

	static Logger logger = LoggerFactory.getLogger(KafdropStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\kafdrop";
		String urlRepository = "https://github.com/obsidiandynamics/kafdrop.git";
		String initialCommit = "43e4ec465a0b45fd83e476be521106fee4d51ed7"; // 1.2.1 - 2016.11.18
		String finalCommit = "a6b44e381f0e5b83ef645ac776f64bf92cd1c308"; // 3.26.0 - 2020.06.06
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\kafdrop";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\kafdrop"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
