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
public class AssociacaoRobotRonda {

    private int idAssociacaoRobotRonda;
    private int idRobot;
    private int idRonda;
    private double tempo;
    private double velocidade;

    private static final int INT_DEFAULT = 0;
    private static final double DOUBLE_DEFAULT = 0.0;

    public AssociacaoRobotRonda() {
        this.idRobot = INT_DEFAULT;
        this.idRonda = INT_DEFAULT;
        this.tempo = DOUBLE_DEFAULT;
        this.velocidade = DOUBLE_DEFAULT;
    }

    public AssociacaoRobotRonda(int idRobot, int idRonda) {
        this.idRobot = idRobot;
        this.idRonda = idRonda;
        this.tempo = DOUBLE_DEFAULT;
        this.velocidade = DOUBLE_DEFAULT;
    }

    public AssociacaoRobotRonda(int idAssociacaoRobotRonda, int idRobot, int idRonda, double tempo, double velocidade) {
        this.idAssociacaoRobotRonda = idAssociacaoRobotRonda;
        this.idRobot = idRobot;
        this.idRonda = idRonda;
        this.tempo = tempo;
        this.velocidade = velocidade;
    }

    public AssociacaoRobotRonda(int idRobot, int idRonda, double tempo, double velocidade) {
//        this.idAssociacaoRobotRonda = idAssociacaoRobotRonda;
        this.idRobot = idRobot;
        this.idRonda = idRonda;
        this.tempo = tempo;
        this.velocidade = velocidade;
    }

    public int getIdAssociacaoRobotRonda() {
        return idAssociacaoRobotRonda;
    }

    public int getIdRobot() {
        return idRobot;
    }

    public int getIdRonda() {
        return idRonda;
    }

    public double getTempo() {
        return tempo;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setIdAssociacaoRobotRonda(int idAssociacaoRobotRonda) {
        this.idAssociacaoRobotRonda = idAssociacaoRobotRonda;
    }

    public void setIdRobot(int idRobot) {
        this.idRobot = idRobot;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public String toString() {
        return "AssociacaoRobotRonda{" + "idAssociacaoRobotRonda=" + idAssociacaoRobotRonda + ", idRobot=" + idRobot + ", idRonda=" + idRonda + ", tempo=" + tempo + ", velocidade=" + velocidade + '}';
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
        final AssociacaoRobotRonda other = (AssociacaoRobotRonda) obj;
        if (this.idAssociacaoRobotRonda != other.idAssociacaoRobotRonda) {
            return false;
        }
        if (this.idRobot != other.idRobot) {
            return false;
        }
        if (this.idRonda != other.idRonda) {
            return false;
        }
        if (Double.doubleToLongBits(this.tempo) != Double.doubleToLongBits(other.tempo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.velocidade) != Double.doubleToLongBits(other.velocidade)) {
            return false;
        }
        return true;
    }
}
