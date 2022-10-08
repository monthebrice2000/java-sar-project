package TD2.taches;

import java.io.IOException;

import TD2.brokers.Broker;
import TD2.brokers.BrokerImplem;
import TD2.channels.Channel;

public class TacheA extends Tache {

	private Broker broker;

	public TacheA(String name, BrokerImplem broker) {
		super(name);
		this.broker = broker;
	}

	public void run() {
		Channel channel = broker.accept(123);
		try {
			channel.write("Hello World!".getBytes(), 0, 12);
		} catch (IOException e) {
			System.out.println("je suis déconnecté");
		}
	}

}
