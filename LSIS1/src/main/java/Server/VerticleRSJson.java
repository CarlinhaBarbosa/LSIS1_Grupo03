package Server;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import static io.vertx.ext.web.handler.StaticHandler.DEFAULT_WEB_ROOT;

/**
 *
 * @author Misterio
 */
public class VerticleRSJson extends AbstractVerticle {

    String webRoot = "src/main/java/webroot";
    Router router;
    MQTTCli mqttCli;

    @Override
    public void start(Promise<Void> startPromise) throws Exception {

        Repository repo = new Repository();
        Handlers handlers = new Handlers(repo);
        router = routes(handlers);

        mqttCli = new MQTTCli(vertx, repo);

        HttpServerOptions options = new HttpServerOptions();
        options.setHost("127.0.0.1").setPort(7510);

        vertx.createHttpServer(options)
                .requestHandler(router) //usa o router para manipular qualquer pedido
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
        router.route("/*").handler(StaticHandler.create(webRoot));

//
//        // ATENÇÃO: necessário usar "bodyHandler" quando se pretende ler o body do pedido
//        //  - nos POST seguintes o body contém os dados do aluno
//        //Handlers
//        router.route(HttpMethod.POST, "/registarCompeticao").handler(handlers::registarCompeticao);
        return router;
    }

}
