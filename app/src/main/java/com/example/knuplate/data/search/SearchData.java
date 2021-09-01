package com.example.knuplate.data.search;

import java.util.List;

public class SearchData {
    List<ResultData> result;
    boolean is_end;
    int pageable_count;

    public List<ResultData> getResult() {
        return result;
    }

    public void setResult(List<ResultData> result) {
        this.result = result;
    }

    public boolean isIs_end() {
        return is_end;
    }

    public void setIs_end(boolean is_end) {
        this.is_end = is_end;
    }

    public int getPageable_count() {
        return pageable_count;
    }

    public void setPageable_count(int pageable_count) {
        this.pageable_count = pageable_count;
    }

    @Override
    public String toString() {
        return "SearchData{" +
                "result=" + result +
                ", is_end=" + is_end +
                ", pageable_count=" + pageable_count +
                '}';
    }
}
