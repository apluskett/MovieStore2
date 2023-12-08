public record Movie(String title, String leading, int year, String genre) {

    @Override
    public String toString() {
        return STR."Movie{title='\{title}\{'\''}, year=\{year}, leading='\{leading}\{'\''}, genre='\{genre}\{'\''}\{'}'}";
    }
}