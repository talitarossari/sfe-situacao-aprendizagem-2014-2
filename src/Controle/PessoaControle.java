package Controle;

import modelo.Pessoa;

public class PessoaControle {

	Pessoa pessoa;

	public void salvar(Pessoa pessoa) throws Exception {
		if (pessoa.getNome() == null || pessoa.getNome().trim().isEmpty()) {
			throw new Exception("O nome é obrigatorio!");
		}
		if (pessoa.getFuncao() == null || pessoa.getFuncao().trim().isEmpty()) {
			throw new Exception("A fução é obrigatoria!");
		}
		if (pessoa.getAreaAtuacao() == null || pessoa.getAreaAtuacao().trim().isEmpty()) {
			throw new Exception("A área de atuação é obrigatória!");
		}
		if(pessoa.getCpf()==null|| pessoa.getCpf().trim().length() < 14){
			throw new Exception("O CPF é obrigatório!");
		}
	}

}
