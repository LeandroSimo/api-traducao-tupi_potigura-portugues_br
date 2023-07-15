package com.tcc.tradutor.repositories;

import com.tcc.tradutor.model.Palavra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalavraRepository extends JpaRepository<Palavra, Long> {
    Palavra findFirstByPalavraTupi(String palavraTupi);
}
