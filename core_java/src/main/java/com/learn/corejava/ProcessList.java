package com.learn.corejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

record serviceDetails(String name, String pid, String type, String sessionNumber, Integer memory) {

};

public class ProcessList {

	public static void main(String[] args) {
		try {
			ProcessBuilder processBuilder = new ProcessBuilder("tasklist");
			Process process = processBuilder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			List<serviceDetails> listOfServices = new ArrayList<serviceDetails>();
			while ((line = reader.readLine()) != null) {
				if (line.indexOf("java") > -1) {
					List<String> collect = List.of(line.split(" ")).stream().filter(e -> !e.isEmpty())
							.collect(Collectors.toList());
					listOfServices.add(new serviceDetails(collect.get(0), collect.get(1), collect.get(2),
							collect.get(3), Integer.valueOf(collect.get(4).replaceAll(",", ""))));
				}
			}
			System.out.println(listOfServices);

			process.waitFor();
			reader.close();

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main2(int processID) {

		try {
			Process process = new ProcessBuilder("taskkill", "/F", "/PID", Integer.toString(processID)).start();

			process.waitFor();

			int exitValue = process.exitValue();
			if (exitValue == 0) {
				System.out.println("Process with PID " + processID + " has been successfully killed.");
			} else {
				System.out.println("Failed to kill process with PID " + processID + ".");
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
