package banco_de_dados.dbo;

public class Responsavel {
	private String email, nome, telefone,endereco;
	
	public Responsavel(String email, String nome, String telefone, String endereco)throws Exception{
		if(!numerico(telefone)){
			throw new Exception("O telefone deve conter apenas numeros");
		}
		
		this.email = email;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		
	}
	
	private boolean numerico(final String s){
		try{
			Integer.parseInt(s);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
