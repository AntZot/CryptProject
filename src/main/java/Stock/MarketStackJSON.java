package Stock;

import java.util.List;

public class MarketStackJSON {
    public Pagination pagination;
    public List<Datum> data;

    public List<Datum> getData() {
        return data;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
