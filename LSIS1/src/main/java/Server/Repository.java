package Server;

import DataBase.DAL;
import static DataBase.DAL.inserirAssociacaoRobotRonda;
import DataBase.DBConnection;
import Model.AssociacaoRobotRonda;
import Model.Robot;
import io.vertx.core.Vertx;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import sun.security.provider.certpath.Vertex;
import static DataBase.DAL.obterResultadosDeUmaRondaTelegram;

/**
 *
 * @author LSIS- Grupo 3 1201141 - Bernardo Oliveira 1200928 - Carla Barbosa
 * 1201822 - Daniel Graça 1201059 - Francisca Ribeiro 1200638 - João Ferreira
 */
// poderia ter recorrido a um controller, mas isto é apenas um exemplo...
public class Repository {

    Vertx vertx;

//    public void inserirNaBDFalsa(String dados) throws SQLException {
//        String split[] = dados.split("#");
//        System.out.println(split[0]);
//        System.out.println(split[1]);
//        System.out.println(split[2]);
//        System.out.println(split[3]);
//        int idRobot = Integer.parseInt(split[0]);
//        int idRonda = Integer.parseInt(split[1]);
//        double tempo = Double.parseDouble(split[2]);
//        double velocidade = Double.parseDouble(split[3]);
//        BotTelegram tbc = new BotTelegram(vertx);
//        String msg = " - idrobot: " + idRobot + " - idRonda: " + idRonda + " - tempo: " + tempo + " - velocidade: " + velocidade;
//        tbc.sendMessage(msg);
//        System.out.println("Dados enviados para o Telegram");
//        AssociacaoRobotRonda associacaoRobotRondaAinserir = new AssociacaoRobotRonda(idRobot, idRonda, tempo, velocidade);
//        inserirAssociacaoRobotRonda(associacaoRobotRondaAinserir);
//    }
    public void inserirNaBDFalsa(String dados) throws SQLException {
        BotTelegram tbc = new BotTelegram(vertx);

        String split[] = dados.split("#");

        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split[2]);
        System.out.println(split[3]);

        String macAddress = split[0];

        int idRonda = Integer.parseInt(split[1]);
        double tempo = Double.parseDouble(split[2]);
        double velocidade = Double.parseDouble(split[3]);

        String msg = " - Mac Address: " + macAddress + ", - ID Ronda:" + idRonda + ", - tempo: " + tempo + ", - velocidade: " + velocidade;
        tbc.sendMessage(msg);
        System.out.println("Dados enviados para o Telegram");
        String obterIdRobotPeloMacAddressSql = "SELECT idRobot FROM Robot WHERE macAddress=?;";

        boolean result = true;
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps;
        ResultSet resultSet = null;
        try {
            ps = conn.prepareStatement(obterIdRobotPeloMacAddressSql);
            ps.setString(1, macAddress);
            resultSet = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (result) {
            assert resultSet != null;
            if (resultSet.next()) {
                int idRobotFinal = resultSet.getInt("idRobot");
                AssociacaoRobotRonda associacaoRobotRondaAinserir = new AssociacaoRobotRonda(idRobotFinal, idRonda, tempo, velocidade);
                inserirAssociacaoRobotRonda(associacaoRobotRondaAinserir);
            } else {
                result = false;
            }
        }
    }
}
