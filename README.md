# JClash

JClash is a powerful api wrapper for [Clash of clans](https://supercell.com/en/games/clashofclans/)
*Note:- majority of the code from this repository is taken from [clashAPI](https://github.com/Lycoon/clash-api)*

## What's the difference?

JClash provides dynamic key handling based on your Ip. JClash removes the need for you to create a token and link it to
your IP, this allows you to focus carelessly run your application without having to create a new key everytime your
system changes Ip.

## Requirements

- java 11 or above
- gradle

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
    <version>1.2.1</version>
</dependency>
```
### For `gradle`

```
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
		
	dependencies {
	   implementation 'com.github.SaHHiiLL:JClash:1.2.2'
	}
}
```

- The library is still under development, although there are no bugs as of writing this, I do have plans to further improve this project!

## How to use it!

- Initialize `JClash` object, throws `ClashAPIException`

```java
JClash clash = new JClash(username,password);
```

- *Note: there's also a no args constructor which you can use, **IF** you have initialized `JClash` with your username and
  password.*

- All api requests are asynchronous by using `CompletableFuture`. Completable future gives the user the flexibility to
  wait for each request and do cool stuff once completed 😎 you can read about CompletableFuture
  more [here](https://www.baeldung.com/java-completablefuture).

```java
clash.getClan("#2QLCY08UV");
```

This will return a `CompletableFuture<ClanModel>`, use `.thenAccept()` method to access the value inside wrapper.

- `.thenAccept()` is an asynchronous method, if you want to block the current thread until the value is returned use `.join()`

### Non blocking operation

```java
clash.getClan("#2pp").thenAccept(clan->System.out.println());
```

### Blocking operation

```java
clash.getClan("#2pp").thenAccept(clan->System.out.println()).join();
```

note - I recommend to not use `.join()` unless you want to _BLOCK_ the current thread. I would suggest to
use `.thenAccept()` instead of `.join()`.

## Warning!!!

**Any `Exceptions` thrown by the completable futures will be ignored. A simple `try` `catch` block won't always be able
to catch those exceptions**

```java
try{
    clash.getClan("akdhb")
    .thenApply(ClanModel::getMemberList)
    .thenAccept(s->s.forEach(System.out::println));
}catch(Exception e){
    e.printStackTrace();
}
```
Here's what happens:
Basically what `.getClan()` call does is tell `JClash` "Oh, and could you like, send this? Good luck". And then your code carries on. 
this allows some `Exceptions` to be ignored. You must handle the exceptions on their own (perks of async programing with java ~~jk~~ )

This is a more appropiate way to handle `Exceptions` in JClash
```java
clash.getClan("#2pp")
        .thenAccept(clan -> clan.getMemberList()
                   .forEach(p -> System.out.println(p.getName()))
        ).exceptionally(e -> {
                   e.printStackTrace();
                   return null;
        });
```
## Disclaimer

This content is not affiliated with, endorsed, sponsored, or specifically approved by Supercell and Supercell is not
responsible for it. For more information
see [Supercell's Fan Content Policy.](https://supercell.com/en/fan-content-policy/)

### TODO

- Delete keys if no key is found of the IP address.
