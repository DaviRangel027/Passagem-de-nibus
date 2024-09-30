/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Pedro
 */
public class Rotas {
    private int rotas_id;
    private String origem;
    private String destino;

    public Rotas(int rotas_id, String origem, String destino) {
        this.rotas_id = rotas_id;
        this.origem = origem;
        this.destino = destino;
    }
    public Rotas(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public String getOrigem() {
        return origem;
    }

    public int getRotas_id() {
        return rotas_id;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setRotas_id(int rotas_id) {
        this.rotas_id = rotas_id;
    }
    
    
}
