package formativa7Abril;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AutorDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/libreria";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	//agregar autor nuevo
	public static void agregarAutor(Scanner scanner) {
		System.out.println("Dime el nombre del autor a agregar: ");
		String nombreAutor = scanner.nextLine();
		System.out.println("Dime la nacionalidad del autor: ");
		int nacionalidadAutor  = scanner.nextInt();
		String sql = "INSERT INTO autor (nombreAutor, nacionalidad) VALUES (?,?)";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nombreAutor);
			stmt.setInt(2, nacionalidadAutor);
			stmt.executeUpdate();
			System.out.println("Nombre del autor añadido correctamente");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	
	// Mostrar la lista de autores
		public static void listarAutor() {
			String sql = "SELECT * FROM autor";

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmt = conn.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery()) {

				System.out.println("Listado de autores: \n");
				while (rs.next()) {
					int id = rs.getInt("idAutor");
					String nombre = rs.getString("nombreAutor");
					String nacionalidad = rs.getString("nacionalidadAutor");

					System.out.println("ID: " + id);
					System.out.println("Nombre: " + nombre);
					System.out.println("Nacionalidad: " + nacionalidad);
					System.out.println("--------------------");
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		// Actualizar un nombre de la lista
		public static void actualizarAutor(Scanner scanner) {
			System.out.println("Ingrese el ID del autor a actualizar: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Ingrese el nombre del autor: ");
			String nombreNuevo = scanner.nextLine();

			String sql = "UPDATE autor SET nombreAutor = ? WHERE idAutor = ?";

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmt = conn.prepareStatement(sql)) {

				stmt.setInt(1, id);
				stmt.setString(2, nombreNuevo);
				int rowsUpdate = stmt.executeUpdate();
				if (rowsUpdate > 0) {
					System.out.println("Autor actualizado correctamente");
				} else {
					System.out.println("No se encontró autor con el id: " + id);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		
		// Eliminar autor
		public static void eliminarAutor(Scanner scanner) {
			System.out.println("Ingrese el ID del autor a eliminar:");
			int id = scanner.nextInt();
			scanner.nextLine();

			
			String deleteActor = "DELETE FROM autor WHERE idAutor = ?";

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmtAutor = conn.prepareStatement(deleteActor)) {

		

				stmtAutor.setInt(1, id);
				int rowDeleted = stmtAutor.executeUpdate();
				if (rowDeleted > 0) {
					System.out.println("El autor se ha eliminado correctamente");
				} else {
					System.out.println("No se ha encontrado ningun autor con ID: " + id);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
}
