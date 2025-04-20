package formativa7Abril;

public class Genero {

	private int id_genero;
	private String nombre_genero;

	public Genero(int id, String nombre) {
		this.id_genero = id;
		this.nombre_genero = nombre;
	}

	public int getId_genero() {
		return id_genero;
	}

	public void setId_genero(int id_genero) {
		this.id_genero = id_genero;
	}

	public String getNombre_genero() {
		return nombre_genero;
	}

	public void setNombre_genero(String nombre_genero) {
		this.nombre_genero = nombre_genero;
	}

	@Override
	public String toString() {
		return id_genero + "-" + nombre_genero;
	}

}
