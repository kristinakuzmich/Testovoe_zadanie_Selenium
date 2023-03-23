package To;

import enums.Currency;
import enums.MoveType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
@Setter
@Getter
@Builder
@AllArgsConstructor
public class ValuesTo {
    private Currency currency;
    private MoveType typeOfMovement;
    private BigDecimal amount;
    @Override
    public String toString() {
        return "To.ValuesTo{" +
                "currency='" + currency + '\'' +
                ", typeOfMovement='" + typeOfMovement + '\'' +
                ", amount=" + amount +
                '}';
    }
}