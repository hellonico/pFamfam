public abstract class Control implements Runnable {
   PImage img;
   int x;
   int y;
   iTunesLibrary itunes;
   
   public Control(iTunesLibrary itunes, PImage img, int x, int y) {
     this.itunes = itunes;
     this.img = img;
     this.x = x;
     this.y = y;
   } 
   
   void display() {
     image(img, x, y);
   }
   
   boolean isPressed() {
      return 
      mouseX < x+img.width &&
      mouseX > x &&
      mouseY < y+img.height &&
      mouseY > y; 
   }
   
   void run() {pressed();}
   abstract void pressed();
}

class Play extends Control {
  public Play(iTunesLibrary itunes, PImage img, int x, int y) {super(itunes, img, x, y);} 
  void pressed() {itunes.play();} 
}
class Stop extends Control {
  public Stop(iTunesLibrary itunes, PImage img, int x, int y) {super(itunes, img, x, y);} 
  void pressed() {itunes.pause();} 
}
class Next extends Control {
  public Next(iTunesLibrary itunes, PImage img, int x, int y) {super(itunes, img, x, y);}
  void pressed() {itunes.next();}
}
class Previous extends Control {
  public Previous(iTunesLibrary itunes, PImage img, int x, int y) {super(itunes, img, x, y);}
  void pressed() {itunes.previous();}
}
class SoundLow extends Control {
  public SoundLow(iTunesLibrary itunes, PImage img, int x, int y) {super(itunes, img, x, y);}
  void pressed() {itunes.soundLow();}
}
class SoundHigh extends Control {
  public SoundHigh(iTunesLibrary itunes, PImage img, int x, int y) {super(itunes, img, x, y);}
  void pressed() {itunes.soundHigh();}
}
