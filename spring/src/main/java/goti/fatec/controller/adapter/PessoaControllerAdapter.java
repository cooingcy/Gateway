package goti.fatec.controller.adapter;

import goti.fatec.controller.dto.request.PessoaRequest;
import goti.fatec.controller.dto.response.PessoaResponse;
import goti.fatec.entity.Pessoa;

import java.util.UUID;

public final class PessoaControllerAdapter {

    private PessoaControllerAdapter() {}

    public static Pessoa castRequest(PessoaRequest request) {

        return new Pessoa(
                gerarIdSeNecessario(request.id()),
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

    private static String gerarIdSeNecessario(String id) {
        return (id == null || id.isBlank())
                ? UUID.randomUUID().toString()
                : id;
    }
}