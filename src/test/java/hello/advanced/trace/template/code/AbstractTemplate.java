package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

	public void execute() {
		long startTime = System.currentTimeMillis();

		call();
		// log.info("비지니스 로직 1 실행");

		long endTime = System.currentTimeMillis();
		long resultTime = endTime - startTime;
		log.info("resultTIme = {}", resultTime);
	}

	protected abstract void call();
}
