## HOW-TO

This problem occurs on JDK8.
If you have nix installed just say `nix develop` and it will set up the shell with Zulu JDK8.

The problem can be reproduced via `sbt run`

The ZIO logger output is correct, it does contain span information.
The log4j output displays an empty MDC, but it should be filled with info about spans.

```
[info] running Main
timestamp=2024-06-15T12:04:04.993Z level=INFO thread=#zio-fiber-4 message="Starting app" location=<empty>.Main.run file=Main.scala line=11
2024-06-15 14:04:05 [INFO ] {} Main.closeLogEntry$$anonfun$7(SLF4J.scala:163) - Starting app
timestamp=2024-06-15T12:04:05.009Z level=INFO thread=#zio-fiber-4 message="Starting program" span-name=1ms location=<empty>.Main.prog file=Main.scala line=16
2024-06-15 14:04:05 [INFO ] {} Main.closeLogEntry$$anonfun$7(SLF4J.scala:163) - Starting program
timestamp=2024-06-15T12:04:05.010Z level=INFO thread=#zio-fiber-4 message="Finishing program" span-name=2ms location=<empty>.Main.prog file=Main.scala line=17
2024-06-15 14:04:05 [INFO ] {} Main.closeLogEntry$$anonfun$7(SLF4J.scala:163) - Finishing program

```
