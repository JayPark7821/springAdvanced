package hello.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1Test {

	@Test
	void strategyV0() throws Exception{
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

	/**
	 * 전략패턴 사용
	 * @throws Exception
	 */
	@Test
	void strategyV1() throws Exception{
		StrategyLogic1 strategyLogic1 = new StrategyLogic1();
		ContextV1 contextV1 = new ContextV1(strategyLogic1);
		contextV1.execute();

		StrategyLogic2 strategyLogic2 = new StrategyLogic2();
		ContextV1 contextV2 = new ContextV1(strategyLogic2);
		contextV2.execute();

	}
	
	@Test
	void strategyv2() throws Exception{
		Strategy strategyLogic1 = new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직1 실행");

			}
		};

		ContextV1 contextV1 = new ContextV1(strategyLogic1);
		contextV1.execute();

		Strategy strategyLogic2 = new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직2 실행");

			}
		};

		ContextV1 contextV2 = new ContextV1(strategyLogic2);
		contextV2.execute();

	}

	@Test
	void strategyv3() throws Exception{

		ContextV1 contextV1 = new ContextV1( new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직1 실행");

			}
		});
		contextV1.execute();

		ContextV1 contextV2 = new ContextV1(new Strategy() {
			@Override
			public void call() {
				log.info("비즈니스 로직2 실행");

			}
		});
		contextV2.execute();
	}

	@Test
	void strategyv4() throws Exception{


		ContextV1 contextV1 = new ContextV1(() -> log.info("비즈니스 로직1 실행"));
		contextV1.execute();

		ContextV1 contextV2 = new ContextV1(() -> log.info("비즈니스 로직2 실행"));
		contextV2.execute();
	}

}
