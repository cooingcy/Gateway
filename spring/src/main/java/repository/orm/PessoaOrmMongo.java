package goti.fatec.repository.orm;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Pessoa")
public record PessoaOrmMongo(
        @Id
        String id,
        String nome,
        String telefone
) {

}
