@announce
Feature: Analyze log entries, collecting user name, location, and timeline data
  In order to demonstrate my understanding of remote procedure calls
  As a student
  I want to be able to send text and images to a remote server, then receive the files back with no changes.

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

  Scenario: Sending text: your client, premade server
    Given a server from "sampleBin/echoserver/EchoServer.class" and a client from "../bin/echoserver/EchoClient.class"
    When I run the echo client with the file "etc/textTest.txt" outputting to "output.txt"
    Then the file "output.txt" exists
    And the file "output.txt" should differ from "etc/textTest.txt" only by whitespace

  Scenario: Sending images: your client, premade server
    Given a server from "sampleBin/echoserver/EchoServer.class" and a client from "../bin/echoserver/EchoClient.class"
    When I run the echo client with the file "etc/pumpkins.jpg" outputting to "output.jpg"
    Then the file "output.jpg" exists
    And the file "output.jpg" should differ from "etc/pumpkins.jpg" only by whitespace

  Scenario: Sending text: your client, your server
    Given a server from "../bin/echoserver/EchoServer.class" and a client from "../bin/echoserver/EchoClient.class"
    When I run the echo client with the file "etc/textTest.txt" outputting to "output.txt"
    Then the file "output.txt" exists
    And the file "output.txt" should differ from "etc/textTest.txt" only by whitespace

  Scenario: Sending images: your client, your server
    Given a server from "../bin/echoserver/EchoServer.class" and a client from "../bin/echoserver/EchoClient.class"
    When I run the echo client with the file "etc/pumpkins.jpg" outputting to "output.jpg"
    Then the file "output.jpg" exists
    And the file "output.jpg" should differ from "etc/pumpkins.jpg" only by whitespace
