package controle;

import modelo.Sala;

public class SalaControle {
	
	Sala sala;
	
	public void salvar(Sala sala) throws Exception{
		if(sala.getDescricao()==null || sala.getDescricao().trim().isEmpty()){
			throw new Exception("A descricao eh obrigatoria!");
		}
		if(sala.getLocalizacao()==null || sala.getLocalizacao().trim().isEmpty()){
			throw new Exception("A localizacao eh obrigatoria!");
		}
		Integer quantidade = sala.getQuantidadeLugares();
		if(quantidade==null||quantidade<0){
			throw new Exception("A quantidade de lugares eh obrigatoria");
		}
		if(sala.getTipo()==null|| sala.getTipo().trim().isEmpty()){
			throw new Exception("O tipo de sala eh obrigatorio!");
		}
	}

}
