package Server;

import static DataBase.DAL.actualizarCompeticao;
import static DataBase.DAL.actualizarEquipa;
import static DataBase.DAL.actualizarResultadoRobot;
import static DataBase.DAL.actualizarRobot;
import static DataBase.DAL.actualizarRonda;
import static DataBase.DAL.eliminarAssociacaoRobotRonda;
import static DataBase.DAL.eliminarCompeticao;
import static DataBase.DAL.eliminarEquipa;
import static DataBase.DAL.eliminarEquipaDeUmaCompeticao;
import static DataBase.DAL.eliminarRobot;
import static DataBase.DAL.eliminarRonda;
import static DataBase.DAL.inserirAssociacaoEquipaCompeticao;
import static DataBase.DAL.inserirCompeticao;
import static DataBase.DAL.inserirEquipa;
import static DataBase.DAL.inserirRobot;
import static DataBase.DAL.inserirRonda;
import static DataBase.DAL.obterListaCompeticoes;
import static DataBase.DAL.obterUmaEquipa;
import static DataBase.DAL.obterUmRobot;
import static DataBase.DAL.obterListaEquipas;
import static DataBase.DAL.obterListaEquipasDeUmaCompeticao;
import static DataBase.DAL.obterListaRobots;
import static DataBase.DAL.obterListaRobotsDeUmaEquipa;
import static DataBase.DAL.obterListaRondasDeUmaCompeticao;
import static DataBase.DAL.obterResultadoDeUmRobotDeUmaRonda;
import static DataBase.DAL.obterUmaCompeticao;
import static DataBase.DAL.obterUmaRonda;
import static DataBase.DAL.obterResultadosDeUmaRonda;
import static DataBase.DAL.obterResultadosDeUmaRondaPontos;
import static DataBase.DAL.obterResultadosDeUmaRondaTempo;
import static DataBase.DAL.obterResultadosDeUmaRondaVelocidade;
import Model.AssociacaoRobotRonda;
import Model.AssociacaoEquipaCompeticao;
import Model.Competicao;
import Model.Equipa;
import Model.Robot;
import Model.Ronda;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Misterio
 */
class Handlers {

    String webRoot = "src/main/java/webroot";

    Repository repo;
    BotTelegram bot;

    public Handlers(Repository repo, BotTelegram bot) {
        this.repo = repo;
        this.bot = bot;
    }

    public void registarCompeticao(RoutingContext rc) {
        String nomeCompeticao = rc.request().getParam("nomeCompeticaoId");
        String dataCriacaoCompeticao = rc.request().getParam("dataCriacaoId");
        Competicao competicaoNova = new Competicao(nomeCompeticao, dataCriacaoCompeticao);
        inserirCompeticao(competicaoNova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void registarRonda(RoutingContext rc) {
        String idCompeticao = rc.request().getParam("CompeticaoId");
        int idCompeticaoFinal = Integer.parseInt(idCompeticao);
        String tipoRonda = rc.request().getParam("Round");
        Ronda rondaNova = new Ronda(idCompeticaoFinal, tipoRonda);
        inserirRonda(rondaNova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void registarEquipa(RoutingContext rc) { //falta testar (comment : joaoFerreira, 13/06/22
        String nomeEquipa = rc.request().getParam("nomeEquipa");
        Equipa equipaNova = new Equipa(nomeEquipa);
        inserirEquipa(equipaNova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
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
    }

    public void selecionarEquipa(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        Equipa equipa = obterUmaEquipa(idFinal);
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
    }

    public void selecionarRobot(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        Robot robot = obterUmRobot(idFinal);
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
    }

    public void deleteRobot(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        eliminarRobot(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
    }

    public void obterCompeticoes(RoutingContext rc) {
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Competicao> listaCompeticoes = new ArrayList<>();
        obterListaCompeticoes(listaCompeticoes);
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
    }

    public void obterEquipas(RoutingContext rc) {
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Equipa> listaEquipas = new ArrayList<>();
        obterListaEquipas(listaEquipas);
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaEquipas));
    }

    public void obterRobots(RoutingContext rc) {
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Robot> listaRobots = new ArrayList<>();
        obterListaRobots(listaRobots);
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaRobots));
    }

    public void obterRobotsDeUmaEquipa(RoutingContext rc) {
        String idEquipa = rc.request().getParam("id");
        int idEquipaFinal = Integer.parseInt(idEquipa);
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Robot> listaRobots = new ArrayList<>();
        obterListaRobotsDeUmaEquipa(listaRobots, idEquipaFinal);
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaRobots));
    }

    public void obterRondasDeUmaCompeticao(RoutingContext rc) {
        String idCompeticao = rc.request().getParam("id");
        int idCompeticaoFinal = Integer.parseInt(idCompeticao);
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Ronda> listaRondas = new ArrayList<>();
        obterListaRondasDeUmaCompeticao(listaRondas, idCompeticaoFinal);
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaRondas));
    }

    public void obterResultadosRonda(RoutingContext rc) {
        String idRonda = rc.request().getParam("id");
        int idRondaFinal = Integer.parseInt(idRonda);
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<AssociacaoRobotRonda> listaAssociacaoRobotRonda = new ArrayList<>();
        obterResultadosDeUmaRonda(listaAssociacaoRobotRonda, idRondaFinal);
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaAssociacaoRobotRonda));
    }

    public void obterResultadosRondaTempo(RoutingContext rc) {
        String idRonda = rc.request().getParam("id");
        int idRondaFinal = Integer.parseInt(idRonda);
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<AssociacaoRobotRonda> listaAssociacaoRobotRonda = new ArrayList<>();
        obterResultadosDeUmaRondaTempo(listaAssociacaoRobotRonda, idRondaFinal);
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaAssociacaoRobotRonda));
    }

    public void obterResultadosRondaVelocidade(RoutingContext rc) {
        String idRonda = rc.request().getParam("id");
        int idRondaFinal = Integer.parseInt(idRonda);
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<AssociacaoRobotRonda> listaAssociacaoRobotRonda = new ArrayList<>();
        obterResultadosDeUmaRondaVelocidade(listaAssociacaoRobotRonda, idRondaFinal);
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaAssociacaoRobotRonda));
    }

    public void obterResultadosRondaPontos(RoutingContext rc) {
        String idRonda = rc.request().getParam("id");
        int idRondaFinal = Integer.parseInt(idRonda);
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<AssociacaoRobotRonda> listaAssociacaoRobotRonda = new ArrayList<>();
        obterResultadosDeUmaRondaPontos(listaAssociacaoRobotRonda, idRondaFinal);
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaAssociacaoRobotRonda));
    }

    public void obterResultadoDeUmRobot(RoutingContext rc) { //verificar
        String idRonda = rc.request().getParam("id");
        String idRobotRonda = rc.request().getParam("idAssociacaoRobotRonda");
        int idRondaFinal = Integer.parseInt(idRonda);
        int idRobotRondaFinal = Integer.parseInt(idRobotRonda);
        AssociacaoRobotRonda robotRonda = obterResultadoDeUmRobotDeUmaRonda(idRobotRondaFinal, idRondaFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
        response.end(Json.encodePrettily(robotRonda));
    }

    public void updateResultadoRobot(RoutingContext rc) {
        String idAssociacaoRonda = rc.request().getParam("association");
        String idRobot = rc.request().getParam("robot");
        String tempo = rc.request().getParam("tempo");
        String velocidade = rc.request().getParam("velocidade");
        String pontos = rc.request().getParam("pontos");
        int idAssociacaoRondaFinal = Integer.parseInt(idAssociacaoRonda);
        int idRobotFinal = Integer.parseInt(idRobot);
        double tempoFinal = Double.parseDouble(tempo);
        double velocidadeFinal = Double.parseDouble(velocidade);
        int pontosFinal = Integer.parseInt(pontos);
        actualizarResultadoRobot(idAssociacaoRondaFinal, idRobotFinal, tempoFinal, velocidadeFinal, pontosFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void selecionarCompeticao(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        Competicao competicao = obterUmaCompeticao(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
        response.end(Json.encodePrettily(competicao));
    }

    public void updateCompeticao(RoutingContext rc) {
        String idCompeticao = rc.request().getParam("idCompeticao");
        int idCompeticaoFinal = Integer.parseInt(idCompeticao);
        String nomeCompeticao = rc.request().getParam("competitionName");
        String dataCriacaoCompeticao = rc.request().getParam("creationDate");
        actualizarCompeticao(idCompeticaoFinal, nomeCompeticao, dataCriacaoCompeticao);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void deleteCompeticao(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        eliminarCompeticao(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
    }

    public void updateRonda(RoutingContext rc) {
        String idRonda = rc.request().getParam("roundId");
        int idRondaFinal = Integer.parseInt(idRonda);
        String idCompeticao = rc.request().getParam("competitionRoundId");
        int idCompeticaoFinal = Integer.parseInt(idCompeticao);
        String tipoDeRonda = rc.request().getParam("RoundType");
        actualizarRonda(idRondaFinal, idCompeticaoFinal, tipoDeRonda);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void deleteRonda(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        eliminarRonda(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
    }

    public void obterEquipasDeUmaCompeticao(RoutingContext rc) {
        HttpServerResponse response = rc.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<AssociacaoEquipaCompeticao> listaAssociacaoEquipaCompeticao = new ArrayList<>();
        obterListaEquipasDeUmaCompeticao(listaAssociacaoEquipaCompeticao);
        response.setStatusCode(200);
        response.end(Json.encodePrettily(listaAssociacaoEquipaCompeticao));
    }

    public void deleteEquipaCompeticao(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        eliminarEquipaDeUmaCompeticao(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
    }

    public void selecionarRonda(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        Ronda ronda = obterUmaRonda(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
        response.end(Json.encodePrettily(ronda));
    }

    public void updateEquipaCompetitionManagement(RoutingContext rc) {
        String idEquipa = rc.request().getParam("competitionTeamId");
        int idEquipaFinal = Integer.parseInt(idEquipa);
        String nomeEquipa = rc.request().getParam("competitionTeamNameId");
        actualizarEquipa(idEquipaFinal, nomeEquipa);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
    }

    public void deleteEquipaSistema(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        eliminarEquipa(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
    }
     public void deleteAssociacaoRobotRonda(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        eliminarAssociacaoRobotRonda(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
    }
}
