package com.infortech.Restaurante.repositorios;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.infortech.Restaurante.ConnectionManager.ConnectionManager;
import com.infortech.Restaurante.classes.Cliente;
import com.infortech.Restaurante.classes.Pedido;

public class PedidoRepository implements IGenericRepository<Pedido, Integer> {
	
	ConnectionManager cm = new ConnectionManager();
	
	@Override
	public void create(Pedido p) {
		try {
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	@Override
    public void update(Pedido p) {
		
	}
	
    @Override
	public Pedido read(Integer i) {
    	
    }
    
    @Override
    public void delete(Integer i) {
    	
    }
    
    @Override
    public List<Pedido> readAll() {
    	
    }
}
