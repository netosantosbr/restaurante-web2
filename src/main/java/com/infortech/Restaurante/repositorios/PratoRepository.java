package com.infortech.Restaurante.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infortech.Restaurante.ConnectionManager.ConnectionManager;
import com.infortech.Restaurante.classes.Prato;

public class PratoRepository implements IGenericRepository<Prato, Integer>{
	
	public PratoRepository() {
		
	}
	
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
    	PreparedStatement ps;
		try {
			ps = cm.getCurrentConnection().prepareStatement("DELETE FROM Prato WHERE id = ?");
			ps.setInt(1, i);
			
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
    public List<Prato> readAll() {
    	List<Prato> listaPratos = new ArrayList<>();
    	try {
			PreparedStatement ps = cm.getCurrentConnection().prepareStatement("SELECT * FROM Prato");
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Prato p = new Prato();
				p.setNome(rs.getString("nome"));
				p.setDescricao(rs.getString("descricao"));
				p.setUrl(rs.getString("url"));
				p.setPreco(Double.parseDouble(rs.getString("preco")));
				
				listaPratos.add(p);
				
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return listaPratos;
    }
}
