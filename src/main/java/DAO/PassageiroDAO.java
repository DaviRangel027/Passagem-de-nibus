/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.Conexao;
import Model.Passageiro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class PassageiroDAO {
     public static void cadastrarPassageiro() {
    String sql = "INSERT INTO passageiros(cpf,nome,sexo,email,telefone) values(?,?,?,?,?);";
    Passageiro passageiro = Passageiro.cadastrandoPassageiro();
    try (Connection conn = Conexao.getConexao();  
         PreparedStatement stmt = conn.prepareStatement(sql)) {  

        if (conn != null) {
            stmt.setString(1, passageiro.getCpf());
            stmt.setString(2, passageiro.getNome());
            stmt.setString(3, passageiro.getSexo());
            stmt.setString(4, passageiro.getEmail());
            stmt.setString(5, passageiro.getTelefone());
            

            stmt.execute();
            System.out.println("Passageiro cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao preparar o statement: " + e.getMessage());
        }
    }
     public static void excluirPassageiro(int id) {
    String sql = "DELETE FROM passageiros WHERE id = ?;";

    try (Connection conn = Conexao.getConexao(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) { 

        if (conn != null) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Passageiro excluído com sucesso!");
            } else {
                System.out.println("Não existe esse ID no banco de dados!");
            }
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao preparar o statement: " + e.getMessage());
        }
    }
     public static void alterarDadosPassageiro(Passageiro passageiro, int referencia){
        String sql = "UPDATE passageiros SET cpf = ?, nome = ?, sexo = ?, email = ?, telefone = ? WHERE id = ?;";

    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {  

        if (conn != null) {
            stmt.setString(1, passageiro.getCpf());
            stmt.setString(2, passageiro.getNome());
            stmt.setString(3, passageiro.getSexo());
            stmt.setString(4, passageiro.getEmail());
            stmt.setString(5, passageiro.getTelefone());
            stmt.setInt(6, referencia);
 
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
    public static void listarDadosDeUmPassageiro(int id) {
    
    Conexao conexaoDB = new Conexao();
    
    
    Connection conn = conexaoDB.getConexao();
    
    if (conn != null) {
        System.out.println("Conexão realizada com sucesso!");
        
        
        String query = "SELECT * FROM passageiros WHERE id = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            
           
            try (ResultSet rs = stmt.executeQuery()) {
                
               
                if (!rs.isBeforeFirst()) {
                    System.out.println("Nenhuma Viagem encontrada.");
                    return; 
                }
                
                System.out.println("===============================================================================");
                System.out.println("Passageiro encontrado: ");
               
                 if(rs.next()) {
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("ID : " + rs.getInt("id") +
                                        " - Nome : "+ rs.getString("nome")+
                                        " - Cpf : "+ rs.getString("cpf")+
                                        " - Email : "+ rs.getString("email")+
                                        " - Sexo : "+ rs.getString("sexo")+
                                        " - Telefone : "+ rs.getString("telefone"));
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
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
                e.printStackTrace(); 
            }
        }
    } else {
        System.out.println("Erro ao conectar ao banco de dados.");
    }
}
}
