package de.lpa;

public class Main {
	public static void main(String[] args) {
		System.out.println("Main Thread Running");
		try {
			System.out.println("Main thread paused for one Second");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Thread thread = new Thread(() -> {
			String tname = Thread.currentThread().getName();
			System.out.println(tname + " should take 10 dots a run");
			for (int i = 0; i < 10; i++) {
				System.out.print(". ");
				try {
					Thread.sleep(500);
					System.out.println("A. State = " + Thread.currentThread().getState());
				} catch (InterruptedException e) {
					System.out.println("\nWhoops!! " + tname + " interrupted.");
					System.out.println("A1. State = " + Thread.currentThread().getState());
					return;
				}
			}
			System.out.println("\n" + tname + " completed.");
		});
		System.out.println(thread.getName() + " starting");
		thread.start();
		//System.out.println("Main thread would continue here");

		/*try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

		long now = System.currentTimeMillis();
		while (thread.isAlive()) {
			System.out.println("\nwaiting for tread to complete");
			try {

				Thread.sleep(1000);
				System.out.println("B. State = " + thread.getState());

				if (System.currentTimeMillis() - now > 2000) {
					thread.interrupt();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("C. State = " + thread.getState());

	}
}
