package controller;

import java.sql.ResultSet;

import model.UsuarioM;

public class UsuarioC {
	
	// acesso ao bd manipular dml
	BancoDeDados bd = new BancoDeDados();
	//ResultSet para receber dados de consulta
	ResultSet dados;
	
	public void cadastrarUsuario(UsuarioM usuario) {
			
			try {
				//conex�o com base de dados
				bd.conexao();
				
				//Comando SQL (para inser��o � o INSERT)
				
				String sql = "insert into usuario values ('"+usuario.getId()+"','"+usuario.getLogin()+"','"+usuario.getSenha()+"')";
				//Cria o Statement para rodar o DML no postgresql banco usuario
				bd.getStatement().execute(sql);
				
				//Aviso cadastro com sucesso
				
				javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
				aviso.showMessageDialog(null, "Usuario cadastrado");
				
				//Desconex�o base de dados
				bd.desconecta();
				
			}catch(Exception erro) {
				erro.printStackTrace();
				
				//Aviso de Erro
				
				javax.swing.JOptionPane aviso = new javax.swing.JOptionPane();
				aviso.showMessageDialog(null, "ERRO");
			}
			
	}
	public void BuscaPorIdUsuario(int id) {
			
			try {
				bd.conexao();
				String sql = "select * from usuario where id = '"+id+"'";
				dados = bd.getStatement().executeQuery(sql);
				
				//impress�o dos dados no prompt
				while(dados.next()) {
					System.out.println("--------------------------------------");
					System.out.println("Id:                  "+ dados.getInt(1));
					System.out.println("Login:               "+ dados.getString(2));
					System.out.println("Senha:               "+ dados.getString(3));
					
				}
				
				
				bd.desconecta();
				
				
			}catch(Exception erro) {
				erro.printStackTrace();
			}
			
		}
}
