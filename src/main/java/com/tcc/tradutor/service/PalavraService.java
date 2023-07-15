package com.tcc.tradutor.service;

import com.tcc.tradutor.model.Palavra;
import com.tcc.tradutor.repositories.PalavraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PalavraService {
    @Autowired
    private final PalavraRepository palavraRepository;

    public String traduzirPalavra(String palavraTupi) {
        Palavra palavra = palavraRepository.findFirstByPalavraTupi(palavraTupi);

        if (palavra != null) {
            return palavra.getPalavraPortugues();
        } else {
            return "Tradução não encontrada.";
        }
    }
}
