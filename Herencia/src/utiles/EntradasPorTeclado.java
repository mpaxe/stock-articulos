package utiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class EntradasPorTeclado {

	public static Integer leerEntero(String msg) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(msg);
		Integer res = 0;
		try {
			res = Integer.parseInt(br.readLine());		
		} catch (Exception e) {		
		}
		return res;
	}

	public static Double leerDecimal(String msg) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(msg);
		Double res = 0.0;
		try {
			res = Double.parseDouble(br.readLine());
		} catch (Exception e) {
		}
		return res;
	}

	public static String leerTexto(String msg) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(msg);
		String res;
		try {
			res = br.readLine();
		} catch (Exception e) {
			res = "";
		}
		return res;
	}
	public static Character leerCaracter(String msg) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(msg);
		Character res;
		try {
			res = (char)br.read();
		} catch (Exception e) {
			res = Character.MIN_VALUE;
		}
		return res;
	}
}
