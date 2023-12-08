package epa.logs.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("Logs")
public class Logs
{
    @Id
    private String id;

    private LocalDateTime fecha;

    private String Mensaje;

    public Logs(String id, LocalDateTime fecha, String mensaje) {
        this.id = id;
        this.fecha = fecha;
        Mensaje = mensaje;
    }

    public Logs() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
