package io.sparktype.customer.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import io.sparktype.customer.Exceptions;
import io.sparktype.customer.repository.Customer;
import io.sparktype.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository repository;

  public Customer detail(Long id) {
    return repository.findById(id)
      .orElseThrow(Exceptions::notFound);
  }

  @Transactional
  public Customer create(Customer customer) {
    return repository.save(customer);
  }

  @Transactional
  public Customer modify(Long id, Customer customer) {
    return repository.findById(id)
      .map(c -> repository.save(c.modifyEmail(customer)))
      .orElseThrow(Exceptions::notFound);
  }

  @Transactional
  public void remove(Long id) {
    repository.deleteById(id);
  }

}
