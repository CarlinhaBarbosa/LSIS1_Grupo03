/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
public class Juri {

    private int idJuri;
    private String nomeJuri;

    private static final int INT_DEFAULT = 0;
    private static final String STRING_DEFAULT = "n/d";

    public Juri() {
        this.idJuri = INT_DEFAULT;
        this.nomeJuri = STRING_DEFAULT;
    }

    public Juri(String nomeJuri) {
        this.nomeJuri = nomeJuri;
    }

    public Juri(int idJuri, String nomeJuri) {
        this.idJuri = idJuri;
        this.nomeJuri = nomeJuri;
    }

    public Juri(Juri juri) {
        this.idJuri = juri.idJuri;
        this.nomeJuri = juri.nomeJuri;
    }

    public int getIdJuri() {
        return idJuri;
    }

    public String getNomeJuri() {
        return nomeJuri;
    }

    public void setIdJuri(int idJuri) {
        this.idJuri = idJuri;
    }

    public void setNomeJuri(String nomeJuri) {
        this.nomeJuri = nomeJuri;
    }

    @Override
    public String toString() {
        return "Juri{" + "idJuri=" + idJuri + ", nomeJuri=" + nomeJuri + '}';
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
        final Juri other = (Juri) obj;
        if (this.idJuri != other.idJuri) {
            return false;
        }
        return Objects.equals(this.nomeJuri, other.nomeJuri);
    }

}
