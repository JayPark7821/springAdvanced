package hello.advanced.trace.logtrace;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.TraceStatus;

class ThreadLocalLogTraceTest {

    ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

    @Test
    void begin_end_level2 () throws Exception {
        //given
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.begin("hell2o");
        trace.end(status2);
        trace.end(status1);

    }

    @Test
    void begin_exception_level2 () throws Exception {
        //given
        TraceStatus status1 = trace.begin("hello");
        TraceStatus status2 = trace.begin("hell2o");
        trace.exception(status2, new IllegalArgumentException());
        trace.exception(status1, new IllegalArgumentException());

    }


}