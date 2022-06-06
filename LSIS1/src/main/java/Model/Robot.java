package Model;

import java.util.Objects;

public class Robot {

    private int idRobot;
    private int idEquipa;
    private String nome;
    private String macAddress;

    private static final int INT_DEFAULT = 0;
    private static final String STRING_DEFAULT = "n/d";

    public Robot() {
        this.idEquipa = INT_DEFAULT;
        this.nome = STRING_DEFAULT;
        this.macAddress = STRING_DEFAULT;
    }

    public Robot(int idEquipa, String nome, String macAdress) {
        this.idEquipa = idEquipa;
        this.nome = nome;
        this.macAddress = macAdress;
    }

    public Robot(int idRobot, int idEquipa, String nome, String macAdress) {
        this.idRobot = idRobot;
        this.idEquipa = idEquipa;
        this.nome = nome;
        this.macAddress = macAdress;
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
        return macAddress;
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
        this.macAddress = macAdress;
    }

    @Override
    public String toString() {
        return "Robot{" + "idRobot=" + idRobot + ", idEquipa=" + idEquipa + ", nome=" + nome + ", macAdress=" + macAddress + '}';
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
        return Objects.equals(this.macAddress, other.macAddress);
    }

}
