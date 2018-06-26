package com.guocai.test;

import java.util.*;

/**
 * java类简单作用描述
 *
 * @ProjectName: J2EE
 * @Package: com.guocai.test
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/20 15:48
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class Demo {

	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("a","A");
		map.put("b","B");
		map.put("c","C");
		map.put("d","D");
		System.out.println("HelloWorld!!!!");
		System.out.println("the BEAUTIFUL");
		System.out.println("");

		for (Map.Entry<String,String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "" + entry.getValue());
		}

		List<String> list = new ArrayList<String>();
		list.add("AA");
		list.add("BB");

		int a = 5;
		int b = 6;
		int c = a+b;

		System.out.println(c);

		while (true) {
			synchronized (new Object()) {
				System.out.println("The is World is very Grace");
			}
		}

	}

}
