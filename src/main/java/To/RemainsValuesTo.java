package To;

import enums.Currency;
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
public class RemainsValuesTo {
    private Currency currency;
    private BigDecimal amount;
    @Override
    public String toString() {
        return "To.ValuesTo{" +
                "currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RemainsValuesTo that)) return false;
        return currency == that.currency && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}