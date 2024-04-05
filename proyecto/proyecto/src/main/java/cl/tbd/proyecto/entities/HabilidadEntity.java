package cl.tbd.proyecto.entities;

public class HabilidadEntity {
    private Long id;
    private String nombre;
    private String descripcion;
    private boolean certificacion_requerida;

    public HabilidadEntity(Long id, String nombre, String descripcion, boolean certificacion_requerida) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.certificacion_requerida = certificacion_requerida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCertificacion_requerida() {
        return certificacion_requerida;
    }

    public void setCertificacion_requerida(boolean certificacion_requerida) {
        this.certificacion_requerida = certificacion_requerida;
    }

}
