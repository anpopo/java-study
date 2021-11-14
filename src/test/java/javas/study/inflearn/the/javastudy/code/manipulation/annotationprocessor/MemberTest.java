package javas.study.inflearn.the.javastudy.code.manipulation.annotationprocessor;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    public static final String SEHYEONG = "sehyeong";

    @Test
    public void getterSetter() {
        Member member = new Member();
        member.setName(SEHYEONG);

        Assertions.assertThat(member.getName()).isEqualTo(SEHYEONG);
    }

}