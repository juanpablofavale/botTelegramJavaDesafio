package es.codegym.telegrambot;

import es.codegym.env.Environment;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {

    public static String NAME;
    public static String TOKEN;

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí
        // __ para cursiva
        // ** para negrita

        if (getMessageText().equals("/start")){
            sendTextMessageAsync("Excelente _futuro_ *desarrollador*! Comenzare a hackearte justo ahora!");
        }
        if(getMessageText().contains("me llamo")){
            sendTextMessageAsync("Encantado de conocerte! Me llamo *Gato*!");
        }

        if (getMessageText().toLowerCase().contains("hola")){
            sendTextMessageAsync("Hola! Como te llamas?");
        }
    }

    public static void main(String[] args) throws Exception {
        Environment.main();
        NAME = Environment.Nombre;
        TOKEN = Environment.Token;

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}