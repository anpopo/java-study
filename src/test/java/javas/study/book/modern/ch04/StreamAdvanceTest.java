package javas.study.book.modern.ch04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAdvanceTest {


    private List<Movie> movies;

    @BeforeEach
    void setup() {
        movies = new ArrayList<>();

        movies.add(new Movie("어바웃 타임", true, 12, Movie.Genre.ROMANTIC, Set.of(Movie.Cinema.MEGA_BOX)));
        movies.add(new Movie("500일의 썸머", false, 12, Movie.Genre.ROMANTIC, Set.of(Movie.Cinema.MEGA_BOX, Movie.Cinema.LOTTE_CINEMA, Movie.Cinema.CGV)));
        movies.add(new Movie("트랜스 포머", true, 12, Movie.Genre.ACTION, Set.of(Movie.Cinema.MEGA_BOX, Movie.Cinema.LOTTE_CINEMA, Movie.Cinema.CGV)));
        movies.add(new Movie("어벤져스:엔드게임", false, 15, Movie.Genre.ACTION, Set.of(Movie.Cinema.LOTTE_CINEMA, Movie.Cinema.CGV)));
        movies.add(new Movie("분노의 질주", false, 12, Movie.Genre.ACTION, Set.of(Movie.Cinema.CGV)));
        movies.add(new Movie("해리포터와 아즈카반의 죄수", true, 15, Movie.Genre.FANTASY, Set.of(Movie.Cinema.MEGA_BOX, Movie.Cinema.CGV)));
        movies.add(new Movie("반지의 제왕:두개의 탑", true, 12, Movie.Genre.FANTASY, Set.of(Movie.Cinema.LOTTE_CINEMA)));
        movies.add(new Movie("신비한 동물사전", false, 12, Movie.Genre.FANTASY, Set.of(Movie.Cinema.MEGA_BOX, Movie.Cinema.LOTTE_CINEMA)));
        movies.add(new Movie("나니아 연대기", true, 18, Movie.Genre.FANTASY, Set.of(Movie.Cinema.MEGA_BOX, Movie.Cinema.LOTTE_CINEMA, Movie.Cinema.CGV)));
        movies.add(new Movie("월터의 상상은 현실이 된다", false, 12, Movie.Genre.FANTASY, Set.of(Movie.Cinema.MEGA_BOX, Movie.Cinema.LOTTE_CINEMA, Movie.Cinema.CGV)));
        movies.add(new Movie("19곰 테드", false, 15, Movie.Genre.COMEDY, Set.of(Movie.Cinema.MEGA_BOX, Movie.Cinema.CGV)));
        movies.add(new Movie("두사부일체", true, 18, Movie.Genre.COMEDY, Set.of(Movie.Cinema.MEGA_BOX, Movie.Cinema.LOTTE_CINEMA, Movie.Cinema.CGV)));
        movies.add(new Movie("극한 직업", false, 12, Movie.Genre.COMEDY, Set.of(Movie.Cinema.MEGA_BOX, Movie.Cinema.LOTTE_CINEMA)));
        movies.add(new Movie("범죄 도시", true, 18, Movie.Genre.ACTION, Set.of(Movie.Cinema.MEGA_BOX, Movie.Cinema.LOTTE_CINEMA, Movie.Cinema.CGV)));
        movies.add(new Movie("코코", false, 15, Movie.Genre.ETC, Set.of(Movie.Cinema.LOTTE_CINEMA, Movie.Cinema.CGV)));
        movies.add(new Movie("주토피아", true, 12, Movie.Genre.ETC, Set.of(Movie.Cinema.MEGA_BOX, Movie.Cinema.LOTTE_CINEMA, Movie.Cinema.CGV)));
    }


    @Test
    @DisplayName("filtering - predicate")
    void predicateFilteringTest() {
        movies.stream()
                .filter(movie -> movie.getAge() >= 18)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("filtering - distinct")
    void distinctFilteringTest() {
        movies.stream()
                .map(Movie::getAge)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("slicing - predicate")
    void predicateSlicingTest() {
        // 영화 관람가능한 나이로 오름차순 정렬
        movies.sort(Comparator.comparingInt(Movie::getAge));

        /*
        takeWhile() 과 dropWhile() 은 Predicate 를 인수로 받는 중간 연산 메소드
        takeWhile() 은 Predicate 의 값이 false 가 나오는 요소의 이전 모든 요소를 반환
        dropWhile() 은 Predicate 의 값이 false 가 나오는 요소의 이후 모든 요소를 반환
         */

        movies.stream()
                .takeWhile(movie -> movie.getAge() < 18)
                .forEach(System.out::println);

        System.out.println("==============");

        movies.stream()
                .dropWhile(movie -> movie.getAge() < 18)
                .forEach(System.out::println);

    }

    @Test
    @DisplayName("slicing - limit")
    void limitSlicingTest() {
        movies.stream()
                .filter(movie -> movie.getAge() >= 15)
                .limit(2)
                .forEach(System.out::println);
    }

    @RepeatedTest(10)
    @DisplayName("slicing - limit with set - 정렬 되지 않은 stream 의 요소에 대해선 정렬되지 않은 결과값을 반환한다.")
    void limitSlicingTestWithNoSorted() {
        Set<Movie> movieSet = new HashSet<>(movies);
        movieSet.stream()
                .filter(movie -> Movie.Genre.ACTION.equals(movie.getGenre()))
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("slicing - skip")
    void skipSlicingTest() {
        movies.stream()
                .filter(Movie::isOpen)
                .skip(2)
                .forEach(System.out::println);
    }


    @Test
    @DisplayName("mapping - map")
    void mapMappingTest() {
        // Movie 의 객체가 들어가 movie 의 getTitle() 의 반환 값인 String 의 Stream 이 생성
        // 메소드 참조 없는 람다 표현식
        movies.stream()
                .map(movie -> movie.getTitle())
                .forEach(System.out::println);

        System.out.println("==============");

        // 메소드 참조 표현식
        movies.stream()
                .map(Movie::getTitle)
                .forEach(System.out::println);

        System.out.println("==============");
    }

    @Test
    @DisplayName("mapping - map 활용")
    void mapAdvanceMappingTest() {

        // 람다를 이용해 메소드를 변수로 설정
        Function<Movie, String> movieTitleLengthFunction = movie -> {
            String title = movie.getTitle();
            return title.length() > 8
                    ? "Too Long [" + title + "]"
                    : title;
        };

        // map 의 활용
        movies.stream()
                .map(movieTitleLengthFunction)
                .forEach(System.out::println);

        // 위와 같은 로직
        movies.stream()
                .map(movie -> {
                    String title = movie.getTitle();
                    return title.length() > 8
                            ? "Too Long [" + title + "]"
                            : title;
                })
                .forEach(System.out::println);

    }

    @Test
    @DisplayName("mapping - flatMap")
    void mapFlatMapTest() {

        Predicate<Movie> pred = movie -> Movie.Genre.FANTASY.equals(movie.getGenre());
        // fantasy 영화 중 상영 가능한 영화관을 중복없이 뽑아오고 싶은 경우
        // map 과 distinct 를 이용해서 평면화된 결과값을 얻기 어렵다.

        // stream 이 반환됨
        movies.stream()
                .filter(pred)
                .map(movie -> movie.getPossibleCinema().stream())
                .distinct()
                .forEach(System.out::println);

        System.out.println("====================");

        // 평면화된 Cinema 요소가 반환됨됨
       movies.stream()
                .filter(pred)
                .flatMap(movie -> movie.getPossibleCinema().stream())
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("matching - anyMatch()")
    void matchingAnyMatchTest() {
        Stream<Movie> movieStream = movies.stream()
                .filter(movie -> movie.getPossibleCinema().contains(Movie.Cinema.CGV));

        if (movieStream.anyMatch(Movie::isOpen)) System.out.println("검색한 영화 중 최소 1개의 영화가 CGV 에서 상영중입니다.");
    }

    @Test
    @DisplayName("matching - allMatch()")
    void matchingAllMatchTest() {
        Stream<Movie> movieStream = movies.stream()
                .filter(movie -> movie.getPossibleCinema().contains(Movie.Cinema.CGV));

        if (movieStream.allMatch(Movie::isOpen)) System.out.println("검색한 모든 영화가 CGV 에서 상영중입니다.");
    }

    @Test
    @DisplayName("matching - noneMatch()")
    void matchingNoneMatchTest() {
        Stream<Movie> movieStream = movies.stream()
                .filter(movie -> movie.getPossibleCinema().contains(Movie.Cinema.CGV));

        if (movieStream.noneMatch(Movie::isOpen)) System.out.println("CGV 상영작이 없습니다.");
    }

    @RepeatedTest(20)
    @DisplayName("searching - findAny(), findFirst()")
    void searchingFindAnyFindFirstTest() {

        // findFirst 와 findAny 의 결과값이 같은걸 알 수 있다.
        // findAny 는 병렬 실행에서 제약이 적다.
        // 병렬 실행에선 첫번째 요소를 찾기 어렵기 때문에 반환 순서가 상관 없다면
        movies.stream()
                .filter(movie -> movie.getPossibleCinema().contains(Movie.Cinema.LOTTE_CINEMA))
                .findAny()
                .ifPresent(System.out::println);

        System.out.println("===========================");
        movies.stream()
                .filter(movie -> movie.getPossibleCinema().contains(Movie.Cinema.LOTTE_CINEMA))
                .findFirst()
                .ifPresent(System.out::println);

    }


}
