package io.swagger.api;

import com.google.gson.Gson;
import io.swagger.aspect.ItemAspect;
import io.swagger.model.Item;
import io.swagger.model.ModelApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.repositories.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-01T10:32:46.053Z")

@Controller
public class ItemApiController implements ItemApi {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemAspect itemAspect;
    private static final Logger log = LoggerFactory.getLogger(ItemApiController.class);
    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;

    @Autowired
    public ItemApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addItem(@ApiParam(value = "Pet object that needs to be added to the store" ,required=true )  @Valid @RequestBody Item body) {
        itemRepository.save(body);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    public @ResponseBody ResponseEntity<Item> getItemById(@ApiParam(value = "ID of item to return",required=true) @PathVariable("itemId") Long itemId) {
        return new ResponseEntity<Item>(itemRepository.getOne(itemId), HttpStatus.OK);
    }

    public @ResponseBody ResponseEntity<List<Item>> getItems(){
        return new ResponseEntity<List<Item>>(itemRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Void> updateItemWithForm(@ApiParam(value = "ID of item that needs to be updated",required=true) @PathVariable("itemId") Long itemId,@ApiParam(value = "Updated name of the item") @Valid @RequestBody Item body) {
        Item item = itemRepository.getOne(itemId);
        item.setName(body.getName());
        item.setDescription(body.getDescription());
        item.setCategories(body.getCategories());
        item.setLocation(body.getLocation());
        item.setOfferType(body.getOfferType());
        item.setPrice(body.getPrice());
        item.setStatus(body.getStatus());
        item.setPhotoUrls(body.getPhotoUrls());
        itemRepository.save(item);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteItem(@ApiParam(value = "Item id to delete",required=true) @PathVariable("itemId") Long itemId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey) {
        itemRepository.deleteById(itemId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public @ResponseBody ResponseEntity<List<Item>> findItemByCategories(@NotNull @ApiParam(value = "Categories to filter by", required = true) @Valid @RequestParam(value = "categories", required = true) List<Long> categories) {
        return new ResponseEntity<List<Item>>(itemRepository.findDistinctByCategoriesIn(categories),HttpStatus.OK);
    }

    public @ResponseBody ResponseEntity<List<Item>> findItemByStatus(@NotNull @ApiParam(value = "Status values that need to be considered for filter", required = true, allowableValues = "available, pending, sold") @Valid @RequestParam(value = "status", required = true) String status) {
        return new ResponseEntity<List<Item>>(itemRepository.findByStatus(Item.StatusEnum.valueOf(status.toUpperCase())), HttpStatus.OK);
    }

    public ResponseEntity<ModelApiResponse> uploadFile(@ApiParam(value = "ID of item to update",required=true) @PathVariable("itemId") Long itemId,@ApiParam(value = "file to upload") @Valid @RequestPart(value="file", required=true) MultipartFile file,@ApiParam(value = "Additional data to pass to server") @RequestParam(value="additionalMetadata", required=false)  String additionalMetadata) {
        return new ResponseEntity<ModelApiResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Item>> findItemByStatusAndCategories(@NotNull @ApiParam(value = "Status values that need to be considered for filter", required = true, allowableValues = "available, sold") @Valid @RequestParam(value = "status", required = true) String status, @NotNull @ApiParam(value = "Categories to filter by", required = true) @Valid @RequestParam(value = "categories", required = true) List<Long> categories){
        return new ResponseEntity<List<Item>>(itemRepository.findDistinctByStatusAndCategoriesIn(Item.StatusEnum.valueOf(status.toUpperCase()), categories), HttpStatus.OK);
    }

    @RequestMapping(value = "/item/numberOfMethodCalls",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<String> getNumberOfMethodCalls (){
        Gson gson = new Gson();
        return new ResponseEntity<String>(gson.toJson(this.itemAspect.getFunctionsCalls()), HttpStatus.OK);
    }

}
