package com.projeto.restapi.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.restapi.entidade.Contato;
import com.projeto.restapi.database.RepositorioContato;

public interface RepositorioContato extends JpaRepository<Contato,Long> {
    

}
