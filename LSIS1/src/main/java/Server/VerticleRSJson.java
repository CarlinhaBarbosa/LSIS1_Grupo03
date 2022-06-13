package Server;

import static DataBase.DAL.inserirCompeticao;
import static DataBase.DAL.inserirRonda;
import static DataBase.DAL.inserirEquipa;
import static DataBase.DAL.inserirRobot;
import static DataBase.DAL.obterEquipa;
import static DataBase.DAL.actualizarEquipa;
import Model.Competicao;
import Model.Equipa;
import Model.Robot;
import Model.Ronda;
import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import static io.vertx.ext.web.handler.StaticHandler.DEFAULT_WEB_ROOT;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Utils;

/**
 *
 * @author Misterio
 */
public class VerticleRSJson extends AbstractVerticle {

    String webRoot = "src/main/java/webroot";
    Router router;
//    MQTTCli mqttCli;
//    String webroot = DEFAULT_WEB_ROOT;

    @Override
    public void start(Promise<Void> promise) throws Exception {

//        Repository repo = new Repository();
//        Handlers handlers = new Handlers(repo);
//        router = routes(handlers);
        Router router = Router.router(vertx);
        router.route().handler(BodyHandler.create());
        router.route(HttpMethod.GET, "/*").handler(StaticHandler.create(webRoot));
        router.route(HttpMethod.POST, "/registarCompeticao").handler(this::registarCompeticao);
        router.route(HttpMethod.POST, "/registarRonda").handler(this::registarRonda);
        router.route(HttpMethod.POST, "/registarEquipa").handler(this::registarEquipa);
        router.route(HttpMethod.POST, "/registarRobot").handler(this::registarRobot);
        router.route(HttpMethod.GET, "/selecionarEquipa").handler(this::selecionarEquipa);
        router.route(HttpMethod.POST, "/atualizarEquipa").handler(this::updateEquipa);

//        mqttCli = new MQTTCli(vertx, repo);
        HttpServerOptions options = new HttpServerOptions();
//        options.setHost("127.0.0.1").setPort(7506);
        options.setPort(7518);

        vertx.createHttpServer(options)
                .requestHandler(router)
                .listen(res -> {
                    if (res.succeeded()) {
                        promise.complete();
                        System.out.println("Servidor HTTP no porto " + options.getPort());
                    } else {
                        promise.fail(res.cause());
                        System.out.println("Não foi possível iniciar o servidor HTTP");
                    }
                });
    }

    private void registarCompeticao(RoutingContext rc) {

        String nomeCompeticao = rc.request().getParam("nomeCompeticaoId");
        String dataCriacaoCompeticao = rc.request().getParam("dataCriacaoId");
        Competicao competicaoNova = new Competicao(nomeCompeticao, dataCriacaoCompeticao);
        inserirCompeticao(competicaoNova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
        response.end(Json.encodePrettily(competicaoNova));
    }

    private void registarRonda(RoutingContext rc) {
        String idCompeticao = rc.request().getParam("CompeticaoId");
        int idCompeticaoFinal = Integer.parseInt(idCompeticao);
        String tipoRonda = rc.request().getParam("Round");
        Ronda rondaNova = new Ronda(idCompeticaoFinal, tipoRonda);
        inserirRonda(rondaNova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
        response.end(Json.encodePrettily(rondaNova));
    }

    private void registarEquipa(RoutingContext rc) { //falta testar (comment : joaoFerreira, 13/06/22
        String nomeEquipa = rc.request().getParam("nomeEquipa");
        Equipa equipaNova = new Equipa(nomeEquipa);
        inserirEquipa(equipaNova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
        response.end(Json.encodePrettily(equipaNova));
    }

    private void registarRobot(RoutingContext rc) { //falta testar (comment : joaoFerreira, 13/06/22
        String idEquipa = rc.request().getParam("idEquipa");
        int idEquipaFinal = Integer.parseInt(idEquipa);
        String nomeRobot = rc.request().getParam("nomeRobot");
        String macAddress = rc.request().getParam("macAddress");
        Robot robotNovo = new Robot(idEquipaFinal, nomeRobot, macAddress);
        inserirRobot(robotNovo);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
        response.end(Json.encodePrettily(robotNovo));
    }

    public void selecionarEquipa(RoutingContext rc) {
        String id = rc.request().getParam("id");
        int idFinal = Integer.parseInt(id);
        Equipa equipa = obterEquipa(idFinal);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
        response.end(Json.encodePrettily(equipa));
    }

    private void updateEquipa(RoutingContext rc) {
        String idEquipa = rc.request().getParam("teamId");
        int idEquipaFinal = Integer.parseInt(idEquipa);
        String nomeEquipa = rc.request().getParam("teamNameId");
        actualizarEquipa(idEquipaFinal, nomeEquipa);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
//        response.end(Json.encodePrettily(cliente));
    }
}
