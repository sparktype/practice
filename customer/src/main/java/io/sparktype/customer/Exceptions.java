package io.sparktype.customer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Exceptions {

  public HttpNotFoundException notFound() {
    return new HttpNotFoundException();
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  public static class HttpNotFoundException extends RuntimeException {

    public HttpNotFoundException() {
      super("Not found");
    }

  }

}
