package br.com.pamcary.controller;

import java.util.List;
import br.com.pamcary.entity.Pessoa;
import br.com.pamcary.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @GetMapping("/pessoas")
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @PostMapping("/pessoas")
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @GetMapping("/pessoas/{codigo}")
    public Pessoa getPessoaById(@PathVariable Long codigo) {
        return pessoaRepository.findById(codigo).get();
    }
    @DeleteMapping("/pessoas/{codigo}")
    public Pessoa deletarPessoa(@PathVariable Long codigo) {
        return pessoaRepository.findById(codigo).orElse(null);
    }
}
