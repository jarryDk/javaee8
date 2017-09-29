#!/bin/bash

mvn clean package

GLASSFISH_HOME=/opt/Glassfish/glassfish-5.0-b24/glassfish5

$GLASSFISH_HOME/bin/asadmin undeploy javaee8

$GLASSFISH_HOME/bin/asadmin deploy target/javaee8.war