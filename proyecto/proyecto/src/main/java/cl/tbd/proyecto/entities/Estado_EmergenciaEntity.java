package cl.tbd.proyecto.entities;

public class Estado_EmergenciaEntity {

    private Long id_estado_emergencia;
    private String descripcion;

    public Estado_EmergenciaEntity(Long id, String descripcion) {
        this.id_estado_emergencia = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id_estado_emergencia;
    }

    public void setId(Long id) {
        this.id_estado_emergencia = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId_estado_emergencia() {
        return id_estado_emergencia;
    }

    public void setId_estado_emergencia(Long id_estado_emergencia) {
        this.id_estado_emergencia = id_estado_emergencia;
    }
}
