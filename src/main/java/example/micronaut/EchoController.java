package example.micronaut;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.micronaut.http.multipart.CompletedPart;
import reactor.core.publisher.Mono;

@Controller("/echo")
public class EchoController {

    @Post(consumes = MediaType.MULTIPART_FORM_DATA)
    public Mono<HttpResponse<String>> echo(
            HttpRequest<?> request,
            @Part("aFile") @Nullable CompletedFileUpload aFile,
            @Part("aPart") @Nullable CompletedPart aPart) {
        return Mono.just(HttpResponse.notFound());
    }
}
