package info.drealm.jtrapkateditor17;

import java.util.function.Consumer;

public enum NakedEvent {

	INSTANCE(new Event<Object>());

	private Event<Object> nakedEvent;

	private NakedEvent(Event<Object> nakedEvent) {
		this.nakedEvent = nakedEvent;
	}

	public final NakedEvent get() { return INSTANCE; }

	public Event<Object> event() { return nakedEvent; }
}
