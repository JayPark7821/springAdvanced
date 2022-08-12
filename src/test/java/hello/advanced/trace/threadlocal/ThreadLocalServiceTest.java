package hello.advanced.trace.threadlocal;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.threadlocal.code.FieldService;
import hello.advanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalServiceTest {

	private ThreadLocalService service = new ThreadLocalService();

	@Test
	void field() throws Exception{
		log.info("main start");
		Runnable userA = () -> {
			service.logic("userA");
		};

		Runnable userB = () -> {
			service.logic("userB");
		};

		Thread threadA = new Thread(userA);
		threadA.setName("thread-A");

		Thread threadB = new Thread(userB);
		threadB.setName("thread-B");

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
