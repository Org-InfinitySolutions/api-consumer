package com.consumer.consumer.config;

import com.consumer.consumer.RelatorioDto;

public class EmailTemplateBuilder {

    public String gerarTemplateRelatorioMensalPedidos(RelatorioDto dto) {
        return """
                <!DOCTYPE html>
                <html lang="pt-BR">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Relatório Mensal de Pedidos</title>
                    <style>
                        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap');
                        body {
                            font-family: 'Roboto', Arial, sans-serif;
                            line-height: 1.6;
                            color: #333333;
                            background-color: #f9f9f9;
                            margin: 0;
                            padding: 0;
                        }
                        .email-container {
                            max-width: 650px;
                            margin: 20px auto;
                            background-color: #ffffff;
                            border-radius: 4px;
                            overflow: hidden;
                            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
                        }
                
                        .email-header {
                            background-color: white;
                            color: black;
                            padding: 20px 30px;
                            text-align: left;
                            border-bottom: 1px solid #f1f1f1;
                            display: flex;
                            align-items: center;
                        }
                
                        .company-logo {
                            display: flex;
                            align-items: center;
                            font-weight: bold;
                        }
                
                        .logo-text {
                            font-size: 18px;
                            font-weight: 600;
                        }
                
                        .logo-icon {
                            display: inline-block;
                            width: 30px;
                            height: 30px;
                            background-color: black;
                            margin-right: 10px;
                            border-radius: 2px;
                            position: relative;
                        }
                
                        .logo-icon::after {
                            content: '';
                            position: absolute;
                            right: -2px;
                            top: 5px;
                            height: 15px;
                            width: 4px;
                            background-color: #ff6600;
                        }
                
                        .gradient-line {
                            height: 4px;
                            background: linear-gradient(90deg, #EE1C27 0%%, #3E5FA9 50%%, #017D1D 100%%);
                            margin: 0;
                        }
                
                        .email-content {
                            padding: 30px;
                            background-color: #ffffff;
                        }
                
                        h1 {
                            color: #333;
                            font-size: 24px;
                            font-weight: 500;
                            margin: 0 0 10px;
                            text-align: center;
                        }
                
                        .subtitle {
                            text-align: center;
                            color: #666;
                            font-size: 16px;
                            margin-bottom: 25px;
                        }
                
                        .greeting {
                            font-size: 16px;
                            margin-bottom: 20px;
                            color: #333;
                        }
                
                        .report-summary {
                            position: relative;
                            background: linear-gradient(135deg, #667eea 0%%, #764ba2 30%%, #3E5FA9 60%%, #2a4580 100%%);
                            border-radius: 12px;
                            padding: 40px 30px;
                            margin: 30px 0;
                            text-align: center;
                            color: white;
                            box-shadow: 0 10px 30px rgba(62, 95, 169, 0.3);
                            overflow: hidden;
                        }
                
                        .report-summary::before {
                            content: '';
                            position: absolute;
                            top: 0;
                            left: 0;
                            right: 0;
                            bottom: 0;
                            background: 
                                radial-gradient(circle at 20%% 20%%, rgba(255,255,255,0.1) 0%%, transparent 50%%),
                                radial-gradient(circle at 80%% 80%%, rgba(255,255,255,0.05) 0%%, transparent 50%%),
                                linear-gradient(45deg, rgba(255,255,255,0.03) 0%%, transparent 100%%);
                            pointer-events: none;
                        }
                
                        .summary-header {
                            position: relative;
                            z-index: 2;
                            margin-bottom: 20px;
                        }
                
                        .summary-icon {
                            display: inline-block;
                            width: 60px;
                            height: 60px;
                            background: rgba(255,255,255,0.15);
                            border-radius: 50%%;
                            line-height: 60px;
                            font-size: 28px;
                            margin-bottom: 15px;
                            border: 2px solid rgba(255,255,255,0.2);
                        }
                
                        .summary-title {
                            position: relative;
                            z-index: 2;
                            font-size: 16px;
                            font-weight: 500;
                            margin-bottom: 15px;
                            text-transform: uppercase;
                            letter-spacing: 2px;
                            opacity: 0.95;
                        }
                
                        .summary-value {
                            position: relative;
                            z-index: 2;
                            font-size: 56px;
                            font-weight: 700;
                            margin: 15px 0;
                            text-shadow: 0 2px 4px rgba(0,0,0,0.2);
                            line-height: 1;
                        }
                
                        .summary-label {
                            position: relative;
                            z-index: 2;
                            font-size: 18px;
                            font-weight: 400;
                            opacity: 0.95;
                            margin-top: 10px;
                        }
                
                        .summary-decoration {
                            position: absolute;
                            bottom: 0;
                            left: 0;
                            right: 0;
                            height: 6px;
                            background: linear-gradient(90deg, #EE1C27 0%%, #3E5FA9 50%%, #017D1D 100%%);
                            opacity: 0.8;
                        }
                
                        .metrics-grid {
                            display: grid;
                            grid-template-columns: repeat(2, 1fr);
                            gap: 15px;
                            margin: 25px 0;
                        }
                
                        .metric-card {
                            background-color: #f8f9fa;
                            border-radius: 6px;
                            padding: 20px;
                            text-align: center;
                            border-left: 4px solid #3E5FA9;
                            transition: all 0.3s ease;
                        }
                
                        .metric-card.status-em-analise {
                            border-left-color: #f39c12;
                        }
                
                        .metric-card.status-aprovado {
                            border-left-color: #3498db;
                        }
                
                        .metric-card.status-em-evento {
                            border-left-color: #9b59b6;
                        }
                
                        .metric-card.status-finalizado {
                            border-left-color: #27ae60;
                        }
                
                        .metric-card.status-cancelado {
                            border-left-color: #e74c3c;
                        }
                
                        .metric-value {
                            font-size: 32px;
                            font-weight: 700;
                            color: #333;
                            margin-bottom: 5px;
                        }
                
                        .metric-label {
                            font-size: 14px;
                            color: #666;
                            font-weight: 500;
                        }
                
                        .section-title {
                            font-size: 18px;
                            font-weight: 600;
                            color: #333;
                            margin: 30px 0 15px;
                            padding-bottom: 10px;
                            border-bottom: 2px solid #e9ecef;
                        }
                
                        .type-breakdown {
                            display: grid;
                            grid-template-columns: repeat(2, 1fr);
                            gap: 15px;
                            margin: 20px 0;
                        }
                
                        .type-card {
                            background-color: #fff;
                            border: 2px solid #e9ecef;
                            border-radius: 6px;
                            padding: 20px;
                            text-align: center;
                        }
                
                        .type-card.indoor {
                            border-color: #3E5FA9;
                            background-color: #f0f4ff;
                        }
                
                        .type-card.outdoor {
                            border-color: #017D1D;
                            background-color: #f0f9f4;
                        }
                
                        .type-icon {
                            font-size: 32px;
                            margin-bottom: 10px;
                        }
                
                        .type-value {
                            font-size: 28px;
                            font-weight: 700;
                            color: #333;
                            margin: 10px 0;
                        }
                
                        .type-label {
                            font-size: 14px;
                            color: #666;
                            font-weight: 500;
                        }
                
                        .additional-info {
                            background-color: #f8f9fa;
                            border-radius: 6px;
                            padding: 20px;
                            margin: 25px 0;
                            border-left: 4px solid #EE1C27;
                        }
                
                        .info-row {
                            display: flex;
                            justify-content: space-between;
                            padding: 10px 0;
                            border-bottom: 1px solid #e9ecef;
                        }
                
                        .info-row:last-child {
                            border-bottom: none;
                        }
                
                        .info-label {
                            font-weight: 500;
                            color: #666;
                        }
                
                        .info-value {
                            font-weight: 600;
                            color: #333;
                        }
                
                        .footer-note {
                            background-color: #e8f4f8;
                            border-radius: 6px;
                            padding: 15px;
                            margin: 20px 0;
                            font-size: 14px;
                            color: #555;
                            text-align: center;
                        }
                
                        .email-footer {
                            background-color: white;
                            padding: 20px 30px;
                            color: #666666;
                            font-size: 14px;
                            text-align: center;
                            border-top: 1px solid #e1e4e8;
                        }
                
                        .bottom-gradient {
                            height: 4px;
                            background: linear-gradient(90deg, #EE1C27 0%%, #3E5FA9 50%%, #017D1D 100%%);
                            margin: 0;
                        }
                
                        @media only screen and (max-width: 600px) {
                            .metrics-grid,
                            .type-breakdown {
                                grid-template-columns: 1fr;
                            }
                        }
                    </style>
                </head>
                <body>
                <div class="email-container">
                    <div class="email-header">
                        <div class="company-logo">
                            <!-- <div class="logo-icon"></div> -->
                            <!-- <div class="logo-text">nova locações</div> -->
                        </div>
                    </div>
                    <div class="gradient-line"></div>
                
                    <div class="email-content">
                        <h1>📊 Relatório Mensal de Pedidos</h1>
                        <p class="subtitle">Referente ao período de <strong>%s</strong></p>
                
                        <p class="greeting">Olá, <strong>Administrador</strong>!</p>
                
                        <p>Segue abaixo o resumo consolidado dos pedidos registrados no sistema durante o mês.</p>
                
                        <!-- RESUMO PRINCIPAL -->
                        <div class="report-summary">
                            <div class="summary-header">
                                <div class="summary-icon">📊</div>
                                <div class="summary-title">Total de Pedidos</div>
                            </div>
                            <div class="summary-value">%s</div>
                            <div class="summary-label">pedidos registrados no período</div>
                            <div class="summary-decoration"></div>
                        </div>
                
                        <!-- STATUS DOS PEDIDOS -->
                        <div class="section-title">📋 Distribuição por Status</div>
                        <div class="metrics-grid">
                            <div class="metric-card status-em-analise">
                                <div class="metric-value">%s</div>
                                <div class="metric-label">Em Análise</div>
                            </div>
                            <div class="metric-card status-aprovado">
                                <div class="metric-value">%s</div>
                                <div class="metric-label">Aprovados</div>
                            </div>
                            <div class="metric-card status-em-evento">
                                <div class="metric-value">%s</div>
                                <div class="metric-label">Em Evento</div>
                            </div>
                            <div class="metric-card status-finalizado">
                                <div class="metric-value">%s</div>
                                <div class="metric-label">Finalizados</div>
                            </div>
                        </div>
                
                        <div class="metrics-grid" style="grid-template-columns: 1fr;">
                            <div class="metric-card status-cancelado">
                                <div class="metric-value">%s</div>
                                <div class="metric-label">Cancelados</div>
                            </div>
                        </div>
                
                        <!-- TIPO DE PEDIDOS -->
                        <div class="section-title">🏷️ Distribuição por Tipo</div>
                        <div class="type-breakdown">
                            <div class="type-card indoor">
                                <div class="type-icon">🏠</div>
                                <div class="type-value">%s</div>
                                <div class="type-label">Pedidos Indoor</div>
                            </div>
                            <div class="type-card outdoor">
                                <div class="type-icon">🌳</div>
                                <div class="type-value">%s</div>
                                <div class="type-label">Pedidos Outdoor</div>
                            </div>
                        </div>
                
                        <!-- INFORMAÇÕES ADICIONAIS -->
                        <div class="section-title">📦 Informações Adicionais</div>
                        <div class="additional-info">
                            <div class="info-row">
                                <span class="info-label">Total de Itens Locados:</span>
                                <span class="info-value">%s unidades</span>
                            </div>
                            <div class="info-row">
                                <span class="info-label">Data de Geração:</span>
                                <span class="info-value">%s</span>
                            </div>
                        </div>
                
                        <div class="footer-note">
                            💡 <strong>Dica:</strong> Este relatório é gerado automaticamente no primeiro dia de cada mês com os dados consolidados do mês anterior.
                        </div>
                    </div>
                
                    <div class="email-footer">
                        <p>Atenciosamente,<br><strong>Sistema NovaLocacoes</strong></p>
                        <p style="margin-top: 15px; color: #999; font-size: 12px;">
                            Este é um email automático. Por favor, não responda a esta mensagem.
                        </p>
                        <p>&copy; 2025 NovaLocacoes. Todos os direitos reservados.</p>
                    </div>
                    <div class="bottom-gradient"></div>
                </div>
                </body>
                </html>
        """.formatted(dto.mesAno(), dto.totalPedidos(), dto.pedidosEmAnalise(), dto.pedidosAprovados(),
                dto.pedidosEmEvento(), dto.pedidosFinalizados(), dto.pedidosCancelados(),
                dto.pedidosIndoor(), dto.pedidosOutdoor(), dto.totalItensLocados(), dto.dataGeracao());
    }
}
