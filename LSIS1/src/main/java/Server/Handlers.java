package Server;

import static DataBase.DAL.inserirCompeticao;
import Model.Competicao;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import static io.vertx.ext.web.handler.StaticHandler.DEFAULT_WEB_ROOT;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Misterio
 */
class Handlers {

//    List<Aluno> BDfalsa = new ArrayList<>();
    String webRoot = DEFAULT_WEB_ROOT;

    Repository repo;
    public Handlers(Repository repo) {
        this.repo = repo;
    }

    //Nota: para alguns dos métodos foi necessário incluir a biblioteca Jackson no pom.xmml
    
     public void registarCompeticao(RoutingContext rc) {
        String nome = rc.request().getParam("nome");
        String password = rc.request().getParam("password");
        String dataNas = rc.request().getParam("dataNasc");
        String email = rc.request().getParam("email");
        String nrFiscal = rc.request().getParam("numeroFiscal");
        String telefone = rc.request().getParam("numeroTelefone");
        String morada = rc.request().getParam("morada");
        Competicao competicaoNova = new Competicao();
        inserirCompeticao(competicaoNova);
        HttpServerResponse response = rc.response();
        response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
        response.end(Json.encodePrettily(competicaoNova));
    }
}
