package goti.fatec.repository.adapter;

import goti.fatec.entity.Pessoa;
import goti.fatec.repository.orm.pessoaOrmMongo;

public class pessoaRepositoryAdapter {
    private pessoaRepositoryAdapter(){}
    public static Pessoa castOrm(pessoaOrmMongo orm) {
        return new Pessoa(
                orm.id(),
                orm.nome(),
                orm.telefone());
    }

    public static pessoaOrmMongo castEntity(Pessoa entity) {
        return new pessoaOrmMongo(
                entity.id(),
                entity.nome(),
                entity.telefone());
    }
}
