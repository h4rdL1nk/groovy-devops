#!/usr/bin/env groovy

import org.umbrella.GlobalVars

def call( String name = 'test' ) {

  print( GlobalVars.getgithubUrl() )

}