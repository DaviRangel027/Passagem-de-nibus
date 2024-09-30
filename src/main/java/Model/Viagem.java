/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.RotasDAO;
import DAO.UsuarioDAO;
import DAO.ViagemDAO;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Viagem {
    private int codigo_viagem;
    private int codigo_onibus;
    private int rota_id;
    private String horario_saida;
    private String horario_chegada;
    private String data_saida;
    private String data_chegada;
    private double valor_passagem;

    
    public Viagem(int codigo_viagem, int codigo_onibus, int rota_id, String horario_saida, String horario_chegada, String data_saida, String data_chegada, double valor_passagem) {
        this.codigo_viagem = codigo_viagem;
        this.codigo_onibus = codigo_onibus;
        this.rota_id = rota_id;
        this.horario_saida = horario_saida;
        this.horario_chegada = horario_chegada;
        this.data_saida = data_saida;
        this.data_chegada = data_chegada;
        this.valor_passagem = valor_passagem;
    }
    public Viagem(int codigo_onibus, int rota_id, String horario_saida, String horario_chegada, String data_saida, String data_chegada, double valor_passagem) {
        this.codigo_onibus = codigo_onibus;
        this.rota_id = rota_id;
        this.horario_saida = horario_saida;
        this.horario_chegada = horario_chegada;
        this.data_saida = data_saida;
        this.data_chegada = data_chegada;
        this.valor_passagem = valor_passagem;
    }
    
    public static void cadastroViagem(){
        Viagem viagem = Viagem.coletandoDadosViagem();
                
        ViagemDAO.cadastrarViagem(viagem);
    }
    public static void listandoViagem(){
        Scanner listeningg = new Scanner(System.in);
        System.out.print("Digite o ID para pesquisar dados de um Onibus em especifico, ou \"-1\" para listar todos os Onibus existentes: ");
        int resposta = listeningg.nextInt();
        if(resposta == -1){
            ViagemDAO.listarDadosDeTodasViagens();
        }else{
            ViagemDAO.listarDadosDeUmaViagem(resposta);
        }
        
    }
    public static void exclusaoViagem(){
        Scanner listening2 = new Scanner(System.in);
        String email = "";
        int id;
        while(email.equals("")){
        System.out.print("Digite o ID da Viagem que deseja Excluir: ");
            id = listening2.nextInt();
            
        if(id != 0){
        ViagemDAO.excluirViagem(id);
        email = "sfd";
        }
        else{
            
            }
        }
    }
    public static void alterandoDadosViagem(){
        Scanner list = new Scanner(System.in);
        System.out.println("Digite o ID da viagem que deseja alterar os dados: ");
        String idReferencia = list.nextLine();
        Viagem viagem = coletandoDadosViagem();
        ViagemDAO.alterarDadosViagem(viagem, idReferencia);
    }
    
    
    
    
    
//GETTERS AND SETTERS    
//==================================================================================================================================
//==================================================================================================================================
    public int getCodigo_onibus() {
        return codigo_onibus;
    }

    public String getData_chegada() {
        return data_chegada;
    }

    public int getCodigo_viagem() {
        return codigo_viagem;
    }

    public String getData_saida() {
        return data_saida;
    }

    public String getHorario_chegada() {
        return horario_chegada;
    }

    public String getHorario_saida() {
        return horario_saida;
    }

    public int getRota_id() {
        return rota_id;
    }

    public double getValor_passagem() {
        return valor_passagem;
    }

    public void setCodigo_onibus(int codigo_onibus) {
        this.codigo_onibus = codigo_onibus;
    }

    public void setCodigo_viagem(int codigo_viagem) {
        this.codigo_viagem = codigo_viagem;
    }

    public void setData_chegada(String data_chegada) {
        this.data_chegada = data_chegada;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }

    public void setHorario_chegada(String horario_chegada) {
        this.horario_chegada = horario_chegada;
    }

    public void setHorario_saida(String horario_saida) {
        this.horario_saida = horario_saida;
    }

    public void setRota_id(int rota_id) {
        this.rota_id = rota_id;
    }

    public void setValor_passagem(double valor_passagem) {
        this.valor_passagem = valor_passagem;
    }
    private static Viagem coletandoDadosViagem(){
        int codigo_onibus;
        String local_origem;
        String local_destino;
        String data_saida;
        String data_chegada;
        String horario_saida;
        String horario_chegada;
        int valor_passagem;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Digite o ID do onibus em que fará a viagem: ");
            codigo_onibus = scan.nextInt();
            scan.nextLine();
        System.out.print("Digite o local de origem da viagem: ");
            local_origem = scan.nextLine();
        System.out.print("Digite o local de destino da viagem: ");
            local_destino = scan.nextLine();
        System.out.print("Digite a data de saida da viagem: ");
            data_saida = scan.next();
        System.out.print("Digite a data de chegada da viagem: ");
            data_chegada = scan.next();
        System.out.print("Digite o horario de saida da viagem: ");
            horario_saida = scan.next();
        System.out.print("Digite o horario de chegada da viagem: ");
            horario_chegada = scan.next();
        System.out.print("Digite o valor de cada Passagem: ");
            valor_passagem = scan.nextInt();
        
        
        Rotas rota = new Rotas(local_origem,local_destino);
        
        int id_rota = RotasDAO.retornarID(rota);
        
        Viagem viagem = new Viagem(codigo_onibus,id_rota,horario_saida,horario_chegada,data_saida,data_chegada,valor_passagem);
        
        return viagem;
    }
    
}
