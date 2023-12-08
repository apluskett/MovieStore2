import java.util.Scanner;
public class Driver
{
    private static final Scanner scanner = new Scanner(System.in);
    private static final Hub hub = new Hub();
    public static void main(String[] args)
    {
        String username, password, role, title, leading, genre;
        int choice, guestInput, managerInput, year;
        UserCredentials loggedInUser;
        boolean mainMenu, roleMenu, guestMainMenu, guestSortMenu, managerMainMenu, managerSortMenu, managerMovieMenu;

        System.out.print("Thank you using Alex's Ship and Watch movie store!\n");

       do
        {
            role = ""; // Reset role for each iteration
            loggedInUser = null; // Reset loggedInUser for each iteration
            mainMenu = true; // Reset mainMenu flag for each iteration
            roleMenu = true;
            guestMainMenu = true;
            guestSortMenu = true;
            managerMainMenu = true;
            managerSortMenu = true;
            managerMovieMenu = true;

            while(mainMenu) {//main menu where the user can log in, create an account, or browse movies as a guest.
                choice = twoChoices("""
                        Would you like to:
                        1.Login
                        2.Browse as a guest
                        """);
                switch (choice) {
                    case 1: // User login
                        while (loggedInUser == null) {
                            System.out.print("Username: ");
                            username = scanner.nextLine();
                            System.out.print("Password: ");
                            password = scanner.nextLine();

                            loggedInUser = hub.getLoginDatabase().authenticateUser(username, password);
                            if (loggedInUser != null) {
                                hub.setUserCredentials(loggedInUser);
                                mainMenu = false;
                                break; // Successful login, break out of the while loop
                            } else {
                                System.out.println("Username or password do not match our records. Please try again.");
                            }
                        }
                        break; // Break out of the switch case
                    case 2://sets role to guest for guest actions
                        role = "Guest";
                        mainMenu = false;
                        break;
                    default:
                        System.out.print("Please try again later.");//throws error in case something happens with choice switch
                }
            }
            if (hub.getUserCredentials() != null) {
                role = hub.getUserCredentials().getRole(); // Set role based on logged-in user's credentials
            }
            while(roleMenu) {
                switch (role) {
                    case "Manager":
                        Manager manager = new Manager(hub.getMovieDatabase());
                        managerMainMenu = true;
                        managerInput = fourChoices("""
                                Guest Menu:
                                1.Display Movies
                                2.Search Movies
                                3.Sort
                                4.Manage Movie Inventory
                                5.Exit Statement
                                """);
                        while (managerMainMenu) {
                            managerSortMenu = true;
                            switch (managerInput) {
                                case 1:
                                    manager.displayMovies();
                                    managerInput = twoChoices("""
                                            Would you like to continue?
                                            1.Yes
                                            2.No
                                            """);
                                    if(managerInput==1)
                                    {
                                        managerMainMenu = false;
                                    } else if (managerInput==2) {
                                        managerMainMenu = false;
                                        roleMenu = false;
                                    }
                                    else {
                                        System.out.println("An error has occurred.");
                                        return;
                                    }
                                    break;
                                case 2:
                                    System.out.print("Enter the title of the movie to search: ");
                                    title = scanner.nextLine();
                                    String searchResult = manager.searchMovieByTitle(title);
                                    System.out.println(searchResult);
                                    managerInput = twoChoices("""
                                            Would you like to continue?
                                            1.Yes
                                            2.No
                                            """);
                                    if(managerInput==1)
                                    {
                                        managerMainMenu = false;
                                    } else if (managerInput==2) {
                                        managerMainMenu = false;
                                        roleMenu = false;
                                    }
                                    else {
                                        System.out.println("An error has occurred.");
                                        return;
                                    }
                                    break;
                                case 3:
                                    managerInput = fiveChoices("""
                                            Which category of the movie would you like sorted?
                                            1.Movie Title
                                            2.Year
                                            3.Leading Role
                                            4.Genre
                                            5.Return
                                            """);
                                    while(managerSortMenu) {
                                        switch (managerInput) {
                                            case 1://movie title
                                                managerInput = threeChoices("""
                                                        How would you like the titles organized?
                                                        1.Ascending
                                                        2.Descending
                                                        3.Back
                                                        """);
                                                switch(managerInput)
                                                {
                                                    case 1://sort asc
                                                        manager.sortMoviesByTitleAsc();
                                                        managerInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(managerInput==1)
                                                        {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                        } else if (managerInput==2) {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 2://sort desc
                                                        manager.sortMoviesByTitleDesc();
                                                        managerInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(managerInput==1)
                                                        {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                        } else if (managerInput==2) {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 3:
                                                        managerMainMenu = false;
                                                        managerSortMenu = false;
                                                        break;
                                                    default :
                                                        System.out.println("An error has occurred.");
                                                        return;
                                                }
                                                break;
                                            case 2://year
                                                managerInput = threeChoices("""
                                                        How would you like the titles organized?
                                                        1.Ascending
                                                        2.Descending
                                                        3.Back
                                                        """);
                                                switch(managerInput)
                                                {
                                                    case 1://sort asc
                                                        manager.sortMoviesByYearAsc();
                                                        managerInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(managerInput==1)
                                                        {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                        } else if (managerInput==2) {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 2://sort desc
                                                        manager.sortMoviesByYearDesc();
                                                        managerInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(managerInput==1)
                                                        {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                        } else if (managerInput==2) {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 3:
                                                        managerMainMenu = false;
                                                        managerSortMenu = false;
                                                        break;
                                                    default :
                                                        System.out.println("An error has occurred.");
                                                        return;
                                                }
                                                break;
                                            case 3://leading
                                                managerInput = threeChoices("""
                                                        How would you like the titles organized?
                                                        1.Ascending
                                                        2.Descending
                                                        3.Back
                                                        """);
                                                switch(managerInput)
                                                {
                                                    case 1://sort asc
                                                        manager.sortMoviesByLeadingAsc();
                                                        managerInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(managerInput==1)
                                                        {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                        } else if (managerInput==2) {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 2://sort desc
                                                        manager.sortMoviesByLeadingDesc();
                                                        managerInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(managerInput==1)
                                                        {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                        } else if (managerInput==2) {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 3:
                                                        managerMainMenu = false;
                                                        managerSortMenu = false;
                                                        break;
                                                    default :
                                                        System.out.println("An error has occurred.");
                                                        return;
                                                }
                                                break;
                                            case 4://genre
                                                managerInput = threeChoices("""
                                                        How would you like the titles organized?
                                                        1.Ascending
                                                        2.Descending
                                                        3.Back
                                                        """);
                                                switch(managerInput)
                                                {
                                                    case 1://sort asc
                                                        manager.sortMoviesByGenreAsc();
                                                        managerInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(managerInput==1)
                                                        {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                        } else if (managerInput==2) {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 2://sort desc
                                                        manager.sortMoviesByGenreDesc();
                                                        managerInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(managerInput==1)
                                                        {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                        } else if (managerInput==2) {
                                                            managerMainMenu = false;
                                                            managerSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 3:
                                                        managerMainMenu = false;
                                                        managerSortMenu = false;
                                                        break;
                                                    default :
                                                        System.out.println("An error has occurred.");
                                                        return;
                                                }
                                                break;
                                            case 5://return
                                                managerSortMenu = false;
                                                break;
                                            default://error throw
                                                System.out.println("An error has occurred.");
                                                return;
                                        }
                                    }
                                    break;
                                case 4://Movie inventory
                                    managerMovieMenu = true;
                                    while(managerMovieMenu)
                                    {
                                        managerInput = threeChoices("""
                                                What would you like to do?
                                                1.Add A Movie
                                                2.Remove A Movie
                                                3.Return
                                                """);
                                        switch(managerInput)
                                        {
                                            case 1:
                                                System.out.println("Here is the list of movies.");
                                                manager.displayMovies();
                                                System.out.println("Please enter the name of the movie.");
                                                title = scanner.nextLine();
                                                System.out.println("Please enter the name of the leading star.");
                                                leading = scanner.nextLine();
                                                System.out.println("Please enter the year the movie came out.");
                                                year = scanner.nextInt();
                                                scanner.nextLine();//consume the remaining int data.
                                                System.out.println("Please enter the genre of the movie.");
                                                genre = scanner.nextLine();
                                                manager.addMovie(title, leading, year, genre);
                                                managerInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                if(managerInput==1)
                                                {
                                                    managerMainMenu = false;
                                                    managerMovieMenu = false;
                                                } else if (managerInput==2) {
                                                    managerMainMenu = false;
                                                    managerMovieMenu = false;
                                                    roleMenu = false;
                                                }
                                                else {
                                                    System.out.println("An error has occurred.");
                                                    return;
                                                }
                                                break;
                                            case 2:
                                                System.out.println("Here is the list of movies.");
                                                manager.displayMovies();
                                                System.out.println("Please enter the name of the movie you wish to remove.");
                                                title = scanner.nextLine();
                                                manager.deleteMovie(title);
                                                managerInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                if(managerInput==1)
                                                {
                                                    managerMainMenu = false;
                                                    managerMovieMenu = false;
                                                }
                                                else if (managerInput==2) {
                                                    managerMainMenu = false;
                                                    managerMovieMenu = false;
                                                    roleMenu = false;
                                                }
                                                else {
                                                    System.out.println("An error has occurred.");
                                                    return;
                                                }
                                                break;
                                            case 3:
                                                managerMovieMenu = false;
                                                break;
                                            default :
                                        }
                                    }
                                    break;
                                case 5://exit program
                                    roleMenu=false;
                                    break;
                                default:
                                    System.out.println("An error has occurred.");
                                    return;
                            }
                        }
                        break;
                    case "Guest":
                        Guest guest = new Guest(hub.getMovieDatabase());
                        guestMainMenu = true;
                        guestInput = fourChoices("""
                                Guest Menu:
                                1.Display Movies
                                2.Search Movies
                                3.Sort
                                4.Exit Statement
                                """);
                        while (guestMainMenu) {
                            guestSortMenu = true;
                            switch (guestInput) {
                                case 1:
                                    guest.displayMovies();
                                    guestInput = twoChoices("""
                                            Would you like to continue?
                                            1.Yes
                                            2.No
                                            """);
                                    if(guestInput==1)
                                    {
                                        guestMainMenu = false;
                                    } else if (guestInput==2) {
                                        guestMainMenu = false;
                                        roleMenu = false;
                                    }
                                    else {
                                        System.out.println("An error has occurred.");
                                        return;
                                    }
                                    break;
                                case 2:
                                    System.out.print("Enter the title of the movie to search: ");
                                    title = scanner.nextLine();
                                    String searchResult = guest.searchMovieByTitle(title);
                                    System.out.println(searchResult);
                                    guestInput = twoChoices("""
                                            Would you like to continue?
                                            1.Yes
                                            2.No
                                            """);
                                    if(guestInput==1)
                                    {
                                        guestMainMenu = false;
                                    } else if (guestInput==2) {
                                        guestMainMenu = false;
                                        roleMenu = false;
                                    }
                                    else {
                                        System.out.println("An error has occurred.");
                                        return;
                                    }
                                    break;
                                case 3:
                                    guestInput = fiveChoices("""
                                            Which category of the movie would you like sorted?
                                            1.Movie Title
                                            2.Year
                                            3.Leading Role
                                            4.Genre
                                            5.Return
                                            """);
                                    while(guestSortMenu) {
                                        switch (guestInput) {
                                            case 1://movie title
                                                guestInput = threeChoices("""
                                                        How would you like the titles organized?
                                                        1.Ascending
                                                        2.Descending
                                                        3.Back
                                                        """);
                                                switch(guestInput)
                                                {
                                                    case 1://sort asc
                                                        guest.sortMoviesByTitleAsc();
                                                        guestInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(guestInput==1)
                                                        {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                        } else if (guestInput==2) {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 2://sort desc
                                                        guest.sortMoviesByTitleDesc();
                                                        guestInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(guestInput==1)
                                                        {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                        } else if (guestInput==2) {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 3:
                                                        guestMainMenu = false;
                                                        guestSortMenu = false;
                                                        break;
                                                    default :
                                                        System.out.println("An error has occurred.");
                                                        return;
                                                }
                                                break;
                                            case 2://year
                                                guestInput = threeChoices("""
                                                        How would you like the titles organized?
                                                        1.Ascending
                                                        2.Descending
                                                        3.Back
                                                        """);
                                                switch(guestInput)
                                                {
                                                    case 1://sort asc
                                                        guest.sortMoviesByYearAsc();
                                                        guestInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(guestInput==1)
                                                        {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                        } else if (guestInput==2) {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 2://sort desc
                                                        guest.sortMoviesByYearDesc();
                                                        guestInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(guestInput==1)
                                                        {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                        } else if (guestInput==2) {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 3:
                                                        guestMainMenu = false;
                                                        guestSortMenu = false;
                                                        break;
                                                    default :
                                                        System.out.println("An error has occurred.");
                                                        return;
                                                }
                                                break;
                                            case 3://leading
                                                guestInput = threeChoices("""
                                                        How would you like the titles organized?
                                                        1.Ascending
                                                        2.Descending
                                                        3.Back
                                                        """);
                                                switch(guestInput)
                                                {
                                                    case 1://sort asc
                                                        guest.sortMoviesByLeadingAsc();
                                                        guestInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(guestInput==1)
                                                        {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                        } else if (guestInput==2) {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 2://sort desc
                                                        guest.sortMoviesByLeadingDesc();
                                                        guestInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(guestInput==1)
                                                        {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                        } else if (guestInput==2) {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 3:
                                                        guestMainMenu = false;
                                                        guestSortMenu = false;
                                                        break;
                                                    default :
                                                        System.out.println("An error has occurred.");
                                                        return;
                                                }
                                                break;
                                            case 4://genre
                                                guestInput = threeChoices("""
                                                        How would you like the titles organized?
                                                        1.Ascending
                                                        2.Descending
                                                        3.Back
                                                        """);
                                                switch(guestInput)
                                                {
                                                    case 1://sort asc
                                                        guest.sortMoviesByGenreAsc();
                                                        guestInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(guestInput==1)
                                                        {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                        } else if (guestInput==2) {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 2://sort desc
                                                        guest.sortMoviesByGenreDesc();
                                                        guestInput = twoChoices("""
                                                             Would you like to continue?
                                                             1.Yes
                                                             2.No
                                                             """);
                                                        if(guestInput==1)
                                                        {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                        } else if (guestInput==2) {
                                                            guestMainMenu = false;
                                                            guestSortMenu = false;
                                                            roleMenu = false;
                                                        }
                                                        else {
                                                            System.out.println("An error has occurred.");
                                                            return;
                                                        }
                                                        break;
                                                    case 3:
                                                        guestMainMenu = false;
                                                        guestSortMenu = false;
                                                        break;
                                                    default :
                                                        System.out.println("An error has occurred.");
                                                        return;
                                                }
                                                break;
                                            case 5://return
                                                guestSortMenu = false;
                                                break;
                                            default://error throw
                                                System.out.println("An error has occurred.");
                                                return;
                                        }
                                    }
                                    break;
                                case 4://exit program
                                    roleMenu=false;
                                    break;
                                default:
                                    System.out.println("An error has occurred.");
                                    return;
                            }
                        }
                        break;
                }
            }
        } while(exitProgram());
    }
    private static int twoChoices(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                if (value >= 1 && value <= 2) {
                    return value;
                } else {
                    System.out.print("Please choose a valid option between 1 and 2.\n");
                }
            } else {
                scanner.nextLine();  // Clear the invalid input
                System.out.print("Invalid input. Please enter a valid integer.\n");
            }
        }
    }
    private static int threeChoices(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                if (value >= 1 && value <= 3) {
                    return value;
                } else {
                    System.out.print("Please choose a valid option between 1 and 3.\n");
                }
            } else {
                scanner.nextLine();  // Clear the invalid input
                System.out.print("Invalid input. Please enter a valid integer.\n");
            }
        }
    }
    private static int fourChoices(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                if (value >= 1 && value <= 4) {
                    return value;
                } else {
                    System.out.print("Please choose a valid option between 1 and 4.\n");
                }
            } else {
                scanner.nextLine();  // Clear the invalid input
                System.out.print("Invalid input. Please enter a valid integer.\n");
            }
        }
    }

    private static int fiveChoices(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character

                if (value >= 1 && value <= 5) {
                    return value;
                } else {
                    System.out.print("Please choose a valid option between 1 and 4.\n");
                }
            } else {
                scanner.nextLine();  // Clear the invalid input
                System.out.print("Invalid input. Please enter a valid integer.\n");
            }
        }
    }

    private static boolean exitProgram()
    {
        while (true)
        {
            System.out.print("Would you like to run again? (Y/N): ");
            String exitValid = scanner.next().toUpperCase(); // Convert to uppercase for case-insensitive check

            if (exitValid.equals("Y"))
            {
                return true; // Run again
            }
            else if (exitValid.equals("N"))
            {
                System.out.print("Thank you for using this program, have a great day!\n");
                return false; // Do not run again
            }
            else
            {
                System.out.print("Invalid input. Please enter 'Y' or 'N'.\n");
            }
        }
    }
}