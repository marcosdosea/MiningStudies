package study.refactoring;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager;
import org.smellrefactored.SmellRefactoredResult;

public class SmsBackupStudy {

	static Logger logger = LoggerFactory.getLogger(SmsBackupStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\sms-backup-plus";
		String urlRepository = "https://github.com/jberkel/sms-backup-plus.git";
		String initialCommit = "9a3a27418362c157aa79f160302c41a2c0cc67c5";
		String finalCommit = "12390bc25c2e4e6355ccd04e6b13dfdb689bdf2b";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\simple\\");

		SmellRefactoredResult result = SmellRefactoredManager.getSmellRefactoredBetweenCommit(urlRepository,
				localFolder, initialCommit, finalCommit, listThresholdsTechiniques);

		SmellRefactoredManager.storeResult(result,
				System.getProperty("user.dir") + "\\refactoring\\refactored-sms.csv");
	}

}
