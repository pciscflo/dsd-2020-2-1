package pe.upc.taller.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.taller.entidades.Author;
import pe.upc.taller.entidades.Book;
import pe.upc.taller.repositorio.AuthorRepository;
import pe.upc.taller.repositorio.BookRepository;


@Service
@Transactional
public class NegocioBiblioteca {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public NegocioBiblioteca(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Book registrar(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Author registrar(Author author) {
        return authorRepository.save(author);
    }
}
