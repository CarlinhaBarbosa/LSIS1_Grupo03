/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lsis1;

/**
 *
 * @author diogo
 */
public class Ronda {
    private enum TipoRonda{
        Nao_Definido,Ronda_Teste,Competicao
    }
    
    private int idRonda;
    private int idCompeticao;
    private TipoRonda tipoRonda;
    
    private static final int INT_DEFAULT = 0;
    private static final TipoRonda TIPORONDA_DEFAULT = TipoRonda.Nao_Definido;
    
    public Ronda(){
        this.idCompeticao = INT_DEFAULT;
        this.tipoRonda = TIPORONDA_DEFAULT;
    }

    public Ronda(int idCompeticao, TipoRonda tipoRonda) {
        this.idCompeticao = idCompeticao;
        this.tipoRonda = tipoRonda;
    }

    public Ronda(int idRonda, int idCompeticao, TipoRonda tipoRonda) {
        this.idRonda = idRonda;
        this.idCompeticao = idCompeticao;
        this.tipoRonda = tipoRonda;
    }

    public int getIdRonda() {
        return idRonda;
    }

    public int getIdCompeticao() {
        return idCompeticao;
    }

    public TipoRonda getTipoRonda() {
        return tipoRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public void setIdCompeticao(int idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public void setTipoRonda(TipoRonda tipoRonda) {
        this.tipoRonda = tipoRonda;
    }

    @Override
    public String toString() {
        return "Ronda{" + "idRonda=" + idRonda + ", idCompeticao=" + idCompeticao + ", tipoRonda=" + tipoRonda + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ronda other = (Ronda) obj;
        if (this.idRonda != other.idRonda) {
            return false;
        }
        if (this.idCompeticao != other.idCompeticao) {
            return false;
        }
        return this.tipoRonda == other.tipoRonda;
    }
    
    
}
