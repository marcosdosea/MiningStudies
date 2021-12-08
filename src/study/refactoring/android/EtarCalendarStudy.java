package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class EtarCalendarStudy {

	static Logger logger = LoggerFactory.getLogger(EtarCalendarStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\Etar-Calendar";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\Etar-Calendar";
		String urlRepository = "https://github.com/Etar-Group/Etar-Calendar.git";
		String finalCommit = "79a1fff00755dcfe8e9c4ff67ee271c807dd466b"; // v1.0.20 - 2020.01.29
		String initialCommit = "3951dea3db10e35318e5d555dfd43176b9b0189c"; // v1.0.8 - 2016.12.18
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\Etar-Calendar"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
