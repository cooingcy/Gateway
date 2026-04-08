package goti.fatec.repository.mongo;

import goti.fatec.repository.orm.pessoaOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface pessoaMongoDB extends MongoRepository<pessoaOrmMongo, String> {
}