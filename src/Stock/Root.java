package Stock;

import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */
public class Root{
    public List<Double> c;
    public List<Double> h;
    public List<Double> l;
    public List<Double> o;
    public String s;
    public List<Integer> t;
    public List<Integer> v;
}

