package ru.relex.restaurant.service.impl;

import org.springframework.stereotype.Service;
import ru.relex.restaurant.service.ITestService;

@Service
public class TestServiceImpl implements ITestService {

  @Override
  public String sayHello(String name) {
    return "Hello, " + name;
  }


  public static void main(String[] args) {

  }
}
