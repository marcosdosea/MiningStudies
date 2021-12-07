package study.smell;

import java.util.ArrayList;
import java.util.List;

import org.designroleminer.MetricReport;
import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.FilterSmells;
import org.designroleminer.smelldetector.model.FilterSmellResult;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.threshold.TechniqueExecutor;

public class FilterSmellSimple {

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "smell\\";
		TechniqueExecutor executor = new TechniqueExecutor();

		System.out.println("Iniciando a coleta de métricas do projeto a ser analisado...");
		ArrayList<String> projetosAnalisar = executor.lerProjetos("AnalysisSimple.txt");
		MetricReport metricasProjetosAnalisar = executor.getMetricsFromProjects(projetosAnalisar, PASTA_RESULTADO, "efdc59004cd254692aa749fab3b1c35aa6680a9d");

		System.out.println("Gerando DR.csv com a lista classes e design roles atribuídos...");
		executor.saveDesignRoles(metricasProjetosAnalisar.all(), System.getProperty("user.dir") + "\\results\\DR.CSV");

		System.out.println("Gerando AR.csv com a lista classes e design roles atribuídos...");
		executor.saveArchitecturalRoles(metricasProjetosAnalisar.all(),
				System.getProperty("user.dir") + "\\results\\AR.CSV");

		System.out.println("Carregando valores limiares...");
		List<LimiarTecnica> listaTecnicas = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2019\\");

		System.out.println("Gerando SMELLS.csv com a lista de problemas de design encontrados...");
		FilterSmellResult result = FilterSmells.filtrar((MetricReport) metricasProjetosAnalisar.all(), listaTecnicas, "HEAD");
		FilterSmells.gravarMetodosSmellProgramador(result.getMetodosSmell(), System.getProperty("user.dir") + "\\results\\SMELLS.csv");
		FilterSmells.gravarClassesSmellProgramador(result.getClassesSmell(), System.getProperty("user.dir") + "\\results\\SMELLS-classes.csv");
	}
}
