package org.jpmc.newsvalidation.common;

import java.util.HashMap;

public class Page {

	public static void sleep(String seconds) throws Exception {
		try {
			Thread.sleep(Integer.parseInt(seconds));

		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public HashMap<String, String> getData(String a, String b) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put(a, b);
		return map;
	}

	
	
}
