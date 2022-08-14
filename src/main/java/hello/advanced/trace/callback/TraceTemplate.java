package hello.advanced.trace.callback;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

public class TraceTemplate {

	private final LogTrace trace;

	public TraceTemplate(LogTrace logTrace) {
		this.trace = logTrace;
	}

	public <T> T excute(String message, TraceCallback<T> callback) {

		TraceStatus status = null;
		try {
			trace.begin(message);
			T result = callback.call();
			trace.end(status);
			return result;
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}
}
