# Postcode Checker Demo Application

The Postcode application is a project used to demonstrate the use of the coolest add-on to the JDK 9: The Jigsaw Project.

### Requirements

  - [JDK 9](http://jdk.java.net/9/)

### One-liner Builder

It's important to go over the commands below and try to understand them. However, if you want to quickly build and run the application, do the following:

  - GSON from Source
    - ```./build.sh```
  - GSON from JAR
    - ```./fat_build.sh```

## Using GSON from Source

In this part, and also in the one-liner, I use the latest GSON source code and convert it to a Java 9 Module.
If you are wondering how I found out which packages the GSON library depends on, so I could create a module out of it, please check the command below:

  - ```jdeps --generate-module-info . jars/gson-2.8.1.jar```

The command above will generate the ```module-info.java``` descriptor that we need.

Remark: jdeps only works with JAR files that are not modularized.

### Build the Modules

  - ```javac -p . -d nl.ekholabs.postcode.validator $(find src/nl.ekholabs.postcode.validator -name "*.java")```
  - ```javac -p com.google.gson -d com.google.gson $(find src/com.google.gson -name "*.java")```
  - ```javac -p . -d nl.ekholabs.address.checker $(find src/nl.ekholabs.address.checker -name "*.java")```

### Create a Modular JAR (make sure 'bin' exists)

  - ```jar --create --file bin/postcodevalidator.jar --module-version=1.0 -C nl.ekholabs.postcode.validator .```

### Create the GSON library JAR Module

  - ```jar --create --file bin/gson.jar --module-version=1.0 -C com.google.gson .```

### Specify the Main-Class

  - ```jar --create --file bin/addresschecker.jar --module-version=1.0 --main-class=nl.ekholabs.address.checker.api.Application -C nl.ekholabs.address.checker .```

### Run the Application Module

  - ```java -p bin -m nl.ekholabs.address.checker 3452RG nl```

### Create a Java Runtime Image

  - ```jlink -p $JAVA_HOME/jmods:bin --add-modules nl.ekholabs.address.checker --output linkedmod```

### List Modules from the Image

  - ```linkedmod/bin/java --list-modules```

### Run the Application from the Image

  - ```linkedmod/bin/java -m nl.ekholabs.address.checker 3452RG nl```

### Reduce the Image Size

  - ```rm -rf linkedmod```
  - ```jlink -p $JAVA_HOME/jmods:jars:bin --add-modules nl.ekholabs.address.checker --output linkedmod --compress=2```

## Using GSON from JAR file

If you want to build it quicly, please execute the ```fat_build.sh``` script. If you want to try it out, please make sure you modify the ```module-info.java``` file descriptors in both modules.

Although you can use the JAR file with Java 9 modularized code, you cannot create Java Images with JLink. Unfortunately, the ```jlink``` tool need a ```module-info.class``` packed with the JAR. Since it's not there, it will fail during execution.

If you are a persistent person, as I'm, there is a way out. However, it involves work arounds and I'm not documenting it here.

You do not have to change anything in the ```com.google.gson``` module. Remember: we are not using the source, Luke!

### Update the Module Descriptor

The change is expected to be made on both ```nl.ekholabs.address.checker``` and ```nl.ekholabs.postcode.validator``` modules.

  - Replace ```com.google.gson``` with only ```gson```.

### Build the Modules

- ```javac -p .:jars -d nl.ekholabs.postcode.validator $(find src/nl.ekholabs.postcode.validator -name "*.java")```
- ```javac -p .:jars -d nl.ekholabs.address.checker $(find src/nl.ekholabs.address.checker -name "*.java")```

### Create a Modular JAR (make sure 'bin' exists)

  - ```jar --create --file bin/postcodevalidator.jar --module-version=1.0 -C nl.ekholabs.postcode.validator .```

### Specify the Main-Class

  - ```jar --create --file bin/addresschecker.jar --module-version=1.0 --main-class=nl.ekholabs.address.checker.api.Application -C nl.ekholabs.address.checker .```

### Run the Application Module

  - ```java -p bin:jars -m nl.ekholabs.address.checker 3452RG nl```
