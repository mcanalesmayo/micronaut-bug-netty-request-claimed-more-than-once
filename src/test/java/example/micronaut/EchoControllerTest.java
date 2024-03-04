package example.micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.multipart.MultipartBody;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class EchoControllerTest {

    private static final MediaType TEXT_CSV_MEDIA_TYPE = new MediaType(MediaType.TEXT_CSV, Map.of(MediaType.CHARSET_PARAMETER, "UTF-8"));

    @Inject
    @Client("/") 
    EchoClient client;

    @Test
    void testHello() {
        MultipartBody body = MultipartBody.builder()
                .addPart("aFile", "aFile", TEXT_CSV_MEDIA_TYPE, "dummy".getBytes(StandardCharsets.UTF_8))
                .addPart("aPart", Long.toString(123L))
                .build();

        Mono<HttpResponse<String>> monoRes = Mono.from(client.sendMultipart(body));
        HttpResponse<String> result = assertDoesNotThrow(() -> monoRes.block());

        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatus());
    }
}
