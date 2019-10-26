package study.smell;

import java.util.ArrayList;
import java.util.List;

import org.designroleminer.MetricReport;
import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.FilterSmells;
import org.designroleminer.smelldetector.model.FilterSmellResult;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.designroleminer.threshold.ArchitecturalRoleTechnique;
import org.designroleminer.threshold.DesignRoleTechnique;
import org.designroleminer.threshold.TechniqueExecutor;

public class FilterSmellSimple {

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "smell\\";
		TechniqueExecutor executor = new TechniqueExecutor(new DesignRoleTechnique());

		System.out.println("Iniciando a coleta de métricas do projeto a ser analisado...");
		ArrayList<String> projetosAnalisar = executor.lerProjetos("AnalysisSimple.txt");
		MetricReport metricasProjetosAnalisar = executor.getMetricsFromProjects(projetosAnalisar, PASTA_RESULTADO,
				true);

		System.out.println("Gerando DR.csv com a lista classes e design roles atribuídos...");
		executor.execute(metricasProjetosAnalisar.all(), System.getProperty("user.dir") + "\\results\\DR.CSV");

		System.out.println("Gerando AR.csv com a lista classes e design roles atribuídos...");
		executor.setTechinique(new ArchitecturalRoleTechnique());
		executor.execute(metricasProjetosAnalisar.all(), System.getProperty("user.dir") + "\\results\\AR.CSV");

		System.out.println("Carregando valores limiares...");
		List<LimiarTecnica> listaTecnicas = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\web2019\\");

		System.out.println("Gerando SMELLS.csv com a lista de problemas de design encontrados...");
		FilterSmellResult result = FilterSmells.filtrar(metricasProjetosAnalisar.all(), listaTecnicas, "HEAD");
		FilterSmells.gravarMetodosSmell(result.getMetodosSmell(), "\\results\\SMELLS.csv");
	}
}
