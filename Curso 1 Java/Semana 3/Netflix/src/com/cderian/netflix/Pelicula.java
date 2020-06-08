package com.cderian.netflix;

public class Pelicula extends Proyeccion implements Visualizable {
	
	private int anio;
	
	public Pelicula() {
		super();
	}
	
	public Pelicula(String titulo, String creador) {
		super(titulo, creador);
		this.anio = 0;
	}
	
	public Pelicula(String titulo, String creador, String genero, int duracion, int anio) {
		super (titulo, creador, genero, duracion);
		this.anio = anio;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String toString() {
		String info = super.toString("Película");
		info+= "Año: " + anio + "\n";
		return info;
	}

	@Override
	public void marcarVisto() {
		super.visto = true;
	}

	@Override
	public boolean esVisto() {
		return super.visto;
	}

	@Override
	public double tiempoVisto() {
		double tiempo = super.getDuracion();
		
		if (tiempo > 110 && tiempo < 130) {
			tiempo = tiempo*1.3;
		} else if (tiempo > 130 && tiempo < 180) {
			tiempo = tiempo*1.5;
		} else if (tiempo > 180) {
			tiempo = tiempo*1.8;
		}
		
		return tiempo;
	}
}