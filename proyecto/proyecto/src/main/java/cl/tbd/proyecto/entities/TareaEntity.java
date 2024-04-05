package cl.tbd.proyecto.entities;

public class TareaEntity {
    private Long id;
    private String descripcion;
    private Long id_emergencia;
    private Long id_voluntario;
    private boolean completada;

    public TareaEntity(Long id, String descripcion, Long id_emergencia, Long id_voluntario, boolean completada) {
        this.id = id;
        this.descripcion = descripcion;
        this.id_emergencia = id_emergencia;
        this.id_voluntario = id_voluntario;
        this.completada = completada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }

    public Long getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

}
