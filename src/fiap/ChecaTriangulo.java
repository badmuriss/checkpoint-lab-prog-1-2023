package fiap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChecaTriangulo {

	public static void main(String[] args) {
		
		//instancia as variaveis e o scanner
		double A = 0, B = 0, C = 0, area, p;
		String unidadeM = null;
		Scanner sc = new Scanner(System.in);
		
		
		while (true) {
		
			//checa se há exceções
			try {
			
				//recebe os dados
				System.out.print("Insira a unidade de medida (mm/cm/dm/m/km): ");
				unidadeM = sc.nextLine();
				
				System.out.print("Insira os lados do triângulo separados por vírgula: ");
				String[] dados = (sc.nextLine().strip()).split(",");
				A = Double.parseDouble(dados[0]);
				B = Double.parseDouble(dados[1]);
				C = Double.parseDouble(dados[2]);
				
				System.out.println();
				
				//verifica se foram inseridos mais que 3 valores
				if (dados.length == 3) {
					//verifica se os lados do triangulo são positivos
					if (A > 0 && B > 0 && C > 0) {
						//se forem menos que 3 valores e positivos, continua o programa
						break;
					} else {
						//se nao forem imprime a mensagem de erro e pede os valores novamente
						System.out.println("Os lados do triângulo devem ser maiores que 0!");
						System.out.println();
					}
				} else {
					//se nao forem imprime a mensagem de erro e pede os valores novamente
					System.out.println("Insira apenas 3 valores! ");
					System.out.println();
				}
				
				
				
			//trata as exceções se houver
			} catch (InputMismatchException | NumberFormatException ex) {
				sc.next(); //limpa o input
				
				//imprime a mensagem de erro e pede os valores novamente
				System.out.println("Insira 3 valores válidos e separado por vírgulas!");
				System.out.println();
				
			}
		
		}
		
		//checa se é possivel formar um triangulo
		if((Math.abs(B - C) < A && A < B + C) && (Math.abs(A - C) < B && B < A + C) 
				&& (Math.abs(A - B) < C && C < A + B) ) {
			
			//calcula a area
			p = (A + B + C) / 2;
			area = Math.sqrt(p*(p-A)*(p-B)*(p-C));
			
			System.out.println("É possivel formar um triângulo de aproximadamente " 
			+ String.format("%,.2f", area) + " " + unidadeM + "² de área.");
			
		} else {
			System.out.println("Não é possível formar um triângulo!");
		}
	
		sc.close();
		
	}
	
}
