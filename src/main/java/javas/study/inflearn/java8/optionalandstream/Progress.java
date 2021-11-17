package javas.study.inflearn.java8.optionalandstream;

import java.time.Duration;

public class Progress {

    private Duration studyDuration;

    private boolean completed;

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
