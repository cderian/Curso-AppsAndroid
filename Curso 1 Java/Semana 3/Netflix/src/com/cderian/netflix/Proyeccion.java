package com.cderian.netflix;

public class Proyeccion {
	
	private String titulo;
	private String creador;
	private String genero;
	private int duracion;
	public boolean visto;
	
	public Proyeccion () {}
	
	public Proyeccion (String titulo, String creador) {
		this.titulo = titulo;
		this.creador = creador;
		this.genero = "";
		this.duracion = 0;
		this.visto = false;
	}
	
	public Proyeccion (String titulo, String creador, String genero, int duracion) {
		this.titulo = titulo;
		this.creador = creador;
		this.genero = genero;
		this.duracion = duracion;
		this.visto = false;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public String toString(String nombre) {
		String info = nombre + ": " + titulo + "\n";
		info+= "Creador: " + creador + "\n";
		info+= "Género: " + genero + "\n";
		info+= "Duración: " + duracion + " mins.\n";
		
		return info;
	}

}