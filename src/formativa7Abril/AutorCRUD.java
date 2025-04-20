package formativa7Abril;

import java.util.Scanner;

public class AutorCRUD {
	private static final String URL = "jdbc:mysql://localhost:3306/libreria";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";

	public static void gestion() {
		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("------Menu------");
			System.out.println("1. Agregar Autor");
			System.out.println("2. Listar Autor");
			System.out.println("3. Actualizar Autor");
			System.out.println("4. Eliminar Autor");
			System.out.println("5. Salir");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				AutorDAO.agregarAutor(scanner);
				break;
			case 2:
				AutorDAO.listarAutor();
				break;
			case 3:
				AutorDAO.actualizarAutor(scanner);
				break;
			case 4:
				AutorDAO.eliminarAutor(scanner);
				break;
			case 5:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opcion no valida");
			}

		} while (opcion != 9);
		scanner.close();
	}
}
