package study.refactoring.android;

import java.util.List;

import org.contextsmell.CarregaSalvaArquivo;
import org.contextsmell.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredFirstManager;

public class SmsBackupStudy {

	static Logger logger = LoggerFactory.getLogger(SmsBackupStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Android\\sms-backup-plus";
		String urlRepository = "https://github.com/jberkel/sms-backup-plus.git";
		String initialCommit = "9c75e5f60abe2d0272fdf965a21c54771aa247c9";
		String finalCommit = "efdc59004cd254692aa749fab3b1c35aa6680a9d";
		String resultFile = System.getProperty("user.dir") + "\\refactoring\\sms";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\simple\\");

		SmellRefactoredFirstManager manager = new SmellRefactoredFirstManager(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
		manager.getSmellRefactoredClasses();
	}

}
