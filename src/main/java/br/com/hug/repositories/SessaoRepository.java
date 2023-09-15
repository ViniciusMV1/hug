package br.com.hug.repositories;

import br.com.hug.models.sessao.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessaoRepository extends JpaRepository<Sessao, Long> {
    Sessao getById(Long cpf);

    Optional<Sessao> findById(Long cpf);
}
