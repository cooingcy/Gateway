package goti.fatec.repository.adapter;

import goti.fatec.entity.Pessoa;
import goti.fatec.repository.orm.PessoaOrmMongo;

public class PessoaRepositoryAdapter {
    private PessoaRepositoryAdapter() {
    }

    public static Pessoa castOrm(PessoaOrmMongo orm) {
        return new Pessoa(
                orm.id(),
                orm.nome(),
                orm.telefone());
    }

    public static PessoaOrmMongo castEntity(Pessoa entity) {
        return new PessoaOrmMongo(
                entity.id(),
                entity.nome(),
                entity.telefone()
        );
    }
}
