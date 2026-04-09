package goti.fatec.repository;

import goti.fatec.entity.Pessoa;
import org.springframework.stereotype.Repository;
import goti.fatec.repository.adapter.PessoaRepositoryAdapter;
import goti.fatec.repository.mongo.PessoaRepositoryWithMongo;
import goti.fatec.repository.orm.PessoaOrmMongo;

@Repository
public class PessoaRepositoryImpl implements PessoaRepository {

    private final PessoaRepositoryWithMongo repository;

    public PessoaRepositoryImpl(PessoaRepositoryWithMongo repository) {
        this.repository = repository;
    }

    @Override
    public Pessoa cadastrar(Pessoa pessoa) {
        return salvar(pessoa);
    }

    @Override
    public Pessoa pesquisar(String id) {
        return repository.findById(id)
                .map(PessoaRepositoryAdapter::castOrm)
                .orElse(null);
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) {
        return salvar(pessoa);
    }

    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }

    private Pessoa salvar(Pessoa pessoa) {
        PessoaOrmMongo orm = PessoaRepositoryAdapter.castEntity(pessoa);
        PessoaOrmMongo ormSave = repository.save(orm);
        return PessoaRepositoryAdapter.castOrm(ormSave);
    }
}