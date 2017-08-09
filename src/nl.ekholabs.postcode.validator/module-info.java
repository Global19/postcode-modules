module nl.ekholabs.postcode.validator {
    exports nl.ekholabs.postcode.validator.api to
       nl.ekholabs.address.checker;
    exports nl.ekholabs.postcode.validator.util to
       nl.ekholabs.address.checker;
    exports nl.ekholabs.postcode.validator.model to
       nl.ekholabs.address.checker;
    // Used when running with GSON fat JAR.
    // opens nl.ekholabs.postcode.validator.model to
    //    gson;
    // Used when running with GSON source.
    opens nl.ekholabs.postcode.validator.model to
       com.google.gson;
}
