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

import info.drealm.jtrapkateditor17.prefs.Preferences;
import info.drealm.jtrapkateditor17.updateTool.Checker;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class JTrapKATEditor {

    public static void main(String[] args) {

        try {

            var ui = UIManager.getSystemLookAndFeelClassName();
            UIManager.put("swing.boldMetal", false);
            UIManager.setLookAndFeel(ui);
        
            // Use custom preferences manager
            System.setProperty("java.util.prefs.PreferencesFactory", "info.drealm.jtrapkateditor17.prefs.FilePreferencesFactory");
        
            // Now we know how to get the preferences, check to see if there's an update
            Checker.dailyCheck();
        
            var top = FrmTrapkatSysexEditor.INSTANCE.frame();
        
            top.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                    try {
                        Preferences.userPreferences().flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
