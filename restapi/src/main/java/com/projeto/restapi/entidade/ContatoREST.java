package com.projeto.restapi.entidade;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.restapi.database.RepositorioContato;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/contato")
public class ContatoREST {
    @Autowired
    private RepositorioContato repositorio;

    @GetMapping
    public List<Contato> listar() {
        return repositorio.findAll();
    }

    @PostMapping
    public void salvar(@RequestBody Contato contato) {
        repositorio.save(contato);
    }

    @PutMapping
    public void alterar(@RequestBody Contato contato) {
        if (contato.getId() > 0)
            repositorio.save(contato);
    }

    @PatchMapping(path = "/atualiza/{id}/{nome}")
    public void atualizarNome(@PathVariable("id") Long id, @PathVariable("nome") String nome) throws Exception {

        Contato contatoEncontrado = repositorio.findById(id).orElse(null);

        if (contatoEncontrado == null) {
            throw new Exception("Not Found");
        }

        contatoEncontrado.setNome(nome);
        repositorio.save(contatoEncontrado);

    }

    @DeleteMapping(path = "/deletar/{id}")
    public void excluir(@PathVariable Long id) throws Exception {

        Contato contatoEncontrado = repositorio.findById(id).orElse(null);

        if (contatoEncontrado == null) {
            throw new Exception("Not Found");
        }

        repositorio.delete(contatoEncontrado);
    }
}
