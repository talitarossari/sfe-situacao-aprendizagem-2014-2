package dao;

import java.util.List;

public interface DAO<E> {

	E salvar(E e);
    void alterar(E e);
    void deletar(E e);
    List<E> findAll();
    boolean isConnectionClose();
    void openConnection();
    void closeConnection();
    
}
