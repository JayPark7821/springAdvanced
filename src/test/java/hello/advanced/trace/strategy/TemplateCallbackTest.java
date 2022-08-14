package hello.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.strategy.code.template.Callback;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateCallbackTest {

	/**
	 * 탬플릿 콜백 패턴
	 * @throws Exception
	 */
	@Test
	void callbackV1() throws Exception{
		TimeLogTemplate timeLogTemplate = new TimeLogTemplate();
		timeLogTemplate.excute(()->log.info("비즈니스 로직 1 실행"));

		timeLogTemplate.excute(new Callback() {
			@Override
			public void call() {
				log.info("비즈니스 로직 2 실행");
			}
		});
	}
}
