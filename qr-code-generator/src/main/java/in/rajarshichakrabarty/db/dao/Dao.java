package in.rajarshichakrabarty.db.dao;

import java.util.List;

import in.rajarshichakrabarty.db.model.DBEntity;

public interface Dao<T extends DBEntity, I> {

	List<T> findAll();
	
	T findById(T id);
	
	void save(T t);
	
	void remove(T t);
}
