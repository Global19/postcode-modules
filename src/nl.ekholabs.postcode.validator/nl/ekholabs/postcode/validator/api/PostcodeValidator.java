package nl.ekholabs.postcode.validator.api;

import nl.ekholabs.postcode.validator.util.CountryEnum;

public interface PostcodeValidator {
  boolean isValid(final String postcode, final CountryEnum countryCode);
}
