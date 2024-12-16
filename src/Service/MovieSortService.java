package Service;

public interface MovieSortService {
    void sortMovieByName(String ascOrDesc); // Аты боюнча сорттоо
    void sortByYear(String ascOrDesc);     // Жылы боюнча сорттоо
    void sortByProducer(String nameOrLastName);
}
