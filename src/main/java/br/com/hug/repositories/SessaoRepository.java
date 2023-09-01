package br.com.hug.repositories;

import br.com.hug.models.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, String> {
}
