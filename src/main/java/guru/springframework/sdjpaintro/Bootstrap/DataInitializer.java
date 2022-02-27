package guru.springframework.sdjpaintro.Bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by rfh on 2/20/2022
 */
@Profile({"local","default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design","2112","Random House", null);
//        System.out.println("ID: " + bookDDD.getId());
        Book savedDDD = bookRepository.save(bookDDD);
//        System.out.println("ID: " + savedDDD.getId());

        Book bookSIA = new Book("Spring In Action", "5150", "O'Reilly", null);
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("ID: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("  ");
        });

    }
}
