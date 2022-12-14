package TD3.taches;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import TD3.brokers.QueueBroker;
import TD3.brokers.QueueBrokerImplem;
import TD3.channels.MessageQueue;

public class TacheBroadcastB extends Tache {

	private QueueBroker queueBroker;
	private int portConnexion;

	public TacheBroadcastB(String name, int portConnexion) {
		super(name);
		this.queueBroker = new QueueBrokerImplem(name);
		this.portConnexion = portConnexion;
	}

	public void run() {
		MessageQueue queue = queueBroker.connect("Broadcast", portConnexion);
		byte[] message = null;
		try {
			message = queue.receive();
			String msgString = new String(message, StandardCharsets.UTF_8);
			System.out.println("Tache B reçu : " + msgString);
		} catch (IOException e) {
			System.out.println("je suis déconnecté");
		}

	}

}
