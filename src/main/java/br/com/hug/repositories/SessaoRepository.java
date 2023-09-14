package br.com.hug.repositories;

import br.com.hug.models.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessaoRepository extends JpaRepository<Sessao, String> {
    Optional<Object> getById(Long cpf);

    Optional<Object> findById(Long cpf);
}
