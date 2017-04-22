package com.hnisi.basic;

import java.io.File;

public class MavenPOMGeneratorTest {

	public static void main(String[] args) {
		String path = "D://hnisi/workspace/basicpt/WebRoot/WEB-INF/lib";

		File file = new File(path);
		File[] tempList = file.listFiles();
		System.out.println("该目录下对象个数：" + tempList.length);

		for (int i = 0; i < tempList.length; i++) {

			if (tempList[i].isFile()) {
				String jarName = tempList[i].getName();
				//System.out.println("文     件：" + jarName);
				String[] j = jarName.split("-");
				if (j.length > 1) {
					System.out.print("artifactId:"+ j[0] + " ");
					System.out.println("version:" + j[1]);
				}
			}
		}
	}
}
