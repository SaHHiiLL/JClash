# JClash

JClash is a powerful api wrapper for [Clash of clans](https://supercell.com/en/games/clashofclans/)
*Note:- majority of the code from this repository is taken from [clashAPI](https://github.com/Lycoon/clash-api)*

## What's the difference?
JClash provides dynamic key handling based on your Ip. JClash removes the need for you to create a token and link it to your IP,
this allows you to focus carelessly run your application withotu having to create a new key everytime your system changes Ip.

## Requirements
- java 11 or above

see [here](https://www.oracle.com/java/technologies/javase/jdk15-archive-downloads.html) to download java 15.
see [here](https://gradle.org/install/) to download the latest version of gradle.

## How to download it?
### For `maven`
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>


<dependency>
    <groupId>com.github.SaHHiiLL</groupId>
    <artifactId>JClash</artifactId>
    <version>1.1.1</version>
</dependency>
```
### For `gradle`

```
allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
		
		dependencies {
	        implementation 'com.github.SaHHiiLL:JClash:1.1.1'
	}
}
```

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
