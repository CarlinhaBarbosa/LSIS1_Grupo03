/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lsis1;

/**
 *
 * @author diogo
 */
public class AssociacaoRondaCompeticao {

    private int idAssociacaoRondaCompeticao;
    private int idRonda;
    private int idCompeticao;

    private static final int INT_DEFAULT = 0;

    public AssociacaoRondaCompeticao() {
        this.idRonda = INT_DEFAULT;
        this.idCompeticao = INT_DEFAULT;
    }

    public AssociacaoRondaCompeticao(int idRonda, int idCompeticao) {
        this.idRonda = idRonda;
        this.idCompeticao = idCompeticao;
    }

    public AssociacaoRondaCompeticao(int idAssociacaoRondaCompeticao, int idRonda, int idCompeticao) {
        this.idAssociacaoRondaCompeticao = idAssociacaoRondaCompeticao;
        this.idRonda = idRonda;
        this.idCompeticao = idCompeticao;
    }

    public int getIdAssociacaoRondaCompeticao() {
        return idAssociacaoRondaCompeticao;
    }

    public int getIdRonda() {
        return idRonda;
    }

    public int getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdAssociacaoRondaCompeticao(int idAssociacaoRondaCompeticao) {
        this.idAssociacaoRondaCompeticao = idAssociacaoRondaCompeticao;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public void setIdCompeticao(int idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    @Override
    public String toString() {
        return "AssociacaoRondaCompeticao{" + "idAssociacaoRondaCompeticao=" + idAssociacaoRondaCompeticao + ", idRonda=" + idRonda + ", idCompeticao=" + idCompeticao + '}';
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
        final AssociacaoRondaCompeticao other = (AssociacaoRondaCompeticao) obj;
        if (this.idAssociacaoRondaCompeticao != other.idAssociacaoRondaCompeticao) {
            return false;
        }
        if (this.idRonda != other.idRonda) {
            return false;
        }
        return this.idCompeticao == other.idCompeticao;
    }

}
