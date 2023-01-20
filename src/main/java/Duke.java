import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        TaskMethods t = new TaskMethods();
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What can I do for you?\n");

        while (true) {
            String input;
            Scanner scan = new Scanner(System.in);
            input = scan.nextLine();
            String[] splitCommand = input.split(" ");
            String splitDescription = input.split(" ", 2).length == 2
                    ? input.split(" ", 2)[1]
                    : "";

            if (splitCommand[0].equals("bye")) {
                t.bye();
                break;
            } else if (splitCommand[0].equals("list")) {
                t.list();
                continue;
            } else if (splitCommand[0].equals("mark")) {
                t.mark(Integer.parseInt(splitCommand[1]));
                continue;
            } else if (splitCommand[0].equals("unmark")) {
                t.unmark(Integer.parseInt(splitCommand[1]));
                continue;
            } else if (splitCommand[0].equals("todo")) {
                t.addTodo(splitDescription);
                continue;
            } else if (splitCommand[0].equals("deadline")) {
                String[] splitDesWithBy = splitDescription.split(" /by ", 2);
                String description = splitDesWithBy[0].trim();
                String dueDate = splitDesWithBy[1].trim();
                t.addDeadline(description, dueDate);
                continue;
            } else if (splitCommand[0].equals("event")) {
                String[] splitDesWithFrom = splitDescription.split(" /from ", 2);
                String description = splitDesWithFrom[0].trim();
                String startingTime = splitDesWithFrom[1].split(" /to ", 2)[0].trim();
                String endingTime = splitDesWithFrom[1].split(" /to ", 2)[1].trim();
                t.addEvent(description, startingTime, endingTime);
            } else {
                t.add(input);
                continue;
            }
        }

    }
}
