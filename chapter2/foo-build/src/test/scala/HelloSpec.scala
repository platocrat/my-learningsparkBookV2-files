/**
  * Reference for deprecations of previous styles of imports: 
  * https://www.scalatest.org/release_notes/3.2.0#expiredDeprecations
  */
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.diagrams.Diagrams

class HelloSpec extends AnyFunSuite with Diagrams {
  test("Hello should start with H") {
    assert("Hello".startsWith("H"))
  }
}
