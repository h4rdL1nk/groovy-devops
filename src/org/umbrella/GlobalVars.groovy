#!/usr/bin/env groovy

package org.umbrella

class GlobalVars {

   static String githubUrl = "github.com"
   static String dockerEndpoint = "unix:///var/run/docker.sock"

   def getgithubUrl() { 
        return this.githubUrl
   }

   def getdockerEndpoint() { 
        return this.dockerEndpoint
   }

}