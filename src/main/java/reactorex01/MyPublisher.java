package reactorex01;

import java.util.Arrays;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

// <T> : 발행 정보
public class MyPublisher implements Publisher<Integer> {

	// DB 정보를 가지고 있음.
	Iterable<Integer> iters = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	
	// 구독자는 이 함수를 통해 구독할 수 있다.
	public void subscribe(Subscriber<? super Integer> s) {
		System.out.println("1. MyPublisher(subscribe) - 구독");
		s.onSubscribe(new MySubscription((MySubscriber)s, iters)); // SubScriber의 onSubscribe 함수를 콜백한다.
		// Subscription에게 Subscriber의 정보를 넘겨줘야 한다.
	}
}