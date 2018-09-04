package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteJdbcDAO {

	private Connection conn;
	
	
	public ClienteJdbcDAO(Connection conn) {
		this.conn = conn;
	}
	
	
	public void salvar(Cliente c) throws SQLException {
		String sql = "insert into cliente (nome, endereco, bairro) values ('"+c.getNome()+"','"+c.getEndereco()+"','"+c.getFone()+"','" + c.getEmail() + "');";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	}
	
	public void alterar(Cliente c) {
		String sql = "update cliente set nome='"+c.getNome()+"',endereco='"+c.getEndereco()+"',bairro='"+c.getFone()+"',email='"+c.getEmail()+"';";
		System.out.println(sql);
		PreparedStatement prepareStatement;
		try {
			prepareStatement = this.conn.prepareStatement(sql);
			prepareStatement.executeUpdate();
            prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void excluir(int id) {
		String sql = "delete from cliente where id='"+id+"';";
		System.out.println(sql);
        try {
    		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
    		prepareStatement.executeUpdate();
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}                		
	}
	
	public List<Cliente> listar() {
		String sql = "select * from cliente";
        System.out.println(sql);		
        List<Cliente> alunos = new ArrayList<Cliente>();
		try {
			PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String fone = rs.getString("fone");
				String email = rs.getString("email");
				Cliente aluno = new Cliente();
				aluno.setNome(nome);
				aluno.setEndereco(endereco);
				aluno.setFone(fone);
				aluno.setEmail(email);
			}
			prepareStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alunos;
	}
}
