package app;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pojo.Articulo;
import pojo.Disco;
import pojo.Libro;
import pojo.Pelicula;
import utiles.EntradasPorTeclado;
import utiles.Utilidades;

public class Principal {
	static List<Articulo> stock;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		stock = new ArrayList<Articulo>();

		ejecutarPrograma();
		
	}

	public static void menu() {
		System.out.println();
		System.out.println("\t\t\t|####################################|");
		System.out.println("\t\t\t|                Menu                |");
		System.out.println("\t\t\t|####################################|");
		System.out.println("\t\t\t| 1. Mostrar lista completa          |");
		System.out.println("\t\t\t| 2. Mostrar por tipo de articulo    |");
		System.out.println("\t\t\t| 3. Añadir articulo                 |");
		System.out.println("\t\t\t| 4. Llenar stock                    |");
		System.out.println("\t\t\t| 5. Ordenar stock                   |");
		System.out.println("\t\t\t| 6. Vaciar stock                    |");
		System.out.println("\t\t\t| 0. Salir                           |");
		System.out.println("\t\t\t|####################################|");

	}

	public static void ejecutarPrograma() throws FileNotFoundException, IOException {
		Integer op;
		do {
			menu();
			System.out.println();
			op = EntradasPorTeclado.leerEntero("Introduzca la opción para el menu: ");
			switch (op) {
			case 1:
				mostrarListaCompleta();
				break;
			case 2:
				mostrarListaPorArticulos();
				break;
			case 3:
				introducirElemento();
				break;
			case 4:
				llenarStockOpciones();
				break;
			case 5:
				ordenarStock();
				break;
			case 6:
				vaciarLista();
				break;
			default:
				if (op != 0) {
					System.out.println("Opción no diponible");
				}
				break;
			}
		} while (op != 0);

	}

	public static void menuIntroducirElemento() {
		System.out.println();
		System.out.println("\t\t\t|###################################|");
		System.out.println("\t\t\t|        Introduce elemento         |");
		System.out.println("\t\t\t|###################################|");
		System.out.println("\t\t\t| 1. Libro                          |");
		System.out.println("\t\t\t| 2. Pelicula                       |");
		System.out.println("\t\t\t| 3. Disco                          |");
		System.out.println("\t\t\t| 0. Salir                          |");
		System.out.println("\t\t\t|###################################|");
	}

	public static void introducirElemento() throws IOException {
		Integer op;
		do {
			menuIntroducirElemento();
			System.out.println();
			op = EntradasPorTeclado.leerEntero("Introduzca la opción para el menu: ");
			switch (op) {
			case 1:
				stock.add(generarLibro());
				break;
			case 2:
				stock.add(generarPelicula());
				break;
			case 3:
				stock.add(generarDisco());
				break;
			}
		} while (op != 0);
	}

	public static Libro generarLibro() throws IOException {
		String codigo = EntradasPorTeclado.leerTexto("Introduzca el código del libro: ");
		String titulo = EntradasPorTeclado.leerTexto("Introduzca el titulo del libro: ");
		Double precio = EntradasPorTeclado.leerDecimal("Introduzca el precio del libro: ");
		String argumento = EntradasPorTeclado.leerTexto("Introduzca el argumento del libro: ");
		Integer pagina = EntradasPorTeclado.leerEntero("Introduzca el número de páginas: ");
		Libro l = new Libro(codigo, titulo, precio, argumento, pagina);
		FileWriter fw = new FileWriter("/home/alvaro/eclipse-workspace/Avante/Herencia/datos/Libros.txt", true);
		fw.write("\""+l.getCodigo()+"\",\""+l.getTitulo()+"\","+l.getPrecio()+",\""+l.getArgumento()+"\","+l.getPaginas()+";");
		fw.close();
		return l;
	}

	public static Pelicula generarPelicula() throws IOException {
		String codigo = EntradasPorTeclado.leerTexto("Introduzca el código de la pelicula : ");
		String titulo = EntradasPorTeclado.leerTexto("Introduzca el titulo de la pelicula: ");
		Double precio = EntradasPorTeclado.leerDecimal("Introduzca el precio de la pelicula: ");
		String argumento = EntradasPorTeclado.leerTexto("Introduzca el argumento de la pelicula: ");
		String esDVDTex = EntradasPorTeclado.leerTexto("Es un DVD?(S/N): ");
		Boolean esDVD;
		if (esDVDTex.equalsIgnoreCase("s") || esDVDTex.equalsIgnoreCase("si")) {
			esDVD = true;
		} else {
			esDVD = false;
		}
		Pelicula p = new Pelicula(codigo, titulo, precio, argumento, esDVD);
		FileWriter fw = new FileWriter("/home/alvaro/eclipse-workspace/Avante/Herencia/datos/Peliculas.txt", true);
		fw.write("\""+p.getCodigo()+"\",\""+p.getTitulo()+"\","+p.getPrecio()+",\""+p.getArgumento()+"\","+p.isDVD()+";");
		fw.close();
		return p;
	}

	public static Disco generarDisco() throws IOException {
		String codigo = EntradasPorTeclado.leerTexto("Introduzca el código del disco: ");
		String titulo = EntradasPorTeclado.leerTexto("Introduzca el titulo del disco: ");
		Double precio = EntradasPorTeclado.leerDecimal("Introduzca el precio del disco: ");
		String esLPTex = EntradasPorTeclado.leerTexto("Es un LP?(S/N): ");
		Boolean esLP;
		if (esLPTex.equalsIgnoreCase("s") || esLPTex.equalsIgnoreCase("si")) {
			esLP = true;
		} else {
			esLP = false;
		}
		Disco d = new Disco(codigo, titulo, precio, esLP);
		FileWriter fw = new FileWriter("/home/alvaro/eclipse-workspace/Avante/Herencia/datos/Discos.txt", true);
		fw.write("\""+d.getCodigo()+"\",\""+d.getTitulo()+"\","+d.getPrecio()+","+d.isLP()+";");
		fw.close();
		return d;
	}

	public static void mostrarListaCompleta() {
		for (Articulo a : stock) {
			if (a instanceof Libro) {
				System.out.println("-------------------------------------------------");
				System.out.println((Libro) a);
				System.out.println("-------------------------------------------------");
			}
			if (a instanceof Pelicula) {
				System.out.println("-------------------------------------------------");
				System.out.println((Pelicula) a);
				System.out.println("-------------------------------------------------");
			}
			if (a instanceof Disco) {
				System.out.println("-------------------------------------------------");
				System.out.println((Disco) a);
				System.out.println("-------------------------------------------------");
			}
		}
	}

	public static void mostrarListaPorArticulos() {
		Integer op = 0;
		List<Libro> listLibro = new ArrayList<Libro>();
		List<Pelicula> listPelicula = new ArrayList<Pelicula>();
		List<Disco> listDiscos = new ArrayList<Disco>();
		do {
			menuListaPorArticulos();
			System.out.println();
			op = EntradasPorTeclado.leerEntero("Introduzca una opcion: ");
			System.out.println();
			for (Articulo a : stock) {
				if (a instanceof Libro) {
					if (!listLibro.contains(a)) {
						listLibro.add((Libro) a);
					}
				} else if (a instanceof Pelicula) {
					if (!listPelicula.contains(a)) {
						listPelicula.add((Pelicula) a);
					}
				} else if (a instanceof Disco) {
					if (!listDiscos.contains(a)) {
						listDiscos.add((Disco) a);
					}
				}
			}
			switch (op) {
			case 1:

				for (Libro l : listLibro) {
					System.out.println("-------------------------------------------------");
					System.out.println(l);
					System.out.println("-------------------------------------------------");
				}
				break;
			case 2:
				for (Pelicula p : listPelicula) {
					System.out.println("-------------------------------------------------");
					System.out.println(p);
					System.out.println("-------------------------------------------------");
				}
				break;
			case 3:
				for (Disco d : listDiscos) {
					System.out.println("-------------------------------------------------");
					System.out.println(d);
					System.out.println("-------------------------------------------------");
				}
				break;
			default:
				if (op != 0) {
					System.out.println("Opción no disponible");
				}
				break;
			}

		} while (op != 0);

	}

	public static void menuListaPorArticulos() {
		System.out.println();
		System.out.println("\t\t\t|###################################|");
		System.out.println("\t\t\t|             Articulos             |");
		System.out.println("\t\t\t|###################################|");
		System.out.println("\t\t\t| 1. Libros                         |");
		System.out.println("\t\t\t| 2. Peliculas                      |");
		System.out.println("\t\t\t| 3. Discos                         |");
		System.out.println("\t\t\t| 0. Salir                          |");
		System.out.println("\t\t\t|###################################|");
	}
	
	public static void menuLlenarStock() {
		System.out.println();
		System.out.println("\t\t\t|###################################|");
		System.out.println("\t\t\t|          Llenar Stock             |");
		System.out.println("\t\t\t|###################################|");
		System.out.println("\t\t\t| 1. Llenar stock                   |");
		System.out.println("\t\t\t| 2. Llenar stock de Libros         |");
		System.out.println("\t\t\t| 3. Llenar stock de Peliculas      |");
		System.out.println("\t\t\t| 4. Llenar stock de Discos         |");
		System.out.println("\t\t\t| 0. Salir                          |");
		System.out.println("\t\t\t|###################################|");
	}
	
	public static void llenarStockOpciones() throws FileNotFoundException, IOException {
		Integer op;
		do {
			menuLlenarStock();
			System.out.println();
			op = EntradasPorTeclado.leerEntero("Introduzca la opción para el menu: ");
			switch (op) {
			case 1:
				llenarStock();
				break;
			case 2:
				llenarStockDeLibros();
				break;
			case 3:
				llenarStockDePeliculas();
				break;
			case 4:
				llenarStockDeDiscos();
				break;
			}
		} while (op != 0);
	}
	
public static void llenarStock() throws FileNotFoundException, IOException {
		
		String cadLibros = Utilidades.leerArchivoTxt("/home/alvaro/eclipse-workspace/Avante/Herencia/datos/Libros.txt");
		String[] cadSplitLibros = cadLibros.split(";");
		for (String s : cadSplitLibros) {
			String[] propiedades = s.split(",");
			String codigo = propiedades[0].trim();
			String titulo = propiedades[1].trim();
			Double precio = Double.parseDouble(propiedades[2].trim());
			String argumento = propiedades[3].trim();
			Integer paginas = Integer.parseInt(propiedades[4].trim());
			stock.add(new Libro(codigo, titulo, precio, argumento, paginas));
		}
		
		String cadPeliculas = Utilidades.leerArchivoTxt("/home/alvaro/eclipse-workspace/Avante/Herencia/datos/Peliculas.txt");
		String[] cadSplitPeliculas = cadPeliculas.split(";");
		for (String s : cadSplitPeliculas) {
			String[] propiedades = s.split(",");
			String codigo = propiedades[0].trim();
			String titulo = propiedades[1].trim();
			Double precio = Double.parseDouble(propiedades[2].trim());
			String argumento = propiedades[3].trim();
			String esDVDTexto = propiedades[4].trim();
			Boolean esDVD;
			if(esDVDTexto.equalsIgnoreCase("true")) {
				esDVD = true;
			}else {
				esDVD = false;
			}
			stock.add(new Pelicula(codigo, titulo, precio, argumento, esDVD));
		}
		
		String cadDiscos = Utilidades.leerArchivoTxt("/home/alvaro/eclipse-workspace/Avante/Herencia/datos/Discos.txt");
		String[] cadSplitDiscos = cadDiscos.split(";");
		for (String s : cadSplitDiscos) {
			String[] propiedades = s.split(",");
			String codigo = propiedades[0].trim();
			String titulo = propiedades[1].trim();
			Double precio = Double.parseDouble(propiedades[2].trim());
			String esLPTexto = propiedades[3].trim();
			Boolean esLP;
			if(esLPTexto.equalsIgnoreCase("true")) {
				esLP = true;
			}else {
				esLP = false;
			}
			stock.add(new Disco(codigo, titulo, precio, esLP));
		}
		
	}
	

	public static void llenarStockDeLibros() throws FileNotFoundException, IOException {
		
		String cad = Utilidades.leerArchivoTxt("/home/alvaro/eclipse-workspace/Avante/Herencia/datos/Libros.txt");
		String[] cadSplit = cad.split(";");
		for (String s : cadSplit) {
			String[] propiedades = s.split(",");
			String codigo = propiedades[0].trim();
			String titulo = propiedades[1].trim();
			Double precio = Double.parseDouble(propiedades[2].trim());
			String argumento = propiedades[3].trim();
			Integer paginas = Integer.parseInt(propiedades[4].trim());
			stock.add(new Libro(codigo, titulo, precio, argumento, paginas));
		}
	}
	
	public static void llenarStockDePeliculas() throws FileNotFoundException, IOException {
		
		String cad = Utilidades.leerArchivoTxt("/home/alvaro/eclipse-workspace/Avante/Herencia/datos/Peliculas.txt");
		String[] cadSplit = cad.split(";");
		for (String s : cadSplit) {
			String[] propiedades = s.split(",");
			String codigo = propiedades[0].trim();
			String titulo = propiedades[1].trim();
			Double precio = Double.parseDouble(propiedades[2].trim());
			String argumento = propiedades[3].trim();
			String esDVDTexto = propiedades[4].trim();
			Boolean esDVD;
			if(esDVDTexto.equalsIgnoreCase("true")) {
				esDVD = true;
			}else {
				esDVD = false;
			}
			stock.add(new Pelicula(codigo, titulo, precio, argumento, esDVD));
		}
	}
	
	public static void llenarStockDeDiscos() throws FileNotFoundException, IOException {
		
		String cad = Utilidades.leerArchivoTxt("/home/alvaro/eclipse-workspace/Avante/Herencia/datos/Discos.txt");
		String[] cadSplit = cad.split(";");
		for (String s : cadSplit) {
			String[] propiedades = s.split(",");
			String codigo = propiedades[0].trim();
			String titulo = propiedades[1].trim();
			Double precio = Double.parseDouble(propiedades[2].trim());
			String esLPTexto = propiedades[3].trim();
			Boolean esLP;
			if(esLPTexto.equalsIgnoreCase("true")) {
				esLP = true;
			}else {
				esLP = false;
			}
			stock.add(new Disco(codigo, titulo, precio, esLP));
		}
	}

	public static void ordenarStock() {
		Collections.sort(stock);
	}

	public static void vaciarLista() {
		stock.clear();
	}

}
// vaciarLista();
// stock.add(new Pelicula("200", "Los vengadores", 45.10, "la ....", true));
// stock.add(new Pelicula("202", "Ironman", 65.30, "la ....", true));
// stock.add(new Pelicula("203", "Lo que el viento se llevo", 23.55, "la ....",
// false));
// stock.add(new Disco("303", "Lo mejor de OT", 15.99, false));
// stock.add(new Libro("100", "Los cinco", 27.25, "la ....", 120));
// stock.add(new Disco("302", "Americana", 15.99, true));
// stock.add(new Disco("301", "Adel", 15.99, true));
// stock.add(new Pelicula("204", "Ciudadano Kane", 65.10, "la ....", false));
// stock.add(new Disco("304", "La flaca", 15.99, false));
// stock.add(new Libro("103", "Pesadillas", 15.99, "la ....", 188));
// stock.add(new Libro("104", "El principito", 22.30, "la ....", 99));
// stock.add(new Libro("101", "La gran apuesta", 55.20, "la ....", 355));
// stock.add(new Disco("300", "Devil come to me", 15.99, true));
// stock.add(new Libro("102", "La biblia", 32.20, "la ....", 255));
// stock.add(new Pelicula("201", "Spiderman", 55.20, "la ....", true));