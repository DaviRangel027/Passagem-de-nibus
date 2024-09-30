/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.PassageiroDAO;
import static DAO.PassageiroDAO.listarDadosDeUmPassageiro;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Passageiro extends Pessoa{
    private String cpf;
    private String sexo;
    
    public Passageiro(String nome, String email, String telefone, String cpf, String sexo) {
        super( nome, email, telefone);
        this.cpf = cpf;
        this.sexo = sexo;
    }
    public static Passageiro cadastrandoPassageiro(){
        Scanner listening = new Scanner(System.in);
        
        System.out.print("Digite o nome do usuario:");
            String nome = listening.nextLine();
        System.out.print("Digite o cpf do usuario:");
            String cpf = listening.next();
        System.out.print("Digite o email do usuario:");
            String email = listening.next();
        System.out.print("Digite o sexo do usuario (M para Masculino e F para feminino):");
            String sexo = listening.next();
        System.out.print("Digite o telefone do usuario:");
            String telefone = listening.next();
        
        Passageiro passageiro = new Passageiro(nome,email,telefone,cpf,sexo);
        
        return passageiro;
    }
   public static void exclusaoPassageiro(){
        Scanner listening2 = new Scanner(System.in);
        String email = "";
        int id;
        while(email.equals("")){
        System.out.print("Digite o ID da Viagem que deseja Excluir: ");
            id = listening2.nextInt();
            
        if(id != 0){
        PassageiroDAO.excluirPassageiro(id);
        email = "sfd";
        }
        else{
            System.out.println("ID nao existente!!");
            }
        }
    }
   public static void listandoPassageiro(){
        Scanner listeningg = new Scanner(System.in);
        System.out.print("Digite o ID para pesquisar dados de um Passageiro:");
        int resposta = listeningg.nextInt();
        if(resposta >0){
            PassageiroDAO.listarDadosDeUmPassageiro(resposta);
        }else{
            System.out.println("ID invalido!!");
        }
        
    }
   public static void alterandoDadosPassageiro(){
        Scanner list = new Scanner(System.in);
        System.out.println("Digite o ID do Passageiro que deseja alterar os dados: ");
        int idReferencia = list.nextInt();
        Passageiro passageiro = cadastrandoPassageiro();
        PassageiroDAO.alterarDadosPassageiro(passageiro, idReferencia);
        ;
    }
    
    
    
//===================================================================================================================
//===================================================================================================================
//===================================================================================================================
//===================================================================================================================

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
