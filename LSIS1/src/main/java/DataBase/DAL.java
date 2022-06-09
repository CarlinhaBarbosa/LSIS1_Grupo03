/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import Model.AssociacaoEquipaCompeticao;
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
 * @author LSIS- Grupo 3
 * 1201141 - Bernardo Oliveira
 * 1200928 - Carla Barbosa
 * 1201822 - Daniel Graça
 * 1201059 - Francisca Ribeiro
 * 1200638 - João Ferreira
 */
public class DAL {

    /**
     * **INSERT**
     * Inserir Competição
     * 
     * @param competicaoInserida 
     */
    
    public static void inserirCompeticao(Competicao competicaoInserida) {
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

    /**
     * **INSERT**
     * Inserir Ronda
     * 
     * @param rondaInserida 
     */
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

    /**
     * **INSERT**
     * Inserir Equipa
     * 
     * @param equipaInserida 
     */
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

    /**
     * **INSERT**
     * Inserir Robot
     * 
     * @param robotInserido 
     */
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

    /**
     * **UPDATE**
     * ATUALIZAR COMPETIÇÃO
     * 
     * @param idCompeticao
     * @param nomeCompeticao
     * @param dataCriacao 
     */
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

    /**
     * **UPDATE**
     * ATUALIZAR RONDA
     * 
     * @param idRonda
     * @param tipoRonda 
     */
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

    /**
     * **UPDATE**
     * ATUALIZAR EQUIPA
     * 
     * @param idEquipa
     * @param nomeEquipa 
     */
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

    /**
     * **UPDATE**
     * Atualizar Robot
     * 
     * @param idRobot
     * @param nomeRobot
     * @param macAddress 
     */
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

    /**
     * **DELETE**
     * ELIMINAR ROBOT
     * 
     * @param idRobot 
     */
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

    /**
     * **SELECT**
     * OBTER COMPETIÇÃO
     * 
     * @return 
     */
    public static List<Competicao> obterCompeticao() {
        List<Competicao> result = new ArrayList<Competicao>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Competicao");
            rs = stmt.executeQuery();
            Competicao competicaoRetornoFinal = new Competicao();
            List<Competicao> listCompeticao = new ArrayList<Competicao>();
            while (rs.next()) {
                Competicao competicaoRetorno = new Competicao();
                competicaoRetorno.setIdCompeticao(rs.getInt("idCompeticao"));
                competicaoRetorno.setNomeCompeticao(rs.getString("nomeCompeticao"));
                competicaoRetorno.setDataCriacao(rs.getDate("dataCriacao"));
                listCompeticao.add(competicaoRetorno);
            }

            conn.close();
            return listCompeticao;

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    //**
    
    public Ronda obterRonda(int id) { //alterar para static aquando da implementação (08/06/22 - joaoferreira
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Ronda WHERE idRonda=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Ronda rondaRetorno = new Ronda();
            while (rs.next()) {
                rondaRetorno.setIdRonda(rs.getInt("idRonda"));
                rondaRetorno.setIdCompeticao((rs.getInt("idCompeticao")));
                rondaRetorno.setTipoRonda(rs.getString("tipoRonda"));
            }

            conn.close();
            return rondaRetorno;

        } catch (Exception e) {
            System.out.println(e);
        }
        return new Ronda();
    }

    /**
     * **SELECT**
     * OBTER EQUIPA ATRAVÉS DO ID
     * 
     * @param id
     * @return 
     */
    public Equipa obterEquipa(int id) { //alterar para static aquando da implementação (08/06/22 - joaoferreira
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Equipa WHERE idEquipa=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Equipa equipaRetorno = new Equipa();
            while (rs.next()) {
                equipaRetorno.setIdEquipa(rs.getInt("idEquipa"));
                equipaRetorno.setNomeEquipa(rs.getString("nomeEquipa"));
            }

            conn.close();
            return equipaRetorno;

        } catch (Exception e) {
            System.out.println(e);
        }
        return new Equipa();
    }

    /**
     * **SELECT**
     * OBTER ROBOT ATRAVÉS DO ID
     * 
     * @param id
     * @return 
     */
    public Robot obterRobot(int id) { //alterar para static aquando da implementação (08/06/22 - joaoferreira
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Robot WHERE idRobot=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Robot robotRetorno = new Robot();
            while (rs.next()) {
                robotRetorno.setIdRobot(rs.getInt("idRobot"));
                robotRetorno.setIdEquipa(rs.getInt("idEquipa"));
                robotRetorno.setNomeRobot(rs.getString("nomeRobot"));
                robotRetorno.setMacAdress(rs.getString("macAddress"));
            }

            conn.close();
            return robotRetorno;

        } catch (Exception e) {
            System.out.println(e);
        }
        return new Robot();
    }


 /**
  * **INSERT**
  * ASSOCIAR UMA RONDA A UMA COMPETIÇÃO
  * 
  * @param associacaoRondaCompeticaoInserida 
  */
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

    /**
     * **INSERT**
     * ASSOCIAR UM ROBOT A UMA RONDA
     * 
     * @param associacaoRobotRondaInserida 
     */
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

    /**
     * **INSERT**
     * ASSOCIAR UM JURI A UMA COMPETIÇÃO
     * 
     * @param associacaoJuriCompeticaoInserida 
     */
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

    /**
     * **INSERT**
     * ASSOCIAR UMA EQUIPA A UMA COMPETIÇÃO
     * 
     * @param associacaoEquipaCompeticaoInserida 
     */
    public void inserirAssociacaoEquipaCompeticao(AssociacaoEquipaCompeticao associacaoEquipaCompeticaoInserida) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO AssociacaoEquipaCompeticao (idEquipa, idCompeticao) VALUES (?,?)");
            stmt.setInt(1, associacaoEquipaCompeticaoInserida.getIdEquipa());
            stmt.setInt(2, associacaoEquipaCompeticaoInserida.getIdCompeticao());
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
