package goti.fatec.repository;

import goti.fatec.entity.Pessoa;


public interface PessoaRepository {
    Pessoa cadastrar(Pessoa pessoa);
    Pessoa pesquisar(String id);
    Pessoa atualizar(Pessoa pessoa);
    void deletar(String id);
}
