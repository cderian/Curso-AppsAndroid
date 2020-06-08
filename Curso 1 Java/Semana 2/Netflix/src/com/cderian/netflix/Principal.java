package com.cderian.netflix;

/**
 * Clase principal del programa
 * 
 * @author Derian Estrada
 *
 */
public class Principal {

	public static void main(String[] args) {
		System.out.println("***** Netflix *****\n");
		
		// 1. Creando arrays
		Pelicula[] peliculas = new Pelicula[5];
		Serie[] series = new Serie[5];
		
		// 2. Creando objetos para los arrays
		peliculas[0] = new Pelicula("Avengers Infinity War", "Los hermanos Russo", "Superhéroes", 160, 2018);
		peliculas[1] = new Pelicula("El Caballero de la Noche", "Christopher Nolan", "Drama", 152, 2008);
		peliculas[2] = new Pelicula("El Señor de los Anillos: El Retorno del Rey", "Peter Jackson", "Fantasía", 281, 2003);
		peliculas[3] = new Pelicula("El Libro Verde", "Peter Farrelly");
		peliculas[4] = new Pelicula("El Renacido", "Alejando González Iñárritu");
		
		series[0] = new Serie ("Criminal Minds", "Jeff Davis", "Acción", 50, 15);
		series[1] = new Serie("Daredevil", "Drew Goddard", "Superhéroes", 39, 3);
		series[2] = new Serie();
		series[3] = new Serie("Hunters","David Well");
		series[4] = new Serie("Dark","Baran bo Odar & Jantje Friese");
		
		// Mostrando catálogo
		System.out.println("***** Catálogo *****\n");
		for (int i=0; i<peliculas.length; i++) {
			System.out.println(peliculas[i].toString());
		}
		
		for (int i=0; i<series.length; i++) {
			System.out.println(series[i].toString());
		}
		
		
		// 3. Marcando películas y series vistas
		peliculas[1].marcarVisto();
		peliculas[2].marcarVisto();
		peliculas[4].marcarVisto();
		
		series[1].marcarVisto();
		series[3].marcarVisto();
		
		// 4. Mostrando listas 
		System.out.println("*** Películas más vistas: *** \n");
		peliculas[3].setDuracion(130);
		peliculas[4].setDuracion(156);
		for (int i=0; i < peliculas.length; i++) {
			if (peliculas[i].esVisto()) {
				System.out.print( peliculas[i].toString());
				System.out.println("Se visualizó por " + peliculas[i].tiempoVisto() + " minutos\n" );
			}
		}
		
		System.out.println("*** Series más vistas: ***\n");
		series[3].setDuracion(70);
		series[4].setDuracion(48);
		for (int i=0; i < series.length; i++) {
			if (series[i].esVisto()) {
				System.out.print( series[i].toString());
				System.out.println("Cada capítulo Se visualizó en promedio por " + series[i].tiempoVisto() + " minutos\n" );
			}
		}
		
		// 5. Obteniendo la película más reciente y la serie con más temporadas
		System.out.println("*** Película más reciente ***");
		peliculas[3].setAnio(2019);
		peliculas[4].setAnio(2016);
		int anio = 0;
		int pelicula = 0;
		for (int i=0; i < peliculas.length; i++) {
			if (peliculas[i].getAnio() > anio) {
				pelicula = i;
				anio = peliculas[i].getAnio();
			}
		}
		System.out.println(peliculas[pelicula].toString());
		
		System.out.println("*** Serie con más temporadas ***");
		series[3].setTemporadas(1);
		series[4].setTemporadas(2);
		int temporadas = 0;
		int serie = 0;
		for (int i=0; i < series.length; i++) {
			if (series[i].getTemporadas() > temporadas) {
				serie = i;
				temporadas = series[i].getTemporadas();
			}
		}
		System.out.println(series[serie].toString());
		
	}

}