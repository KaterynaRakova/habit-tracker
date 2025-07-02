package com.example.habittracker.service;
import com.example.habittracker.model.Habit;
import com.example.habittracker.repository.HabitRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HabitServiceImpl implements HabitService{
    private final HabitRepository habitRepository;

    public HabitServiceImpl(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    @Override
    public List<Habit> allHabits() {
        return habitRepository.findAll();
    }

    @Override
    public Habit addHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    @Override
    public void deleteHabit(Long id) {
       habitRepository.deleteById(id);
    }

    @Override
    public Habit markCompleted(Long id) {
        return habitRepository.findById(id)
                .map(habit->{
                    habit.setCompletedDays(habit.getCompletedDays()+1);
                    return habitRepository.save(habit);
                })
                .orElseThrow(()->new RuntimeException("Habit not found with id: "+ id));

    }
}
