package Server;

import static DataBase.DAL.actualizarEquipa;
import static DataBase.DAL.actualizarRobot;
import static DataBase.DAL.eliminarRobot;
import static DataBase.DAL.inserirAssociacaoEquipaCompeticao;
import static DataBase.DAL.inserirCompeticao;
import static DataBase.DAL.inserirEquipa;
import static DataBase.DAL.inserirRobot;
import static DataBase.DAL.inserirRonda;
import static DataBase.DAL.obterCompeticao;
import static DataBase.DAL.obterEquipa;
import static DataBase.DAL.obterRobot;
import Model.AssociacaoEquipaCompeticao;
import Model.Competicao;
import Model.Equipa;
import Model.Robot;
import Model.Ronda;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import static io.vertx.ext.web.handler.StaticHandler.DEFAULT_WEB_ROOT;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Misterio
 */
class Handlers {

//    List<Aluno> BDfalsa = new ArrayList<>();
    String webRoot = "src/main/java/webroot";

    Repository repo;
//    BotTelegram bot;

    public Handlers(Repository repo/*, BotTelegram bot*/) {
        this.repo = repo;
//        this.bot = bot;
    }

    public void registarCompeticao(RoutingContext rc) {
//        try {
            String nomeCompeticao = rc.request().getParam("nomeCompeticaoId");
            String dataCriacaoCompeticao = rc.request().getParam("dataCriacaoId");
//            Date dataCriacaoCompeticaoConvertida;
//            dataCriacaoCompeticaoConvertida = utils.Utils.obterDataConvertidaParaJavaDateComParametroString(dataCriacaoCompeticao);
            Competicao competicaoNova = new Competicao(nomeCompeticao, dataCriacaoCompeticao);
            inserirCompeticao(competicaoNova);
            HttpServerResponse response = rc.response();
            response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
//        } catch (ParseException ex) {
//            Logger.getLogger(VerticleRSJson.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void registarRonda(RoutingContext rc) {
        String idCompeticao = rc.request().getParam("CompeticaoId");
        int idCompeticaoFinal = Integer.parseInt(idCompeticao);
        String tipoRonda = rc.request().getParam("Round");
        Ronda rondaNova = new Ronda(idCompeticaoFinal, tipoRonda);
        inserirRonda(rondaNova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
//        response.end(Json.encodePrettily(rondaNova));
    }

    public void registarEquipa(RoutingContext rc) { //falta testar (comment : joaoFerreira, 13/06/22
        String nomeEquipa = rc.request().getParam("nomeEquipa");
        Equipa equipaNova = new Equipa(nomeEquipa);
        inserirEquipa(equipaNova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
//        response.end(Json.encodePrettily(equipaNova));
    }

    public void registarRobot(RoutingContext rc) { //falta testar (comment : joaoFerreira, 13/06/22
        String idEquipa = rc.request().getParam("idEquipa");
        int idEquipaFinal = Integer.parseInt(idEquipa);
        String nomeRobot = rc.request().getParam("nomeRobot");
        String macAddress = rc.request().getParam("macAddress");
        Robot robotNovo = new Robot(idEquipaFinal, nomeRobot, macAddress);
        inserirRobot(robotNovo);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
//        response.end(Json.encodePrettily(robotNovo));
    }

    public void selecionarEquipa(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        Equipa equipa = obterEquipa(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
        response.end(Json.encodePrettily(equipa));
    }

    public void updateEquipa(RoutingContext rc) {
        String idEquipa = rc.request().getParam("teamId");
        int idEquipaFinal = Integer.parseInt(idEquipa);
        String nomeEquipa = rc.request().getParam("teamNameId");
        actualizarEquipa(idEquipaFinal, nomeEquipa);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
        // response.end(Json.encodePrettily(cliente));
    }

    public void selecionarRobot(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        Robot robot = obterRobot(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
        response.end(Json.encodePrettily(robot));
    }

    public void updateRobot(RoutingContext rc) {
        String idRobot = rc.request().getParam("id");
        int idRobotFinal = Integer.parseInt(idRobot);
        String nomeRobot = rc.request().getParam("robotName");
        String macAddress = rc.request().getParam("macAddress");
        actualizarRobot(idRobotFinal, nomeRobot, macAddress);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
        // response.end(Json.encodePrettily(cliente));
    }

    public void deleteRobot(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        eliminarRobot(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
//        response.end(Json.encodePrettily(robot));
    }

    public void obterListaCompeticoes(RoutingContext rc) {
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Competicao> listaCompeticoes = new ArrayList<>();
        obterCompeticao(listaCompeticoes);
        System.out.println(listaCompeticoes.toString());
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaCompeticoes));
    }

    public void inscricaoEquipaCompeticao(RoutingContext rc) {
        String idCompeticao = rc.request().getParam("idCompeticao");
        int idCompeticaoFinal = Integer.parseInt(idCompeticao);
        String idEquipa = rc.request().getParam("teamId");
        int idEquipaFinal = Integer.parseInt(idEquipa);
        AssociacaoEquipaCompeticao associacaoEquipaCompeticaoNova = new AssociacaoEquipaCompeticao(idEquipaFinal, idCompeticaoFinal);
        inserirAssociacaoEquipaCompeticao(associacaoEquipaCompeticaoNova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
//        response.end(Json.encodePrettily(associacaoEquipaCompeticaoNova));
    }
}
