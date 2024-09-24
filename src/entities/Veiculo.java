package entities;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Veiculo {
	
	private String modelo;
    private int ano;
    private int velocidade = 0;
    private int velocidadeMaxima = 200;
    private final int tamanhoBarra = 20;
    private int nivelAtualBarra;
    private Motorista motorista;

    Scanner sc = new Scanner(System.in);
  
    public Veiculo() {
        this.modelo = "Não definido";
        this.ano = 0;
        this.velocidade = 0;
    }


    public Veiculo(String modelo, int ano) {
        this.modelo = modelo;
        this.ano = ano;
        this.velocidade = 0;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    } 

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    
    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
    
    
    
    // metodos especiais 
    
    public void dirigir() throws InterruptedException {
    	acelerar() ;
    }

    public void acelerar() throws InterruptedException {
    	
    		System.out.print("[                    ] 0 km/h");
    		int incremento = velocidadeMaxima / tamanhoBarra;
    	
    		for (int i = 1; i <= tamanhoBarra; i++) {
                this.velocidade += incremento;  // Aumenta a velocidade proporcionalmente
                
                if (this.velocidade > 120) {
                     // avisa o limite de velocidade a 120 km/h
                	System.out.println();
                    System.out.println("limite da via atingido, deseja continuar? [S/N]");
                    String decisao = sc.next();
                    decisao = decisao.toUpperCase();
                    if(decisao.equals("S")) {
                    	System.out.print("\r[" + "=".repeat(i) + " ".repeat(tamanhoBarra - i) + "] " + this.velocidade + " km/h");
                    	this.nivelAtualBarra = i;
                    	continue;
                    }else if(decisao.equals("N")){
                    	System.out.println("Parabéns, escolheu viver!");
                    	frear();
                    	return;
                    }else {
                    	System.out.println("opção errada, agora vc morreu!");
                    	return;
                    }
                    
                }
                this.nivelAtualBarra = i;
                System.out.print("\r[" + "=".repeat(i) + " ".repeat(tamanhoBarra - i) + "] " + this.velocidade + " km/h");

                TimeUnit.MILLISECONDS.sleep(1000);
                
    		}
            
    }

    public void frear() throws InterruptedException {
    	int decremento = velocidadeMaxima / tamanhoBarra;

        // Simular a redução de velocidade
        for (int i = nivelAtualBarra; i >= 0; i--) {
            this.velocidade -= decremento;  // Reduz a velocidade 
            if (this.velocidade <= 0) {
                this.velocidade = 0;  // Limita a velocidade mínima a 0 km/h
                System.out.print("\r[" + "=".repeat(i) + " ".repeat(tamanhoBarra - i) + "] " + this.velocidade + " km/h");
                return;
            }

            // Atualiza a barra e a velocidade durante a frenagem
            System.out.print("\r[" + "=".repeat(i) + " ".repeat(tamanhoBarra - i) + "] " + this.velocidade + " km/h");

            TimeUnit.MILLISECONDS.sleep(700); // Pausa para simular o tempo de frenagem
        }
    }


    public void exibirInformacoes() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Velocidade atual: " + velocidade + " km/h");
        if (motorista != null) {
            System.out.println("Motorista: " + motorista.getNome());
        } else {
            System.out.println("Motorista não definido.");
        }
    }

}
