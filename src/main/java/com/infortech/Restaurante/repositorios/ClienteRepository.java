package com.infortech.Restaurante.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infortech.Restaurante.classes.Cliente;

import com.infortech.Restaurante.ConnectionManager.*;

public class ClienteRepository implements IGenericRepository<Cliente, String> {
	public ClienteRepository() {
	}
	
	ConnectionManager cm = new ConnectionManager();
	
	@Override
	public void create(Cliente c) {
		PreparedStatement ps;
		try {
			ps = cm.getCurrentConnection().
					prepareStatement("INSERT INTO CLIENTE (CPF, nome, telefoneContato, email, senha) "
							+ "VALUES (?, ?, ?, ?, ?)");

			ps.setString(1, c.getCpf());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getTelefoneContato());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getSenha());
			
			ps.execute();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
    public void update(Cliente c) {
		PreparedStatement ps;
		try {
			ps = cm.getCurrentConnection().
					prepareStatement("UPDATE CLIENTE SET CPF = ?, nome = ?, telefoneContato = ?, email = ?,"
							+ "senha = ? WHERE CPF = ?");
			ps.setString(1, c.getCpf());
			ps.setString(2, c.getNome());
			ps.setString(3, c.getTelefoneContato());
			ps.setString(4, c.getEmail());
			ps.setString(5, c.getSenha());
			ps.setString(6, c.getCpf());

			ps.execute();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
    @Override
	public Cliente read(String cpf) {
    	PreparedStatement ps;
		try {
			ps = cm.getCurrentConnection().prepareStatement("SELECT * FROM Cliente WHERE CPF = ?");
			ps.setString(1, cpf);
	    	
	    	ResultSet rs = ps.executeQuery();
	    	Cliente c = new Cliente();
	    	
	    	while(rs.next()) {
	    		
	    		c.setCpf(rs.getString("CPF"));
	    		c.setNome(rs.getString("nome"));
	    		c.setTelefoneContato(rs.getString("telefoneContato"));
	    		c.setEmail(rs.getString("email"));
	    		c.setSenha(rs.getString("senha"));
	    		
	    	}
	    	return c;
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return null;
    }
    
    @Override
    public void delete(String cpf) {
    	PreparedStatement ps;
		try {
			ps = cm.getCurrentConnection().prepareStatement("DELETE FROM Cliente WHERE CPF = ?");
			ps.setString(1, cpf);
	    	
	    	ps.execute();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    @Override
    public List<Cliente> readAll() {
    	List<Cliente> lc = new ArrayList<>();
    	
		try {
			PreparedStatement ps = cm.getCurrentConnection().prepareStatement("SELECT * FROM Cliente");
			ResultSet rs = ps.executeQuery();
			
    	
	    	while(rs.next()) {
	    		Cliente c = new Cliente();
	    		c.setCpf(rs.getString("CPF"));
	    		c.setNome(rs.getString("nome"));
	    		c.setTelefoneContato(rs.getString("telefoneContato"));
	    		c.setEmail(rs.getString("email"));
	    		c.setSenha(rs.getString("senha"));
	    		
	    		lc.add(c);
	    	}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return lc;
    }
}
