package com.infortech.Restaurante.repositorios;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.infortech.Restaurante.ConnectionManager.ConnectionManager;
import com.infortech.Restaurante.classes.Prato;

public class PratoRepository implements IGenericRepository<Prato, Integer>{
	
	ConnectionManager cm = new ConnectionManager();
	
	@Override
	public void create(Prato p) {
		PreparedStatement ps;
		try {
			ps = cm.getCurrentConnection().
					prepareStatement("INSERT INTO Prato (nome, descricao, url, preco) VALUES (?, ?, ?, ?)");
			

			ps.setString(1, p.getNome());
			ps.setString(2, p.getDescricao());
			ps.setString(3, p.getUrl());
			ps.setDouble(4, p.getPreco());
			
			ps.execute();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
    public void update(Prato p) {
		
	}
	
    @Override
	public Prato read(Integer i) {
    	return null;
    }
    
    @Override
    public void delete(Integer i) {
    	
    }
    
    @Override
    public List<Prato> readAll() {
    	return null;
    }
}
