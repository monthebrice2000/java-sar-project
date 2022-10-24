package TD3.brokers;

import TD3.channels.MessageQueue;

public abstract class QueueBrokerEvent {
	QueueBrokerEvent(String name) {
	}

	interface AcceptListener {
		void accepted(int port, MessageQueue queue);
	}

	boolean bind(int port, AcceptListener listener) {
		return false;
	}

	boolean unbind(int port) {
		return false;
	}

	interface ConnectListener {
		void connected(String name, int port, MessageQueue queue);

		void refused(String name, int port);
	}

	boolean connect(String name, int port, ConnectListener listener) {
		return false;
	}
}