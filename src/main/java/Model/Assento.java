/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Pedro
 */
public class Assento {
    int id_assento;
    int numero_do_assento;
    int codigo_onibus;
    String disponibilidade;
    
    public Assento(int id_assento, int numero_do_assento, int codigo_onibus, String disponibilidade){
        this.codigo_onibus = codigo_onibus;
        this.disponibilidade = disponibilidade;
        this.id_assento = id_assento;
        this.numero_do_assento = numero_do_assento;
    }
    public Assento( int numero_do_assento, int codigo_onibus, String disponibilidade){
        this.codigo_onibus = codigo_onibus;
        this.disponibilidade = disponibilidade;
        this.numero_do_assento = numero_do_assento;
    }
    public Assento(){
        
    }
    
    
    
//=============================================================================================================
//=============================================================================================================
//=============================================================================================================
//=============================================================================================================
    public int getId_assento() {
        return id_assento;
    }

    public void setId_assento(int id_assento) {
        this.id_assento = id_assento;
    }

    public int getNumero_do_assento() {
        return numero_do_assento;
    }

    public void setNumero_do_assento(int numero_do_assento) {
        this.numero_do_assento = numero_do_assento;
    }

    public int getCodigo_onibus() {
        return codigo_onibus;
    }

    public void setCodigo_onibus(int codigo_onibus) {
        this.codigo_onibus = codigo_onibus;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    
}
