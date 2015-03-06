package banco_de_dados.dao;

import java.sql.ResultSet;

import banco_de_dados.BD;
import banco_de_dados.dbo.Responsavel;

public class Responsaveis {
	private BD bancoConec;
	
	public Responsaveis()throws Exception{
		this.bancoConec = new BD("com.microsoft.sqlserver.jdbc.SQLServerDriver",
    			"jdbc:sqlserver://regulus:1433;databasename=BD13185",
    			"BD13185", "GeorgeOrwell");
	}
	
	public void inserirResponsavel(Responsavel responsavel) throws Exception{
		ResultSet result = this.bancoConec.execConsulta("Select * from ACI_Responsavel where Email='"
	+responsavel.getEmail()+"'");
		if(result.first()){
			throw new Exception("Responsavel com esse email j� existente");
		}
		
		String comSQL = "insert into ACI_Responsavel values('"+
				responsavel.getEmail()+"','"+responsavel.getNome()+
				"','"+ responsavel.getTelefone()+"','"+responsavel.getEndereco() + "')";
		
		this.bancoConec.execComando(comSQL);
	}
	
	public void removerResponsavel(String emailResponsavel) throws Exception{
		ResultSet result = this.bancoConec.execConsulta("Select * from ACI_Responsavel where Email='"
				+emailResponsavel+"'");
		
		if(!result.first()){
			throw new Exception("Respons�vel com esse Email inexistente");
		}
		
		String comSql = "delete from ACI_Responsavel were Email='"+emailResponsavel + "'";
		this.bancoConec.execComando(comSql);
	}
	
	public void editarResponsavel(Responsavel responsavel) throws Exception{
		ResultSet result = this.bancoConec.execConsulta("Select * from ACI_Responsavel where Email='"
				+responsavel.getEmail()+"'");
		if(!result.first()){
			throw new Exception("Responsavel com esse email j� inexistente");
		}
		
		String comSql = "update ACI_Responsavel set Nome='"+responsavel.getNome()+
				"' Telefone='" + responsavel.getTelefone() + "' Endereco='" + responsavel.getEndereco()
				+ "' were Email='"+ responsavel.getEmail() + "'";
		this.bancoConec.execComando(comSql);
	}
}
