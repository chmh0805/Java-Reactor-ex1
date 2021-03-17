package reactorex01;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

// <T> : 구독할 데이터 타입
public class MySubscriber implements Subscriber<Integer> {

	private Integer size = 3;
	private Subscription subscription;
	
	public void onSubscribe(Subscription s) {
		this.subscription = s;
		System.out.println("3. MySubscriber(onSubscribe) - 구독 정보 돌려받음");
		// 데이터 받기
		s.request(size); // n은 구독할 수 있는 데이터의 한계를 의미한다. (Back Pressure)
	}

	// 데이터를 돌려받는 함수
	public void onNext(Integer t) {
		System.out.println("5. MySubscriber(onNext) - 데이터 : " + t);
		size--;
		if (size == 0) {
			size = 3;
			subscription.request(size);
		}
	}

	public void onError(Throwable t) {
		
	}

	public void onComplete() {
		System.out.println("데이터 다 받음");
	}
	
}
