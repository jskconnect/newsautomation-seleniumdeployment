package org.jpmc.newsvalidation.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	public static String getConfigProperty(String skeyval) throws IOException {

		Properties props = new Properties();
		String filepath = "src/test/resources/testdata/config.properties";
		FileInputStream fs = new FileInputStream(filepath);
		String cvalue = "";
		try {
			props.load(fs);
			cvalue = props.getProperty(skeyval);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fs.close();
		}

		return cvalue;

	}

}
