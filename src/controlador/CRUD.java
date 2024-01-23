package controlador;

import java.util.Iterator;
import java.util.List;

public interface CRUD<E> {
	
	boolean add(E element);
	List<E> search (E element);
	boolean update (E element);
	boolean delete (E element);
	Iterator<E> listAll();

}
