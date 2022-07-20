package com.infortech.Restaurante.repositorios;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.infortech.Restaurante.ConnectionManager.ConnectionManager;
import com.infortech.Restaurante.classes.FormaPagamento;
import com.infortech.Restaurante.classes.Prato;

public class FormaPagamentoRepository implements IGenericRepository<FormaPagamento, Integer>{
	public FormaPagamentoRepository() {
		
	}
	
	ConnectionManager cm = new ConnectionManager();
	
	@Override
	public void create(FormaPagamento f) {
		PreparedStatement ps;
		try {
			ps = cm.getCurrentConnection().prepareStatement("INSERT INTO FormaPagamento (descricao) VALUES (?)");
			ps.setString(1, f.getDescricao());
			
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
    public void update(FormaPagamento f) {
		try {
			PreparedStatement ps = cm.getCurrentConnection().
					prepareStatement("UPDATE FormaPagamento SET descricao = ? WHERE ID = ?");
			ps.setString(1, f.getDescricao());
			ps.setInt(2, f.getId());
			
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
	public FormaPagamento read(Integer i) {
    	FormaPagamento fp = new FormaPagamento();
    	try {
			PreparedStatement ps = cm.getCurrentConnection().prepareStatement("SELECT * FROM FormaPagamento WHERE ID = ?");
			ps.setInt(1, i);
			
			ResultSet rs = ps.executeQuery();
			
			fp.setDescricao(rs.getString("descricao"));
			
						
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return fp;
    }
    
    @Override
    public void delete(Integer i) {
    	PreparedStatement ps;
		try {
			ps = cm.getCurrentConnection().prepareStatement("DELETE FROM FormaPagamento WHERE ID = ?");
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
    public List<FormaPagamento> readAll() {
    	List<FormaPagamento> listaFormaPagamento = new ArrayList<>();
    	try {
			PreparedStatement ps = cm.getCurrentConnection().prepareStatement("SELECT * FROM FormaPagamento");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				FormaPagamento fp = new FormaPagamento();
				fp.setDescricao(rs.getString("descricao"));
				
				listaFormaPagamento.add(fp);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return listaFormaPagamento;
    }
}
