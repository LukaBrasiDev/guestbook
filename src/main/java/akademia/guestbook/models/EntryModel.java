package akademia.guestbook.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EntryModel {
    private String name;
    private String surname;
    private String message;
}
