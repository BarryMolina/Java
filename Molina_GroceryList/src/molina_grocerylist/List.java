/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molina_grocerylist;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author barrymolina
 */
public class List {

	private String filename;
	private ArrayList<String> items = new ArrayList<>();

	Scanner keyboard = new Scanner(System.in);

	public List(String file) {
		filename = file;
	}

	public void loadFile() throws IOException {
		File file = new File(filename);
		Scanner inputFile;

		String item;
		
		if (file.exists()) {
			inputFile = new Scanner(file);

			while (inputFile.hasNext()) {
				
				items.add(inputFile.nextLine());
			}
			inputFile.close();
		}
	}

	public void save() throws IOException {
		PrintWriter outputFile = new PrintWriter(filename);

		for (String item : items) {
			outputFile.println(item);
		}
		outputFile.close();
	}

	public int getSize() {
		return items.size();
	}

	public void addItem(String item) {
		items.add(item);
	}

	public String getItem(int index) {
		return items.get(index);
	}

	public void deleteItem(int index) {
		items.remove(index);
	}
}
