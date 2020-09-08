package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class RedReaderStudy {

	static Logger logger = LoggerFactory.getLogger(RedReaderStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\RedReader";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\RedReader";
		String urlRepository = "https://github.com/QuantumBadger/RedReader.git";
		String finalCommit = "6b21e0c19db0b66fc7df7055e9ff27eaab8f6dcd"; // v1.11 - 2020.07.01
		String initialCommit = "de15b05493c14d496200f38de33c0f572f6006eb"; // v1.3.5 - 2013.04.06
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\RedReader"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
