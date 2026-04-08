package goti.fatec.repository;


import goti.fatec.entity.Pessoa;
import goti.fatec.repository.adapter.pessoaRepositoryAdapter;
import goti.fatec.repository.mongo.pessoaMongoDB;
import goti.fatec.repository.orm.pessoaOrmMongo;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.stream.Collectors;

@Repository
public class PessoaRepositoryImpl implements pessoaRepository {
    private final pessoaMongoDB mongoRepository;

    public PessoaRepositoryImpl(pessoaMongoDB mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public Collection<Pessoa> listar() {
        return mongoRepository.findAll()
                .stream()
                .map(pessoaRepositoryAdapter::castOrm)
                .collect(Collectors.toList());
    }

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        pessoaOrmMongo orm = pessoaRepositoryAdapter.castEntity(pessoa);
        pessoaOrmMongo salvo = mongoRepository.save(orm);
        return pessoaRepositoryAdapter.castOrm(salvo);
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) {
        return salvar(pessoa);
    }

    @Override
    public boolean deletar(String id) {
        if (mongoRepository.existsById(id)) {
            mongoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}