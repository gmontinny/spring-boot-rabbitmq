package br.com.alurafood.pedidos.amqp;

import br.com.alurafood.pedidos.dto.PagamentoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

    @RabbitListener(queues = "pagamentos.detalhes-pedido")
    public void recebeMensagem(@Payload PagamentoDto pagamento) {
        String mensagem = " Dados do pagamento: " + pagamento.getId() +"Número do pedido: "+pagamento.getPedidoId()
                +"  Valor R$: "+pagamento.getValor()+" Status: "+pagamento.getStatus();
        System.out.println("Recebi a mensagem " + mensagem);
    }
}
