# Spring boot application with hashicorp vault integration

Simple app built to experiment and learn how to integrate vault into a spring boot application.

`start-vault.sh` will spin up a vault container with some secrets set

`VaultSecrets` class will be created with property keys injected in by `@ConfigurationProperties`.

`@Configuration` annotation on `VaultSecrets` allows it to be Autowired into the `ApplicationConfiguration` class.

`ApplicationConfiguration` takes that `VaultSecrets` Java object and passes it into the constructor of a service which would then make use of them, e.g. API keys, dev, stage, prod urls etc.

Default property keys and vault config is set up in `application.properties`

Vault token passed in from environment variable VAULT_TOKEN, could also extract out further setting to environment variables

By setting `spring.profiles.active` to development/production when running the app the vault properties will override the default `application.property` values