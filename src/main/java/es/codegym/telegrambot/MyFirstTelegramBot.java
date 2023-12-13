package es.codegym.telegrambot;

import es.codegym.env.Environment;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

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
            //sendTextMessageAsync("Excelente _futuro_ *desarrollador*! Comenzare a hackearte justo ahora!");
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT, Map.of(
                    "¡Hackear la Heladera!","step-1"
            ));
        }

        if (getCallbackQueryButtonKey().equals("step-1")){
            addUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT, Map.of(
                    "¡Tomar una salchicha! +20 de fama","step-2",
                    "¡Tomar un pescado! +20 de fama","step-2",
                    "¡Tirar una lata de pepinillos! +20 de fama","step-2"
            ));
        }

        if (getCallbackQueryButtonKey().equals("step-2")){
            addUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT, Map.of(
                    "¡Hackear la aspiradora!","step-3"
            ));
        }

        if (getCallbackQueryButtonKey().equals("step-3")){
            sendTextMessageAsync(STEP_4_TEXT, Map.of(
                    "¡Enviar al robot aspirador a por comida! +30 de fama","step-4",
                    "¡Dar un paseo en el robot aspirador! +30 de fama","step-4",
                    "¡Huir del robot aspirador! +30 de fama","step-4"
            ));
        }

        if (getCallbackQueryButtonKey().equals("step-4")){
            addUserGlory(30);
            sendTextMessageAsync(STEP_5_TEXT, Map.of(
                    "¡Encender y ponerse la GoPro!","step-5"
            ));
        }

        if (getCallbackQueryButtonKey().equals("step-5")){
            addUserGlory(40);
            sendTextMessageAsync(STEP_6_TEXT, Map.of(
                    "¡Correr por los tejados, grabar con la GoPro! +40 de fama","step-6",
                    "¡Atacar a otros gatos desde tu escondite con la GoPro! +40 de fama","step-6",
                    "¡Atacar a los perros desde tu escondite con la GoPro! +40 de fama","step-6"
            ));
        }

        if (getCallbackQueryButtonKey().equals("step-6")){
            addUserGlory(40);
            sendTextMessageAsync(STEP_7_TEXT, Map.of(
                    "¡Hackear la contraseña!","step-7"
            ));
        }

        if (getCallbackQueryButtonKey().equals("step-7")){
            addUserGlory(50);
            sendTextMessageAsync(STEP_8_TEXT, Map.of(
                    "¡Salir al patio!","step-8"
            ));
        }

        if (getCallbackQueryButtonKey().equals("step-8")){
            sendTextMessageAsync(FINAL_TEXT);
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