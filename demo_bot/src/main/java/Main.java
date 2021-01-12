import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
	public static void main(String[] args) {
		TelegramBotsApi api = null;
		try {
			api = new TelegramBotsApi(DefaultBotSession.class);
			api.registerBot(new Bot());
			System.out.println("Bot started!");
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
