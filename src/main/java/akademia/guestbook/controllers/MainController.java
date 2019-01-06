package akademia.guestbook.controllers;

import akademia.guestbook.models.EntryModel;
import akademia.guestbook.services.EntryService;
import akademia.guestbook.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private EntryService entryService;


    @Autowired
    public MainController(EntryService entryService) {
        this.entryService = entryService;
    }


  /*  @GetMapping("/")
    public String index() {
        return "index";
    }*/

    @PostMapping("/")
    public String index(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("message") String message,
            Model model
    ) {
        if (name.isEmpty() || surname.isEmpty() || message.isEmpty()) {
            model.addAttribute("error","Nieprawidłowa operacja!");
            return "index";
        }
        entryService.addEntry(new EntryModel(name, surname, message));
        model.addAttribute("success", "Wpis dodany poprawnie!");
        return "index";
    }

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("entries", entryService.getEntries());
        return "index";
    }
}
