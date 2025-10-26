package com.consumer.consumer;

import java.time.LocalDateTime;

public record RelatorioDto (
    String mesAno,
    Integer totalPedidos,
    Integer pedidosEmAnalise,
    Integer pedidosAprovados,
    Integer pedidosEmEvento,
    Integer pedidosFinalizados,
    Integer pedidosCancelados,
    Integer pedidosIndoor,
    Integer pedidosOutdoor,
    Integer totalItensLocados,
    LocalDateTime dataGeracao
){
}
