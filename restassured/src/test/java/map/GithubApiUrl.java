package map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubApiUrl {

    @JsonProperty
    public String events_url;
    @JsonProperty
    public String feeds_url;

}
