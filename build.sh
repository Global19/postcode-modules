#!/bin/bash

echo "Start building Postcode Modules..."
rm -rf bin
mkdir bin
javac -d . --module-source-path src $(find src -name "*.java")

echo "Creating the Postcode Validator JAR module..."
jar --create --file bin/postcodevalidator.jar --module-version=1.0 -C nl.ekholabs.postcode.validator .

echo "Creating the Address Checker Application JAR module..."
jar --create --file bin/addresschecker.jar --module-version=1.0 --main-class=nl.ekholabs.address.checker.api.Application -C nl.ekholabs.address.checker .

echo "Creating compressed Java Image..."
rm -rf linkedmod
jlink --module-path $JAVA_HOME/jmods:bin --add-modules nl.ekholabs.address.checker --output linkedmod --compress=2

echo "Done!"
echo "To run the application, please type: linkedmod/bin/java -m nl.ekholabs.address.checker 3452RG nl"
