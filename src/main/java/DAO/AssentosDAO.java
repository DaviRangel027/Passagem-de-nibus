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
public class AssentosDAO {
    public static void cadastrarAssentos(Onibus bus){
        String sql = "INSERT INTO assento(numero_assento,codigo_onibus,disponibilidade) VALUES( ?, ?, ?);";
        int id = recuperarID(bus);
    try (Connection conn = Conexao.getConexao();  
         PreparedStatement stmt = conn.prepareStatement(sql)) {  
        
        for(int i = 1; i < bus.getQuantidade_Assentos()+1 ; i++){
            if (conn != null) {
                stmt.setInt(1, i);
                stmt.setInt(2, id);
                stmt.setString(3, "LIVRE");

                stmt.execute();
                System.out.println("Viagem cadastrada com sucesso!");
            } else {
                System.out.println("Erro ao conectar ao banco de dados.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao preparar o statement: " + e.getMessage());
        }
    }
    public static int recuperarID(Onibus bus){
    PreparedStatement stmt = null;
        String sql = "SELECT * FROM onibus WHERE placa_onibus = ?;";
        ResultSet rs = null;

        try {
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.setString(1,bus.getPlaca());

            rs = stmt.executeQuery();
            
            if(rs.next() == true){
                return rs.getInt("codigo_onibus");
            }else{
                return 0;
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                
                if (stmt != null) stmt.close();
                if (Conexao.getConexao() != null) Conexao.getConexao().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    return 0;
    }
}