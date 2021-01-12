import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class Bot extends TelegramLongPollingBot {

	@Override
	public String getBotUsername() {
		return "vlasenko_demo_bot";
	}

	@Override
	public String getBotToken() {
		return "1592235628:AAGBVqrLlvnq3o-vayN3irf6qCyjFFVLbiE";
	}

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			Message message = update.getMessage();
			long chatId = message.getChatId();

			String text = message.getText();
			if (text.equals("/start")) {
				text = "Введи название города";
				System.out.println(text);
			} else {
				try {
					text = Weather.getWeather(text);
					System.out.println(text);
				} catch (IOException e) {
					text = "Ошибка!";
					e.printStackTrace();
				}
			}
			sendAnswer(chatId, text);

		}
	}

	private void sendAnswer(Long chatId, String text) {
		SendMessage answer = new SendMessage();
		answer.setChatId(chatId.toString());
		answer.setText(text);
		try {
			execute(answer);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
