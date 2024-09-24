package entities;

public class Motorista {
	
		private String nome;
	    private int idade;
	    private String licenca;


	    public Motorista() {
	        this.nome = "null";
	        this.idade = 0;
	        this.licenca = "null";
	    }


	    public Motorista(String nome, int idade, String licenca) {
	        this.nome = nome;
	        this.idade = idade;
	        this.licenca = licenca;
	    }


	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public int getIdade() {
	        return idade;
	    }

	    public void setIdade(int idade) {
	    	if (idade < 18) {
	            throw new IllegalArgumentException("O motorista deve ter mais de 18 anos.");
	        }
	        this.idade = idade;
	    }

	    public String getLicenca() {
	        return licenca;
	    }

	    public void setLicenca(String licenca) {
	        this.licenca = licenca;
	    }
	    
	    @Override
	    public String toString() {
	    	StringBuilder sb = new StringBuilder();
	        sb.append("Nome: ").append(this.nome).append("\n");
	        sb.append("Idade: ").append(this.idade).append("\n");
	        sb.append("Licença: ").append(this.licenca);
	        return sb.toString();
	    }

}
