package formativa7Abril;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrestamoDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/libreria";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	//agregar autor prestamo
	public static void agregarPrestamor(Scanner scanner) {
		System.out.println("Dime la fecha del prestamo a agregar: ");
		String fecha = scanner.nextLine();
		System.out.println("Está devuelto?: ");
		boolean  devuelto  = scanner.hasNextBoolean();
		String sql = "INSERT INTO prestamo (fecha_prestamo, devuelto) VALUES (?,?)";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, fecha);
			stmt.setBoolean(2, devuelto);
			stmt.executeUpdate();
			System.out.println("Prestamo añadido correctamente");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	
	// Mostrar la lista de prestamos
		public static void listarPrestamo() {
			String sql = "SELECT * FROM prestamo";

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmt = conn.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery()) {

				System.out.println("Listado de prestamos: \n");
				while (rs.next()) {
					String fecha = rs.getString("fech_prestamo");
					Boolean devuelto = rs.getBoolean("devuelto");

					System.out.println("Fecha: " + fecha);
					System.out.println("Estado devolucion: " + devuelto);
					System.out.println("--------------------");
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		// Actualizar un prestamo de la lista
		public static void actualizarPrestamo(Scanner scanner) {
			System.out.println("Ingrese el ID del prestamo a actualizar: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Ingrese la fecha del prestamo: ");
			String fechaPrestamo = scanner.nextLine();
			System.out.println("Ingrese el estado de devolucion: ");
			Boolean  devuelto = scanner.hasNextBoolean();

			String sql = "UPDATE prestamo SET fecha_prestamo = ? WHERE idAutor = ?";

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmt = conn.prepareStatement(sql)) {

				stmt.setInt(1, id);
				stmt.setString(2, fechaPrestamo);
				stmt.setBoolean(3, devuelto);
				
				int rowsUpdate = stmt.executeUpdate();
				if (rowsUpdate > 0) {
					System.out.println("Prestamo actualizado correctamente");
				} else {
					System.out.println("No se encontró prestamo con el id: " + id);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		
		// Eliminar prestamo
		public static void eliminarPrestamo(Scanner scanner) {
			System.out.println("Ingrese el ID del prestamo a eliminar:");
			int id = scanner.nextInt();
			scanner.nextLine();

			
			String deletePrestamo = "DELETE FROM prestamo WHERE id_prestamo = ?";

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmtPrestamo = conn.prepareStatement(deletePrestamo)) {

				stmtPrestamo.setInt(1, id);
				int rowDeleted = stmtPrestamo.executeUpdate();
				if (rowDeleted > 0) {
					System.out.println("El prestamo se ha eliminado correctamente");
				} else {
					System.out.println("No se ha encontrado ningun prestamo con ID: " + id);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
}

