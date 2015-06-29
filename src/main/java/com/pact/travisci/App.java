package com.pact.travisci;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Author: Mukta Aphale
 *
 */
public class App {
	private static URLConnection connect(String urlString) {
		try {
			URL url = new URL(urlString);
			URLConnection con = url.openConnection();
			return con;
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	private static String readPage(URLConnection con){
		String pageSource = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String curLine;
			StringBuilder builder = new StringBuilder();
			while((curLine = br.readLine()) != null) {
				builder.append(curLine);
			}
			br.close();
			pageSource = builder.toString();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return pageSource;
	}

	public static String getPageSource(String urlString) {
		URLConnection con = connect(urlString);
		String pageSource = readPage(con);
		return pageSource;
	}

	public static void main(String[] args) {
		System.out.println(getPageSource(args[0]));
	}
}
