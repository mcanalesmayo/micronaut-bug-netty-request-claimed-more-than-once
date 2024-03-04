package example.micronaut;

import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.multipart.MultipartBody;
import org.reactivestreams.Publisher;

@Client("/")
public interface EchoClient {

    @Post(value = "/echo", produces = MediaType.MULTIPART_FORM_DATA)
    @SingleResult
    Publisher<HttpResponse<String>> sendMultipart(@Body MultipartBody body);
}
