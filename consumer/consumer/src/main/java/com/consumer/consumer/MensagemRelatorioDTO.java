package com.consumer.consumer;
public record MensagemRelatorioDTO(
        String email,
        String tituloRelatorio,
        RelatorioDto relatorio
) {

}
