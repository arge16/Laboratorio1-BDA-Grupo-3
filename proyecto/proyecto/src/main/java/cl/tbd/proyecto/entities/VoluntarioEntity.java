package cl.tbd.proyecto.entities;

public class VoluntarioEntity {
        private Long id;
        private String nombre;
        private int edad;
        private String direccion;
        private String genero;
        private String email;
        private String telefono;

        public VoluntarioEntity(Long id, String nombre, int edad, String direccion, String genero, String email, String telefono) {
            this.id = id;
            this.nombre = nombre;
            this.edad = edad;
            this.direccion = direccion;
            this.genero = genero;
            this.email = email;
            this.telefono = telefono;
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

        public int getEdad() {
            return edad;
        }

        public void setEdad(int edad) {
            this.edad = edad;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }


}
