package study.refactoring.android;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredAllManager;

public class BitcoinStudy {

	static Logger logger = LoggerFactory.getLogger(BitcoinStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\bitcoin-wallet";
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\bitcoin-wallet";
		String urlRepository = "https://github.com/bitcoin-wallet/bitcoin-wallet.git";
		String finalCommit = "4692a94e8d2a0229b60daf5c05a5ee842d5b89a0"; // v7.54 - 2020.02.07
		String initialCommit = "104d54017c9185f4e34a54e2a9c806428c0bea65"; // v2.46 - 2013.03.19
		
		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\android2020\\bitcoin-wallet"));

		SmellRefactoredAllManager manager = new SmellRefactoredAllManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
