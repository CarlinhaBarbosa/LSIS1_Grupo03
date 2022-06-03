package com.mycompany.lsis1;

import java.util.Objects;

public class Robot {

    private int idRobot;
    private int idEquipa;
    private String nome;
    private String macAdress;

    private static final int INT_DEFAULT = 0;
    private static final String STRING_DEFAULT = "n/d";

    public Robot() {
        this.idEquipa = INT_DEFAULT;
        this.nome = STRING_DEFAULT;
        this.macAdress = STRING_DEFAULT;
    }

    public Robot(int idEquipa, String nome, String macAdress) {
        this.idEquipa = idEquipa;
        this.nome = nome;
        this.macAdress = macAdress;
    }

    public Robot(int idRobot, int idEquipa, String nome, String macAdress) {
        this.idRobot = idRobot;
        this.idEquipa = idEquipa;
        this.nome = nome;
        this.macAdress = macAdress;
    }

    public Robot(Robot robot) {
        this.idRobot = robot.idRobot;
        this.idEquipa = robot.idEquipa;
        this.nome = robot.nome;
    }

    public int getIdRobot() {
        return idRobot;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public String getNome() {
        return nome;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setIdRobot(int idRobot) {
        this.idRobot = idRobot;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    @Override
    public String toString() {
        return "Robot{" + "idRobot=" + idRobot + ", idEquipa=" + idEquipa + ", nome=" + nome + ", macAdress=" + macAdress + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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
        final Robot other = (Robot) obj;
        if (this.idRobot != other.idRobot) {
            return false;
        }
        if (this.idEquipa != other.idEquipa) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.macAdress, other.macAdress);
    }

}
