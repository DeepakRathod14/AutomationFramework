package Learning.Automation.beans.guest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "checkin",
    "checkout"
})
public class Bookingdates {

    @JsonProperty("checkin")
    private String checkin;
    
    @JsonProperty("checkout")
    private String checkout;
    
    @JsonProperty("checkin")
    public String getCheckin() {
        return checkin;
    }

    @JsonProperty("checkin")
    public Bookingdates setCheckin(String checkin) {
        this.checkin = checkin;
        return this;
    }

    @JsonProperty("checkout")
    public String getCheckout() {
        return checkout;
    }

    @JsonProperty("checkout")
    public Bookingdates setCheckout(String checkout) {
        this.checkout = checkout;
        return this;
    }
}
