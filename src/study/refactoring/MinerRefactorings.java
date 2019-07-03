package study.refactoring;

import java.util.List;

import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.refactoringminer.api.GitHistoryRefactoringMiner;
import org.refactoringminer.api.GitService;
import org.refactoringminer.api.Refactoring;
import org.refactoringminer.api.RefactoringHandler;
import org.refactoringminer.rm1.GitHistoryRefactoringMinerImpl;
import org.refactoringminer.util.GitServiceImpl;
import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.persistence.csv.CSVFile;

public class MinerRefactorings {

	public static void main(String[] args) {
		GitService gitService = new GitServiceImpl();
		GitHistoryRefactoringMiner miner = new GitHistoryRefactoringMinerImpl();

		String pastaProjeto = "D:\\Projetos\\_Android\\sms-backup-plus";
		String commitInicial = "9a3a27418362c157aa79f160302c41a2c0cc67c5";
		String commitFinal = "12390bc25c2e4e6355ccd04e6b13dfdb689bdf2b";


		try {

			Repository repo = gitService.cloneIfNotExists(pastaProjeto,
					"https://github.com/jberkel/sms-backup-plus.git");

			final PersistenceMechanism pm = new CSVFile(System.getProperty("user.dir") + "\\refactoring-sms.csv");
			pm.write("Commmit-name", "Refactring-name", "Refactoring-Type", "Code Element Left", "Code Element Right",
					"Class After", "Class Before", "Short Message", "Full Message");

			miner.detectBetweenCommits(repo, commitInicial, commitFinal, new RefactoringHandler() {
				@Override
				public void handle(RevCommit commitData, List<Refactoring> refactorings) {

					// RefactoringData data;
					// System.out.println("Refactorings at " + commitData.getId().getName());
					for (Refactoring ref : refactorings) {
						pm.write(commitData.getId().getName(), ref.getName(), ref.getRefactoringType(),
								// ref.leftSide().size() > 0 ? ref.leftSide().get(0).getCodeElement() : 0 ,
								// ref.rightSide().size() > 0 ? ref.rightSide().get(0).getCodeElement() : 0 ,
								ref.getInvolvedClassesAfterRefactoring(), ref.getInvolvedClassesBeforeRefactoring(),
								commitData.getShortMessage(), commitData.getFullMessage());
						// data = new RefactoringData();
						// data.setCommit(commitData.getId().getName());
						// data.setRefactoringName(ref.getName());
						// data.setRefactoringType(ref.getRefactoringType().toString());
						// data.setLeftSide(ref.leftSide().size() > 0 ?
						// ref.leftSide().get(0).getCodeElement() : "");
						// data.setRightSide(ref.rightSide().size() > 0 ?
						// ref.rightSide().get(0).getCodeElement() : "");
						// data.setInvolvedClassesBefore(ref.getInvolvedClassesBeforeRefactoring().toString());
						// data.setInvolvedClassesAfter(ref.getInvolvedClassesAfterRefactoring().toString());
						// data.setShortMessage(commitData.getShortMessage());
						// data.setFullMessage(commitData.getFullMessage());
						// pm.write(data.getCommit(), data.getRefactoringName(),
						// data.getRefactoringType(),
						// data.getLeftSide(), data.getRightSide(), data.getInvolvedClassesBefore(),
						// data.getInvolvedClassesAfter(), data.getShortMessage(),
						// data.getFullMessage());
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
