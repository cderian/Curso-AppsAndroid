package com.cderian.netflix;

public class Serie extends Proyeccion implements Visualizable {
	
	private int temporadas;
	
	public Serie () {
		super();
	}
	
	public Serie (String titulo, String creador) {
		super(titulo, creador);
		this.temporadas = 1;
	}
	
	public Serie (String titulo, String creador, String genero, int duracion, int temporadas) {
		super (titulo, creador, genero, duracion);
		this.temporadas = temporadas;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public String toString() {
		String info = super.toString("Serie");
		info+= temporadas + " temporadas\n";
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
		
		if (tiempo > 30 && tiempo < 50) {
			tiempo = tiempo*1.05;
		} else if (tiempo > 50 && tiempo < 60) {
			tiempo = tiempo*1.2;
		} else if (tiempo > 60) {
			tiempo = tiempo*1.4;
		}
		
		return tiempo;
	}
	
}