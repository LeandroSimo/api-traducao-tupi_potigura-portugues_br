package com.tcc.tradutor.service;

import com.tcc.tradutor.model.Palavra;
import com.tcc.tradutor.repositories.PalavraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PalavraService {
    @Autowired
    private final PalavraRepository palavraRepository;

    public String traduzirFrase(String fraseTupi) {
        String[] palavrasTupi = fraseTupi.split(" ");
        List<String> palavrasTraduzidas = new ArrayList<>();
        int index = 0;

        while (index < palavrasTupi.length) {
            int palavrasRestantes = palavrasTupi.length - index;
            String palavraAtual = String.join("", palavrasTupi[index],
                    (palavrasRestantes > 1) ? palavrasTupi[index + 1] : "",
                    (palavrasRestantes > 2) ? palavrasTupi[index + 2] : "");

            String traducao = traduzirPalavra(palavraAtual);

            if (!traducao.equals(palavraAtual)) {
                palavrasTraduzidas.add(traducao);
                index += (palavrasRestantes >= 3) ? 3 : (palavrasRestantes == 2) ? 2 : 1;
            } else if (palavrasRestantes >= 2) {
                palavraAtual = String.join("", palavrasTupi[index],
                        (palavrasRestantes > 1) ? palavrasTupi[index + 1] : "");
                traducao = traduzirPalavra(palavraAtual);
                if (!traducao.equals(palavraAtual)) {
                    palavrasTraduzidas.add(traducao);
                    index += 2;
                } else {
                    palavrasTraduzidas.add(traduzirPalavra(palavrasTupi[index]));
                    index += 1;
                }
            } else {
                palavrasTraduzidas.add(traduzirPalavra(palavrasTupi[index]));
                index += 1;
            }
        }

        return String.join(" ", palavrasTraduzidas);
    }

    private String traduzirPalavra(String palavraTupi) {
        Palavra palavra = palavraRepository.findFirstByPalavraTupi(palavraTupi);
        return (palavra != null) ? palavra.getPalavraPortugues() : palavraTupi;
    }

}
