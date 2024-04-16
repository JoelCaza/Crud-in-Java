package bdd;

import java.sql.*;

// Clase para la persistencia de datos
public class Persistencia {

    // Atributos de la clase
    private String cadenaConexion;
    private String usu;
    private String pass;
    private String bdd = "empleados";

    // Constructor de la clase
    public Persistencia(String preambulo, String server, int puerto, String bdd, String usu, String pass) {
        cadenaConexion = preambulo + "://" + server + ":" + puerto + "/" + bdd;
        this.usu = usu;
        this.pass = pass;
    }

    // Método para obtener una conexion a la base de datos
    public Connection getConexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(cadenaConexion, usu, pass);
    }

    // Método para leer un registro de la base de datos
    public Cliente LeerRegisto(String statement) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        try {
            conexion = getConexion();
            PreparedStatement ps = conexion.prepareStatement(statement);
            ResultSet resultado = ps.executeQuery();
            if (resultado.next()) {
                int id = resultado.getInt("id");
                String cedula = resultado.getString("cedula");
                String nombre = resultado.getString("nombre");
                String apellido = resultado.getString("apellido");
                String direccion = resultado.getString("direccion");
                String telefono = resultado.getString("telefono");
                String email = resultado.getString("email");
                return new Cliente(id, cedula, nombre, apellido, direccion, telefono, email, 1);
            }
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
        return new Cliente(0);
    }

    // Método para realizar operaciones de creación, actualización o eliminación en la base de datos
    public int Cud(String statement) throws ClassNotFoundException, SQLException {
        Connection conexion = null;
        try {
            conexion = getConexion();
            PreparedStatement ps = conexion.prepareStatement(statement);
            return ps.executeUpdate();
        } finally {
            if (conexion != null) {
                conexion.close();
            }
        }
    }
}
