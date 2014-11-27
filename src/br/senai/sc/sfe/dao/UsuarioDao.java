package br.senai.sc.sfe.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.senai.sc.sfe.entity.Sala;
import br.senai.sc.sfe.entity.Usuario;
import br.senai.sc.sfe.utils.JpaUtils;


/**
 * @author nestor_augusto
 *
 */

public class UsuarioDao {

	private EntityManager entityManager;

	/**
	 * Consutor criando instancia
	 * */
	public UsuarioDao() {
		JpaUtils.getInstance().createEntityManagerFactory();
		entityManager = JpaUtils.getInstance().getEntityManager();
	}

	public Usuario salvar(Usuario usuario) {
		try {
			if (usuario.getIdUsuarios() == null) {
				entityManager.persist(usuario);
			} else {
				entityManager.merge(usuario);
			}
		} catch (Exception e) {
			Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE,
					null, e);
		}
		return usuario;
	}

	/**
	 * Esse metodo remove o Usuario.
	 * */
	public void remover(int id) {
		Usuario usuario = entityManager.getReference(Usuario.class, id);
		entityManager.remove(usuario);
	}

	/**
	 * Esse metodo lista os Usuarios.
	 * */
	public List<Usuario> listar() {
		Query query = entityManager.createQuery("From Usuario", Usuario.class);
		return query.getResultList();
	}

	/**
	 * Esse metodo busca o Usuario pelo ID.
	 * */
	public Usuario buscarPorId(int id) {
		return entityManager.find(Usuario.class, id);
	}

	/**
	 * Esse metodo verifica se o Usuario Existe
	 * */
	public boolean buscarUsuario(String login, int senha) {
		Query query = entityManager.createQuery(
				"From Usuario u where u.login = login and u.senha = senha",
				Usuario.class);
		query.setParameter("login", login);
		query.setParameter("senha", senha);

		if (query.getResultList() == null) {
			return false;
		} else {
			return true;
		}
	}
}
