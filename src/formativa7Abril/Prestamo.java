package formativa7Abril;

public class Prestamo {
	private int idLibro;
	private String fechaPrestamo;
	private boolean devuelto;
	
	public Prestamo (int id, String fecha, boolean devuelto) {
		this.idLibro = id;
		this.fechaPrestamo = fecha;
		this.devuelto = devuelto;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public boolean isDevuelto() {
		return devuelto;
	}

	public void setDevuelto(boolean devuelto) {
		this.devuelto = devuelto;
	}

	@Override
	public String toString() {
		return idLibro + "-" + fechaPrestamo + "(" + devuelto + ")";
	}
	
	
}
