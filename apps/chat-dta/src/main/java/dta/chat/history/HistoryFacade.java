package dta.chat.history;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import dta.chat.model.ChatMessage;
import dta.chat.model.socket.ChatClientException;

public class HistoryFacade {

	public List<ChatMessage> findLastMessages() throws ChatClientException {
		try {
			return Files.lines(Paths.get("data/historic.txt")).map(line -> {
				String[] lineTab = line.split(ChatMessage.FORMAT_SEPARATOR);
				return new ChatMessage(lineTab[0], lineTab[1]);
			}).collect(Collectors.toList());

		} catch (IOException e) {
			throw new ChatClientException(e);
		}
	}

	public void saveMessage(ChatMessage message) throws ChatClientException {
		try {
			Files.write(Paths.get("data/historic.txt"), message.formater().getBytes(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new ChatClientException(e);
		}
	}
}
