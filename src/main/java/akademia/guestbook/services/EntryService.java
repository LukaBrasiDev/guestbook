package akademia.guestbook.services;

import akademia.guestbook.models.EntryModel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class EntryService {

    private List<EntryModel> entries;

    //taka klasa musi miec bezargumentowy konstruktor (ale nie pusty!)
    //linked lista dlatego zeby dodawac zawsze pod index 0 - kolejnosc wpisow najnowsze na górze
    public EntryService(){
        entries = new LinkedList<>();
    }

    public void addEntry(EntryModel entryModel) {
        entries.add(0,entryModel);
    }

    public List<EntryModel> getEntries() {
        return entries;
    }


}
