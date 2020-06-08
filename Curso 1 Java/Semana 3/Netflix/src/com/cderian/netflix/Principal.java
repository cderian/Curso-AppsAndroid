package com.cderian.netflix;

import java.util.ArrayList;

/**
 * Clase principal del programa
 * 
 * @author Derian Estrada
 *
 */
public class Principal {

	public static void main(String[] args) {
		System.out.println("***** Netflix *****\n");
		
		// 1. Creando listas
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		ArrayList<Serie> series = new ArrayList<Serie>();
		
		try {
		// 2. Creando objetos para los arrays
		peliculas.add(new Pelicula("Avengers Infinity War", "Los hermanos Russo", "Superhéroes", 160, 2018));
		peliculas.add(new Pelicula("El Caballero de la Noche", "Christopher Nolan", "Drama", 152, 2008));
		peliculas.add(new Pelicula("El Señor de los Anillos: El Retorno del Rey", "Peter Jackson", "Fantasía", 281, 2003));
		peliculas.add(new Pelicula("El Libro Verde", "Peter Farrelly"));
		peliculas.add(new Pelicula("El Renacido", "Alejando González Iñárritu"));
		
		series.add(new Serie ("Criminal Minds", "Jeff Davis", "Acción", 50, 15));
		//series.add(new Serie("Daredevil", "Drew Goddard", "Superhéroes", 39, 3));
		series.add(null);
		series.add(new Serie("Stranger Things", "Matt Duffer, Ross Duffer, Shawn Levy" , "Suspenso", 58 ,3));
		series.add(new Serie("Hunters","David Well"));
		series.add(new Serie("Dark","Baran bo Odar & Jantje Friese"));
		
		// Mostrando catálogo
		System.out.println("***** Catálogo *****\n");
		System.out.println("***** Películas *****\n");
		for (Pelicula peli : peliculas) {
			System.out.println(peli.toString());
		}
		
		System.out.println("***** Series *****\n");
		for (Serie serie : series) {
			System.out.println(serie.toString());
		}
		
		
		// 3. Marcando películas y series vistas
		peliculas.get(1).marcarVisto();
		peliculas.get(2).marcarVisto();
		peliculas.get(4).marcarVisto();
		
		series.get(1).marcarVisto();
		series.get(3).marcarVisto();
		
		// 4. Mostrando listas 
		System.out.println("*** Películas más vistas: *** \n");
		peliculas.get(3).setDuracion(130);
		peliculas.get(4).setDuracion(156);
		for (Pelicula peli : peliculas) {
			if (peli.esVisto()) {
				System.out.print( peli.toString());
				System.out.println("Se visualizó por " + peli.tiempoVisto() + " minutos\n" );
			}
		}
		
		System.out.println("*** Series más vistas: ***\n");
		series.get(3).setDuracion(70);
		series.get(4).setDuracion(48);
		for (Serie serie : series) {
			if (serie.esVisto()) {
				System.out.print( serie.toString());
				System.out.println("Cada capítulo Se visualizó en promedio por " + serie.tiempoVisto() + " minutos\n" );
			}
		}
		
		// 5. Obteniendo la película más reciente y la serie con más temporadas
		System.out.println("*** Película más reciente ***");
		peliculas.get(3).setAnio(2019);
		peliculas.get(4).setAnio(2016);
		int anio = 0;
		int pelicula = 0;
		
		for (int i = 0; i < peliculas.size(); i++) {
			if (peliculas.get(i).getAnio() > anio) {
				pelicula = i;
				anio = peliculas.get(i).getAnio();
			}
		}
		
		System.out.println(peliculas.get(pelicula).toString());
		
		System.out.println("*** Serie con más temporadas ***");
		series.get(3).setTemporadas(1);
		series.get(4).setTemporadas(2);
		int temporadas = 0;
		int serie = 0;
		
		for (int i = 0; i < series.size(); i++) {
			if (series.get(i).getTemporadas() > temporadas) {
				serie = i;
				temporadas = series.get(i).getTemporadas();
			}
		}
		
		System.out.println(series.get(serie).toString());
		} catch (NullPointerException e) {
			System.out.println("Hay objetos nulos en las listas que están causando conflictos.\n");
		} catch (Exception e) {
			System.out.println("Ocurrió un error inesperado\n");
			e.printStackTrace();
		} finally {
			System.out.println("Regresa pronto!\n");
		}
	}

}