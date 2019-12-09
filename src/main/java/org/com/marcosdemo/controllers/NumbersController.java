package org.com.marcosdemo.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.com.marcosdemo.services.NumbersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "Numbers API", description = "API to manage numbers")
public class NumbersController {

    private static final ObjectMapper jsonConverter = new ObjectMapper();
    private NumbersService numbersService;

    public NumbersController(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    //@ApiOperation(value = "API to convert list of number to a json format", response = List.class)
    @RequestMapping(value = "/compute/{numbers}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> compute(@PathVariable String numbers) {
        try {
            return new ResponseEntity<Object>(
                    jsonConverter.writeValueAsString(numbersService.convertToNumericValues(numbers)),
                    HttpStatus.OK);
        } catch (Exception e) {
            ObjectNode error = jsonConverter.createObjectNode();
            error.put("error", e.getMessage());
            return new ResponseEntity<Object>(error, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/compute", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> computeEmpty() {
        ObjectNode error = jsonConverter.createObjectNode();
        error.put("error", "Please insert number as path parameters. Ex: /compute/{numbers}");
        return new ResponseEntity<Object>(error, HttpStatus.OK);
    }


}
