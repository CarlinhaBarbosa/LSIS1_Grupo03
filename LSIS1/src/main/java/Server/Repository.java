package Server;

import static DataBase.DAL.inserirAssociacaoRobotRonda;
import Model.AssociacaoRobotRonda;
import io.vertx.core.Vertx;
import java.sql.SQLException;
import sun.security.provider.certpath.Vertex;

/**
 *
 * @author LSIS- Grupo 3 1201141 - Bernardo Oliveira 1200928 - Carla Barbosa
 * 1201822 - Daniel Graça 1201059 - Francisca Ribeiro 1200638 - João Ferreira
 */
// poderia ter recorrido a um controller, mas isto é apenas um exemplo...
public class Repository {

    Vertx vertx;

    public void inserirNaBDFalsa(String dados) throws SQLException {
        String split[] = dados.split("#");
        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split[2]);
        System.out.println(split[3]);
        int idRobot = Integer.parseInt(split[0]);
        int idRonda = Integer.parseInt(split[1]);
        double tempo = Double.parseDouble(split[2]);
        double velocidade = Double.parseDouble(split[3]);
        BotTelegram tbc = new BotTelegram(vertx);
        String msg = " - idrobot: " + idRobot + " - idRonda: " + idRonda + " - tempo: " + tempo + " - velocidade: " + velocidade;
        tbc.sendMessage(msg);
        System.out.println("Dados enviados para o Telegram");
        AssociacaoRobotRonda associacaoRobotRondaAinserir = new AssociacaoRobotRonda(idRobot, idRonda, tempo, velocidade);
        inserirAssociacaoRobotRonda(associacaoRobotRondaAinserir);
    }
}
