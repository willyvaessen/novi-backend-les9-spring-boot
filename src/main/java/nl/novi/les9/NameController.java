package nl.novi.les9;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class NameController {

    private ArrayList<String> namesList = new ArrayList<>();

    //  Endpoints aanmaken
    @PostMapping("/add")
    public void addName(String name) {
        namesList.add(name);
    }

    @GetMapping("/show")
    public ArrayList<String> showNames() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < namesList.size(); i++){
            result.add("Hallo " + (namesList.get(i)));
        }
        return result;
    }
/*
    @DeleteMapping("/delete{name}")
    public void deleteDoubleName(@PathVariable String name) {
        if (namesList.contains(name)) {
            namesList.remove(name);
        }
    }
*/


}
