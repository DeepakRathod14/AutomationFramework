package Learning.Automation.beans.guest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "firstname",
    "lastname",
    "totalprice",
    "depositpaid",
    "bookingdates",
    "additionalneeds"
})

public class GuestInfo {

    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;
    
    @JsonProperty("totalprice")
    private Integer totalprice;
    
    @JsonProperty("depositpaid")
    private Boolean depositpaid;
    
    @JsonProperty("bookingdates")
    private Bookingdates bookingdates;
    
    @JsonProperty("additionalneeds")
    private String additionalneeds;
    
    @JsonProperty("firstname")
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty("firstname")
    public GuestInfo setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    @JsonProperty("lastname")
    public String getLastname() {
        return lastname;
    }

    @JsonProperty("lastname")
    public GuestInfo setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    @JsonProperty("totalprice")
    public Integer getTotalprice() {
        return totalprice;
    }

    @JsonProperty("totalprice")
    public GuestInfo setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    @JsonProperty("depositpaid")
    public Boolean getDepositpaid() {
        return depositpaid;
    }

    @JsonProperty("depositpaid")
    public GuestInfo setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
        return this;
    }

    @JsonProperty("bookingdates")
    public Bookingdates getBookingdates() {
        return bookingdates;
    }

    @JsonProperty("bookingdates")
    public GuestInfo setBookingdates(Bookingdates bookingdates) {
        this.bookingdates = bookingdates;
        return this;
    }

    @JsonProperty("additionalneeds")
    public String getAdditionalneeds() {
        return additionalneeds;
    }

    @JsonProperty("additionalneeds")
    public GuestInfo setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
        return this;
    }
}
