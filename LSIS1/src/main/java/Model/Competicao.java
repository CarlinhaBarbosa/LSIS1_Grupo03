/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author LSIS- Grupo 3
 * 1201141 - Bernardo Oliveira
 * 1200928 - Carla Barbosa
 * 1201822 - Daniel Graça
 * 1201059 - Francisca Ribeiro
 * 1200638 - João Ferreira
 */
public class Competicao {

    private int idCompeticao;
    private String nomeCompeticao;
    private Date dataCriacao;

    private static final int INT_DEFAULT = 0;
    private static final String STRING_DEFAULT = "n/d";

    public Competicao() {
        this.nomeCompeticao = STRING_DEFAULT;
        this.dataCriacao = new Date();
    }

    public Competicao(String nomeCompeticao, Date dataCriacao) {
        this.nomeCompeticao = nomeCompeticao;
        this.dataCriacao = dataCriacao;
    }

    public Competicao(int idCompeticao, String nomeCompeticao, Date dataCriacao) {
        this.idCompeticao = idCompeticao;
        this.nomeCompeticao = nomeCompeticao;
        this.dataCriacao = dataCriacao;
    }

    public Competicao(Competicao competicao) {
        this.idCompeticao = competicao.idCompeticao;
        this.nomeCompeticao = competicao.nomeCompeticao;
        this.dataCriacao = competicao.dataCriacao;
    }

    public int getIdCompeticao() {
        return idCompeticao;
    }

    public String getNomeCompeticao() {
        return nomeCompeticao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public static int getINT_DEFAULT() {
        return INT_DEFAULT;
    }

    public static String getSTRING_DEFAULT() {
        return STRING_DEFAULT;
    }

    public void setIdCompeticao(int idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public void setNomeCompeticao(String nomeCompeticao) {
        this.nomeCompeticao = nomeCompeticao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    @Override
    public String toString() {
        return "Competicao{" + "idCompeticao=" + idCompeticao + ", nomeCompeticao=" + nomeCompeticao + ", dataCriacao=" + dataCriacao + '}';
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
        final Competicao other = (Competicao) obj;
        if (this.idCompeticao != other.idCompeticao) {
            return false;
        }
        if (!Objects.equals(this.nomeCompeticao, other.nomeCompeticao)) {
            return false;
        }
        if (!Objects.equals(this.dataCriacao, other.dataCriacao)) {
            return false;
        }
        return true;
    }

}
