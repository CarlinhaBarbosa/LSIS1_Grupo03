/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lsis1;

/**
 *
 * @author diogo
 */
public class AssociacaoEquipaCompeticao {

    private int idAssociacaoEquipaCompeticao;
    private int idEquipa;
    private int idCompeticao;

    private static final int INT_DEFAULT = 0;

    public AssociacaoEquipaCompeticao() {
        this.idEquipa = INT_DEFAULT;
        this.idCompeticao = INT_DEFAULT;
    }

    public AssociacaoEquipaCompeticao(int idEquipa, int idCompeticao) {
        this.idEquipa = idEquipa;
        this.idCompeticao = idCompeticao;
    }

    public AssociacaoEquipaCompeticao(int idAssociacaoEquipaCompeticao, int idEquipa, int idCompeticao) {
        this.idAssociacaoEquipaCompeticao = idAssociacaoEquipaCompeticao;
        this.idEquipa = idEquipa;
        this.idCompeticao = idCompeticao;
    }

    public int getIdAssociacaoEquipaCompeticao() {
        return idAssociacaoEquipaCompeticao;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public int getIdCompeticao() {
        return idCompeticao;
    }

    public void setIdAssociacaoEquipaCompeticao(int idAssociacaoEquipaCompeticao) {
        this.idAssociacaoEquipaCompeticao = idAssociacaoEquipaCompeticao;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    public void setIdCompeticao(int idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    @Override
    public String toString() {
        return "AssociacaoEquipaCompeticao{" + "idAssociacaoEquipaCompeticao=" + idAssociacaoEquipaCompeticao + ", idEquipa=" + idEquipa + ", idCompeticao=" + idCompeticao + '}';
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
        final AssociacaoEquipaCompeticao other = (AssociacaoEquipaCompeticao) obj;
        if (this.idAssociacaoEquipaCompeticao != other.idAssociacaoEquipaCompeticao) {
            return false;
        }
        if (this.idEquipa != other.idEquipa) {
            return false;
        }
        return this.idCompeticao == other.idCompeticao;
    }

}
