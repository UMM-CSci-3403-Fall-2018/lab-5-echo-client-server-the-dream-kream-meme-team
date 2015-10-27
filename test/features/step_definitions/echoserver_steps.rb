require 'etc'
require 'aruba/cucumber'

Before do
  @aruba_timeout_seconds = 20
  `mkdir -p tmp/aruba/echoserver`
  `cp -R etc tmp/aruba`
  `cp -R sampleBin tmp/aruba`
end

After do
  `kill \`cat tmp/aruba/.pid\``
  `sleep 1`
end

Given /^a server from "([^"]*)" and a client from "([^"]*)"$/ do |server, client|
  `etc/copy_client_and_server.sh #{server} #{client}`
  steps %{
    When I run `etc/echo_server.sh`
  }
end

When /^I run the echo client with the file "([^"]*)" outputting to "([^"]*)"$/ do |input, output|
  #puts "Running client with input=<#{input}> and output=<#{output}>"
  steps %{
    When I run `etc/echo_client.sh #{input} #{output}`
  }
  #puts "Client has been run"
end

Then /^the file "([^"]*)" exists$/ do |file_name|
  steps %{
    Then a file named "#{file_name}" should exist
  }
end

Then /^the file "(.*?)" should differ from "(.*?)" only by whitespace$/ do |actual_filename, expected_filename|
  steps %{
    Then I successfully run `diff -wbB #{actual_filename} #{expected_filename}`
  }
end
