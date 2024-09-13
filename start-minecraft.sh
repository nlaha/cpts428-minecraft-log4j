#!/bin/sh
cd ./minecraft
java -Xmx1024M -Xms1024M -Dcom.sun.jndi.ldap.object.trustURLCodebase=true -jar minecraft_server.jar nogui