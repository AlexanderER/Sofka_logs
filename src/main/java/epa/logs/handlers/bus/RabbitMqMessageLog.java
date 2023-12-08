package epa.logs.handlers.bus;

import epa.logs.RabbitConfig;
import epa.logs.drivenAdapters.repositorios.repositorioLogs;
import epa.logs.models.Logs;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.rabbitmq.Receiver;

@Component
public class RabbitMqMessageLog implements CommandLineRunner
{
    @Autowired
    private Receiver receiver;

    @Autowired
    repositorioLogs repo;

    @Override
    public void run(String... args) throws Exception
    {
        receiver.consumeAutoAck(RabbitConfig.QUEUE_NAME_LOG)
                .map(message -> {
                    String sMensaje = new String(message.getBody());
                    Logs miLog = new Logs();
                    miLog.setMensaje(sMensaje);

                    System.out.println(sMensaje);
                    repo.save(miLog).subscribe();
                    return Mono.empty();
                }).subscribe();
    }
}
