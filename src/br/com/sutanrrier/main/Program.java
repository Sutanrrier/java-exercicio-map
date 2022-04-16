package br.com.sutanrrier.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> mapaCandidatos = new HashMap<>();
		
		System.out.print("Informe o caminho do arquivo .csv de votos: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				if(mapaCandidatos.containsKey(fields[0])) {
					mapaCandidatos.put(fields[0], Integer.parseInt(fields[1]) + mapaCandidatos.get(fields[0]));
				}
				else {
					mapaCandidatos.put(fields[0], Integer.parseInt(fields[1]));
				}
				line = br.readLine();
			}
			System.out.println("\nContagem de votos\n");
			for(String key : mapaCandidatos.keySet()) {
				System.out.println(key + ": " + mapaCandidatos.get(key));
			}
		}
		catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		finally {
			sc.close();
			System.out.println("\nFim do Programa!");
		}
	}
}
