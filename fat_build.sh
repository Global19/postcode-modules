#!/bin/bash

echo "Start building Postcode Modules..."
rm -rf bin
mkdir bin
javac -p .:jars -d nl.ekholabs.postcode.validator $(find src/nl.ekholabs.postcode.validator -name "*.java")
javac -p .:jars -d nl.ekholabs.address.checker $(find src/nl.ekholabs.address.checker -name "*.java")

echo "Creating the Postcode Validator JAR module..."
jar --create --file bin/postcodevalidator.jar --module-version=1.0 -C nl.ekholabs.postcode.validator .

echo "Creating the Address Checker Application JAR module..."
jar --create --file bin/addresschecker.jar --module-version=1.0 --main-class=nl.ekholabs.address.checker.api.Application -C nl.ekholabs.address.checker .

echo "Done!"
echo "To run the application, please type: java -p bin:jars -m nl.ekholabs.address.checker 3452RG nl"
