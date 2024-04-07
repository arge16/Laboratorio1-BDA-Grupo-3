package cl.tbd.proyecto.entities;

public class Estado_TareaEntity {
    private Long id;
    private String descripcion;
    private Long id_tarea;

    public Estado_TareaEntity(Long id, String descripcion, Long id_tarea) {
        this.id = id;
        this.descripcion = descripcion;
        this.id_tarea = id_tarea;
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

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

}
