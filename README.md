jTrapKATEditor - an AlternateMode TrapKAT SysEx Editor
======================================================

This project delivers a more friendly way of editing the rich feature settings
of your AlternateMode TrapKAT, versions 3 and 4 (and possibly 5, too).

Because it runs under the Java Virtual Machine, it should run on most computers
(and possibly other devices that have full Java support).

For the latest download, please see [the project website](http://pljones.github.io/jTrapKATEditor/ "the project website").

For support, please see
[this thread](http://www.alternatemode.com/forum/index.php?topic=4140 "jTrapKATEditor for Windows, MacOS and Linux")
on the AlternateMode site (registration required).  Or build from source (see below).


Dependencies
------------
When I started this project, I had had little experience with Java and it had all been fairly
painful.  I was migrating away from C# but still wanted cross-platform support for a desktop
appliction.  That meant either getting into Qt and C++ which, at the time, didn't sound like a
great idea, or going for Swing and the JVM.  Hmm and Java?  Well, Scala also had Swing support
(very nice Swing support) and was a much nicer language with lots of features that went to make
newer versions of Java much less objectionable.

Unfortunately, development of Scala seems to have slowed to a dead stop.  Swing and Java are
still very much alive, though.  So here we are again, migrating from Scala to Java.  I have
also had the benefit of more years paid work in Java, so it's less challenging.

Everyone else seems to have moved to gradle.  Having only just settled into maven, I'm sticking
with it for now...

Running the program
-------------------
Run as with any other java executable:
```
java -jar jTrapKATEditor.jar
```
(or double-click on Windows, or set up a shortcut or .desktop file, or whatever on a Mac).
