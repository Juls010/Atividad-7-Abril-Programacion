package formativa7Abril;

public class Libro {

	private int idLibro;
	private String titulo;
	private int anioPublicacion;
	private int idAutor;
	private int idGenero;

	public Libro(int idLibro, String titulo, int anioPublicacion, int idAutor, int idGenero) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.anioPublicacion = anioPublicacion;
		this.idAutor = idAutor;
		this.idGenero = idGenero;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAnioPublicacion() {
		return anioPublicacion;
	}

	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public int getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}

	@Override
	public String toString() {
		return idLibro + "-" + titulo + "(" + anioPublicacion + ")";
	}

}
