import zio.*
import zio.logging.backend.SLF4J

object Main extends ZIOAppDefault:

  override val bootstrap: ZLayer[ZIOAppArgs, Any, Any] =
    //Runtime.removeDefaultLoggers >>> SLF4J.slf4j
    SLF4J.slf4j

  def run: Task[ExitCode] = for
    _ <- ZIO.logInfo("Starting app")
    _ <- ZIO.logSpan("span-name") (prog())
  yield ExitCode.success

  def prog() = for
    _ <- ZIO.logInfo("Starting program")
    _ <- ZIO.logInfo("Finishing program")
  yield ()
