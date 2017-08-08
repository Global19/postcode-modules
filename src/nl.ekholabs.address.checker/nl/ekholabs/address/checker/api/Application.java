package nl.ekholabs.address.checker.api;

import nl.ekholabs.address.checker.AddressCheckerService;
import nl.ekholabs.postcode.validator.api.CountryEnum;

public final class Application {

  public static void main(String... args) {

    if (args.length < 2) {
      throw new IllegalArgumentException("First parameter must be the postcode and second the country code.");
    }

    final String postcode = args[0];
    final String countryCode = args[1];

    final CountryEnum countryEnum = CountryEnum.findByCode(countryCode);

    final boolean isValidPostcode = AddressCheckerService.getInstance().isValidPostode(postcode, countryEnum);

    if(isValidPostcode){
        System.out.println(postcode + " is a valid postcode.");
    } else {
        System.out.println(postcode + " is not a valid postcode.");
    }
  }
}
