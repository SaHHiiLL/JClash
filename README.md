# JClash

JClash is a powerful api wrapper for [Clash of clans](https://supercell.com/en/games/clashofclans/)
*Note:- majority of the code from this repository is taken from [clashAPI](https://github.com/Lycoon/clash-api)*

## What's the difference?
JClash provides dynamic key handling based on your Ip. JClash removes the need for you to create a token and link it to your IP, this allows you to focus carelessly change run your application withotu having to create a new key everytime.

## Requirements
- java 15 or above
- gradle 

see [here](https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html) to download java 15.
see [here](https://gradle.org/install/) to download the latest version of gradle.

## How to download it?
Currently I lack the time and knowledge to upload this project to maven central or [jitpack](https://jitpack.io/). 
In the meantime i suggest downloading the repository and running `gradle build` it should create a build folder in your working directory, then navigate to this path 
`build/libs/JClash-1.0-SNAPSHOT.jar` to find your jar file. This should produce a jar which you can use in your projects!


- The library is still under development, although there are no bugs as of writing this, I do have plans to further improve this project!

## How to use it!

- Initialize `JClash` object, throws `ClashAPIException`
```java
JClash clash = new JClash(username, password);
```
- *Note: there's also a no args construstor which you can use, **IF** you have inilized `JClash` with your username and password.*

- To fetch clan information.
```java
ClanModel clan = clash.getClan("#2QLCY08UV");
```
- Every field inside `clash` will throw `ClashAPIException, IOException`


## Disclaimer
This content is not affiliated with, endorsed, sponsored, or specifically approved by Supercell and Supercell is not responsible for it. For more information see [Supercell's Fan Content Policy.](https://supercell.com/en/fan-content-policy/)

### TODO
- Delete keys if no key is found of the IP address.
