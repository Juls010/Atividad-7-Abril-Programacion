package formativa7Abril;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LibroDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/libreria";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	//agregar libro nuevo
	public static void agregarLibro(Scanner scanner) {
		System.out.println("Dime el nombre del libro a agregar: ");
		String nombreLibro = scanner.nextLine();
		System.out.println("Dime el año de publicacion: ");
		int anioPublicacion  = scanner.nextInt();
		System.out.println("Dime el id de su autor: ");
		int idAutor  = scanner.nextInt();
		System.out.println("Dime el id de su genero:: ");
		int idGenero  = scanner.nextInt();
		
		
		String sql = "INSERT INTO libro (titulo, anio_publicacion, idAutor, idGenero) VALUES (?,?.?.?)";

		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, nombreLibro);
			stmt.setInt(2, anioPublicacion);
			stmt.setInt(2, idAutor);
			stmt.setInt(2, idGenero);
			stmt.executeUpdate();
			System.out.println("Nuevo libro añadido correctamente");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	
	// Mostrar la lista de libros
		public static void listarLibros() {
			String sql = "SELECT * FROM libro";

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmt = conn.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery()) {

				System.out.println("Listado de libros: \n");
				while (rs.next()) {
					int id = rs.getInt("id_libro");
					String titulo = rs.getString("titulo:");
					String anioPublicacion = rs.getString("año publicacion:");
					int id_autor = rs.getInt("id autor:");
					int id_genero = rs.getInt("id genero:");

					System.out.println("ID: " + id);
					System.out.println("Titulo: " + titulo);
					System.out.println("Nacionalidad: " + anioPublicacion);
					System.out.println("id Autor: " + id_autor);
					System.out.println("id_Genero: " + id_genero);
					System.out.println("--------------------");
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		
		// Actualizar un libro de la lista
		public static void actualizarLibro(Scanner scanner) {
			System.out.println("Ingrese el ID del libro a actualizar: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Ingrese el titulo del libror: ");
			String tituloNuevo = scanner.nextLine();

			String sql = "UPDATE libro SET titulo = ? WHERE id_libro = ?";

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmt = conn.prepareStatement(sql)) {

				stmt.setInt(1, id);
				stmt.setString(2, tituloNuevo);
				int rowsUpdate = stmt.executeUpdate();
				if (rowsUpdate > 0) {
					System.out.println("libro actualizado correctamente");
				} else {
					System.out.println("No se encontró libro con el id: " + id);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		
		// Eliminar libro
		public static void eliminarLibro(Scanner scanner) {
			System.out.println("Ingrese el ID del libro a eliminar:");
			int id = scanner.nextInt();
			scanner.nextLine();

			
			String deleteLibro = "DELETE FROM libro WHERE id_libro = ?";

			try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
					PreparedStatement stmtAutor = conn.prepareStatement(deleteLibro)) {
				
				stmtAutor.setInt(1, id);
				int rowDeleted = stmtAutor.executeUpdate();
				if (rowDeleted > 0) {
					System.out.println("El libro se ha eliminado correctamente");
				} else {
					System.out.println("No se ha encontrado ningun libro con ID: " + id);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
}

