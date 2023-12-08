package epa.logs.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Logs")
public class Logs
{
    @Id
    private String id;

    private String Mensaje;

    public Logs(String id, String mensaje) {
        this.id = id;
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
}
