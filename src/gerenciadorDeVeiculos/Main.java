package gerenciadorDeVeiculos;

import java.util.Scanner;


import entities.Motorista;
import entities.Veiculo;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		
		try {
			
			 Scanner sc = new Scanner(System.in);
			 
			 System.out.println("insira seus dados:");
			 System.out.print("Nome: ");
			 String nome = sc.nextLine();
			 System.out.print("Idade: ");
			 int idade = sc.nextInt();
			 if(idade < 18) {
				 throw new IllegalArgumentException("O motorista deve ter mais de 18 anos.");
			 }
			 System.out.print("Licença: ");
			 String licenca = sc.next();
			 sc.nextLine();
			 
			 Motorista motorista1 = new Motorista(nome, idade, licenca);
			 String opcao;
			 
			do {
				System.out.println("deseja incluir algum veículo?[S/N]");
				opcao = sc.nextLine();
				 
				 if(opcao.equalsIgnoreCase("S")) {
					 System.out.println("insira os dados do veiculo:");
					 System.out.print("Modelo: ");
					 String modelo = sc.nextLine();
					 System.out.print("Ano: ");
					 int ano = sc.nextInt();
					 sc.nextLine();
				
					 Veiculo carro = new Veiculo(modelo, ano); 
					 carro.setMotorista(motorista1);
					 System.out.println("Quer dar uma volta?[S/N]");
					 String op = sc.nextLine();
					 if(op.equalsIgnoreCase("S")) {
						
						carro.acelerar();
						System.out.println();
						System.out.println("Veículo parado!"); 
					 } 
				     	
				     System.out.println();
				     carro.exibirInformacoes();
				     return;
				 }else if(opcao.equalsIgnoreCase("N")) {
					 System.out.println("Obrigado pela preferencia!");
					 return; 
				 }else {
					System.out.println("Opção incorreta!");
				 }
			}while(!opcao.equalsIgnoreCase("s") || !opcao.equalsIgnoreCase("n"));
		    
		     sc.close();
		}catch(IllegalArgumentException e) {
			System.out.println("Negado: " + e.getMessage());
		}
		
	}

}
