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
package info.drealm.jtrapkateditor17.event;

import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.Flow;


public class CurrentAllMemoryChanged implements ParameterisedPublishable<Object> {// will be Component
	private final Object source;
	private CurrentAllMemoryChanged(Object source) { this.source = source; }
	public Object source() { return source; }

	private static SubmissionPublisher<CurrentAllMemoryChanged> publisher = new SubmissionPublisher<>();

	public static void trigger(Object source) {
		publisher.submit(new CurrentAllMemoryChanged(source));
	}

	public static void subscribe(Flow.Subscriber<CurrentAllMemoryChanged> subscriber) {
		publisher.subscribe(subscriber);
	}
}