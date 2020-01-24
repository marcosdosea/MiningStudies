package study.refactoring.web;

import java.util.List;

import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.SmellRefactoredManager2;

public class ProjectForgeStudy {

	static Logger logger = LoggerFactory.getLogger(ProjectForgeStudy.class);

	public static void main(String[] args) {

		String localFolder = "D:\\Projetos\\_Web\\projectforge";
		String urlRepository = "https://github.com/micromata/projectforge.git";
		String initialCommit = "2277a49e0047a76d254e8c56815b23fe70157cf1"; // 6.1.1 - 2016.07.27
		String finalCommit = "92152514b467de58c73d1371f8fb9215a577a20a"; // 6.25.0 - 2019.03.08
		String resultFile= System.getProperty("user.dir") + "\\refactoring\\projectforge";

		List<LimiarTecnica> listThresholdsTechiniques = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\");

		listThresholdsTechiniques.addAll(
				CarregaSalvaArquivo.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2020\\projectforge"));

		SmellRefactoredManager2 manager = new SmellRefactoredManager2(urlRepository, localFolder, initialCommit,
				finalCommit, listThresholdsTechiniques, resultFile);
		manager.getSmellRefactoredMethods();
	}
}
