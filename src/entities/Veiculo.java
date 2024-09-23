package entities;

public class Veiculo {
	
	private String modelo;
    private int ano;
    private int velocidade;
    private Motorista motorista;

  
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

    public java.lang.String getModelo() {
        return modelo;
    }

    public void setModelo(java.lang.String modelo) {
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

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void acelerar(int valor) {
        velocidade += valor;
        if (velocidade > 120) {
            System.out.println("Atenção! Velocidade acima do limite!");
        }
    }


    public void frear(int valor) {
        velocidade -= valor;
        if (velocidade < 0) {
            velocidade = 0;
            System.out.println("Veículo parado.");
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
