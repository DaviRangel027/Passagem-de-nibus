/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/passagens"; 
    private static final String USER = "root";  
    private static final String PASSWORD = "6@=y&sT)5NUm";  
    private static Connection conexao = null;
    public static Connection getConexao() {
    Connection conexao = null;  
    try {
        
        Class.forName("com.mysql.cj.jdbc.Driver");

        
        conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Conexão estabelecida com sucesso!");
    } catch (ClassNotFoundException e) {
        System.out.println("Driver JDBC do MySQL não encontrado.");
        e.printStackTrace();
    } catch (SQLException e) {
        System.out.println("Erro ao conectar ao banco de dados.");
        e.printStackTrace();
    }
    return conexao;
}
     public static void fecharConexao() {
        if (conexao != null) {
            try {
                conexao.close();
                System.out.println("Conexão fechada com sucesso.");
                conexao = null;  
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão.");
                e.printStackTrace();
            }
        }
    }
}