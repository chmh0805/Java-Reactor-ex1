package reactorex01;

import java.util.Iterator;

import org.reactivestreams.Subscription;

public class MySubscription implements Subscription {
	
	private final MySubscriber subscriber;
	private final Iterator<Integer> data;
	
	public MySubscription(MySubscriber s, Iterable<Integer> iters) {
		System.out.println("2. MySubscription(constructor) - 구독 정보 생성");
		this.subscriber = s;
		this.data = iters.iterator();
	}

	public void request(long n) {
		System.out.println("4. MySubscription(request) - "+n+"개씩 구독 시작");
		// 구독자에게 n개씩 돌려주는 로직이 필요
		while (n > 0) {
			if (data.hasNext()) {
				subscriber.onNext(data.next());
			} else {
				subscriber.onComplete();
				break;
			}
			n--;
		}
	}

	public void cancel() {
		
	}
}
