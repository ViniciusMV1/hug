package br.com.hug.repositories;

import br.com.hug.models.psicologo.Psicologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PsicologoRepository extends JpaRepository<Psicologo,String> {
}
