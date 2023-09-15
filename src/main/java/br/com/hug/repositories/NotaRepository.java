package br.com.hug.repositories;

import br.com.hug.models.nota.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota,Long> {
}
