import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    private final String userName = "@mysterious_rt_bot";
    private final String token = "5177751400:AAGjeX8kamTuLbg1KRRqZX8a-B3_v045pzY";

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            String text = message.getText();
            try {
                execute(SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text(text)
                        .build());

            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
