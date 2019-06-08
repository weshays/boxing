public class Box {
  int length;
  int width;
  int height;

  Boolean box_open;

  public Box() {
    length = 0;
    width = 0;
    height = 0;
    box_open = false;
  }

  public int volume() {
    return length * width * height;
  }

  public void setDimensions(int l, int w, int h) {
    length = l;
    width = w;
    height = h;
  }

  public void openBox() {
    box_open = true;
  }

  public void closeBox() {
    box_open = false;
  }

  public void status() {
    System.out.println("Length: " + length);
    System.out.println("Width: " + width);
    System.out.println("Height: " + height);
    System.out.println("Volume: " + volume());
  }
}
