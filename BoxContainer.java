public class BoxContainer {
  static final int CONTAINER_SIZE = 2;
  Box[] boxes;

  public BoxContainer() {
    boxes = new Box[CONTAINER_SIZE];
  }

  public void addBox(Box box) {
    Boolean found_position = false;
    for(int i = 0; i < CONTAINER_SIZE; i++) {
      // find open position
      if(boxes[i] == null && found_position == false) {
        boxes[i] = box;
        found_position = true;
      }
    }
  }

  public Box removeBox(int box_index) {
    Box box = boxes[box_index];
    boxes[box_index] = null;
    return box;
  }

  public Boolean isFull() {
    for(int i = 0; i < CONTAINER_SIZE; i++) {
      if(boxes[i] == null) {
        return false;
      }
    }
    return true;
  }

  public Boolean isEmpty() {
    for(int i = 0; i < CONTAINER_SIZE; i++) {
      if(boxes[i] != null) {
        return false;
      }
    }
    return true;
  }

  public void status() {
    int total_volume = 0;
    for(int i = 0; i < CONTAINER_SIZE; i++) {
      if(boxes[i] != null) {
        System.out.print("Box Position: ");
        System.out.println(i+1);
        boxes[i].status();
        System.out.println("------------------------");
        total_volume = total_volume + boxes[i].volume();
      }
    }
    System.out.println("########################");
    System.out.println("TOTAL VOLUME: " + total_volume);
    System.out.println("CONTAINER CAPACITY: " + CONTAINER_SIZE);

    if(isFull()) {
      System.out.println("########################");
      System.out.println("Container is full!!");
      System.out.println("########################");
    }
  }
}
