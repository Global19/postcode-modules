package nl.ekholabs.address.checker.api;

import nl.ekholabs.address.checker.AddressCheckerService;
import nl.ekholabs.postcode.validator.util.CountryEnum;
import nl.ekholabs.postcode.validator.model.Postcode;

import com.google.gson.Gson;

public final class Application {

  public static void main(String... args) {

    if (args.length < 2) {
      throw new IllegalArgumentException("First parameter must be the postcode and second the country code.");
    }

    final String code = args[0];
    final String countryCode = args[1];

    final CountryEnum countryEnum = CountryEnum.findByCode(countryCode);
    final Postcode postcode = AddressCheckerService.getInstance().validatePostcode(code, countryEnum);

    final Gson gson = new Gson();
    final String json = gson.toJson(postcode);

    System.out.println(json);
  }
}
