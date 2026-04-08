package goti.fatec.repository;

import goti.fatec.entity.Pessoa;

import goti.fatec.repository.PessoaRepository;
import org.springframework.stereotype.Repository;
import goti.fatec.repository.adapter.PessoaRepositoryAdapter;
import goti.fatec.repository.mongo.PessoaRepositoryWithMongo;
import goti.fatec.repository.orm.PessoaOrmMongo;

import java.util.Optional;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {

    private final PessoaRepositoryWithMongo repository;

    public PessoaRepositoryImpl(PessoaRepositoryWithMongo repository) {
        this.repository = repository;
    }

    @Override
    public Pessoa cadastrar(Pessoa cliente) {
        PessoaOrmMongo orm = PessoaRepositoryAdapter.castEntity(cliente);
        PessoaOrmMongo ormSave = repository.save(orm);
        return PessoaRepositoryAdapter.castOrm(ormSave);
    }

    @Override
    public Pessoa pesquisar(String id){
        Optional<PessoaOrmMongo> orm = repository.findById(id);
        if (orm.isEmpty()) return null;

        return PessoaRepositoryAdapter.castOrm(orm.get());
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa){
        PessoaOrmMongo orm = PessoaRepositoryAdapter.castEntity(pessoa);
        PessoaOrmMongo ormUpdate = repository.save(orm);
        return PessoaRepositoryAdapter.castOrm(ormUpdate);
    }

    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }


}