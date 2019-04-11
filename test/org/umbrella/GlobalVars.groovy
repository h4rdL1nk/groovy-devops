import spock.lang.*
import org.umbrella.GlobalVars

class GlobalVarsTest extends Specification {

  def "Variables test"() {

    given:
    def globals = new GlobalVars()

    expect: 'Should return variables'
    globals.getdockerEndpoint() == "unix:///var/run/docker.sock"
    globals.getgithubUrl() == "github.com"

  }

}