/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lsis1;

/**
 *
 * @author diogo
 */
public class AssociacaoJuriCompeticao {

    private int idAssociacaoJuriCompeticao;
    private int idJuri;
    private int idCompeticao;

    private static final int INT_DEFAULT = 0;

    public AssociacaoJuriCompeticao() {
        this.idJuri = INT_DEFAULT;
        this.idCompeticao = INT_DEFAULT;
    }

    public AssociacaoJuriCompeticao(int idJuri, int idCompeticao) {
        this.idJuri = idJuri;
        this.idCompeticao = idCompeticao;
    }

    public AssociacaoJuriCompeticao(int idAssociacaoJuriCompeticao, int idJuri, int idCompeticao) {
        this.idAssociacaoJuriCompeticao = idAssociacaoJuriCompeticao;
        this.idJuri = idJuri;
        this.idCompeticao = idCompeticao;
    }

    public int getIdAssociacaoJuriCompeticao() {
        return idAssociacaoJuriCompeticao;
    }

    public int getIdJuri() {
        return idJuri;
    }

    public int getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdAssociacaoJuriCompeticao(int idAssociacaoJuriCompeticao) {
        this.idAssociacaoJuriCompeticao = idAssociacaoJuriCompeticao;
    }

    public void setIdJuri(int idJuri) {
        this.idJuri = idJuri;
    }

    public void setIdCompeticao(int idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    @Override
    public String toString() {
        return "AssociacaoJuriCompeticao{" + "idAssociacaoJuriCompeticao=" + idAssociacaoJuriCompeticao + ", idJuri=" + idJuri + ", idCompeticao=" + idCompeticao + '}';
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
        final AssociacaoJuriCompeticao other = (AssociacaoJuriCompeticao) obj;
        if (this.idAssociacaoJuriCompeticao != other.idAssociacaoJuriCompeticao) {
            return false;
        }
        if (this.idJuri != other.idJuri) {
            return false;
        }
        return this.idCompeticao == other.idCompeticao;
    }

}
