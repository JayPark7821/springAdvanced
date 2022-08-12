package hello.advanced.trace.threadlocal;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldServiceTest {

	private FieldService fieldService = new FieldService();

	@Test
	void field() throws Exception{
		log.info("main start");
		Runnable userA = () -> {
			fieldService.logic("userA");
		};

		Runnable userB = () -> {
			fieldService.logic("userB");
		};

		Thread threadA = new Thread(userA);
		threadA.setName("thread-A");

		Thread threadB = new Thread(userB);
		threadA.setName("thread-B");

		threadA.start();
		sleep(100); // 동시성 문제 X
		threadB.start();

		sleep(3000);
		log.info("main Exit");
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
