package banco_de_dados.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import banco_de_dados.BD;
import banco_de_dados.ConnectionData;
import banco_de_dados.dbo.Aluno;

public class Alunos {
	
	private BD bancoConec;
	
	public Alunos()throws Exception{
		this.bancoConec = new BD(ConnectionData.DRIVER,
				ConnectionData.CONNECTION_STRING,
				ConnectionData.USER, ConnectionData.PASSWORD);
	}
	
	public void inserirAluno(Aluno aluno) throws Exception{
		// checa se o aluno j� foi cadastrado
		String comSql = "select * from ACI_Aluno where RA='" + aluno.getRA() + "'";
		ResultSet result = this.bancoConec.execConsulta(comSql);
		if(result.first()){
			throw new Exception("Aluno Com Esse RA J� Existente");
		}
		result.close();
		
		// checa se o responsavel j� foi cadastrado
		comSql = "select * from ACI_Responsavel where Email='" + aluno.getResponsavel() +"'";
		result = this.bancoConec.execConsulta(comSql);
		if(!result.first()){
			throw new Exception("Respons�vel N�o Cadastrado");
		}
		result.close();
		
		// insere aluno
		comSql= "insert into ACI_Aluno values('"+aluno.getRA() +"','"+ aluno.getNome() +"','"+aluno.getEmail() +"','" + aluno.getTelefone() +
				"','"+aluno.getEndereco() + "','"+aluno.getResponsavel() + "')";
		this.bancoConec.execComando(comSql);
	}
	
	public void editarAluno(Aluno aluno) throws Exception{
		// checa se o aluno j� foi cadastrado
		String comSql = "select * from ACI_Aluno where RA='" + aluno.getRA() + "'";
		ResultSet result = this.bancoConec.execConsulta(comSql);
		if(!result.first()){
			throw new Exception("Aluno Com Esse RA N�o Existente");
		}
		result.close();
				
		// checa se o responsavel j� foi cadastrado
		comSql = "select * from ACI_Responsavel where Email='" + aluno.getResponsavel() +"'";
		result = this.bancoConec.execConsulta(comSql);
		if(!result.first()){
			throw new Exception("Respons�vel N�o Cadastrado");
		}
		result.close();
				
		// edita
		comSql = "update ACI_Aluno set Nome = '" + aluno.getNome() + "', Email='" + aluno.getEmail()+
				"', Telefone='"+aluno.getTelefone()+"', Endereco='"+aluno.getEndereco()+
				"', Responsavel='"+aluno.getResponsavel()+"' where ra='"+aluno.getRA()+"'"; 
		this.bancoConec.execComando(comSql);
	}
	
	public ResultSet getAlunos()throws Exception{
		String comSql = "select * from ACI_Aluno";
		ResultSet result = this.bancoConec.execConsulta(comSql);
		if(result.first()){
			result.beforeFirst();
			return result;
		}else{
			result.close();
			return null;
		}
	}
	
	public Aluno getAluno(String ra)throws Exception{
		String comSql = "select * from ACI_Aluno where ra='"+ra+"'";
		ResultSet result = this.bancoConec.execConsulta(comSql);
		if(result.first()){
			Aluno aluno = new Aluno(result.getString("RA"),
					result.getString("nome"),result.getString("Email"), result.getString("telefone")
					, result.getString("Endereco"),result.getString("Responsavel"));
			result.close();
			return aluno;
		}else{
			result.close();
			return null;
		}
	}
	
	public ArrayList<Aluno> buscarAluno(String RA, String nome, String email, String telefone, String endereco, String responsavel){
		return null;
	}
	
	public void removerAluno(String RA)throws Exception{
		// checa se o aluno j� foi cadastrado
		String comSql = "select * from ACI_Aluno where RA='" + RA + "'";
		ResultSet result = this.bancoConec.execConsulta(comSql);
		if(!result.first()){
			result.close();
			throw new Exception("Aluno Com Esse RA N�o Existente");
		}
		result.close();
		
		comSql = "delete from ACI_Aluno where RA='" + RA + "'";
		this.bancoConec.execComando(comSql);
	}
}
