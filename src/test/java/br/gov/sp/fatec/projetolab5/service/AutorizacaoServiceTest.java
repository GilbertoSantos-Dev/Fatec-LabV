package br.gov.sp.fatec.projetolab5.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import br.gov.sp.fatec.projetolab5.repository.AutorizacaoRepository;

public class AutorizacaoServiceTest {

    @Autowired
    private AutorizacaoServiceImpl autorizacao;

    @MockBean
    private AutorizacaoRepository autorizacaoRepo;

    @Test
    public void buscarAutorizacaoPeloNomeTestNOk() {
        assertThrows(IllegalArgumentException.class, () -> {
            autorizacao.buscarPeloNome(null);
    });
    }

}
