package home

import org.junit.{Ignore, Test}
import org.scalatest.junit.JUnitSuite
import org.slf4j.LoggerFactory

import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.H2Profile.api._

/**
  * java -jar h2-version.jar -web -webAllowOthers -tcp -tcpAllowOthers
  */
class MyTest extends JUnitSuite {
    private val logger = LoggerFactory.getLogger(classOf[MyTest])

    @Ignore
    @Test def test(): Unit = {
        val name = "World"
        logger.debug(s"Hello $name")
    }

    @Test def testDb(): Unit = {
        val db = Database.forConfig("h2localhost")
        try {
            logger.debug("in testDb")
        } finally db.close
    }
}
