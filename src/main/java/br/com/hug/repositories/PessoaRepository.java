package br.com.hug.repositories;

import br.com.hug.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.support.Repositories;

public interface PessoaRepository extends JpaRepository<Pessoa, String>{

}
