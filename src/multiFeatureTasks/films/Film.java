package multiFeatureTasks.films;

import java.util.Objects;

public record Film(String title, String category, int rating ) {
    public Film {
        if ((rating < 0) || (rating > 5)) {
            throw new IllegalArgumentException("Ocena z przedziału 0 - 5");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(title, film.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
