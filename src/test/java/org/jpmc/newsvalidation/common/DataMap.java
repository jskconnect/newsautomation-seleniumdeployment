package org.jpmc.newsvalidation.common;

import java.util.HashMap;

public class DataMap {

	public static HashMap<String, String> map = new HashMap<String, String>();
	public String k;
	public String v;
	
	public static void putData(String k, String v) throws Exception {
		map.put(k, v);
		
	}
	
	public static void getData(String k) throws Exception {
		map.get(k);
	}
	
	
	
}
