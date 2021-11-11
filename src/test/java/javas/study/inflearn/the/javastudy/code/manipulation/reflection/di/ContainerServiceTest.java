package javas.study.inflearn.the.javastudy.code.manipulation.reflection.di;

import javas.study.inflearn.the.javastudy.code.manipulation.reflection.Book;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class ContainerServiceTest {

    @Test
    public void getObject_BookRepository() {
        BookRepository object = ContainerService.getObject(BookRepository.class);

        Assertions.assertThat(object).isNotNull();
    }

    @Test
    public void getObject_BookService() {
        BookService bookService = ContainerService.getObject(BookService.class);

        Assertions.assertThat(bookService).isNotNull();
        Assertions.assertThat(bookService.bookRepository).as("book repository in book service").isNotNull();
        Assertions.assertThat(bookService.bookRepository).isExactlyInstanceOf(BookRepository.class);
    }

}