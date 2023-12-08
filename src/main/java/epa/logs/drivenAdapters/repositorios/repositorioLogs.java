package epa.logs.drivenAdapters.repositorios;

import epa.logs.models.Logs;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface repositorioLogs extends ReactiveMongoRepository<Logs, String>
{
}
