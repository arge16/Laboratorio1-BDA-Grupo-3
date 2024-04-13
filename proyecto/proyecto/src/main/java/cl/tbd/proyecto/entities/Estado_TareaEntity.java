package cl.tbd.proyecto.entities;

public class Estado_TareaEntity {
    private Long id_estado_tarea;
    private String descripcion;
    private Long id_tarea;

    public Estado_TareaEntity(Long id, String descripcion, Long id_tarea) {
        this.id_estado_tarea = id;
        this.descripcion = descripcion;
        this.id_tarea = id_tarea;
    }

    public Long getId() {
        return id_estado_tarea;
    }

    public void setId(Long id) {
        this.id_estado_tarea = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

    public Long getId_estado_tarea() {
        return id_estado_tarea;
    }

    public void setId_estado_tarea(Long id_estado_tarea) {
        this.id_estado_tarea = id_estado_tarea;
    }
}
