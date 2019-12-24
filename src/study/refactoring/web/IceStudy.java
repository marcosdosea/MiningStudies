package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager;

public class IceStudy {

	static Logger logger = LoggerFactory.getLogger(IceStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\ice";
		String urlRepository = "https://github.com/JBEI/ice.git";
		String initialCommit = "b3f9a0784b9a61ad713675aac3543e0035345e85"; // 3.3 - 2013-04-01
		String finalCommit = "28ee8a76035de05d97116ff483c9ca6229009a07"; // 5.6.0 - 2019.09.11
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\ice";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\ice"));

		SmellRefactoredManager manager = new SmellRefactoredManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
