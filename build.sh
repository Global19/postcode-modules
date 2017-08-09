#!/bin/bash

echo "Start building Postcode Modules..."
rm -rf bin
mkdir bin
javac -p nl.ekholabs.address.checker:com.google.gson -d nl.ekholabs.postcode.validator $(find src/nl.ekholabs.postcode.validator -name "*.java")
javac -p com.google.gson -d com.google.gson $(find src/com.google.gson -name "*.java")
javac -p nl.ekholabs.postcode.validator:com.google.gson -d nl.ekholabs.address.checker $(find src/nl.ekholabs.address.checker -name "*.java")

echo "Creating the GSON library JAR module"
jar --create --file bin/gson.jar --module-version=1.0 -C com.google.gson .

echo "Creating the Postcode Validator JAR module..."
jar --create --file bin/postcodevalidator.jar --module-version=1.0 -C nl.ekholabs.postcode.validator .

echo "Creating the Address Checker Application JAR module..."
jar --create --file bin/addresschecker.jar --module-version=1.0 --main-class=nl.ekholabs.address.checker.api.Application -C nl.ekholabs.address.checker .

echo "Creating compressed Java Image..."
rm -rf linkedmod
jlink -p $JAVA_HOME/jmods:bin --add-modules nl.ekholabs.address.checker --output linkedmod --compress=2

echo "Done!"
echo "To run the application, please type: linkedmod/bin/java -m nl.ekholabs.address.checker 3452RG nl"
