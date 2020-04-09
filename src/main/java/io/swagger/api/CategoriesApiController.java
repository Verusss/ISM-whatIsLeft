package io.swagger.api;

import io.swagger.model.Categories;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repositories.CategoriesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-07T20:12:02.978Z")

@Controller
public class CategoriesApiController implements CategoriesApi {

    @Autowired
    private CategoriesRepository categoriesRepository;
    private static final Logger log = LoggerFactory.getLogger(CategoriesApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CategoriesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addCategory(@ApiParam(value = "Category object that needs to be added to the store" ,required=true )  @Valid @RequestBody Categories body) {
        categoriesRepository.save(body);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> deleteCategory(@ApiParam(value = "Category id to delete",required=true) @PathVariable("categoryId") Long categoryId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey) {
        categoriesRepository.deleteById(categoryId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public @ResponseBody ResponseEntity<List<Categories>> getCategories() {
        return new ResponseEntity<List<Categories>>(categoriesRepository.findAll(),HttpStatus.OK);
    }

    public @ResponseBody  ResponseEntity<Categories> getCategoryById(@ApiParam(value = "ID of item to return",required=true) @PathVariable("categoryId") Long categoryId) {
        return new ResponseEntity<Categories>(categoriesRepository.getOne(categoryId),HttpStatus.OK);
    }

}
