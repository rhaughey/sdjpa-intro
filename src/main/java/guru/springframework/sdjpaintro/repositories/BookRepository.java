package guru.springframework.sdjpaintro.repositories;

import guru.springframework.sdjpaintro.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rfh on 2/20/2022
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
