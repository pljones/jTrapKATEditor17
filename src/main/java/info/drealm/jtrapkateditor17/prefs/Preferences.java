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
package info.drealm.jtrapkateditor17.prefs;

import java.io.File;
import java.io.IOException;

public class Preferences {// extends (scala) swing.Publisher

	// userPreferences.get("currentWorkingDirectory", "")
	public static File currentWorkingDirectory() {
		// "" -> home
		// else File(pref)
		return new File(".");
	}

	public static void currentWorkingDirectory(File value) {
		if (!value.isDirectory()) {
			throw new IllegalArgumentException(value.getName() + "is not a directory.");
		}
		// userPreferences.put("currentWorkingDirectory", value.getCanonicalPath())
		// publish(new CurrentWorkingDirectoryPreferencChanged)
	}

	public static java.io.FileWriter userPreferences() throws IOException {
		// "" -> home
		// else File(pref)
		return new java.io.FileWriter(".");
	}
}
