package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-01T10:32:46.053Z")
@Entity
@JsonIgnoreProperties(ignoreUnknown = true, value={"hibernateLazyInitializer"})
public class Item   {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("photoUrls")
  @Valid
  @ElementCollection
  private List<String> photoUrls = new ArrayList<String>();

  public enum OfferTypeEnum {
    SELLING("selling"),
    
    EXCHANGING("exchanging"),
    
    GIVING_AWAY("giving away");

    private String value;

    OfferTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OfferTypeEnum fromValue(String text) {
      for (OfferTypeEnum b : OfferTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("offerType")
  private OfferTypeEnum offerType = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("categories")
  @Valid
  @ElementCollection
  private List<Long> categories = null;

  public enum StatusEnum {
    AVAILABLE("available"),
    
    SOLD("sold");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("price")
  private Double price = null;

  @JsonProperty("location")
  private String location = null;

  public Item id(Long id) {
    this.id = id;
    return this;
  }

  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Item name(String name) {
    this.name = name;
    return this;
  }

  @ApiModelProperty(example = "hammer", required = true, value = "")
  @NotNull

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Item photoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
    return this;
  }

  public Item addPhotoUrlsItem(String photoUrlsItem) {
    this.photoUrls.add(photoUrlsItem);
    return this;
  }

  @ApiModelProperty(required = true, value = "")
  @NotNull
  public List<String> getPhotoUrls() {
    return photoUrls;
  }

  public void setPhotoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
  }

  public Item offerType(OfferTypeEnum offerType) {
    this.offerType = offerType;
    return this;
  }

  @ApiModelProperty(required = true, value = "offer type")
  @NotNull
  public OfferTypeEnum getOfferType() {
    return offerType;
  }

  public void setOfferType(OfferTypeEnum offerType) {
    this.offerType = offerType;
  }

  public Item desciption(String desciption) {
    this.description = desciption;
    return this;
  }

  @ApiModelProperty(example = "Hammer which I used during last remont. Good state.", value = "")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Item categories(List<Long> categories) {
    this.categories = categories;
    return this;
  }

  public Item addCategoriesItem(Long categoriesId) {
    if (this.categories == null) {
      this.categories = new ArrayList<Long>();
    }
    this.categories.add(categoriesId);
    return this;
  }

  @ApiModelProperty(value = "categories")
  @Valid
  public List<Long> getCategories() {
    return categories;
  }

  public void setCategories(List<Long> categories) {
    this.categories = categories;
  }

  public Item status(StatusEnum status) {
    this.status = status;
    return this;
  }

  @ApiModelProperty(value = "item status in the store")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Item price(Double price) {
    this.price = price;
    return this;
  }

  @ApiModelProperty(value = "price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Item location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(example = "Wroclaw", required = true, value = "")
  @NotNull
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(this.id, item.id) &&
        Objects.equals(this.name, item.name) &&
        Objects.equals(this.photoUrls, item.photoUrls) &&
        Objects.equals(this.offerType, item.offerType) &&
        Objects.equals(this.description, item.description) &&
        Objects.equals(this.categories, item.categories) &&
        Objects.equals(this.status, item.status) &&
        Objects.equals(this.price, item.price) &&
        Objects.equals(this.location, item.location);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, photoUrls, offerType, description, categories, status, price, location);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Item {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
    sb.append("    offerType: ").append(toIndentedString(offerType)).append("\n");
    sb.append("    desciption: ").append(toIndentedString(description)).append("\n");
    sb.append("    categories: ").append(toIndentedString(categories)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

