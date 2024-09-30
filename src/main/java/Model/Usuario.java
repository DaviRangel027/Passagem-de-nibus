/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.UsuarioDAO;
import java.util.Scanner;

/*
 * @author Pedro
 */
public class Usuario extends Pessoa {
    private String grupo;
    public Usuario( String nome, String email, String senha, String telefone,String grupo) {
        super( nome, email, senha, telefone);
        this.grupo = grupo;
    }
     public static Usuario logar(String nomeInput, String senhaInput) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario user = usuarioDAO.recuperarDados(nomeInput, senhaInput);
        return user;
    }
     public void exibirMenu() {
        if (grupo.equals("administrador")) {
            exibirMenuAdministrador();
        } else if (grupo.equals("vendedor")) {
            exibirMenuVendedor();
        } else {
            System.out.println("Grupo de usuário desconhecido.");
        }
    }
     public void exibirMenuAdministrador() {
        Scanner scan = new Scanner(System.in);
        limpar();
        System.out.println("Bem-vindo, Administrador!");
        Administrador adm = new Administrador( "", "", "", "", "");
        System.out.println("---------------------------------------------");
        System.out.println("|          PAINEL DO ADMINISTRADOR           |");
        System.out.println("---------------------------------------------");
        System.out.println("1. Gerenciar Usuários");
        System.out.println("2. Gerenciar Onibus");
        System.out.println("3. Gerenciar Passageiros");
        System.out.println("4. Gerenciar Viagem");
        System.out.println("---------------------------------------------");
        int resposta = 5;
        while(resposta == 5){
        System.out.print("Escolha o que deseja: ");
        resposta = scan.nextInt();
        switch(resposta){
            case 1:
                limpar();
                adm.menuGerenciarUsuarios();
                break;
            case 2:
                limpar();
                adm.menuGerenciarOnibus();
                break;
            case 3:
                limpar();
                Administrador.menuGerenciarPassageiros();
                break;
            case 4:
                limpar();
                adm.menuGerenciarViagens();
                break;
            default:
                limpar();
                System.out.println("Escolha um numero valido.");
                resposta = 5;
        }
    }
        
    }

    public static void exibirMenuVendedor() {
        Scanner scan = new Scanner(System.in);
        limpar();
        System.out.println("Bem-vindo, Vendedor!");
        System.out.println("---------------------------------------------");
        System.out.println("|            PAINEL DO VENDEDOR              |");
        System.out.println("---------------------------------------------");
        System.out.println("1. Gerenciar Passageiros");
        System.out.println("2. Consultar Dados para vendas");
        System.out.println("---------------------------------------------");
        int resposta = 5;
        while(resposta == 5){
        System.out.print("Escolha o que deseja: ");
        resposta = scan.nextInt();
        switch(resposta){
            case 1:
                limpar();
                Administrador.menuGerenciarPassageiros();
                break;
            case 2:
                limpar();
                Vendedor.consultarDadosVendas();
                break;
            default:
                System.out.println("Escolha um numero valido.");
                resposta = 5;
        }
    }
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public static void limpar(){
        for (int i = 0; i < 50; i++) {
        System.out.println("");
}
    }
    
}
