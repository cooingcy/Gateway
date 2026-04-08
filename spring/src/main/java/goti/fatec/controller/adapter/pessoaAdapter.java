package goti.fatec.controller.adapter;

import goti.fatec.controller.dto.request.pessoaRequest;
import goti.fatec.controller.dto.response.pessoaResponse;
import goti.fatec.entity.Pessoa;

import java.util.UUID;

public class pessoaAdapter {

    private pessoaAdapter() {}

    public static Pessoa castRequest(pessoaRequest request) {
        return new Pessoa(
                UUID.randomUUID().toString(),
                request.nome(),
                request.telefone()
        );
    }

    public static pessoaResponse castResponse(Pessoa pessoa) {
        return new pessoaResponse(
                pessoa.id(),
                pessoa.nome(),
                pessoa.telefone());
    }
}
