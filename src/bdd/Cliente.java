package bdd;

public class Cliente {
    // Atributos de la clase Cliente
    public int id; // Identificador del cliente
    public String cedula; // Cédula del cliente
    public String nombre; // Nombre del cliente
    public String apellido; // Apellido del cliente
    public String direccion; // Dirección del cliente
    public String telefono; // Número de teléfono del cliente
    public String email; // Dirección de correo electrónico del cliente
    
    public int resultado; // Resultado de alguna operación relacionada con el cliente

    // Constructor de Cliente con parámetro resultado
    public Cliente(int resultado) {
        this.resultado = resultado;
    }

    // Constructor de Cliente con todos los atributos
    public Cliente(int id, String cedula, String nombre, String apellido, String direccion, String telefono, String email, int resultado) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.resultado = resultado;
    }
}
