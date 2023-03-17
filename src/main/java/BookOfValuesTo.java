import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Objects;
@Setter
@Getter
@Builder
@AllArgsConstructor
public class BookOfValuesTo {
    private String operation,fio,currency;
    private BigDecimal amount;
    @Override
    public String toString() {
        return "BookOfValuesTo{" +
                "operation='" + operation + '\'' +
                ", fio='" + fio + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        BookOfValuesTo that=(BookOfValuesTo) o;
        return  Objects.equals(operation, that.operation) &&
                Objects.equals(fio, that.fio) &&
                Objects.equals(currency, that.currency) &&
                amount.compareTo(that.amount) == 0;
    }
}
