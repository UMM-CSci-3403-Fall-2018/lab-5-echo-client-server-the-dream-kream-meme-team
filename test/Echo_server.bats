#!/usr/bin/env bats

Scenario: Sending text: premade client, your server
  Given a server from "../bin/echoserver/EchoServer.class" and a client from "sampleBin/echoserver/EchoClient.class"
  When I run the echo client with the file "etc/textTest.txt" outputting to "output.txt"
  Then the file "output.txt" exists
  And the file "output.txt" should differ from "etc/textTest.txt" only by whitespace

Scenario: Sending images: premade client, your server
  Given a server from "../bin/echoserver/EchoServer.class" and a client from "sampleBin/echoserver/EchoClient.class"
  When I run the echo client with the file "etc/pumpkins.jpg" outputting to "output.jpg"
  Then the file "output.jpg" exists
  And the file "output.jpg" should differ from "etc/pumpkins.jpg" only by whitespace

@setup {
  mktemp
}

@test {

}
