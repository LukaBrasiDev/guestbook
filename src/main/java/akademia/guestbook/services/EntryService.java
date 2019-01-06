package akademia.guestbook.services;

import akademia.guestbook.models.EntryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class EntryService {

    private List<EntryModel> entries;
    private NotificationService notificationService;



    //taka klasa musi miec bezargumentowy konstruktor (ale nie pusty!)
    //linked lista dlatego zeby dodawac zawsze pod index 0 - kolejnosc wpisow najnowsze na górze
    @Autowired
    public EntryService(NotificationService notificationService) {
        entries = new LinkedList<>();
        this.notificationService = notificationService;

    }

    public void addEntry(EntryModel entryModel) {
        entries.add(0, entryModel);
        notificationService.sendMessageToAdmin("Nowy wpis w księdze gości");
    }

    public List<EntryModel> getEntries() {
        return entries;
    }


}
