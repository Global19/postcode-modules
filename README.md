# Postcode Checker Demo Application

The Postcode application is a project used to demonstrate the use of the coolest add-on to the JDK 9: Project Jigsaw.

### Requirements

  - [JDK 9](http://jdk.java.net/9/)

### One-liner Builder

It's important to go over the commands below and try to understand them. However, if you want to quickly build and run the application, do the following:

  - ```./build.sh```

### Build Modules

  - ```javac -p nl.ekholabs.address.checker:com.google.gson -d nl.ekholabs.postcode.validator $(find src/nl.ekholabs.postcode.validator -name "*.java")```
  - ```javac -p com.google.gson -d com.google.gson $(find src/com.google.gson -name "*.java")```
  - ```javac -p nl.ekholabs.postcode.validator:com.google.gson -d nl.ekholabs.address.checker $(find src/nl.ekholabs.address.checker -name "*.java")```

### Create a modular JAR (make sure 'bin' exists)

  - ```jar --create --file bin/postcodevalidator.jar --module-version=1.0 -C nl.ekholabs.postcode.validator .```

### Create the GSON library JAR module...

  - ```jar --create --file bin/gson.jar --module-version=1.0 -C com.google.gson .```

### Specify MainClass

  - ```jar --create --file bin/addresschecker.jar --module-version=1.0 --main-class=nl.ekholabs.address.checker.api.Application -C nl.ekholabs.address.checker .```

### Run module

  - ```java -p bin -m nl.ekholabs.address.checker 3452RG nl```

### Create a runtime image

  - ```jlink -p $JAVA_HOME/jmods:bin --add-modules nl.ekholabs.address.checker --output linkedmod```

### List modules from the image

  - ```linkedmod/bin/java --list-modules```

### Run application from the image

  - ```linkedmod/bin/java -m nl.ekholabs.address.checker 3452RG nl```

### Reducing image size

  - ```rm -rf linkedmod```
  - ```jlink -p $JAVA_HOME/jmods:jars:bin --add-modules nl.ekholabs.address.checker --output linkedmod --compress=2```
