package TD2.taches;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import TD2.Manager;
import TD2.brokers.Broker;
import TD2.brokers.BrokerImplem;
import TD2.channels.Channel;



public class TacheB extends Tache {
	private Broker broker;

	public TacheB(String name, BrokerImplem broker) {
		super(name);
		this.broker = broker;
	}

	public void run() {
		Channel channel = null;
		try{
			channel = broker.connect("broker1", 123);
			byte[] bytesRecus = new byte[12];
			try {
				channel.read(bytesRecus, 0, 12);
			} catch (IOException e) {
				System.out.println("je suis déconnecté");
			}
			String msgString = new String(bytesRecus, StandardCharsets.UTF_8);
			System.out.println("message reçu : " + msgString);
		}catch(Error e){
			System.out.println("Ajout de tache à la liste de rdvs");
			Manager.addRDV( this );
		}
	}

}
