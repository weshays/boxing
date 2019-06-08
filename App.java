import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
  String input = "";
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));;
  BoxContainer box_container = new BoxContainer();

  public static void main(String[] args)  {
    App app = new App();
    app.prompt();
  }

  public void prompt() {
    do {
      try {
        System.out.print("~> ");
        input = reader.readLine();
        clearScreen();

        if(input.equalsIgnoreCase("help")) {
          helpMenu();
        } else if(input.equalsIgnoreCase("status")) {
          box_container.status();
        } else if(input.equalsIgnoreCase("addbox")) {
          addBoxToContainer();
        } else if(input.equalsIgnoreCase("removebox")) {
          removeBoxFromContainer();
        }

      } catch(Exception e) {
        System.out.println("SOMETHING BAD HAPPENED!!!");
      }
    }
    while (!input.equalsIgnoreCase("exit") && !input.equalsIgnoreCase("quit"));
  }

  public void addBoxToContainer() {
    int input_length = -1;
    int input_width = -1;
    int input_height = -1;

    if(box_container.isFull()) {
      System.out.println("Box container is full!!");
    } else {
      try {
        System.out.println("Enter box length");
        input_length = Integer.parseInt(reader.readLine());

        System.out.println("Enter box width");
        input_width = Integer.parseInt(reader.readLine());

        System.out.println("Enter box height");
        input_height = Integer.parseInt(reader.readLine());
      } catch(Exception e) {
        System.out.println("SOMETHING BAD HAPPENED IN addBoxToContainer!!!");
      }

      Box box = new Box();
      box.setDimensions(input_length, input_width, input_height);
      box_container.addBox(box);
    }
  }

  public void removeBoxFromContainer() {
    int position_to_remove = -1;
    try {
      System.out.println("What box do you want to remove?");
      position_to_remove = Integer.parseInt(reader.readLine());
      box_container.removeBox(position_to_remove - 1);
    } catch(Exception e) {
      System.out.println("SOMETHING BAD HAPPENED IN removeBoxFromContainer!!!");
    }
  }

  public void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public void helpMenu() {
    System.out.println("############# Help Menu #############");
    System.out.println("quit/exit: Quit the app");
    System.out.println("#####################################");
    System.out.println("\n\n");
  }
}