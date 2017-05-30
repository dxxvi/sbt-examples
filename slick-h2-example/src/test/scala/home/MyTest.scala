package home

import org.junit.Test
import org.scalatest.junit.JUnitSuite
import org.slf4j.LoggerFactory

class MyTest extends JUnitSuite {
    private val logger = LoggerFactory.getLogger(classOf[MyTest])

    @Test def test(): Unit = {
        val name = "World"
        logger.debug(s"Hello $name")
    }
}
