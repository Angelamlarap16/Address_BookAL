public class Contacto {

    private String nombre;
    private String telefono;
    private String email;

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

        public String getNombre() {
            return this.nombre;
        }
        public String getTelefono() {
            return this.telefono;
        }
        public String getEmail() {
            return this.email;
        }

    public void setNombre(String nombre) {
        this.nombre = nombre; }

    public void setTelefono(String telefono) {
        this.telefono = telefono; }

    public void setEmail(String email) {
        this.email = email; }

    @Override
    public String toString(){
        return ("Nombre: " + nombre + "| Teléfono: " + telefono + "| Email: " + email);
    }
}
