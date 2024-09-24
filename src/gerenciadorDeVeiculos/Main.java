package gerenciadorDeVeiculos;

import java.util.Scanner;


import entities.Motorista;
import entities.Veiculo;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		try {
			
			 Scanner sc = new Scanner(System.in);
			 
			 System.out.println("insira seus dados:");
			 System.out.print("Nome: ");
			 String nome = sc.nextLine();
			 System.out.print("Idade: ");
			 int idade = sc.nextInt();
			 System.out.print("Licença: ");
			 String licenca = sc.next();
			 sc.nextLine();
			 
			 Motorista motorista1 = new Motorista(nome, idade, licenca);
			 
			 System.out.println("insira os dados do veiculo:");
			 System.out.print("Modelo: ");
			 String modelo = sc.nextLine();
			 System.out.print("Ano: ");
			 int ano = sc.nextInt();
			
	         Veiculo carro = new Veiculo(modelo, ano); 
	         
		     carro.setMotorista(motorista1);
		     carro.acelerar();
		     
		     
		    
		     sc.close();
		}catch(IllegalArgumentException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
	}

}
