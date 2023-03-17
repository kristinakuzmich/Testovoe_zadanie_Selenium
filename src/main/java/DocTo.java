import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Builder
@AllArgsConstructor
public class DocTo {
    private String purpose;
    private String description;
    private String userName;
    @Override
    public String toString() {
        return "DocTo{" +
                "purpose='" + purpose + '\'' +
                ", description='" + description + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}