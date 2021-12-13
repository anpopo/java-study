package javas.study.book.modern.ch04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class MovieTest {

    private List<Movie> movies;

    @BeforeEach
    void setup() {
        movies = new ArrayList<>();

        movies.add(new Movie("어바웃 타임", true, 12, Movie.Genre.ROMANTIC));
        movies.add(new Movie("500일의 썸머", false, 12, Movie.Genre.ROMANTIC));
        movies.add(new Movie("트랜스 포머", true, 12, Movie.Genre.ACTION));
        movies.add(new Movie("어벤져스:엔드게임", false, 15, Movie.Genre.ACTION));
        movies.add(new Movie("분노의 질주", false, 12, Movie.Genre.ACTION));
        movies.add(new Movie("해리포터와 아즈카반의 죄수", true, 15, Movie.Genre.FANTASY));
        movies.add(new Movie("반지의 제왕:두개의 탑", true, 12, Movie.Genre.FANTASY));
        movies.add(new Movie("신비한 동물사전", false, 12, Movie.Genre.FANTASY));
        movies.add(new Movie("나니아 연대기", true, 18, Movie.Genre.FANTASY));
        movies.add(new Movie("월터의 상상은 현실이 된다", false, 12, Movie.Genre.FANTASY));
        movies.add(new Movie("19곰 테드", false, 15, Movie.Genre.COMEDY));
        movies.add(new Movie("두사부일체", true, 18, Movie.Genre.COMEDY));
        movies.add(new Movie("극한 직업", false, 12, Movie.Genre.COMEDY));
        movies.add(new Movie("범죄 도시", true, 18, Movie.Genre.ACTION));
        movies.add(new Movie("코코", false, 15, Movie.Genre.ETC));
        movies.add(new Movie("주토피아", true, 12, Movie.Genre.ETC));
    }

    @Test
    @DisplayName("stream 맛보기")
    void test1ForStream() {
        // 연속된 요소인 데이터 컬렉션을 사용해 스트림을 만들었다.
        // 데이터 처리 연산을 파이프 라이닝을 통해 내부에서 반복해 수행
        // 스트림의 모든 특징이 나타나있다.
        List<String> movieTitleList = movies.stream()
                .filter(movie -> movie.isOpen())
                .map(movie -> movie.getTitle())
                .limit(5)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("컬렉션 외부 반복과 스트림의 내부 반복")
    void externalAndInternalIteration() {
        // 외부 반복 - 사용자 직접 명시적인 반복을 한다.
        List<String> movieName1 = new ArrayList<>();
        for (Movie movie : movies) {
            if(movie.isOpen())
                movieName1.add(movie.getTitle());
        }

        List<String> movieName2  = movies.stream()
                .filter(Movie::isOpen)  // 람다에서 배운 메서드 참조를 이용해 더 간단하게 표현할 수 있다.
                .map(Movie::getTitle)
                .collect(Collectors.toList());

        Assertions.assertThat(movieName1).containsAll(movieName2);
    }

}