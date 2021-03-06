package com.cuongnghiem.spring5webapp.bootstrap;

import com.cuongnghiem.spring5webapp.domain.Author;
import com.cuongnghiem.spring5webapp.domain.Book;
import com.cuongnghiem.spring5webapp.domain.Publisher;
import com.cuongnghiem.spring5webapp.repositories.AuthorRepository;
import com.cuongnghiem.spring5webapp.repositories.BookRepository;
import com.cuongnghiem.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher prh = new Publisher("Penguin Random House",
                "1745 Broadway",
                "New York",
                "NY United States",
                "10019");

        publisherRepository.save(prh);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(prh);
        prh.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "12213125");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(prh);
        prh.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        publisherRepository.save(prh);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
    }
}
