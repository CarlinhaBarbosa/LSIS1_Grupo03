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
import java.util.List;

/**
 *
 * @author LSIS- Grupo 3 1201141 - Bernardo Oliveira 1200928 - Carla Barbosa
 * 1201822 - Daniel Graça 1201059 - Francisca Ribeiro 1200638 - João Ferreira
 */
public class DAL {

    /**
     * **INSERT** Inserir Competição
     *
     * @param competicaoInserida
     */
    public static void inserirCompeticao(Competicao competicaoInserida) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Competicao (nomeCompeticao, dataCriacao) VALUES (?,?)");
            stmt.setString(1, competicaoInserida.getNomeCompeticao());
            Date dataConvertidaParaSqlDate = utils.Utils.obterDataConvertidaParaSqlDatecomParametroString(competicaoInserida.getDataCriacaoString());
            stmt.setDate(2, dataConvertidaParaSqlDate);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * **INSERT** Inserir Ronda
     *
     * @param rondaInserida
     */
    public static void inserirRonda(Ronda rondaInserida) {
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
     * **INSERT** Inserir Equipa
     *
     * @param equipaInserida
     */
    public static void inserirEquipa(Equipa equipaInserida) {
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
     * **INSERT** Inserir Robot
     *
     * @param robotInserido
     */
    public static void inserirRobot(Robot robotInserido) {
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
     * **UPDATE** ATUALIZAR COMPETIÇÃO
     *
     * @param idCompeticao
     * @param nomeCompeticao
     * @param dataCriacao
     */
    public static void actualizarCompeticao(int idCompeticao, String nomeCompeticao, String dataCriacao) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE Competicao SET nomeCompeticao=?, dataCriacao=? WHERE idCompeticao=?");
            stmt.setString(1, nomeCompeticao);
            Date dataConvertidaParaSqlDate = utils.Utils.obterDataConvertidaParaSqlDatecomParametroString(dataCriacao);
            stmt.setDate(2, dataConvertidaParaSqlDate);
            stmt.setInt(3, idCompeticao);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * **UPDATE** ATUALIZAR RONDA
     *
     * @param idRonda
     * @param tipoRonda
     */
    public static void actualizarRonda(int idRonda, String tipoRonda) {
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
     * **UPDATE** ATUALIZAR EQUIPA
     *
     * @param idEquipa
     * @param nomeEquipa
     */
    public static void actualizarEquipa(int idEquipa, String nomeEquipa) {
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
     * **UPDATE** Atualizar Robot
     *
     * @param idRobot
     * @param nomeRobot
     * @param macAddress
     */
    public static void actualizarRobot(int idRobot, String nomeRobot, String macAddress) {
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

    public static void actualizarResultadoRobot(int idAssociacaoRobotRonda, int idRobot, double tempo, double velocidade) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE AssociacaoRobotRonda SET tempo=?, velocidade=? WHERE idRobot=? AND idAssociacaoRobotRonda=?");
            stmt.setDouble(1, tempo);
            stmt.setDouble(2, velocidade);
            stmt.setInt(3, idRobot);
            stmt.setInt(4, idAssociacaoRobotRonda);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void eliminarCompeticao(int idCompeticao) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Competicao WHERE idCompeticao=?");
            stmt.setInt(1, idCompeticao);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void eliminarRonda(int idRonda) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Ronda WHERE idRonda=?");
            stmt.setInt(1, idRonda);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void eliminarEquipa(int idEquipa) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM Equipa WHERE idEquipa=?");
            stmt.setInt(1, idEquipa);
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * **DELETE** ELIMINAR ROBOT
     *
     * @param idRobot
     */
    public static void eliminarRobot(int idRobot) {
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

    public static Competicao obterUmaCompeticao(int idCompeticao) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Competicao WHERE idCompeticao=?");
            stmt.setInt(1, idCompeticao);
            rs = stmt.executeQuery();
            Competicao competicaoRetorno = new Competicao();
            while (rs.next()) {
                competicaoRetorno.setIdCompeticao(rs.getInt("idCompeticao"));
                competicaoRetorno.setNomeCompeticao((rs.getString("nomeCompeticao")));
                competicaoRetorno.setDataCriacaoString(rs.getDate("dataCriacao").toString());
            }

            conn.close();
            return competicaoRetorno;

        } catch (Exception e) {
            System.out.println(e);
        }
        return new Competicao();
    }

    public static Ronda obterUmaRonda(int idRonda) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Ronda WHERE idRonda=?");
            stmt.setInt(1, idRonda);
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
     * **SELECT** OBTER EQUIPA ATRAVÉS DO ID
     *
     * @param idEquipa
     * @return
     */
    public static Equipa obterUmaEquipa(int idEquipa) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Equipa WHERE idEquipa=?");
            stmt.setInt(1, idEquipa);
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
     * **SELECT** OBTER ROBOT ATRAVÉS DO ID
     *
     * @param idRobot
     * @return
     */
    public static Robot obterUmRobot(int idRobot) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Robot WHERE idRobot=?");
            stmt.setInt(1, idRobot);
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
     * **SELECT** OBTER COMPETIÇÃO
     *
     * @param listaCompeticoes
     */
    public static void obterListaCompeticoes(List<Competicao> listaCompeticoes) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Competicao");
            rs = stmt.executeQuery();
            int c = 0;
            while (rs.next()) {
                listaCompeticoes.add(new Competicao(rs.getInt("idCompeticao"), rs.getString("nomeCompeticao"), rs.getDate("dataCriacao").toString()));
                c++;
            }
            conn.close();
            return;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void obterListaEquipas(List<Equipa> listaEquipas) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Equipa");
            rs = stmt.executeQuery();
            int c = 0;
            while (rs.next()) {
                listaEquipas.add(new Equipa(rs.getInt("idEquipa"), rs.getString("nomeEquipa")));
                c++;
            }
            conn.close();
            return;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void obterListaRobots(List<Robot> listaRobots) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Robot");
            rs = stmt.executeQuery();
            int c = 0;
            while (rs.next()) {
                listaRobots.add(new Robot(rs.getInt("idRobot"), rs.getInt("idEquipa"), rs.getString("nomeRobot"), rs.getString("macAddress")));
                c++;
            }
            conn.close();
            return;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void obterListaRobotsDeUmaEquipa(List<Robot> listaRobots, int idEquipa) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Robot WHERE idEquipa=?");
            stmt.setInt(1, idEquipa);
            rs = stmt.executeQuery();
            int c = 0;
            while (rs.next()) {
                listaRobots.add(new Robot(rs.getInt("idRobot"), rs.getInt("idEquipa"), rs.getString("nomeRobot"), rs.getString("macAddress")));
                c++;
            }
            conn.close();
            return;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void obterListaRondasDeUmaCompeticao(List<Ronda> listaRondas, int idCompeticao) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM Ronda WHERE idCompeticao=?");
            stmt.setInt(1, idCompeticao);
            rs = stmt.executeQuery();
            int c = 0;
            while (rs.next()) {
                listaRondas.add(new Ronda(rs.getInt("idRonda"), rs.getInt("idCompeticao"), rs.getString("tipoRonda")));
                c++;
            }
            conn.close();
            return;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void obterResultadosDeUmaRonda(List<AssociacaoRobotRonda> listaAssociaocaoRobotRonda, int idRonda) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            PreparedStatement stmt2 = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM AssociacaoRobotRonda ORDER BY tempo ASC");
            stmt2 = conn.prepareStatement("SELECT * FROM AssociacaoRobotRonda WHERE idRonda=?");
            stmt2.setInt(1, idRonda);
            rs = stmt2.executeQuery();
            int c = 0;
            while (rs.next()) {
                listaAssociaocaoRobotRonda.add(new AssociacaoRobotRonda(rs.getInt("idAssociacaoRobotRonda"),
                        rs.getInt("idRobot"), rs.getInt("idRonda"), rs.getInt("tempo"),
                        rs.getInt("velocidade")));
                c++;
            }
            conn.close();
            return;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static AssociacaoRobotRonda obterResultadoDeUmRobotDeUmaRonda(int idRobot, int idRonda) {
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = conn.prepareStatement("SELECT * FROM AssociacaoRobotRonda WHERE idRonda=? AND idRobot=?");
            stmt.setInt(1, idRonda);
            stmt.setInt(2, idRobot);
            rs = stmt.executeQuery();
            AssociacaoRobotRonda robotRondaRetorno = new AssociacaoRobotRonda();
            while (rs.next()) {
                robotRondaRetorno.setIdAssociacaoRobotRonda(rs.getInt("idAssociacaoRobotRonda"));
                robotRondaRetorno.setIdRonda(rs.getInt("idRonda"));
                robotRondaRetorno.setIdRobot(rs.getInt("idRobot"));
                robotRondaRetorno.setTempo(rs.getDouble("tempo"));
                robotRondaRetorno.setVelocidade(rs.getDouble("velocidade"));
            }
            conn.close();
            return robotRondaRetorno;
        } catch (Exception e) {
            System.out.println(e);
        }
        return new AssociacaoRobotRonda();
    }

    /**
     * **INSERT** ASSOCIAR UMA RONDA A UMA COMPETIÇÃO
     *
     * @param associacaoRondaCompeticaoInserida
     */
    public static void inserirAssociacaoRondaCompeticao(AssociacaoRondaCompeticao associacaoRondaCompeticaoInserida) {
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
     * **INSERT** ASSOCIAR UM ROBOT A UMA RONDA
     *
     * @param associacaoRobotRondaInserida
     */
    public static void inserirAssociacaoRobotRonda(AssociacaoRobotRonda associacaoRobotRondaInserida) {
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
     * **INSERT** ASSOCIAR UM JURI A UMA COMPETIÇÃO
     *
     * @param associacaoJuriCompeticaoInserida
     */
    public static void inserirAssociacaoJuriCompeticao(AssociacaoJuriCompeticao associacaoJuriCompeticaoInserida) {
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
     * **INSERT** ASSOCIAR UMA EQUIPA A UMA COMPETIÇÃO
     *
     * @param associacaoEquipaCompeticaoInserida
     */
    public static void inserirAssociacaoEquipaCompeticao(AssociacaoEquipaCompeticao associacaoEquipaCompeticaoInserida) {
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
