package formativa7Abril;

import java.util.Scanner;
public class Main {

		private static final String URL = "jdbc:mysql://localhost:3306/libreria";
		private static final String USER = "root";
		private static final String PASSWORD = "1234";

		public static void main (String [] args) {
			Scanner scanner = new Scanner(System.in);
			int opcion;
			
			do {
				System.out.println("=== Menú Principal ===");
				System.out.println("1. Gestionar Generos");
				System.out.println("2. Gestionar Autores");
				System.out.println("3. Gestionar Libros");
				System.out.println("4. Gestionar Prestamos");
				System.out.println("5. Consultar Libros con Autor y Genero");
				System.out.println("6. Consultar Prestamos con Libros");
				System.out.println("0. Salir");
				System.out.println("Opcion: ");
				opcion = scanner.nextInt();
				scanner.nextLine();
				
				switch (opcion) {
				case 1: 
					GeneroCRUD.gestion();
					break;
				case 2: 
					AutorCRUD.gestion();
					break;
				case 3:
					LibroCRUD.gestion();
					break;
				case 4: 
					PrestamoCRUD.gestion();
					break;
				case 0: 
					System.out.println("Saliendo...");
					break;
				default: 
					System.out.println("Opcion no valida");
				}
				
			}while (opcion != 9);
				scanner.close();
			}	
 }
