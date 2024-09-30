/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.Conexao;
import Model.Rotas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class RotasDAO {
    
    
    public static void cadastrarRota(Rotas rota){
    String sql = "INSERT INTO rotas(origem,destino) values(?,?);";
    
   
    try (Connection conn = Conexao.getConexao(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) { 

        if (conn != null) {
            stmt.setString(1, rota.getOrigem());
            stmt.setString(2, rota.getDestino());

            stmt.execute();
            System.out.println("Cadastro feito com sucesso!");
            
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao preparar o statement: " + e.getMessage());
        }
    
    }
    public static int retornarID(Rotas rota){
        int id_rotas = RotasDAO.consultarID(rota);
        if(id_rotas != -1){
            
            return consultarID(rota);
        }else{
            cadastrarRota(rota);
            return consultarID(rota);
        }
    }
    public static int consultarID(Rotas rota){
       
    Conexao conexaoDB = new Conexao();
    int a = -1;
    
    
    Connection conn = conexaoDB.getConexao();
    
    if (conn != null) {
        System.out.println("Conexão realizada com sucesso!");
        
        
        String query = "SELECT rotas_id FROM rotas WHERE origem = ? AND destino = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            
           
            stmt.setString(1, rota.getOrigem());
            stmt.setString(2, rota.getDestino());
            
            
            try (ResultSet rs = stmt.executeQuery()) {
                
               
                if (!rs.isBeforeFirst()) {
                    System.out.println("Nenhuma rota encontrado.");
                    a = -1; 
                }
                
                if(rs.next()) {
                   a =  rs.getInt("rotas_id");
                   System.out.println("Rota encontrada: "+a);
                }
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
    return a;
}
}
