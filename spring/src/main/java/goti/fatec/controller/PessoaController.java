package goti.fatec.controller;

import goti.fatec.controller.adapter.PessoaControllerAdapter;
import goti.fatec.controller.dto.request.PessoaRequest;
import goti.fatec.controller.dto.response.PessoaResponse;
import goti.fatec.entity.Pessoa;
import goti.fatec.repository.PessoaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    public final PessoaRepository pessoaRepository;

    public PessoaController(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    // CREATE
    @PostMapping("/cadastrar")
    public PessoaResponse salvar(@RequestBody PessoaRequest request) {
        Pessoa pessoa = PessoaControllerAdapter.castRequest(request);
        Pessoa pessoaSalvo = pessoaRepository.cadastrar(pessoa);
        return PessoaControllerAdapter.castResponse(pessoaSalvo);
    }

    // READ
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> pesquisar(@PathVariable String id) {

        Pessoa pessoa = pessoaRepository.pesquisar(id);

        if (pessoa == null) {
            return ResponseEntity.status(404).body("Pessoa não encontrada");
        }

        return ResponseEntity.ok(PessoaControllerAdapter.castResponse(pessoa));
    }

    // UPDATE
    @PutMapping("/atualizar")
    public PessoaResponse atualizar(@RequestBody PessoaRequest request) {

        Pessoa pessoa = PessoaControllerAdapter.castRequest(request);

        Pessoa pessoaAtualizado = pessoaRepository.atualizar(pessoa);

        return PessoaControllerAdapter.castResponse(pessoaAtualizado);
    }

    // DELETE
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id) {
        pessoaRepository.deletar(id);
        return ResponseEntity.ok("Pessoa deletada com sucesso");
    }
}