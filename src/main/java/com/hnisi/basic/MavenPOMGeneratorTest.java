package com.hnisi.basic;

import java.io.File;
/**
 * 
 * @author lilu
 *
 */
public class MavenPOMGeneratorTest {

	public static void main(String[] args) {
		String path = "/Users/lilu/hnisi/temp";

		File file = new File(path);
		File[] tempList = file.listFiles();
		System.out.println("该目录下对象个数：" + tempList.length);

		for (int i = 0; i < tempList.length; i++) {
			
			if (tempList[i].isFile()) {
				String jarName = tempList[i].getName();
				//System.out.println("文     件：" + jarName);
				if(jarName.endsWith(".jar")){
					int beginIndex = jarName.lastIndexOf("-");
					int endIndex = jarName.lastIndexOf(".jar");
					String artifactId = jarName.substring(0, beginIndex);
					String version = jarName.substring(beginIndex+1, endIndex);
					System.out.println("<dependency>");
					System.out.println("  <groupId>com.hnisi</groupId>");
					System.out.println("  <artifactId>"+artifactId+"</artifactId>");
					System.out.println("  <version>"+version+"</version>");
					System.out.println("</dependency>");
				}
			}
		}
	}
}
