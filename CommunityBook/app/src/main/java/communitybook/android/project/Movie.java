package communitybook.android.project;

/**
 * Created by rudresha on 10/06/17.
 */
public class Movie {
    private String timeline_profile_name , title, genre, year;

    public Movie() {
    }

    public Movie(String timeline_profile_name ,String title, String genre, String year) {
        this.timeline_profile_name = timeline_profile_name;
        this.title = title;
        this.genre = genre;
        this.year = year;
    }


    public String getTimeline_profile_name() {
        return timeline_profile_name;
    }

    public void setTimeline_profile_name(String timeline_profile_name) {
        this.timeline_profile_name = timeline_profile_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
