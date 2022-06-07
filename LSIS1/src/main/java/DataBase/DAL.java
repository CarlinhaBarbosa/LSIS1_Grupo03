/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import Model.AssociacaoJuriCompeticao;
import Model.AssociacaoRobotRonda;
import Model.AssociacaoRondaCompeticao;
import Model.Competicao;
import Model.Equipa;
import Model.Robot;
import Model.Ronda;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaoferreira
 */
public class DAL {

    /*OBJECTOS*/

 /*Inserir*/
    public void inserirCompeticao(Competicao competicaoInserida) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Competicao (nomeCompeticao, dataCriacao) VALUES (?,?)");
            stmt.setString(1, competicaoInserida.getNomeCompeticao());
            Date dataConvertidaParaSqlDate = new Date(competicaoInserida.getDataCriacao().getTime());
            stmt.setDate(2, dataConvertidaParaSqlDate);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inserirRonda(Ronda rondaInserida) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Ronda (idCompeticao, tipoRonda) VALUES (?,?)");
            stmt.setInt(1, rondaInserida.getIdCompeticao());
            stmt.setString(2, rondaInserida.getTipoRonda());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inserirEquipa(Equipa equipaInserida) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Equipa (nomeEquipa) VALUES (?)");
            stmt.setString(1, equipaInserida.getNomeEquipa());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inserirRobot(Robot robotInserido) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Robot (idEquipa, nomeRobot, MacAddress) VALUES (?,?,?)");
            stmt.setInt(1, robotInserido.getIdEquipa());
            stmt.setString(2, robotInserido.getNomeRobot());
            stmt.setString(3, robotInserido.getMacAdress());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*Update*/
    public void actualizarCompeticao(int idCompeticao, String nomeCompeticao, java.util.Date dataCriacao) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Competicao SET nomeCompeticao=?, dataCriacao=? WHERE idCompeticao=?");
            stmt.setString(1, nomeCompeticao);
            Date dataConvertidaParaSqlDate = new Date(dataCriacao.getTime());
            stmt.setDate(2, dataConvertidaParaSqlDate);
            stmt.setInt(3, idCompeticao);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actualizarRonda(int idRonda, String tipoRonda) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Ronda SET tipoRonda=? WHERE idRonda=?");
            stmt.setString(1, tipoRonda);
            stmt.setInt(2, idRonda);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actualizarEquipa(int idEquipa, String nomeEquipa) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Equipa SET nomeEquipa=? WHERE idEquipa=?");
            stmt.setString(1, nomeEquipa);
            stmt.setInt(2, idEquipa);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void actualizarRobot(int idRobot, String nomeRobot, String macAddress) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Robot SET nomeRobot=?, MacAddress=? WHERE idRobot=?");
            stmt.setString(1, nomeRobot);
            stmt.setString(2, macAddress);
            stmt.setInt(3, idRobot);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*Eliminar*/
    public void eliminarRobot(int idRobot) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Robot WHERE idRobot=?");
            stmt.setInt(1, idRobot);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /*ASSOCIAÇÕES*/

 /*Inserir*/
    public void inserirAssociacaoRondaCompeticao(AssociacaoRondaCompeticao associacaoRondaCompeticaoInserida) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO AssociacaoRondaCompeticao (idRonda, idCompeticao) VALUES (?,?)");
            stmt.setInt(1, associacaoRondaCompeticaoInserida.getIdRonda());
            stmt.setInt(2, associacaoRondaCompeticaoInserida.getIdCompeticao());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inserirAssociacaoRobotRonda(AssociacaoRobotRonda associacaoRobotRondaInserida) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO AssociacaoRobotRonda (idRobot, idRonda, tempo, velocidade) VALUES (?,?,?,?)");
            stmt.setInt(1, associacaoRobotRondaInserida.getIdRobot());
            stmt.setInt(2, associacaoRobotRondaInserida.getIdRonda());
            stmt.setDouble(3, associacaoRobotRondaInserida.getTempo());
            stmt.setDouble(4, associacaoRobotRondaInserida.getVelocidade());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void inserirAssociacaoJuriCompeticao(AssociacaoJuriCompeticao associacaoJuriCompeticaoInserida) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO AssociacaoJuriCompeticao (idJuri, idCompeticao) VALUES (?,?)");
            stmt.setInt(1, associacaoJuriCompeticaoInserida.getIdJuri());
            stmt.setInt(2, associacaoJuriCompeticaoInserida.getIdCompeticao());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
