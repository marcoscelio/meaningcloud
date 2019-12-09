# MeaningCloud Challenge

In this challenge we will sketch a Spring Boot service. You will need Java 1.8 installed, and an IDE is highly recommended.

This challenge consists of three different parts, where each one depends on the previous one. Please create a git repository to track
the evolution of the code and tag each commit that solves each part with `part_x`.

You can solve this challenge using Kotlin or Java. In case of doubt, we enjoy Kotlin a lot.


## The problem

This service implements a simple transformation over a list of numbers. The process is:

  - Split the list of numbers in two classes: odds and evens
  - Odd numbers will be substracted their mean
  - Even numbers will be substracted their mean and added odd numbers' mean


## Implementing the service

### Part I

  1. Create a Spring Boot application supporting:
      1. Java 1.8
      1. Kotlin
      1. Latest Spring Boot stable version
      1. Spring Web Starter

  1. Create a controller that exports a `/compute` endpoint, something like:

         @Controller
         class MyController {

             @RequestMapping(value = "/compute/{numbers}", method = [RequestMethod.GET])
             fun whatever(@PathVariable("numbers") numbers: String): ResponseEntity<String>

     This endpoint accepts a list of comma-separated numbers that will be the input of our algorithm.

  1. Implement the business logic

  1. Return the transformed list as a JSON Array


### Part II

Now that we have our service working, we have to make a change to the logic: if the list of numbers is empty,
it should be retreived from an external database.

  1. Create a `Database` interface. For simplicity, instead of using a real database, we'll implement it with a stub that returns a hard-coded list.
  1. Instruct Spring to inject the database stub in the controller. Hint: take a look at `@Autowired`, `@Bean` and `@Configuration` annotations.
  1. Implement the change in the business logic.


### Part III

A new feature must be implemented: if the list of numbers contains only one number `N`, we will use the list of numbers
read from the database, filtering only those numbers whose positions in the list are positive multiples of `N`.

Example: if the given number is 3 and the list of numbers from the database is:

    [ 11,21,31,41,51,61,71,81,91,101 ]
    
Then the algorithm should be executed over 41, 71, 101.


## Hints and guidelines

  1. [Spring Initializr](https://start.spring.io/) can help a lot to bootstrap the project.
  1. Think that you are writing production-grade code. Do not confuse _simplicity_ and _quality_.
  1. Do not trust the user. Do proper validations and error handling.
  1. Regardless of the simplicity of this project, split the components properly so that tests looks simple and easily understandable.
  1. A rule of thumb for writing good Object-oriented code is following the [SOLID principles.](https://en.wikipedia.org/wiki/SOLID)
  1. For the service implementation, you can also feel inspired by the [12 factor app.](https://12factor.net/)
  1. We don't trust comments. If your code must be commented to be understood, try to make it cleaner. Remember that the best programmers in the world do not write clever and intrincated code, but exactly the opposite. The _hacking_ thing is for movies.
