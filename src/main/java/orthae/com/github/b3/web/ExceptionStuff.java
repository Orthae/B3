package orthae.com.github.b3.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionStuff {

  @ExceptionHandler
  public ResponseEntity<ErrorDto> handle(IllegalArgumentException exception) {
    return ResponseEntity.badRequest().body(new ErrorDto(exception.getMessage()));
  }

  @ExceptionHandler
  public ResponseEntity<ErrorDto> handle(IllegalStateException exception) {
    return ResponseEntity.badRequest().body(new ErrorDto(exception.getMessage()));
  }

  @ExceptionHandler
  public ResponseEntity<ErrorDto> handle(MethodArgumentNotValidException exception) {
    var builder = new StringBuilder("Request have following errors:");
    for (var error : exception.getAllErrors()) {
      builder.append(" ");
      builder.append(error.getDefaultMessage());
    }
    return ResponseEntity.badRequest().body(new ErrorDto(builder.toString()));
  }
}
