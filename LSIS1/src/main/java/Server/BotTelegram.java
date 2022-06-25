/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import Model.AssociacaoRobotRonda;
import io.vertx.core.Vertx;
import java.util.List;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import static DataBase.DAL.obterResultadosDeUmaRondaTelegramPontos;

/**
 *
 * @author diogo
 */
public final class BotTelegram extends TelegramLongPollingBot {

    Vertx vertx;
    private final String chat_id = "-767548377";

    /*5513869022*/
    public BotTelegram(Vertx vertx) {
        this.vertx = vertx;
        System.out.println("O meu Bot do Telegram");
        sendMessage("BotTelegram iniciado" + "\nComandos:" + "\n /classificacaoRondaGeral");
    }

    public void sendMessage(String msg) {
        SendMessage message = new SendMessage();
        message.setText(msg);
        message.setChatId(chat_id);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            System.out.print("Mensagem de: ");
            System.out.println(update.getMessage().getFrom().getFirstName());
            if (update.getMessage().hasText()) {
                String msgRec = update.getMessage().getText();
                System.out.println("(Telegram) " + msgRec);
                if (msgRec.contains("/classificacaoRondaGeral")) {
                    sendMessage("Insira o número da ronda: ");
                }
                classificacaoRondaGeral(update);
                System.out.println(msgRec);
            }
        }
    }

    private void classificacaoRondaGeral(Update update) {
        List<AssociacaoRobotRonda> listFinal = obterResultadosDeUmaRondaTelegramPontos(Integer.parseInt(update.getMessage().getText()));
        String str = "";
        for (AssociacaoRobotRonda associacaoRobotRonda : listFinal) {
            str += "\nidRobot: " + associacaoRobotRonda.getIdRobot() + "\ntempo:" + associacaoRobotRonda.getTempo() + "\nvelocidade:" + associacaoRobotRonda.getVelocidade()
                    + "\npontos:" + associacaoRobotRonda.getPontos() + "\n" + "\n---";
        }
        sendMessage(str);
    }

    @Override
    public String getBotUsername() {
        return "lsisGrupo2bot";
    }

    @Override
    public String getBotToken() {
        return "5497785906:AAGIqSdAZusEjAJT8YI9uB7iuv165HwV03E";
    }
}
