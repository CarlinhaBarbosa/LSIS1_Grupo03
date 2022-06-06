/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author diogo
 */
public class AssociacaoRobotRonda {

    private int idAssociacaoRobotRonda;
    private int idRobot;
    private int idRonda;

    private static final int INT_DEFAULT = 0;

    public AssociacaoRobotRonda() {
        this.idRobot = INT_DEFAULT;
        this.idRonda = INT_DEFAULT;
    }

    public AssociacaoRobotRonda(int idRobot, int idRonda) {
        this.idRobot = idRobot;
        this.idRonda = idRonda;
    }

    public AssociacaoRobotRonda(int idAssociacaoRobotRonda, int idRobot, int idRonda) {
        this.idAssociacaoRobotRonda = idAssociacaoRobotRonda;
        this.idRobot = idRobot;
        this.idRonda = idRonda;
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

    public void setIdAssociacaoRobotRonda(int idAssociacaoRobotRonda) {
        this.idAssociacaoRobotRonda = idAssociacaoRobotRonda;
    }

    public void setIdRobot(int idRobot) {
        this.idRobot = idRobot;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    @Override
    public String toString() {
        return "AssociacaoRobotRonda{" + "idAssociacaoRobotRonda=" + idAssociacaoRobotRonda + ", idRobot=" + idRobot + ", idRonda=" + idRonda + '}';
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
        return this.idRonda == other.idRonda;
    }

}
