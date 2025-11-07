
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@NoArgsConstructor
@AllArgsConstructor

public class UserEntity{
    private int id;
    private String address;
    private String mail;
    private String password;

}
