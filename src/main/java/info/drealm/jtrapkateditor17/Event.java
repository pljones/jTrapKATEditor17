package info.drealm.jtrapkateditor17;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Consumer;

public class Event<T> extends SubmissionPublisher<T> implements Subscriber<T> {

	private Consumer<T> onNext = null;
	private Runnable onSubscribe = null;
	private Consumer<Throwable> onError = null;
	private Runnable onComplete = null;

	// Store subscription to request next value.
	private Subscription subscription;

	public void connect(Consumer<T> onNext) { this.connect(onNext, null, null, null); }

	public void connect(
		Consumer<T> onNext // mandatory
		, Runnable onSubscribe // optional
		, Consumer<Throwable> onError // optional
		, Runnable onComplete // optional
	) {
		this.onNext = onNext;
		this.onSubscribe = onSubscribe;
		this.onError = onError;
		this.onComplete = onComplete;
		super.subscribe(this);
	}

	@Override
	public void onSubscribe(Subscription subscription) {
		if (onSubscribe != null) {
			onSubscribe.run();
		}
		// Store subscription
		this.subscription = subscription;
		// Request the first item
		subscription.request(1);
	}

	@Override
	public void onNext(T item) {
		// Process received value.
		onNext.accept(item);
		// Processing of item is done so request next value.
		subscription.request(1);
	}

	@Override
	public void onError(Throwable throwable) {
		System.err.println("[" + Thread.currentThread().getName() + "] ERROR "
				+ throwable.getClass().getSimpleName() + ": " + throwable.getMessage());
		throwable.printStackTrace();
		
		try {
			if (onError != null) {
				onError.accept(throwable);
			}
			subscription.cancel();
		} catch (Exception e) {
			// ignore it
		}
		//onNext = null; onSubscribe = null; onError = null; onComplete = null; subscription = null;
	}

	@Override
	public void onComplete() {
		if (onComplete != null) {
			onComplete.run();
		}
		onNext = null; onSubscribe = null; onError = null; onComplete = null; subscription = null;
	}

}
