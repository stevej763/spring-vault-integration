# Spring boot application with hashicorp vault integration

Simple app built to experiment and learn how to integrate vault into a spring boot application.

`start-vault.sh` will spin up a vault container with some secrets set

`AppSecrets` class will be created with property keys injected in by `@ConfigurationProperties`.

`@ConstructorBinding` annotation on `AppSecrets` tells spring to instantiate the class using the constructor.

`ApplicationConfiguration` takes that `AppSecrets` Java object and passes it into the constructor of a service which would then make use of them, e.g. API keys, dev, stage, prod urls etc.

`@ConfigurationPropertiesScan` annotation on `ApplicationConfiguration` tells spring where to look for any configuration properties.

Default property keys and vault config is set up in `application.properties`.

Vault token passed in from environment variable VAULT_TOKEN, could also extract out other settings to environment variables if you wanted to.

By setting `spring.profiles.active` to development/production when running the app the vault properties will override the default `application.properties` values