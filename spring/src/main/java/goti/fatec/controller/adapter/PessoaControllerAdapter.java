package goti.fatec.controller.adapter;

import goti.fatec.controller.dto.request.PessoaRequest;
import goti.fatec.controller.dto.response.PessoaResponse;
import goti.fatec.entity.Pessoa;

import java.util.UUID;

public class PessoaControllerAdapter {
    private PessoaControllerAdapter() {
    }

    public static Pessoa castRequest(PessoaRequest request) {

        String id = request.id();

        if (id == null || id.isBlank()) {
            id = UUID.randomUUID().toString();
        }

        return new Pessoa(
                id,
                request.nome(),
                request.telefone()
        );
    }

    public static PessoaResponse castResponse(Pessoa pessoa) {
        return new PessoaResponse(
                pessoa.id(),
                pessoa.nome(),
                pessoa.telefone()
        );
    }
}
