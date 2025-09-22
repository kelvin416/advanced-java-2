/* CodingNomads (C)2024 */
package com.codingnomads.springmvc.thymeleaf;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("name", "Spring Developer!");
        return "greeting";
    }

    @GetMapping("/practice")
    public String practice(Model model){
        model.addAttribute("car1", "Mazda");
        model.addAttribute("car2", "Benz");
        model.addAttribute("car3", "Prado");
        model.addAttribute("car4", "BMW");

        return "practice";
    }

    @GetMapping("/subjects")
    public String subjects(Model model) {
        Subject s1 = new Subject("Java", "Programming");
        Subject s2 = new Subject("Python", "Programming");
        Subject s3 = new Subject("Geometry", "Math");

        ArrayList<Subject> subjects = new ArrayList<>();
        subjects.add(s1);
        subjects.add(s2);
        subjects.add(s3);

        model.addAttribute("subjects", subjects);
        return "subjects";
    }
}
