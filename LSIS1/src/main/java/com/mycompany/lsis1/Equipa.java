/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lsis1;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author joaoferreira
 */
public class Equipa {

    private int idEquipa;
    private String nomeEquipa;
    private ArrayList<String> nomeElementosEquipa;

    private static final int INT_DEFAULT = 0;
    private static final String STRING_DEFAULT = "n/d";

    static int totalIdEquipa = 0;

    public Equipa() {
        this.idEquipa = ++totalIdEquipa;
        this.nomeEquipa = STRING_DEFAULT;
        this.nomeElementosEquipa = new ArrayList();
    }

    public Equipa(String nomeEquipa, ArrayList<String> nomeElementosEquipa) {
        this.idEquipa = ++totalIdEquipa;
        this.nomeEquipa = nomeEquipa;
        this.nomeElementosEquipa = new ArrayList(nomeElementosEquipa);
    }

    public Equipa(Equipa equipa) {
        this.idEquipa = equipa.idEquipa;
        this.nomeEquipa = equipa.nomeEquipa;
        this.nomeElementosEquipa = new ArrayList();
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public String getNomeEquipa() {
        return nomeEquipa;
    }

    public ArrayList<String> getNomeElementosEquipa() {
        return nomeElementosEquipa;
    }

    public static int getINT_DEFAULT() {
        return INT_DEFAULT;
    }

    public static String getSTRING_DEFAULT() {
        return STRING_DEFAULT;
    }

    public static int getTotalIdEquipa() {
        return totalIdEquipa;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    public void setNomeEquipa(String nomeEquipa) {
        this.nomeEquipa = nomeEquipa;
    }

    public void setNomeElementosEquipa(ArrayList<String> nomeElementosEquipa) {
        this.nomeElementosEquipa = nomeElementosEquipa;
    }

    public static void setTotalIdEquipa(int totalIdEquipa) {
        Equipa.totalIdEquipa = totalIdEquipa;
    }

    @Override
    public String toString() {
        return "Equipa{" + "idEquipa=" + idEquipa + ", nomeEquipa=" + nomeEquipa + ", nomeElementosEquipa=" + nomeElementosEquipa + '}';
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
        final Equipa other = (Equipa) obj;
        if (this.idEquipa != other.idEquipa) {
            return false;
        }
        if (!Objects.equals(this.nomeEquipa, other.nomeEquipa)) {
            return false;
        }
        if (!Objects.equals(this.nomeElementosEquipa, other.nomeElementosEquipa)) {
            return false;
        }
        return true;
    }
}
