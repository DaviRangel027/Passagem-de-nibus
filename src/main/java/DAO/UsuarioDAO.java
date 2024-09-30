/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.Conexao;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    public void listarDadosDeTodosUsuarios() {
       
        Conexao conexaoDB = new Conexao();
        
      
        Connection conn = conexaoDB.getConexao();
        
        if (conn != null) {
            System.out.println("Conexão realizada com sucesso!");
            
            
            String query = "SELECT * FROM usuarios;";
            try (PreparedStatement stmt = conn.prepareStatement(query); 
                 ResultSet rs = stmt.executeQuery()) {
                
               
                if (!rs.isBeforeFirst()) {
                    System.out.println("Nenhum usuário encontrado.");
                }
                
                
                Usuario.limpar();
                System.out.println("===============================================================================");
                System.out.println("Usuarios encontrados: ");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id")+" - Nome: " + rs.getString("nome")+" - Email: " + rs.getString("email")+" - Grupo: " + rs.getString("grupo")+" - Telefone: " + rs.getString("telefone"));

                }
                System.out.println("===============================================================================");
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
    public void listarDadosDeUmUsuario(String email) {
    
    Conexao conexaoDB = new Conexao();
    
    
    Connection conn = conexaoDB.getConexao();
    
    if (conn != null) {
        System.out.println("Conexão realizada com sucesso!");
        
       
        String query = "SELECT * FROM usuarios WHERE email = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            
           
            stmt.setString(1, email);
            
          
            try (ResultSet rs = stmt.executeQuery()) {
                
                
                if (!rs.isBeforeFirst()) {
                    System.out.println("Nenhum usuário encontrado.");
                    return;
                }
                Usuario.limpar();
                System.out.println("===============================================================================");
                System.out.println("Usuario encontrado: ");
               
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") + 
                                       " - Nome: " + rs.getString("nome") + 
                                       " - Email: " + rs.getString("email") + 
                                       " - Grupo: " + rs.getString("grupo") + 
                                       " - Telefone: " + rs.getString("telefone"));
                }
                System.out.println("===============================================================================");
                Usuario.limpar();
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

    
    public Usuario recuperarDados(String nomeInput, String senhaInput){
        PreparedStatement stmt = null;
        String sql = "select * from usuarios where nome = ? and senha = ?;";
        ResultSet rs = null;
        Usuario user = new Usuario( "", "", "","", "");

        try {
            stmt = Conexao.getConexao().prepareStatement(sql);
            stmt.setString(1,nomeInput);
            stmt.setString(2,senhaInput);

            rs = stmt.executeQuery();
            
            if(rs.next() == true){
                user = new Usuario(rs.getString("nome"),rs.getString("email"),rs.getString("senha"),rs.getString("telefone"),rs.getString("grupo"));
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
         
        return user;
    }
    public void cadastrarUsuario(Usuario usuario) {
    String sql = "INSERT INTO usuarios(nome, email, senha, telefone, grupo) VALUES(?,?,?,?,?);";

    try (Connection conn = Conexao.getConexao(); 
         PreparedStatement stmt = conn.prepareStatement(sql)) {  

        if (conn != null) {
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTelefone());
            stmt.setString(5, usuario.getGrupo());

            stmt.execute();
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao preparar o statement: " + e.getMessage());
        }
    }
    public void excluirUsuario(String email) {
    String sql = "DELETE FROM usuarios WHERE email = ?";

    try (Connection conn = Conexao.getConexao();  
         PreparedStatement stmt = conn.prepareStatement(sql)) {  

        if (conn != null) {
            stmt.setString(1, email);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuário excluído com sucesso!");
            } else {
                System.out.println("Não existe esse email no banco de dados!");
            }
        } else {
            System.out.println("Erro ao conectar ao banco de dados.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Erro ao preparar o statement: " + e.getMessage());
        }
    }
    public void alterarDadosUsuario(Usuario u,String referencia){
        String sql = "UPDATE usuarios SET nome = ?, email = ?, senha = ?,telefone = ?, grupo = ? WHERE email = ?;";

    try (Connection conn = Conexao.getConexao();  
         PreparedStatement stmt = conn.prepareStatement(sql)) {  

        if (conn != null) {
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(4, u.getTelefone());
            stmt.setString(5, u.getGrupo());
            stmt.setString(6, referencia );

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
