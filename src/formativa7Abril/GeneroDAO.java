package formativa7Abril;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GeneroDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/libreria";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	//agregar genero nuevo
	public static void agregarGenero(Scanner scanner) {
		System.out.println("Dime el genero a agregar: ");
		String nuevoGenero = scanner.nextLine();
		String sql = "INSERT INTO genero (nombre_genero) VALUES (?)";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nuevoGenero);
			stmt.executeUpdate();
			System.out.println("Nuevo genero añadido correctamente");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	
	// Mostrar la lista de generos
		public static void listarGenero() {
			String sql = "SELECT * FROM genero";

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmt = conn.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery()) {

				System.out.println("Listado de generos: \n");
				while (rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					

					System.out.println("ID: " + id);
					System.out.println("Nombre: " + nombre);
					System.out.println("--------------------");
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		// Actualizar un nombre de generos
		public static void actualizarGenero(Scanner scanner) {
			System.out.println("Ingrese el ID del genero a actualizar: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Ingrese el nombre del genero: ");
			String modificaGenero = scanner.nextLine();

			String sql = "UPDATE genero SET nombre_genero = ? WHERE id_genero = ?";

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmt = conn.prepareStatement(sql)) {

				stmt.setInt(1, id);
				stmt.setString(2, modificaGenero);
				int rowsUpdate = stmt.executeUpdate();
				if (rowsUpdate > 0) {
					System.out.println("Genero actualizado correctamente");
				} else {
					System.out.println("No se encontró genero con el id: " + id);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		
		// Eliminar genero
		public static void eliminarGenero(Scanner scanner) {
			System.out.println("Ingrese el ID del genero a eliminar:");
			int id = scanner.nextInt();
			scanner.nextLine();

			
			String deleteActor = "DELETE FROM genero WHERE id_genero = ?";

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmtAutor = conn.prepareStatement(deleteActor)) {

		

				stmtAutor.setInt(1, id);
				int rowDeleted = stmtAutor.executeUpdate();
				if (rowDeleted > 0) {
					System.out.println("El genero se ha eliminado correctamente");
				} else {
					System.out.println("No se ha encontrado ningun genero con ID: " + id);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
}

