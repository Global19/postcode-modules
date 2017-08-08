# Postcode Checker Demo Application 

The Postcode application is a project used to demonstrate the use of the coolest add-on to the JDK 9: Project Jigsaw.

# Requirements

  - [JDK 9](http://jdk.java.net/9/)

# Build Modules

  - javac -d nl.ekholabs.postcode.validator $(find src/nl.ekholabs.postcode.validator -name "*.java")
  - javac -p src/. -d nl.ekholabs.address.checker $(find src/nl.ekholabs.address.checker -name "*.java")

# Run Application

  - java -p src/. -m nl.ekholabs.address.checker/nl.ekholabs.address.checker.api.Application 3252RG

# Create a modular JAR (make sure 'bin' exists)

  - jar --create --file bin/postcodevalidator.jar --module-version=1.0 -C nl.ekholabs.postcode.validator .

# Specify MainClass

  - jar --create --file bin/addresschecker.jar --module-version=1.0 --main-class=nl.ekholabs.address.checker.api.Application -C nl.ekholabs.address.checker .

# Run module

  - java -p bin -m nl.ekholabs.address.checker 3452RG

# Create a runtime image

  - jlink --module-path $JAVA_HOME/jmods:bin --add-modules nl.ekholabs.address.checker --output linkedmod

# List modules from the image

  - linkedmod/bin/java --list-modules

# Run application from the image

  - linkedmod/bin/java -m nl.ekholabs.address.checker 3452RG

# Reducing image size

  - rm -rf linkedmod
  - jlink --module-path $JAVA_HOME/jmods:bin --add-modules nl.ekholabs.address.checker --output linkedmod --compress=2