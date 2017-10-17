#!/bin/bash

mvn clean package

GLASSFISH_HOME=/opt/Glassfish/glassfish-5.0-b24/glassfish5

$GLASSFISH_HOME/bin/asadmin undeploy todo

$GLASSFISH_HOME/bin/asadmin deploy target/todo.war