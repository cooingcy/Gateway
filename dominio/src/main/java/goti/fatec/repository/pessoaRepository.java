package goti.fatec.repository;

import goti.fatec.entity.Pessoa;

import java.util.Collection;

public interface pessoaRepository {
    Collection<Pessoa> listar();
    Pessoa salvar(Pessoa pessoa);
    Pessoa atualizar(Pessoa pessoa);
    boolean deletar(String id);
}
