## Micronaut bug Netty request claimed more than once

See issue here https://github.com/micronaut-projects/micronaut-core/issues/10568

Micronaut bug happening in 4.x.x (since 4.0.0) where an `IllegalStateException: already claimed` happens when a controller consumes a multipart request and throws an error which is caught by an error handler.

To reproduce, run `./gradlew test`

