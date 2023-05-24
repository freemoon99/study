package purewallet.api.pureapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Word")
public class Word {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String input;
    private String result;
    public Word() {}
    public Word(String input, String result) {
        this.input = input;
        this.result = result;
    }

}
