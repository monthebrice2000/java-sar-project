package TD3;

import TD3.taches.Broadcast;
import TD3.taches.TacheBroadcastA;
import TD3.taches.TacheBroadcastB;

class Main {
	public static void main(String[] args) {
		TacheBroadcastA tacheQueueA = new TacheBroadcastA("test1", 123);
		TacheBroadcastB tacheQueueB1 = new TacheBroadcastB("test2", 124);
		TacheBroadcastB tacheQueueB2 = new TacheBroadcastB("test3", 126);

		Broadcast broadcast = new Broadcast("Broadcast");

		broadcast.start();
		tacheQueueA.start();
		tacheQueueB1.start();
		tacheQueueB2.start();
	}
}