package com.infortech.Restaurante.repositorios;

import java.sql.SQLException;
import java.util.List;

public interface IGenericRepository<T, I>  {
	    
	    public void create(T t);
	    public void update(T t);
	    public T read(I i);
	    public void delete(I i);
	    public List<T> readAll();
	    
}
