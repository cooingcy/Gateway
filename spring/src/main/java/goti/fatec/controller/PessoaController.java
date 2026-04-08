package goti.fatec.controller;


import goti.fatec.controller.adapter.pessoaAdapter;
import goti.fatec.controller.dto.request.pessoaRequest;
import goti.fatec.controller.dto.response.pessoaResponse;
import goti.fatec.entity.Pessoa;
import goti.fatec.repository.pessoaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {


    private final pessoaRepository repository;

    public PessoaController(pessoaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public Collection<pessoaResponse> listar() {
        return repository.listar()
                .stream()
                .map(pessoaAdapter::castResponse)
                .collect(Collectors.toList());
    }

    @PostMapping
    public pessoaResponse criar(@RequestBody pessoaRequest request) {

        Pessoa pessoa = pessoaAdapter.castRequest(request);
        Pessoa salvo = repository.salvar(pessoa);
        return pessoaAdapter.castResponse(salvo);
    }

    @PutMapping("/{id}")
    public pessoaResponse atualizar(@PathVariable String id, @RequestBody pessoaRequest request) {
        Pessoa pessoa = new Pessoa(id, request.nome(), request.telefone());
        Pessoa atualizada = repository.atualizar(pessoa);

        return pessoaAdapter.castResponse(atualizada);
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable String id) {
        boolean excluiu = repository.deletar(id);
        if (excluiu) {
            return "Pessoa " + id + " deletada com sucesso!";
        }
        return "Pessoa não encontrada.";
    }
}