/*
    (C) Copyright 2022 by Peter L Jones <pljones@users.noreply.github.com>
    This file is part of jTrapKATEditor17 TrapKAT SysEx Editor.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package info.drealm.jtrapkateditor17;

import info.drealm.jtrapkateditor17.event.*;

import java.util.concurrent.Flow;
import java.util.function.Consumer;

import javax.swing.JFrame;

public enum FrmTrapkatSysexEditor {
    INSTANCE(new JFrame());

	private Object latestObjectInstance = null;
	private Consumer<Object> currentAllMemoryChangedConsumer = o -> {
		latestObjectInstance = o;
		System.out.println("consumed a CurrentAllMemoryChanged event");
	};

	private class CurrentAllMemoryChangedSubscriber implements Flow.Subscriber<CurrentAllMemoryChanged> {
		private final Consumer<Object> consumer;
		private Flow.Subscription subscription;

		CurrentAllMemoryChangedSubscriber(Consumer<Object> consumer) {
			this.consumer = consumer;
			CurrentAllMemoryChanged.subscribe(this);
		}
		public void onSubscribe(Flow.Subscription subscription) {
			(this.subscription = subscription).request(1);
		}
		public void onNext(CurrentAllMemoryChanged event) {
			subscription.request(1);
			consumer.accept(event.source());
		}
		public void onComplete() {}
		public void onError(Throwable t) {}
	}

	JFrame frame;
    public final JFrame frame() { return frame; }

	/**
	 * Create the application.
	 */
    private FrmTrapkatSysexEditor(JFrame frame) {
        this.frame = frame;
		//Event.subscribe(this);

		initialize();
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
