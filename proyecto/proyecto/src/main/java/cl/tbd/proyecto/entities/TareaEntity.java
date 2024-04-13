package cl.tbd.proyecto.entities;

public class TareaEntity {
    private Long id_tarea;
    private String descripcion;
    private Long id_emergencia;
    private Long id_voluntario;
    private int completada;
    private Long id_estado_tarea;

    public TareaEntity(Long id, String descripcion, Long id_emergencia, Long id_voluntario, int completada) {
        this.id_tarea = id;
        this.descripcion = descripcion;
        this.id_emergencia = id_emergencia;
        this.id_voluntario = id_voluntario;
        this.completada = completada;
	this.id_estado_tarea = id_estado_tarea;
    }

    public Long getId() {
        return id_tarea;
    }

    public void setId(Long id) {
        this.id_tarea = id;
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

    public int getCompletada() {
        return completada;
    }

    public void setCompletada(int completada) {
        this.completada = completada;
    }

    public Long getId_estado_tarea() {
	 return id_estado_tarea; 
    }

    public void setId_estado_tarea(Long id_estado_tarea) {
	 this.id_estado_tarea = id_estado_tarea;
    }


}
