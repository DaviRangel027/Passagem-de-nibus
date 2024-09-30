/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.PassageiroDAO;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Vendedor {
    public static void consultarDadosVendas(){
        Scanner scan = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("|                  VENDAS                    |");
        System.out.println("---------------------------------------------");
        System.out.println("1. Listar Onibus");
        System.out.println("2. Listar Viagens");
        System.out.println("---------------------------------------------");
        int resposta = 5;
        while(resposta == 5){
        System.out.print("Escolha o que deseja: ");
        resposta = scan.nextInt();
        switch(resposta){
            case 1:
                Onibus.listandoOnibus();
                break;
            case 2:
                Viagem.listandoViagem();
                break;
            default:
                System.out.println("Escolha um numero valido.");
                resposta = 5;
            }
        }
        consultarDadosVendas();
        
    }
    public static void menuGerenciarPassageiros2(){
        Scanner listening = new Scanner(System.in);
        System.out.println("---------------------------------------------");
        System.out.println("|           GERENCIAR PASSAGEIRO             |");
        System.out.println("---------------------------------------------");
        System.out.println("1. Cadastrar Passageiro");
        System.out.println("2. Alterar dados do Passageiro");
        System.out.println("3. Excluir Passageiro");
        System.out.println("4. Listar Passageiro");
        System.out.println("0. Voltar para o Menu de gerenciamento.");
        System.out.println("---------------------------------------------");
        int resposta = 5;
        while(resposta == 5){
        System.out.print("Escolha uma das opçoes: ");
        resposta = listening.nextInt();
        switch(resposta){
            case 1:
                PassageiroDAO.cadastrarPassageiro();
                break;
            case 2:
                Passageiro.alterandoDadosPassageiro();
                break;
            case 3:
                Passageiro.exclusaoPassageiro();
                break;
            case 4:
                Passageiro.listandoPassageiro();
                break;
            case 0:
                new Usuario("","","","","").exibirMenuAdministrador();
                break;
            default:
                resposta = 5;
                System.out.println("Numero escolhido nao é uma opçao!");   
            }
        Usuario.exibirMenuVendedor();
        }
    }
}
