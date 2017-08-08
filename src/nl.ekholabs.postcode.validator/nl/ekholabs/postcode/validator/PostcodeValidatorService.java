package nl.ekholabs.postcode.validator;

import nl.ekholabs.postcode.validator.api.PostcodeValidator;
import java.util.regex.Pattern;

public final class PostcodeValidatorService implements PostcodeValidator {

    private static final String POSTCODE_REGEX = "(NL-)?(\\d{4})\\s*([A-Z]{2})";

    public boolean isValid(final String postcode) {
      final Pattern pattern = Pattern.compile(POSTCODE_REGEX);
      if (!pattern.matcher(postcode).matches()) {
        return false;
      }
      return true;
    }
}
