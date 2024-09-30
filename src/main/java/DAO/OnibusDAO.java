/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.Conexao;
import Model.Onibus;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class OnibusDAO {
    
    public void cadastrarOnibus(Onibus bus) {
    String sql = "INSERT INTO onibus(placa_onibus,quantidade_assentos)VALUES(?,?);";

    try (Connection conn = Conexao.getConexao(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) { 

        if (conn != null) {
            stmt.setString(1, bus.getPlaca());
            stmt.setInt(2, bus.getQuantidade_Assentos());

            stmt.execute();
            System.out.println("Onibus cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao preparar o statement: " + e.getMessage());
        }
    AssentosDAO.cadastrarAssentos(bus);
    
    }
    public void excluirOnibus(String placa) {
    String sql = "DELETE FROM onibus WHERE placa_onibus = ?;";

    try (Connection conn = Conexao.getConexao(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) { 

        if (conn != null) {
            stmt.setString(1, placa);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Onibus excluído com sucesso!");
            } else {
                System.out.println("Não existe essa placa no banco de dados!");
            }
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao preparar o statement: " + e.getMessage());
        }
    }
    
    public void alterarDadosOnibus(Onibus bus,String referencia){
        String sql = "UPDATE onibus SET placa_onibus = ?, quantidade_assentos = ? WHERE placa_onibus = ?;";

    try (Connection conn = Conexao.getConexao();  
         PreparedStatement stmt = conn.prepareStatement(sql)) { 

        if (conn != null) {
            stmt.setString(1, bus.getPlaca());
            stmt.setInt(2, bus.getQuantidade_Assentos());
            stmt.setString(3, referencia );

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Alteraçao dos dados feita com sucesso com sucesso!");
            } else {
                System.out.println("Não foi possivel fazer as alteraçoes no banco de dados!");
            }
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao preparar o statement: " + e.getMessage());
        }
    }
    public void listarDadosDeUmOnibus(String placa) {
    Conexao conexaoDB = new Conexao();
    
    
    Connection conn = conexaoDB.getConexao();
    
    if (conn != null) {
        System.out.println("Conexão realizada com sucesso!");
        
       
        String query = "SELECT * FROM onibus WHERE placa_onibus = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, placa);
            
         
            try (ResultSet rs = stmt.executeQuery()) {
                
               
                if (!rs.isBeforeFirst()) {
                    System.out.println("Nenhum Onibus encontrado.");
                    return;
                }
                
                System.out.println("===============================================================================");
                System.out.println("Onibus encontrado: ");
               
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + 
                                       " - Placa: " + rs.getString("nome") + 
                                       " - Quantidade de Assentos: " + rs.getString("email"));
                }
                System.out.println("===============================================================================");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao realizar consulta: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close(); 
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                e.printStackTrace(); // Imprimir o stack trace completo
            }
        }
    } else {
        System.out.println("Erro ao conectar ao banco de dados.");
    }
}
    public void listarDadosDeTodosOnibus() {
    
    Conexao conexaoDB = new Conexao();
    
    
    Connection conn = conexaoDB.getConexao();
    
    if (conn != null) {
        System.out.println("Conexão realizada com sucesso!");
        
        
        String query = "SELECT * FROM onibus;";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            
          
            try (ResultSet rs = stmt.executeQuery()) {
                
               
                if (!rs.isBeforeFirst()) {
                    System.out.println("Nenhum Onibus encontrado.");
                    return;
                }
                
                System.out.println("===============================================================================");
                System.out.println("Onibus encontrados: ");
              
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("codigo_onibus") + 
                                       " - Placa: " + rs.getString("placa_onibus") + 
                                       " - Quantidade de Assentos: " + rs.getString("quantidade_assentos"));
                }
                System.out.println("===============================================================================");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao realizar consulta: " + e.getMessage());
            e.printStackTrace(); 
        } finally {
            try {
                conn.close(); 
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                e.printStackTrace(); // Imprimir o stack trace completo
            }
        }
    } else {
        System.out.println("Erro ao conectar ao banco de dados.");
    }
}
}
