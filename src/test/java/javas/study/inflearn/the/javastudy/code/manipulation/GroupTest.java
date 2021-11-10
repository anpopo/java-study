package javas.study.inflearn.the.javastudy.code.manipulation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GroupTest {

    @Test
    public void isFull() {
        Group group = new Group();
        group.maxNumberOfAttendees = 100;
        group.numberOfEnrollment = 10;

        Assertions.assertThat(group.isEnrollmentFull()).isFalse();

    }

}