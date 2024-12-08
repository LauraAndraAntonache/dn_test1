package ro.digitalnation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MVCController {
	
	@Autowired
	GreetingRepository repo;
	
	Integer counter = 0;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,
			Model model) {
		//model.addAttribute("nume", name);
		//System.out.println(model);
		//greetings.add(new Greeting(counter++, name));
		return "greetingPage";
	}
	
	@GetMapping("/greetings")
	public String greetings(Model model) {
		model.addAttribute("greetings", repo.findAll());
		model.addAttribute("greeting", new Greeting());
		return "greetingPage";
	}
	
	@PostMapping("/greetingPost")
	public String addGreeting(@ModelAttribute Greeting greet, Model model) {
		System.out.println(model);
		//greetings.add(greet);
		repo.save(greet);
		
		return "redirect:greetings";
	}
}
