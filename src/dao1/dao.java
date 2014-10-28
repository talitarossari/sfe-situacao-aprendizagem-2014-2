package dao1;

import java.util.List;

public interface dao<E> {

	E salvar(E e);
    void alterar(E e);
    void deletar(E e);
    List<E> findAll();
    boolean isConnectionClose();
    void openConnection();
    void closeConnection();
    
}
