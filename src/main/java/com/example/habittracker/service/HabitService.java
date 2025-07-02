package com.example.habittracker.service;
import com.example.habittracker.model.Habit;
import java.util.List;

public interface HabitService {
    List<Habit> allHabits();
    Habit addHabit(Habit habit);
    void deleteHabit(Long id);
    Habit markCompleted(Long id);

}
