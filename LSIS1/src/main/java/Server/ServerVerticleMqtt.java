/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Model.Repository;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Promise;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import static io.vertx.ext.web.handler.StaticHandler.DEFAULT_WEB_ROOT;
import io.vertx.mqtt.MqttClient;
import io.vertx.mqtt.MqttClientOptions;
import io.vertx.mqtt.messages.MqttConnAckMessage;
import io.vertx.mqtt.messages.MqttPublishMessage;
import java.util.ArrayList;

/**
 *
 * @author joaoferreira
 */
public class ServerVerticleMqtt extends AbstractVerticle {

    private String webRoot = DEFAULT_WEB_ROOT;
//    ArrayList<String> ListaComunicacaoMQTT = new ArrayList();
    MqttClient client;
    Repository repo; // comment by joaoferreira : verificar a necessidade

    @Override
    public void start(Promise<Void> startPromise) {

        MqttClientOptions options = new MqttClientOptions();
        options.setUsername("1200638@isep.ipp.pt");
        options.setPassword("user123");
        client = MqttClient.create(vertx, options);
        String broker = "maqiatto.com";
        //String broker = "mq.ttmby.org"; //Caso maqiatto nao estiver operacional
        Future<MqttConnAckMessage> maqiatto = client.connect(1883, broker);//connectHandler(client));
        maqiatto.onComplete(connectHandler(client));

        Router router = Router.router(vertx);
        router.route("/*").handler(StaticHandler.create(webRoot));

        HttpServerOptions Options = new HttpServerOptions();
        Options.setPort(7506);

        vertx.createHttpServer(Options)
                .requestHandler(router)
                .listen(res -> {
                    if (res.succeeded()) {
                        startPromise.complete();
                    } else {
                        startPromise.fail(res.cause());
                    }
                });

        if (client.isConnected()) {
            System.out.println("Connected");
        } else {
            System.out.println("Not connected");
        }
    }

    private Handler<AsyncResult<MqttConnAckMessage>> connectHandler(MqttClient client) {
        return s -> {
            if (s.succeeded()) {
                System.out.println("Ligado e a subscrever tópicos " + client.clientId());
                String topico1 = "1200638@isep.ipp.pt/lsis1";
                subscrever(client, topico1); //alterado
            } else {
                System.out.println("Falhou ligação ");
                System.out.println(s.cause());
            }
        };
    }

    public void subscrever(MqttClient client, String topico) { //alterado
        client.publishHandler(topicHandler())
                .subscribe(topico, 0);
    }

    private Handler<MqttPublishMessage> topicHandler() {
        return s -> {
            System.out.println("--- Mensagem Nova ---");
            System.out.println("Tópico: " + s.topicName());
            System.out.println("Mensagem: " + s.payload().toString());
            System.out.println("QoS: " + s.qosLevel());
            repo.inserirNaBDFalsa(s.payload().toString());
        };
    }

}
