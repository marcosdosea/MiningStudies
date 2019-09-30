package study.refactoring;

import java.util.List;
import java.util.Map;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.DadosMetodoSmell;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.persistence.csv.CSVFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.RefactoringData;
import org.smellrefactored.SmellRefactoredManager;
import org.smellrefactored.SmellRefactoredResult;

import com.github.mauricioaniche.ck.MethodData;

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

		logger.info("Número total de refatorações:" + result.getListRefactoring().size());
		logger.info("Número total de refatorações em Métodos Não Smell: "
				+ result.getListRefactoringsByMethodSmelly().size());
		logger.info("Número total de refatorações em Métodos Smell: " + result.getListRefactoringsByMethod().size());

		final PersistenceMechanism pmRef = new CSVFile(System.getProperty("user.dir") + "\\refactoring-sms.csv");
		pmRef.write("Class", "Method", "Commit", "Smell", "Tecnicas", "Refactoring", "Full Message");

		for (Map.Entry<String, DadosMetodoSmell> entry : result.getSmellsInitial().getMetodosSmell().entrySet()) {
			DadosMetodoSmell smell = entry.getValue();
			String key = smell.getNomeClasse() + smell.getNomeMetodo() + smell.getSmell();
			List<RefactoringData> lista = result.getListRefactoringsByMethod().get(key);
			if (lista != null) {
				for (RefactoringData ref : lista) {
					pmRef.write(smell.getNomeClasse(), smell.getNomeMetodo(), ref.getCommit(), smell.getSmell(),
							smell.getListaTecnicas(), ref.getRefactoringType(), ref.getFullMessage());
				}
			}
		}

		for (MethodData metodo : result.getSmellsInitial().getListaMethodsNotSmelly()) {
			String key = metodo.getNomeClasse() + metodo.getNomeMethod();
			List<RefactoringData> lista = result.getListRefactoringsByMethodSmelly().get(key);
			if (lista != null) {
				for (RefactoringData ref : lista) {
					pmRef.write(metodo.getNomeClasse(), metodo.getNomeMethod(), ref.getCommit(), "", "",
							ref.getRefactoringType(), ref.getFullMessage());
				}
			}
		}

	}

}
