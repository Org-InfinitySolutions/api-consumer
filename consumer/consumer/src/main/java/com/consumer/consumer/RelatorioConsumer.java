package com.consumer.consumer;

import com.consumer.consumer.config.EmailSender;
import com.consumer.consumer.config.EmailTemplateBuilder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;

@Component
public class RelatorioConsumer {

    @Autowired
    private EmailSender emailSender;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final EmailTemplateBuilder templateBuilder = new EmailTemplateBuilder();

    @RabbitListener(queues = "${broker.queue.name}")
    public void consumirMensagem(String mensagemJson) {
        try {
            MensagemRelatorioDTO dto = objectMapper.readValue(mensagemJson, MensagemRelatorioDTO.class);
            String relatorio = templateBuilder.gerarTemplateRelatorioMensalPedidos(dto.relatorio());
            emailSender.enviarEmailHtmlAsync(dto.email(), dto.tituloRelatorio(), relatorio);
            System.out.println("📩 E-mail enviado com sucesso para " + dto.email());
        } catch (Exception e) {
            System.err.println("❌ Erro ao processar mensagem: " + e.getMessage());
        }
    }
}
