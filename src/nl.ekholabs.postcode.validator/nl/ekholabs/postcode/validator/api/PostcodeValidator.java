package nl.ekholabs.postcode.validator.api;

import nl.ekholabs.postcode.validator.util.CountryEnum;
import nl.ekholabs.postcode.validator.model.Postcode;

public interface PostcodeValidator {
  Postcode validate(final String postcode, final CountryEnum countryCode);
}
