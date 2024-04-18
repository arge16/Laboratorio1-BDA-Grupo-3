package cl.tbd.proyecto.entities;

public class Estado_TareaEntity {
    private Long id_estado_tarea;
    private String descripcion;

    public Estado_TareaEntity(Long id, String descripcion) {
        this.id_estado_tarea = id;
        this.descripcion = descripcion;
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
    

    public Long getId_estado_tarea() {
        return id_estado_tarea;
    }

    public void setId_estado_tarea(Long id_estado_tarea) {
        this.id_estado_tarea = id_estado_tarea;
    }
}
