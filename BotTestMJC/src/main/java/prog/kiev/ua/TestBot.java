package prog.kiev.ua;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TestBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "*****************";
    }

    @Override
    public String getBotToken() {
        return "****************";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String text = update.getMessage().getText();
            System.out.println(update.getMessage().getText());
            SendMessage message = new SendMessage();
            if(text.equals("дай ссыку")){
                message = SendMessage.builder().
                        chatId(update.getMessage().getChatId().toString()).
                        text("https://prom.ua/Podstavki-dlya-aromapalochek.html ").build();
            } else {
                message = SendMessage.builder().
                        chatId(update.getMessage().getChatId().toString()).text("хуй").build();
            }
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TestBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
