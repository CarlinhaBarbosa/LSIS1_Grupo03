//package Server;
//
//import static DataBase.DAL.inserirCompeticao;
//import Model.Competicao;
//import io.vertx.core.http.HttpServerResponse;
//import io.vertx.core.json.Json;
//import io.vertx.core.json.JsonObject;
//import io.vertx.ext.web.RoutingContext;
//import static io.vertx.ext.web.handler.StaticHandler.DEFAULT_WEB_ROOT;
//import java.text.ParseException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import utils.Utils;
//
///**
// *
// * @author Misterio
// */
//class Handlers {
//
////    List<Aluno> BDfalsa = new ArrayList<>();
//    String webRoot = DEFAULT_WEB_ROOT;
//
//    Repository repo;
//
//    public Handlers(Repository repo) {
//        this.repo = repo;
//    }
//
//    //Nota: para alguns dos métodos foi necessário incluir a biblioteca Jackson no pom.xmml
//    public void registarCompeticao(RoutingContext rc) {
//        try {
//            String nomeCompeticao = rc.request().getParam("nomeId");
//            String dataCriacaoCompeticao = rc.request().getParam("dataCriacaoId");
//            Date dataCriacaoCompeticaoConvertida = Utils.obterDataConvertidaParaJavaDateComParametroString(dataCriacaoCompeticao);
//            Competicao competicaoNova = new Competicao(nomeCompeticao, dataCriacaoCompeticaoConvertida);
//            inserirCompeticao(competicaoNova);
//            HttpServerResponse response = rc.response();
//            response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
//            response.end(Json.encodePrettily(competicaoNova));
//        } catch (ParseException ex) {
//            Logger.getLogger(Handlers.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//}
