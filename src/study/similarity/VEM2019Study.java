package study.similarity;

import java.util.ArrayList;
import java.util.Collection;

import org.designroleminer.ClassMetricResult;
import org.systemsimilarity.SimilarityManager;
import org.threshold.TechniqueExecutor;

public class VEM2019Study {

	private static SimilarityManager gSimilarity = new SimilarityManager();
	private static TechniqueExecutor executor = new TechniqueExecutor();

	public static void main(String[] args) {
		final String PASTA_RESULTADO = "similarity\\";
		System.out.println("Iniciando C�lculo Similaridade 1...");
		Collection<String> listAndroid = new ArrayList<String>();
		listAndroid.add("D:\\Projetos\\_Android\\bitcoin-wallet");
		Collection<ClassMetricResult> bitcoin = executor.getMetricsFromProjects(listAndroid, PASTA_RESULTADO, "")
				.all();

		listAndroid = new ArrayList<String>();
		listAndroid.add("D:\\Projetos\\_Android\\k-9");
		Collection<ClassMetricResult> k9 = executor.getMetricsFromProjects(listAndroid, PASTA_RESULTADO, "").all();

		listAndroid = new ArrayList<String>();
		listAndroid.add("D:\\Projetos\\_Android\\ExoPlayer");
		Collection<ClassMetricResult> exoplayer = executor.getMetricsFromProjects(listAndroid, PASTA_RESULTADO, "").all();

		listAndroid = new ArrayList<String>();
		listAndroid.add("D:\\Projetos\\_Android\\sms-backup-plus");
		Collection<ClassMetricResult> sms = executor.getMetricsFromProjects(listAndroid, PASTA_RESULTADO, "").all();

		listAndroid = new ArrayList<String>();
		listAndroid.add("D:\\Projetos\\_Android\\Talon-for-Twitter");
		Collection<ClassMetricResult> talon = executor.getMetricsFromProjects(listAndroid, PASTA_RESULTADO, "").all();

		Collection<String> listEclipse = new ArrayList<String>();
		listEclipse.add("D:\\Projetos\\_Eclipse\\Activiti-Designer");
		Collection<ClassMetricResult> activiti = executor.getMetricsFromProjects(listEclipse, PASTA_RESULTADO, "").all();

		listEclipse = new ArrayList<String>();
		listEclipse.add("D:\\Projetos\\_Eclipse\\angularjs-eclipse");
		Collection<ClassMetricResult> angularjs = executor.getMetricsFromProjects(listEclipse, PASTA_RESULTADO, "").all();

		listEclipse = new ArrayList<String>();
		listEclipse.add("D:\\Projetos\\_Eclipse\\arduino-eclipse-plugin");
		Collection<ClassMetricResult> arduino = executor.getMetricsFromProjects(listEclipse, PASTA_RESULTADO, "").all();

		listEclipse = new ArrayList<String>();
		listEclipse.add("D:\\Projetos\\_Eclipse\\droolsjbpm-tools");
		Collection<ClassMetricResult> droolsjbpm = executor.getMetricsFromProjects(listEclipse, PASTA_RESULTADO, "").all();

		listEclipse = new ArrayList<String>();
		listEclipse.add("D:\\Projetos\\_Eclipse\\sonarlint-eclipse");
		Collection<ClassMetricResult> sonarlint = executor.getMetricsFromProjects(listEclipse, PASTA_RESULTADO, "").all();

		Collection<String> web = new ArrayList<String>();
		web.add("D:\\Projetos\\_Web\\bigbluebutton");
		Collection<ClassMetricResult> bigbluebutton = executor.getMetricsFromProjects(web, PASTA_RESULTADO, "").all();
		compareSystems("Bigbluebutton", bigbluebutton, bitcoin, k9, exoplayer, sms, talon, activiti, angularjs, arduino,
				droolsjbpm, sonarlint);

		web = new ArrayList<String>();
		web.add("D:\\Projetos\\_Web\\openmrs-core");
		Collection<ClassMetricResult> openmrs = executor.getMetricsFromProjects(web, PASTA_RESULTADO, "").all();
		compareSystems("OpenMRS", openmrs, bitcoin, k9, exoplayer, sms, talon, activiti, angularjs, arduino, droolsjbpm,
				sonarlint);

		web = new ArrayList<String>();
		web.add("D:\\Projetos\\_Web\\heritrix3");
		Collection<ClassMetricResult> heritrix3 = executor.getMetricsFromProjects(web, PASTA_RESULTADO, "").all();
		compareSystems("heritrix3", heritrix3, bitcoin, k9, exoplayer, sms, talon, activiti, angularjs, arduino,
				droolsjbpm, sonarlint);

		web = new ArrayList<String>();
		web.add("D:\\Projetos\\_Web\\qalingo-engine");
		Collection<ClassMetricResult> qalingo = executor.getMetricsFromProjects(web, PASTA_RESULTADO, "").all();
		compareSystems("qalingo", qalingo, bitcoin, k9, exoplayer, sms, talon, activiti, angularjs, arduino, droolsjbpm,
				sonarlint);

		web = new ArrayList<String>();
		web.add("D:\\Projetos\\_Web\\libreplan");
		Collection<ClassMetricResult> libreplan = executor.getMetricsFromProjects(web, PASTA_RESULTADO, "").all();
		compareSystems("libreplan", libreplan, bitcoin, k9, exoplayer, sms, talon, activiti, angularjs, arduino,
				droolsjbpm, sonarlint);
		System.out.println("*********** WEB ************");
		System.out.println(
				"======>>>> BigBlueButton x BigBlueButton: " + gSimilarity.calculate(bigbluebutton, bigbluebutton));
		System.out.println("======>>>> BigBlueButton x OpenMRS: " + gSimilarity.calculate(bigbluebutton, openmrs));
		System.out.println("======>>>> BigBlueButton x Qalingo: " + gSimilarity.calculate(bigbluebutton, qalingo));
		System.out.println("======>>>> BigBlueButton x Heritrix3: " + gSimilarity.calculate(bigbluebutton, heritrix3));
		System.out.println("======>>>> BigBlueButton x Libreplan: " + gSimilarity.calculate(bigbluebutton, libreplan));

		System.out.println("======>>>> OpenMRS x OpenMRS: " + gSimilarity.calculate(openmrs, openmrs));
		System.out.println("======>>>> OpenMRS x Qalingo: " + gSimilarity.calculate(openmrs, qalingo));
		System.out.println("======>>>> OpenMRS x Heritrix3: " + gSimilarity.calculate(openmrs, heritrix3));
		System.out.println("======>>>> OpenMRS x Libreplan: " + gSimilarity.calculate(openmrs, libreplan));

		System.out.println("======>>>> Qalingo x Qalingo: " + gSimilarity.calculate(qalingo, qalingo));
		System.out.println("======>>>> Qalingo x Heritrix3: " + gSimilarity.calculate(qalingo, heritrix3));
		System.out.println("======>>>> Qalingo x Libreplan: " + gSimilarity.calculate(qalingo, libreplan));

		System.out.println("======>>>> Heritrix3 x Heritrix3: " + gSimilarity.calculate(heritrix3, heritrix3));
		System.out.println("======>>>> Heritrix3 x Libreplan: " + gSimilarity.calculate(heritrix3, libreplan));

		System.out.println("======>>>> Libreplan x Libreplan: " + gSimilarity.calculate(libreplan, libreplan));

	}

	private static void compareSystems(String nameWebSystem, Collection<ClassMetricResult> webSystem,
			Collection<ClassMetricResult> bitcoin, Collection<ClassMetricResult> k9,
			Collection<ClassMetricResult> exoplayer, Collection<ClassMetricResult> sms,
			Collection<ClassMetricResult> talon, Collection<ClassMetricResult> activiti,
			Collection<ClassMetricResult> angularjs, Collection<ClassMetricResult> arduino,
			Collection<ClassMetricResult> droolsjbpm, Collection<ClassMetricResult> sonarlint) {

		System.out.println("*********** Android ************");
		System.out.println("======>>>> " + nameWebSystem + " x Bitcoin : " + gSimilarity.calculate(webSystem, bitcoin));
		System.out.println("======>>>> " + nameWebSystem + "  x K9 : " + gSimilarity.calculate(webSystem, k9));
		System.out.println(
				"======>>>> " + nameWebSystem + "  x Exoplayer : " + gSimilarity.calculate(webSystem, exoplayer));
		System.out.println("======>>>> " + nameWebSystem + "  x SMS : " + gSimilarity.calculate(webSystem, sms));
		System.out.println("======>>>> " + nameWebSystem + "  x Talon : " + gSimilarity.calculate(webSystem, talon));
		System.out.println("======>>>> " + nameWebSystem + "  x " + nameWebSystem + " : "
				+ gSimilarity.calculate(webSystem, webSystem));

		System.out.println("******* Eclipse *****");
		System.out.println(
				"======>>>> " + nameWebSystem + "  x Activiti : " + gSimilarity.calculate(webSystem, activiti));
		System.out.println(
				"======>>>> " + nameWebSystem + "  x AngularJS : " + gSimilarity.calculate(webSystem, angularjs));
		System.out
				.println("======>>>> " + nameWebSystem + "  x Arduino : " + gSimilarity.calculate(webSystem, arduino));
		System.out.println(
				"======>>>> " + nameWebSystem + "  x Droolsjbpm : " + gSimilarity.calculate(webSystem, droolsjbpm));
		System.out.println(
				"======>>>> " + nameWebSystem + "  x Sonarlint : " + gSimilarity.calculate(webSystem, sonarlint));

		System.out.println("**** Android x Android ***********");
		System.out.println("======>>>> Bitcoin x Bitcoin: " + gSimilarity.calculate(bitcoin, bitcoin));
		System.out.println("======>>>> Bitcoin x K9: " + gSimilarity.calculate(bitcoin, k9));
		System.out.println("======>>>> Bitcoin x Exoplayer: " + gSimilarity.calculate(bitcoin, exoplayer));
		System.out.println("======>>>> Bitcoin x SMS: " + gSimilarity.calculate(bitcoin, sms));
		System.out.println("======>>>> Bitcoin x Talon: " + gSimilarity.calculate(bitcoin, talon));
		System.out.println("======>>>> K9 X K9: " + gSimilarity.calculate(k9, k9));
		System.out.println("======>>>> K9 X Exoplayer: " + gSimilarity.calculate(k9, exoplayer));
		System.out.println("======>>>> K9 X SMS: " + gSimilarity.calculate(k9, sms));
		System.out.println("======>>>> K9 X Talon: " + gSimilarity.calculate(k9, talon));
		System.out.println("======>>>> Exoplayer X Exoplayer: " + gSimilarity.calculate(exoplayer, exoplayer));
		System.out.println("======>>>> Exoplayer X SMS: " + gSimilarity.calculate(exoplayer, sms));
		System.out.println("======>>>> Exoplayer X Talon: " + gSimilarity.calculate(exoplayer, talon));
		System.out.println("======>>>> SMS X SMS: " + gSimilarity.calculate(sms, sms));
		System.out.println("======>>>> SMS X talon: " + gSimilarity.calculate(sms, talon));
		System.out.println("======>>>> Talon X talon: " + gSimilarity.calculate(talon, talon));

		System.out.println("**** Eclipse x Eclipse ***********");
		System.out.println("======>>>> Activiti x Activiti : " + gSimilarity.calculate(activiti, activiti));
		System.out.println("======>>>> Activiti x AngularJS : " + gSimilarity.calculate(activiti, angularjs));
		System.out.println("======>>>> Activiti x Arduino : " + gSimilarity.calculate(activiti, arduino));
		System.out.println("======>>>> Activiti x Droolsjbpm : " + gSimilarity.calculate(activiti, droolsjbpm));
		System.out.println("======>>>> Activiti x Sonarlint : " + gSimilarity.calculate(activiti, sonarlint));
		System.out.println("======>>>> AngularJS x AngularJS : " + gSimilarity.calculate(angularjs, angularjs));
		System.out.println("======>>>> AngularJS x Arduino : " + gSimilarity.calculate(angularjs, arduino));
		System.out.println("======>>>> AngularJS x Droolsjbpm : " + gSimilarity.calculate(angularjs, droolsjbpm));
		System.out.println("======>>>> AngularJS x Sonarlint : " + gSimilarity.calculate(angularjs, sonarlint));
		System.out.println("======>>>> Arduino x Arduino : " + gSimilarity.calculate(arduino, arduino));
		System.out.println("======>>>> Arduino x Droolsjbpm : " + gSimilarity.calculate(arduino, droolsjbpm));
		System.out.println("======>>>> Arduino x Sonarlint : " + gSimilarity.calculate(arduino, sonarlint));
		System.out.println("======>>>> Droolsjbpm x Droolsjbpm : " + gSimilarity.calculate(droolsjbpm, droolsjbpm));
		System.out.println("======>>>> Droolsjbpm x Sonarlint : " + gSimilarity.calculate(droolsjbpm, sonarlint));
		System.out.println("======>>>> Sonarlint x Sonarlint : " + gSimilarity.calculate(sonarlint, sonarlint));

		System.out.println("**** Android x Eclipse ***********");
		System.out.println("======>>>> k9 x Activiti : " + gSimilarity.calculate(k9, activiti));
		System.out.println("======>>>> k9 x AngularJS : " + gSimilarity.calculate(k9, angularjs));
		System.out.println("======>>>> k9 x Arduino : " + gSimilarity.calculate(k9, arduino));
		System.out.println("======>>>> k9 x Droolsjbpm : " + gSimilarity.calculate(k9, droolsjbpm));
		System.out.println("======>>>> k9 x Sonarlint : " + gSimilarity.calculate(k9, sonarlint));

		System.out.println("======>>>> bitcoin x Activiti : " + gSimilarity.calculate(bitcoin, activiti));
		System.out.println("======>>>> bitcoin x AngularJS : " + gSimilarity.calculate(bitcoin, angularjs));
		System.out.println("======>>>> bitcoin x Arduino : " + gSimilarity.calculate(bitcoin, arduino));
		System.out.println("======>>>> bitcoin x Droolsjbpm : " + gSimilarity.calculate(bitcoin, droolsjbpm));
		System.out.println("======>>>> bitcoin x Sonarlint : " + gSimilarity.calculate(bitcoin, sonarlint));

		System.out.println("======>>>> exoplayer x Activiti : " + gSimilarity.calculate(exoplayer, activiti));
		System.out.println("======>>>> exoplayer x AngularJS : " + gSimilarity.calculate(exoplayer, angularjs));
		System.out.println("======>>>> exoplayer x Arduino : " + gSimilarity.calculate(exoplayer, arduino));
		System.out.println("======>>>> exoplayer x Droolsjbpm : " + gSimilarity.calculate(exoplayer, droolsjbpm));
		System.out.println("======>>>> exoplayer x Sonarlint : " + gSimilarity.calculate(exoplayer, sonarlint));

		System.out.println("======>>>> sms x Activiti : " + gSimilarity.calculate(sms, activiti));
		System.out.println("======>>>> sms x AngularJS : " + gSimilarity.calculate(sms, angularjs));
		System.out.println("======>>>> sms x Arduino : " + gSimilarity.calculate(sms, arduino));
		System.out.println("======>>>> sms x Droolsjbpm : " + gSimilarity.calculate(sms, droolsjbpm));
		System.out.println("======>>>> sms x Sonarlint : " + gSimilarity.calculate(sms, sonarlint));

		System.out.println("======>>>> talon x Activiti : " + gSimilarity.calculate(talon, activiti));
		System.out.println("======>>>> talon x AngularJS : " + gSimilarity.calculate(talon, angularjs));
		System.out.println("======>>>> talon x Arduino : " + gSimilarity.calculate(talon, arduino));
		System.out.println("======>>>> talon x Droolsjbpm : " + gSimilarity.calculate(talon, droolsjbpm));
		System.out.println("======>>>> talon x Sonarlint : " + gSimilarity.calculate(talon, sonarlint));
	}

}
