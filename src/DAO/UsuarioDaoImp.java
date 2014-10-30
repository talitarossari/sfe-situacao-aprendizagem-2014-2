package DAO;


/* public class UsuarioDaoImp implements UsuarioDao{

	private final String INSERT = "insert into usuario (login, senha, Pessoa_idPessoa) values (?,?,?)";
   private final String UPDATE = "update usuario set login = ?, senha = ? where idusuario = ?";
	private final String DELETE = "delete from usuario where idusuario = ?";
   private final String ALL = "select * from usuario";
	// private final String VERIFICAR = "select * from usuario where dataa = ?";
	private static Connection connection;
	
	public UsuarioDaoImp() {
		openConnection();
	}
	
	public Usuario salvar(Usuario e){
		try {

			PreparedStatement ps = null;
			
			ps = ConnectionManager.getInstance().getConnection().prepareStatement(INSERT);
			
			ps.setObject(1, e.getLogin());
			ps.setObject(2, e.getSenha());
			ps.setObject(3, e.getPessoa().getIdPessoa());
			
			ps.executeUpdate();
			
		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
		return e;
		}
	
	public void alterar(Usuario e) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(UPDATE);
			
			ps.setObject(1, e.getLogin());
			ps.setObject(2, e.getSenha());
			ps.setObject(3, e.getIdUsuario());
			
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
	}
	
	public void deletar(Usuario e) {
		try {
			PreparedStatement ps = null;
			ps = connection.prepareStatement(DELETE);

			ps.setObject(1, e.getIdUsuario());
			
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
	}
	
	/* public List<Usuario> findAll() {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			ps = connection.prepareStatement(ALL);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getInt("idUsuario"));
				usuario.setRegistro(rs.getString("registro"));
				usuario.setDataa(rs.getDate("dataa"));
				usuarios.add(usuario);
			}

		} catch (SQLException ex) {
			Logger.getLogger(EventoDaoImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			this.closeConnection();
		}
		return eventos;
	} 
} */
