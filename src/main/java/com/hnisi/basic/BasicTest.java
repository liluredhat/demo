package com.hnisi.basic;

import java.util.HashMap;
import java.util.Hashtable;

public class BasicTest {

	public static void main(String[] args) {
		Object key = null;
		//特点：非线程安全的，允许key or value is null
		HashMap map = new HashMap();
		map.put(null, null);
		map.put(null, "value");
		map.put("key", null);
		map.put(key, "value2");
		//map.put("key", "value");
		System.out.println(map.get(null));
		//
		System.out.println(map.get("key"));
		//特点：线程安全的，不允许kv为空
		Hashtable table = new Hashtable();
		table.put("key", "value");
		System.out.println(table.get("key"));
	}
}
