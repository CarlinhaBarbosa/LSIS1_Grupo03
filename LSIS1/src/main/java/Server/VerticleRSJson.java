package Server;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
//import static io.vertx.ext.web.handler.StaticHandler.DEFAULT_WEB_ROOT;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 *
 * @author Misterio
 */
public class VerticleRSJson extends AbstractVerticle {

    String webRoot = "src/main/java/webroot";
    Router router;
    BotTelegram bot;
    MQTTCli mqttCli;
//    String webroot = DEFAULT_WEB_ROOT;

    @Override
    public void start(Promise<Void> startPromise) throws Exception {

        bot = new BotTelegram(vertx);
        telegramBot(bot);
        Repository repo = new Repository();
        Handlers handlers = new Handlers(repo, bot);
        router = routes(handlers);

        mqttCli = new MQTTCli(vertx, repo);
        HttpServerOptions options = new HttpServerOptions();
        options.setHost("127.0.0.1").setPort(7522);
//        options.setPort(7530);

        vertx.createHttpServer(options)
                .requestHandler(router)
                .listen(res -> {
                    if (res.succeeded()) {
                        startPromise.complete();
                        System.out.println("Servidor HTTP no porto " + options.getPort());
                    } else {
                        startPromise.fail(res.cause());
                        System.out.println("Não foi possível iniciar o servidor HTTP");
                    }
                });
    }

    private Router routes(Handlers handlers) {

        router = Router.router(vertx);

        router.route().handler(BodyHandler.create());
        router.route(HttpMethod.GET, "/*").handler(StaticHandler.create(webRoot));
        router.route(HttpMethod.POST, "/registarCompeticao").handler(handlers::registarCompeticao);
        router.route(HttpMethod.POST, "/registarRonda").handler(handlers::registarRonda);
        router.route(HttpMethod.POST, "/registarEquipa").handler(handlers::registarEquipa);
        router.route(HttpMethod.POST, "/registarRobot").handler(handlers::registarRobot);
        router.route(HttpMethod.GET, "/selecionarEquipa").handler(handlers::selecionarEquipa);
        router.route(HttpMethod.POST, "/atualizarEquipa").handler(handlers::updateEquipa);
        router.route(HttpMethod.GET, "/selecionarRobot").handler(handlers::selecionarRobot);
        router.route(HttpMethod.POST, "/atualizarRobot").handler(handlers::updateRobot);
        router.route(HttpMethod.POST, "/eliminarRobot").handler(handlers::deleteRobot);
        router.route(HttpMethod.GET, "/obterCompeticoes").handler(handlers::obterCompeticoes);
        router.route(HttpMethod.POST, "/inscreverEquipaCompeticao").handler(handlers::inscricaoEquipaCompeticao);
        router.route(HttpMethod.GET, "/obterEquipas").handler(handlers::obterEquipas);
        router.route(HttpMethod.GET, "/obterRobots").handler(handlers::obterRobots);
        router.route(HttpMethod.GET, "/selecionarRobotsEquipa").handler(handlers::obterRobotsDeUmaEquipa);
        router.route(HttpMethod.GET, "/obterRondasCompeticao").handler(handlers::obterRondasDeUmaCompeticao);
        router.route(HttpMethod.GET, "/obterResultadosRonda").handler(handlers::obterResultadosRonda);
        router.route(HttpMethod.GET, "/obterResultadosRobotRonda").handler(handlers::obterResultadoDeUmRobot);
        router.route(HttpMethod.POST, "/atualizarResultados").handler(handlers::updateResultadoRobot);
        router.route(HttpMethod.GET, "/selecionarCompeticao").handler(handlers::selecionarCompeticao);
        router.route(HttpMethod.POST, "/atualizarCompeticao").handler(handlers::updateCompeticao);
        router.route(HttpMethod.POST, "/eliminarCompeticao").handler(handlers::deleteCompeticao);
        router.route(HttpMethod.POST, "/atualizarRonda").handler(handlers::updateRonda);
        router.route(HttpMethod.POST, "/eliminarRonda").handler(handlers::deleteRonda);
        router.route(HttpMethod.GET, "/obterEquipasDeUmaCompeticao").handler(handlers::obterEquipasDeUmaCompeticao);
        router.route(HttpMethod.POST, "/eliminarEquipaCompeticao").handler(handlers::deleteEquipaCompeticao);
        router.route(HttpMethod.GET, "/selecionarRonda").handler(handlers::selecionarRonda);
        router.route(HttpMethod.POST, "/atualizarEquipaCompetitionManagement").handler(handlers::updateEquipaCompetitionManagement);
        router.route(HttpMethod.POST, "/eliminarEquipaSistema").handler(handlers::deleteEquipaSistema);

        return router;
    }

    public void telegramBot(BotTelegram bot) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace(System.out);
        }
    }
}
