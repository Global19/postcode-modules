package nl.ekholabs.address.checker.api;

import nl.ekholabs.address.checker.AddressCheckerService;

public final class Application {

  public static void main(String... args) {

    final String value = args.length > 0  ? args[0] : "";
    final boolean isValidPostcode = AddressCheckerService.getInstance().isValidPostode(value);

    if(isValidPostcode){
        System.out.println(value + " is a valid Dutch postcode.");
    } else {
        System.out.println(value + " is not a valid Dutch postcode.");
    }
  }
}
