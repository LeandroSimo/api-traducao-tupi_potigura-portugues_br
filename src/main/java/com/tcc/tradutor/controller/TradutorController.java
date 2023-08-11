package com.tcc.tradutor.controller;

import com.tcc.tradutor.service.PalavraService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/palavras")
public class TradutorController {

    @Autowired
    private final PalavraService palavraService;

    @GetMapping("/traducao")
    public ResponseEntity<String> buscarTraducao(@RequestParam("fraseTupi") String fraseTupi) {
        String fraseTraduzida = palavraService.traduzirFrase(fraseTupi);
        if (fraseTraduzida != null) {
            return ResponseEntity.ok(fraseTraduzida);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
