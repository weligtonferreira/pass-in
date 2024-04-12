package br.com.rocketseat.passin.config;

import br.com.rocketseat.passin.domain.attendee.exceptions.AttendeeAlreadyExistsException;
import br.com.rocketseat.passin.domain.attendee.exceptions.AttendeeNotFoundException;
import br.com.rocketseat.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import br.com.rocketseat.passin.domain.event.exceptions.EventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEntityHandler {
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<Void> handleEventNotFound(EventNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity<Void> handleAttendeeNotFound(AttendeeNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeAlreadyExistsException.class)
    public ResponseEntity<Void> handleAttendeeAlreadyExists(AttendeeAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(CheckInAlreadyExistsException.class)
    public ResponseEntity<Void> handleCheckInAlreadyExists(CheckInAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
