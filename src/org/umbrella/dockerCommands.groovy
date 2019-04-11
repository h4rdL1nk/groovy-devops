#!/usr/bin/env groovy

//@Grab('de.gesellix:docker-client:2019-03-26T11-38-01')
//@Grab('org.slf4j:slf4j-simple:1.7.26')

package org.umbrella

import de.gesellix.docker.client.DockerClientImpl
import de.gesellix.docker.client.DockerAsyncCallback

class dockerCommands {

        def getInfo( dockerEndpoint = "unix:///var/run/docker.sock") {
                def dockerClient = new DockerClientImpl(dockerEndpoint)
                def info = dockerClient.info().content

                return this.info
        }

        def runContainerCmd( String image = "alpine:3.9", String cmd = "slepp 2") {

                def callback = new DockerAsyncCallback() {

                        def lines = []

                        @Override
                        def onEvent(Object line) {
                                println(line)
                                lines << line
                        }

                        @Override
                        def onFinish() {
                        }

                }

                def dockerClient = new DockerClientImpl("unix:///var/run/docker.sock")

                def cmd_array = cmd.split()
                def image_array = image.split(':')
                def image_name = image_array[0]
                def image_tag = "latest"

                if( 1 < image_array.size() ) {
                        image_tag = image_array[1]
                }

                def config = ["Cmd" : cmd_array]

                def containerStatus = dockerClient.run(image_name, config, image_tag)
                def containerId = containerStatus.container.content.Id


                //def response = dockerClient.logs(containerId, [tail: 1], callback)


                dockerClient.stop(containerId)
                dockerClient.wait(containerId)
                dockerClient.rm(containerId)

                return "OK"

        }

}