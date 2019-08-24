package study.smell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.designroleminer.ClassMetricResult;
import org.designroleminer.smelldetector.CarregaSalvaArquivo;
import org.designroleminer.smelldetector.FilterSmells;
import org.designroleminer.smelldetector.model.DadosMetodoSmell;
import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.designroleminer.threshold.ArchitecturalRoleTechnique;
import org.designroleminer.threshold.DesignRoleTechnique;
import org.designroleminer.threshold.TechniqueExecutor;

import com.github.mauricioaniche.ck.MethodData;

public class FilterSmellSimple {

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "smell\\";
		TechniqueExecutor executor = new TechniqueExecutor(new DesignRoleTechnique());

		System.out.println("Iniciando a coleta de métricas do projeto a ser analisado...");
		ArrayList<String> projetosAnalisar = executor.lerProjetos("AnalysisSimple.txt");
		ArrayList<ClassMetricResult> metricasProjetosAnalisar = executor.getMetricsFromProjects(projetosAnalisar, PASTA_RESULTADO);

		System.out.println("Gerando DR.csv com a lista classes e design roles atribuídos...");
		executor.execute(metricasProjetosAnalisar, System.getProperty("user.dir") + "\\results\\simple\\DR.CSV");

		System.out.println("Gerando AR.csv com a lista classes e design roles atribuídos...");
		executor.setTechinique(new ArchitecturalRoleTechnique());
		executor.execute(metricasProjetosAnalisar, System.getProperty("user.dir") + "\\results\\\\simple\\AR.CSV");

		System.out.println("Carregando valores limiares...");
		List<LimiarTecnica> listaTecnicas = CarregaSalvaArquivo
				.carregarLimiares(System.getProperty("user.dir") + "\\thresholds\\2019\\");

		System.out.println("Gerando SMELLS.csv com a lista de problemas de design encontrados...");
		HashMap<String, DadosMetodoSmell> metodosSmell = null;
		HashSet<MethodData> metodosSmelly = null;
		metodosSmell = FilterSmells.filtrar(metricasProjetosAnalisar, listaTecnicas, metodosSmell, metodosSmelly);
		FilterSmells.gravarMetodosSmell(metodosSmell, "\\results\\simple\\SMELLS.csv");
	}
}
