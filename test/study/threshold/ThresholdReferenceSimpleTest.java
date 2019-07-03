package study.threshold;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class ThresholdReferenceSimpleTest {

	@Test
	public void test() {
		String pasta = "D:\\Projetos\\_Android\\sms-backup-plus";
		int lastIndex = pasta.lastIndexOf("\\");
		String nameLastFolder = pasta.substring(lastIndex+1);
		assertEquals("sms-backup-plus", nameLastFolder);
		
		
		String filePathString = pasta + "\\" + nameLastFolder + ".csv";
		File f = new File(filePathString);
		if(f.exists() && !f.isDirectory()) { 
		    assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

}
