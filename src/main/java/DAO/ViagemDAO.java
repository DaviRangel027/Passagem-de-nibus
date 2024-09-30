/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.Conexao;
import Model.Viagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pedro
 */
public class ViagemDAO {
    public static void cadastrarViagem(Viagem viagem){
        String sql = "INSERT INTO viagem (codigo_onibus, data_saida, horario_saida, data_chegada, horario_chegada, valor_passagem,rota_id) VALUES (?, STR_TO_DATE(?, '%d/%m/%Y'), ?, STR_TO_DATE(?, '%d/%m/%Y'), ?, ?,?);";

    try (Connection conn = Conexao.getConexao(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {  

        if (conn != null) {
            stmt.setInt(1, viagem.getCodigo_onibus());
            stmt.setString(2, viagem.getData_saida());
            stmt.setString(3, viagem.getHorario_saida());
            stmt.setString(4, viagem.getData_chegada());
            stmt.setString(5, viagem.getHorario_chegada());
            stmt.setDouble(6, viagem.getValor_passagem());
            stmt.setInt(7, viagem.getRota_id());

            stmt.execute();
            System.out.println("Viagem cadastrada com sucesso!");
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao preparar o statement: " + e.getMessage());
        }
    }
    public static void excluirViagem(int id){
    String sql = "DELETE FROM viagem WHERE codigo_viagem = ?;";

    try (Connection conn = Conexao.getConexao();  
         PreparedStatement stmt = conn.prepareStatement(sql)) {  

        if (conn != null) {
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Viagem excluída com sucesso!");
            } else {
                System.out.println("Não existe esse ID na tabela viagem do banco de dados!");
            }
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao preparar o statement: " + e.getMessage());
        }
    
    }
    
    
    public static void listarDadosDeTodasViagens(){
    
    
    Conexao conexaoDB = new Conexao();
    
    
    Connection conn = conexaoDB.getConexao();
    
    if (conn != null) {
        System.out.println("Conexão realizada com sucesso!");
        
       
        String query = "SELECT v.codigo_viagem, v.codigo_onibus, DATE_FORMAT(v.data_saida, '%d/%m/%Y') AS data_saida_brasileira, v.horario_saida,DATE_FORMAT(v.data_chegada, '%d/%m/%Y') AS data_chegada_brasileira, v.horario_chegada, v.valor_passagem, r.origem, r.destino FROM viagem v JOIN rotas r ON v.rota_id = r.rotas_id;";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            
          
            try (ResultSet rs = stmt.executeQuery()) {
                
               
                if (!rs.isBeforeFirst()) {
                    System.out.println("Nenhuma Viagem encontrado, ou erro na consulta!");
                    return;
                }
                
                System.out.println("===============================================================================");
                System.out.println("Viagens encontradas: ");
             
                while (rs.next()) {
                    System.out.println("----------------------------------------------------");
                    System.out.println("ID: " + rs.getInt("codigo_viagem") +
                                       "\nLocal de Origem: " +rs.getString("origem") +
                                       "\nLocal de Destino: " +rs.getString("destino") +
                                       "\nData/Horario da saida: " + rs.getString("data_saida_brasileira")+" ás "+ rs.getString("horario_saida") + 
                                       "\nData/Horario chegada: " + rs.getString("data_chegada_brasileira")+" ás "+ rs.getString("horario_chegada")+
                                       "\nValor de Passagem: " +rs.getString("valor_passagem")+ " REAIS" );
                    System.out.println("----------------------------------------------------");
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
    public static void listarDadosDeUmaViagem(int id) {
    
    Conexao conexaoDB = new Conexao();
    
    
    Connection conn = conexaoDB.getConexao();
    
    if (conn != null) {
        System.out.println("Conexão realizada com sucesso!");
        
      
        String query = "SELECT v.codigo_viagem, v.codigo_onibus, DATE_FORMAT(v.data_saida, '%d/%m/%Y') AS data_saida_brasileira, v.horario_saida,DATE_FORMAT(v.data_chegada, '%d/%m/%Y') AS data_chegada_brasileira, v.horario_chegada, v.valor_passagem, r.origem, r.destino FROM viagem v JOIN rotas r ON v.rota_id = r.rotas_id WHERE v.codigo_viagem = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            
           
            try (ResultSet rs = stmt.executeQuery()) {
                
                
                if (!rs.isBeforeFirst()) {
                    System.out.println("Nenhuma Viagem encontrada.");
                    return;
                }
                
                System.out.println("===============================================================================");
                System.out.println("Viagem encontrada: ");
                
                 if(rs.next()) {
                    System.out.println("----------------------------------------------------");
                    System.out.println("ID: " + rs.getInt("codigo_viagem") +
                                       "\nLocal de Origem: " +rs.getString("origem") +
                                       "\nLocal de Destino: " +rs.getString("destino") +
                                       "\nData/Horario da saida: " + rs.getString("data_saida_brasileira")+" ás "+ rs.getString("horario_saida") + 
                                       "\nData/Horario chegada: " + rs.getString("data_chegada_brasileira")+" ás "+ rs.getString("horario_chegada")+
                                       "\nValor de Passagem: " +rs.getString("valor_passagem")+" REAIS" );
                    System.out.println("----------------------------------------------------");
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
    public static void alterarDadosViagem(Viagem viagem,String referencia){
        String sql = "";

    try (Connection conn = Conexao.getConexao(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) { 

        if (conn != null) {
            stmt.setString(1, viagem.getData_saida());
            stmt.setString(2, viagem.getHorario_saida());
            stmt.setString(3, viagem.getData_chegada());
            stmt.setString(4, viagem.getHorario_chegada());
            stmt.setDouble(5, viagem.getValor_passagem());
            stmt.setInt(6, viagem.getRota_id());
            stmt.setInt(7, viagem.getCodigo_onibus());
            stmt.setString(8, referencia);
            
            

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
    
}
