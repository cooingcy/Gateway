package goti.fatec.repository.mongo;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import goti.fatec.repository.orm.PessoaOrmMongo;

@Repository
public interface PessoaRepositoryWithMongo extends MongoRepository<PessoaOrmMongo, String> {
}
