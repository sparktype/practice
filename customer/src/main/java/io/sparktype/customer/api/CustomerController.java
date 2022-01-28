package io.sparktype.customer.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import io.sparktype.customer.repository.Customer;
import io.sparktype.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService service;

  @GetMapping("/{id}")
  public ResponseEntity detail(@PathVariable("id") Long id) {
    return ResponseEntity.ok(service.detail(id));
  }

  @PostMapping
  public ResponseEntity create(@RequestBody Customer customer) {

    var uri = MvcUriComponentsBuilder.fromController(getClass())
      .path("/{id}")
      .buildAndExpand(customer.getId())
      .toUri();
    return ResponseEntity.created(uri).body(service.create(customer));
  }

  @PutMapping("/{id}")
  public ResponseEntity modify(@PathVariable("id") Long id, @RequestBody Customer customer) {

    var uri = MvcUriComponentsBuilder.fromController(getClass())
      .path("/{id}")
      .buildAndExpand(customer.getId())
      .toUri();

    return ResponseEntity.created(uri).body(service.modify(id, customer));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity remove(@PathVariable("id") Long id) {
    service.remove(id);
    return ResponseEntity.noContent().build();
  }

}
