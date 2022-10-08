package TD2;

import TD2.taches.*;

class Main {
	public static void main(String[] args) {
		TacheQueueA tacheQueueA = new TacheQueueA("test1");
		TacheQueueB tacheQueueB = new TacheQueueB("test2");
		tacheQueueA.start(); tacheQueueB.start();
	}
}