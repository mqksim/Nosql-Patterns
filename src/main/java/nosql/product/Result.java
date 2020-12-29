package nosql.product;

import javax.persistence.Id;

public class Result {

    @Id
    String id;

    Integer count;

    Double sum;

    public Result() {
    }

    public Result(String id, Double sum) {
        this.id = id;
        this.sum = sum;
    }

    public Result(String id, Integer count) {
        this.id = id;
        this.count = count;
    }

    public Result(String id, Integer count, Double sum) {
        this.id = id;
        this.count = count;
        this.sum=sum;
    }

    public Result(String id) {
        this.id = id;

    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        String result="Agg{" + "id='" + id + '\'';
        if(count!=null){
            result+=", count=" + count;
        }
        if(sum!=null){
            result+=", sum=" + sum;
        }
        result+='}';
        return result;
    }
}
