/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import io.vertx.core.Vertx;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 *
 * @author diogo
 */
public class BotTelegram extends TelegramLongPollingBot {

    Vertx vertx;
    private final String chat_id = "5513869022";

    public BotTelegram(Vertx vertx) {
        this.vertx = vertx;
        System.out.println("O meu Bot do Telegram");
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

        // verifica se existe uma mensagem e se a msg tem texto
        if (update.hasMessage()) {
            // quem enviou a msg
            System.out.print("Mensagem de: ");
            System.out.println(update.getMessage().getFrom().getFirstName());

            if (update.getMessage().hasText()) {
                String msgRec = update.getMessage().getText();
                System.out.println(msgRec);
            }
        }
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
