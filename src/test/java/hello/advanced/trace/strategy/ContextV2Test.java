package hello.advanced.trace.strategy;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.strategy.code.strategy.ContextV2;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2Test {

	/**
	 * 전략 패턴 사용
	 * @throws Exception
	 */
	@Test
	void strategyV1() throws Exception{
		ContextV2 contextV2 = new ContextV2();
		contextV2.execute(new StrategyLogic1());
		contextV2.execute(new StrategyLogic2());


	}
}
