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

		try {
			Repository repo = gitService.cloneIfNotExists("D:\\Projetos\\_Android\\sms-backup-plus",
					"https://github.com/jberkel/sms-backup-plus.git");
			final PersistenceMechanism pm = new CSVFile(System.getProperty("user.dir") + "\\refactoring-sms.csv");
			pm.write(
					"Commmit-name", "Refactring-name", "Refactoring-Type", "Code Element Left", "Code Element Right", "Class After", "Class Before", "Short Message", "Full Message");

			miner.detectBetweenTags(repo, "1.5.2", "1.5.5", new RefactoringHandler() {
				@Override
				public void handle(RevCommit commitData, List<Refactoring> refactorings) {
					//System.out.println("Refactorings at " + commitData.getId().getName());
					for (Refactoring ref : refactorings) {
						pm.write(commitData.getId().getName(), 
								 ref.getName(),
								 ref.getRefactoringType(), 
								 ref.leftSide().size() > 0 ? ref.leftSide().get(0).getCodeElement() : 0 ,
								 ref.rightSide().size() > 0 ? ref.rightSide().get(0).getCodeElement() : 0 ,
								 ref.getInvolvedClassesAfterRefactoring(),
								 ref.getInvolvedClassesBeforeRefactoring(),
								 commitData.getShortMessage(),
								 commitData.getFullMessage());
					}
				}
			});
		} catch (Exception e) {
			// System.out.println(e.printStackTrace());
		}

	}

}
