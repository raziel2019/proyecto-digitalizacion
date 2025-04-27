package utilitats;
import java.util.Scanner;

public class InputHelper {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static int readInteger() {
		int numero = 0;
		boolean valido = false;
	
		while(!valido) {
			try{
			System.out.print("Introduce un número entero: ");
			numero = Integer.parseInt(scanner.nextLine());
			valido = true;
		}catch(NumberFormatException error) {
			System.out.print("Error: no es un número entero no valido");
		}		
	}
		return numero;
	}
	
	public static int readPositiveInteger() {
		int numero = -1;
		while(numero < 0) {
			numero = readInteger();
			if(numero < 0) {
				System.out.println("Error introduce un numero positivo");
			}
		}
		return numero;
		}
	
	public static double readDecimal() {
		double numero = 0.0;
		boolean valido = false;
		
		while(!valido) {
			try {
				System.out.println("Introduce un numero decimal");
				numero = Double.parseDouble(scanner.nextLine());
				valido = true;
			}catch(NumberFormatException error) {
				System.out.print("Haz introducido un numero que no es");
				
			}
		}
		
		return numero;
		
	}
	
	public static String readString() {
		String texto = "";
		
		while(texto.isBlank()) {
			System.out.print("Introduce un texto: ");
			texto = scanner.nextLine().trim();
			if(texto.isBlank()){
				System.out.print("No puede estar vacio");
			}	
		}
		return texto;
	}
		
	}
	

