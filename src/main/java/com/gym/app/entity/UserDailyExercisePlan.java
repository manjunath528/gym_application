package  com.gym.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_exercise_plan")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDailyExercisePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_sequence_user_exercise_plan")
    @SequenceGenerator(name = "id_sequence_user_exercise_plan", sequenceName = "sequence_user_exercise_plan", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "login_id")
    private String loginId;

    @Column(name = "exercise_name")
    private String exerciseName;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "calories_burned")
    private Long caloriesBurned;

    @Column(name = "repetitions")
    private Long repetitions;

    @Column(name = "created_ts")
    private Date createdTs;

    @Column(name = "updated_ts")
    private Date updatedTs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(Long caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public Long getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(Long repetitions) {
        this.repetitions = repetitions;
    }

    public Date getCreatedTs() {
        return createdTs;
    }

    public void setCreatedTs(Date createdTs) {
        this.createdTs = createdTs;
    }

    public Date getUpdatedTs() {
        return updatedTs;
    }

    public void setUpdatedTs(Date updatedTs) {
        this.updatedTs = updatedTs;
    }

    @Override
    public String toString() {
        return "UserDailyExercisePlan{" +
                "id=" + id +
                ", loginId='" + loginId + '\'' +
                ", exerciseName='" + exerciseName + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", caloriesBurned=" + caloriesBurned +
                ", repetitions=" + repetitions +
                ", createdTs=" + createdTs +
                ", updatedTs=" + updatedTs +
                '}';
    }
}
