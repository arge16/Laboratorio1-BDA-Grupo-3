package cl.tbd.proyecto.entities;

public class RankingEntity {
    private Long id;
    private Long id_voluntario;
    private Integer puntuacion;

    public RankingEntity(Long id, Long id_voluntario, Integer puntuacion) {
        this.id = id;
        this.id_voluntario = id_voluntario;
        this.puntuacion = puntuacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
