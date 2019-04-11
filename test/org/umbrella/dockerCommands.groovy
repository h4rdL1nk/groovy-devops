import spock.lang.*
import org.umbrella.dockerCommands

class dockerCommandTest extends Specification {

  def "Docker run test"() {

    given:
    def dockerCommandInstance = new dockerCommands()

    expect: 'Should return True result'
    dockerCommandInstance.runContainerCmd( "alpine:3.6" , "echo TEST" ) == "OK"

  }

}