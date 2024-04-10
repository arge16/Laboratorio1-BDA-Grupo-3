package cl.tbd.proyecto.entities;

public class RankingEntity {
    private Long id_rankind;
    private Long id_voluntario;
    private Long id_tarea;
    private Integer puntuacion;

    public RankingEntity(Long id, Long id_voluntario, Integer puntuacion, Long id_tarea) {
        this.id_rankind = id;
        this.id_voluntario = id_voluntario;
        this.puntuacion = puntuacion;
        this.id_tarea = id_tarea;
    }

    public Long getId() {
        return id_rankind;
    }

    public void setId(Long id) {
        this.id_rankind = id;
    }

    public Long getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }


    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Long getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(Long id_tarea) {
        this.id_tarea = id_tarea;
    }

}
