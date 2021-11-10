package javas.study.inflearn.the.javastudy.code.manipulation;

public class Group {

    int maxNumberOfAttendees;

    int numberOfEnrollment;

    public boolean isEnrollmentFull() {
        if(maxNumberOfAttendees == 0)
            return false;

        if(numberOfEnrollment < maxNumberOfAttendees)
            return false;

        return true;
    }

    public String pullOut() {
        return "";
    }
}
