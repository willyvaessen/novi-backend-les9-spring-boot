package nl.novi.les9;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class NameController {

    private ArrayList<String> namesList = new ArrayList<>();

    //  Endpoints aanmaken
    @PostMapping("/add") // Een add die geen rekening houdt met dubbele namen.
    public void addName(String name) {
        namesList.add(name);
    }

    @PostMapping("/add2")   //  Add methode die d.m.v. for-loop checkt op dubbele namen voordat de naam wordt toegevoegd.
    public void addName2(String name) {
        boolean isNew = true;
        for (int i = 0; i < namesList.size(); i++) {
            if (namesList.get(i).equals(name)) {
                isNew = false;
                System.out.println("The name is already in the list.");
            }
        }
        if (isNew) {
            this.namesList.add(name);
            System.out.println("Name added to the list.");
        }
    }


    @PostMapping("/add3")   //  Add methode die d.m.v. een while-loop checkt op dubbele namen voordat de naam wordt toegevoegd.
    public void addName3(String name) {
        boolean isNew = true;
        while (isNew){
            if (namesList.contains(name)) {
                isNew = false;
                System.out.println("This name is already in the list!");
                break;
            } else {
                this.namesList.add(name);
                System.out.println("Name added to the list.");
                break;
            }
        }
    }


    @GetMapping("/show") // O.a. Damon heeft hem zo gemaakt. Hij werkt.
    public ArrayList<String> showNames() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < namesList.size(); i++){
            result.add("Hallo " + (namesList.get(i)));
        }
        return result;
    }

    @GetMapping("/show2") //    Gebruik maken van een String builder, zoals Johan gedaan heeft.
    public String getNames(){
        StringBuilder greetings = new StringBuilder();
        for (String name: namesList) {
            greetings.append("Hallo ").append(name).append("\n");
        }
        return greetings.toString();
    }

    @GetMapping("/flip")    //  Draait de namen in de lijst om.
    public void flipNames() {
        for (int i = 0; i < namesList.size(); i++) {
            String orgStr = namesList.get(i), newStr = "";
            char ch;
            System.out.println("Normal: " + orgStr);
            for (int j = 0; j < orgStr.length(); j++){
                ch = orgStr.charAt(j);
                newStr = ch+newStr;
            }
            System.out.println("Reversed name: " + newStr);
        }

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
