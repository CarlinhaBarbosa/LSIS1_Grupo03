/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author LSIS- Grupo 3 1201141 - Bernardo Oliveira 1200928 - Carla Barbosa
 * 1201822 - Daniel Graça 1201059 - Francisca Ribeiro 1200638 - João Ferreira
 */
public class Ronda {

    private int idRonda;
    private int idCompeticao;
    private String tipoRonda;

    private static final int INT_DEFAULT = 0;
    private static final String TIPORONDA_DEFAULT = "n/d";

    public Ronda() {
        this.idRonda = INT_DEFAULT;
        this.idCompeticao = INT_DEFAULT;
        this.tipoRonda = TIPORONDA_DEFAULT;
    }

    public Ronda(int idCompeticao, String tipoRonda) {
        this.idCompeticao = idCompeticao;
        this.tipoRonda = tipoRonda;
    }

    public Ronda(int idRonda, int idCompeticao, String tipoRonda) {
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

    public String getTipoRonda() {
        return tipoRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public void setIdCompeticao(int idCompeticao) {
        this.idCompeticao = idCompeticao;
    }

    public void setTipoRonda(String tipoRonda) {
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
