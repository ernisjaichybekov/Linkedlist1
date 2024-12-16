import Service.MovieService;

import Service.MovieSortService;
import Service.impl.MovieServiceImpl;

import Service.impl.MovieSortServiceImpl;
import enums.Genre;
import model.Actor;
import model.Movie;
import model.Producer;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

                Producer producer = new Producer("Steven", "Spielberg");
                List<Actor> actors = Arrays.asList(
                        new Actor("Leonardo DiCaprio", "Hero"),
                        new Actor("Tom Hardy", "Villain")
                );

                List<Movie> movies = Arrays.asList(
                        new Movie("Inception", LocalDate.of(2010, 7, 16), Genre.SCI_FI, producer, actors),
                        new Movie("Titanic", LocalDate.of(1997, 12, 19), Genre.DRAMA, producer, actors)
                );

                MovieService movieService = new MovieServiceImpl(movies);
                MovieSortService movieSortService = (MovieSortService) new MovieSortServiceImpl(movies);

                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.println("\nChoose an option:");
                    System.out.println("1. Get all movies");
                    System.out.println("2. Find movie by name");
                    System.out.println("3. Find movie by actor name");
                    System.out.println("4. Find movie by year");
                    System.out.println("5. Find movie by producer");
                    System.out.println("6. Find movie by genre");
                    System.out.println("7. Find movie by role");
                    System.out.println("8. Sort movies by name");
                    System.out.println("9. Sort movies by year");
                    System.out.println("10. Sort movies by producer");
                    System.out.println("0. Exit");

                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1 -> movieService.getAllMovies().forEach(System.out::println);
                        case 2 -> {
                            System.out.print("Enter movie name: ");
                            String name = scanner.nextLine();
                            System.out.println(movieService.findMovieByFullNameOrPartName(name));
                        }
                        case 3 -> {
                            System.out.print("Enter actor name: ");
                            String actorName = scanner.nextLine();
                            System.out.println(movieService.findMovieByActorName(actorName));
                        }
                        case 4 -> {
                            System.out.print("Enter year (yyyy): ");
                            int year = scanner.nextInt();
                            System.out.println(movieService.findMovieByYear(LocalDate.of(year, 1, 1)));
                        }
                        case 5 -> {
                            System.out.print("Enter producer full name: ");
                            String producerName = scanner.nextLine();
                            System.out.println(movieService.findMovieByProducer(producerName));
                        }
                        case 6 -> {
                            System.out.print("Enter genre (ACTION, DRAMA, COMEDY, HORROR, SCI_FI): ");
                            Genre genre = Genre.valueOf(scanner.nextLine().toUpperCase());
                            System.out.println(movieService.findMovieByGenre(genre));
                        }
                        case 7 -> {
                            System.out.print("Enter role: ");
                            String role = scanner.nextLine();
                            System.out.println(movieService.findMovieByRole(role));
                        }
                        case 8 -> {
                            System.out.print("Sort by name (asc/desc): ");
                            String order = scanner.nextLine();
                            movieSortService.sortMovieByName(order);
                        }
                        case 9 -> {
                            System.out.print("Sort by year (asc/desc): ");
                            String order = scanner.nextLine();
                            movieSortService.sortByYear(order);
                        }
                        case 10 -> {
                            System.out.print("Sort by producer (name/lastName): ");
                            String order = scanner.nextLine();
                            movieSortService.sortByProducer(order);
                        }
                        case 0 -> {
                            System.out.println("Exiting...");
                            return;
                        }
                        default -> System.out.println("Invalid choice. Try again.");
                    }
                }
             }
          }