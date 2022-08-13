package hello.advanced.trace.template;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodTest {

	@Test
	void templateMethodV0() throws Exception{
		logic1();
		logic2();

	}

	private void logic1() {
		long startTime = System.currentTimeMillis();
		log.info("비지니스 로직 1 실행");

		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTIme = {}", resultTime);

	}
	private void logic2() {
		long startTime = System.currentTimeMillis();
		log.info("비지니스 로직 2 실행");

		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTIme = {}", resultTime);

	}

	@Test
	void templateMethodV1() throws Exception{
		AbstractTemplate template1 = new SubClassLogic1();
		template1.execute();

		AbstractTemplate template2 = new SubClassLogic2();
		template2.execute();
	}

	@Test
	void templateMethodV2() throws Exception{
	    //given
		AbstractTemplate template1 = new AbstractTemplate() {
			@Override
			protected void call() {
				log.info("비즈니스 로직1 실행");
			}
		};
		template1.execute();
		AbstractTemplate template2 = new AbstractTemplate() {
			@Override
			protected void call() {
				log.info("비즈니스 로직2 실행");
			}
		};
		template2.execute();
		//when

	    //then
	}
}
