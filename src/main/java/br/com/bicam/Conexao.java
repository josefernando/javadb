package br.com.bicam;

import java.sql.*;
// import java.sql.DriverManager;

public class Conexao {

    public static void main(String[] args) throws SQLException { 

        String driver = "org.postgresql.Driver";
        String user = "root";
        String senha = "root";
        String url = "jdbc:postgresql://172.18.0.2:5432/root";

        Connection conn = null;

        try{
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, senha);

        ResultSet rsCliente = conn.createStatement().executeQuery("select * from clientes");

        while(rsCliente.next()){
            System.out.println("Nome: " + rsCliente.getString("user_name"));
        }

        }catch (ClassNotFoundException cnfe){
            System.err.println("Drive not found: " + "org.postgresql.Driver");
        } catch (SQLException sqlex){
            System.err.println("Erro no acesso ao db: ");
            sqlex.printStackTrace();
        } finally {
            if (conn != null){
                conn.close();
            }
        }
    }
}