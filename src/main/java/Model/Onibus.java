/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.OnibusDAO;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Onibus {
    private int codigo_onibus;
    private String placa;
    private int quantidade_Assentos;

    public Onibus(String placa, int quantidade_Assentos) {
        this.placa = placa;
        this.quantidade_Assentos = quantidade_Assentos;
    }

    public Onibus(int codigo_onibus, String placa, int quantidade_Assentos) {
        this.codigo_onibus = codigo_onibus;
        this.placa = placa;
        this.quantidade_Assentos = quantidade_Assentos;
    }
    public static void cadastroOnibus(){
        Scanner scan1 = new Scanner(System.in);
        System.out.print("Digite a placa do Onibus que deseja cadastrar: ");
        String placa = scan1.nextLine();
        System.out.print("Digite a quantidade de Assentos que o Onibus tem: ");
        int quantidade_Assentos = scan1.nextInt();
        if(placa == null || placa.isEmpty()){
            cadastroOnibus();
        }else{
            Onibus bus = new Onibus(placa, quantidade_Assentos);
            OnibusDAO o = new OnibusDAO();
            o.cadastrarOnibus(bus);
        }
        
    }
    public static void exclusaoOnibus(){
        
        Scanner listening2 = new Scanner(System.in);
        String email = "";
        while(email.equals("")){
        System.out.print("Digite a placa do Onibus que deseja Excluir: ");
            email = listening2.next();
        if(!"".equals(email)){
        new OnibusDAO().excluirOnibus(email);}
        else{
            System.out.print("Digite uma Placa valida.");
            }
        }   
    }
    public static void alterandoOnibus(){
        Scanner list = new Scanner(System.in);
        System.out.println("Digite placa do Onibus que deseja alterar os dados: ");
        String placaReferencia = list.nextLine();
        System.out.print("Digite a placa do Onibus que deseja cadastrar: ");
        String placa = list.nextLine();
        System.out.print("Digite a quantidade de Assentos que o Onibus tem: ");
        int quantidade_Assentos = list.nextInt();
        Onibus onibus = new Onibus(placa,quantidade_Assentos);
        new OnibusDAO().alterarDadosOnibus(onibus, placaReferencia);
    }
    public static void listandoOnibus(){
        Scanner listeningg = new Scanner(System.in);
        System.out.print("Digite a placa para pesquisar dados de um Onibus em expecifico, ou \"TODOS\" para listar todos os Onibus existentes: ");
        String resposta = listeningg.nextLine();
        if(resposta.equals("TODOS")){
            new OnibusDAO().listarDadosDeTodosOnibus();
        }else{
            new OnibusDAO().listarDadosDeUmOnibus(resposta);
        }
        
    }
    

    public int getCodigo_onibus() {
        return codigo_onibus;
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getQuantidade_Assentos() {
        return quantidade_Assentos;
    }

    public void setQuantidade_Assentos(int quantidade_Assentos) {
        this.quantidade_Assentos = quantidade_Assentos;
    }
    
    
}
