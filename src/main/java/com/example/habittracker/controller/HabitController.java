package com.example.habittracker.controller;

import com.example.habittracker.model.Habit;
import com.example.habittracker.service.HabitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public String listHabits(Model model) {
        model.addAttribute("habits", habitService.allHabits());
        return "habits";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("habit", new Habit());
        return "habit_form";
    }

    @PostMapping("/save")
    public String saveHabit(@ModelAttribute Habit habit) {
        habitService.addHabit(habit);
        return "redirect:/habits";
    }

    @GetMapping("/delete/{id}")
    public String deleteHabit(@PathVariable Long id) {
        habitService.deleteHabit(id);
        return "redirect:/habits";
    }

    @GetMapping("/complete/{id}")
    public String markCompleted(@PathVariable Long id) {
        habitService.markCompleted(id);
        return "redirect:/habits";
    }
    @PostMapping
    public String saveHabit(@ModelAttribute Habit habit, RedirectAttributes redirectAttributes) {
        habitService.addHabit(habit);
        redirectAttributes.addFlashAttribute("message", "✅ Habit added successfully!");
        return "redirect:/habits";
    }
}