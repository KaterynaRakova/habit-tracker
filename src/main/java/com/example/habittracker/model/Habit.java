package com.example.habittracker.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(length = 500)
    private String description;
    // can use the annotation the same
    /*
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDate createdAt;
     */
    private LocalDate createdAt = LocalDate.now();
    private int completedDays;
    public int getCompletedDays() {
        return completedDays;
    }

    public void setCompletedDays(int completedDays) {
        this.completedDays = completedDays;
    }
}
