package TD2.brokers;

import TD2.channels.Channel;
import TD2.channels.MessageQueue;
import TD2.channels.MessageQueueImplem;

public class QueueBrokerImplem extends QueueBroker {

	private String name;
	private int port;
	private TD1.brokers.BrokerImplem broker;

	public QueueBrokerImplem(String name) {
		this.name = name;
		this.broker = new BrokerImplem(name);
	}

	/**
	 * Attend (bloquant) la connexion d'un broker sur un port donne
	 * 
	 * @param int port - numero de port sur lequel attendre la connexion
	 * @return MessageQueue - canal de communication avec l'autre tache
	 **/
	public MessageQueue accept(int port) {
		Channel channel = broker.accept(port);
		return new MessageQueueImplem(channel);
	}

	/**
	 * Connexion bloquante à un broker d'un nom ainsi que d'un port donnes
	 * 
	 * @param int    port - numero de port sur lequel se connecter
	 * @param String name - nom de la tache
	 * @return MessageQueue - canal de communication entre les TD1.taches
	 **/
	public MessageQueue connect(String name, int port) {
		Channel channel = broker.connect(name, port);
		return new MessageQueueImplem(channel);
	}
}
