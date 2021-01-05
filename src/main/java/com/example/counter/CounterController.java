package com.example.counter;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/counter")
public class CounterController {
	
	private AtomicInteger counter= new AtomicInteger(0);

	
	@GetMapping
	public String getCounter(Model model) {
		model.addAttribute("count", counter.incrementAndGet());
		return "counter";
	}
	
	@PostMapping
	public String postCounter(Model model) {
		model.addAttribute("count", counter.incrementAndGet());
		return "counter";
	}
	
	@PostMapping
	@RequestMapping("/reset")
	public String resetCounter(@ModelAttribute("resetForm")ResetForm form, Model model) {
		counter.set(form.getValue());
		model.addAttribute("count", counter.get());
		form.setValue(0);
		return "counter";
		
	}
	
	@ModelAttribute("resetForm")
    public ResetForm initResetForm() {
        ResetForm result = new ResetForm();
        result.setValue(0);
        return result;
    }
}
