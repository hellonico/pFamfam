import processing.core.*; 
import processing.data.*; 

import net.hellonico.famfam.*; 
import net.hellonico.pitunes.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class Hello extends PApplet {




iTunesLibrary itunes;
IconLibrary icons;
Control[] cs;
PFont font;

public void setup() {
  // frame formatting
  size(300,75);
  smooth();
  
  // text formatting
  font = createFont("",10);
  textFont(font);
  
  // libraries used today
  icons = new IconLibrary(this);
  itunes = new iTunesLibrary();
  
  // from the top
  int x = 30;
  // prepare buttons
  cs = new Control[]{
    new Play(itunes, icons.getIconI("resultset_next"), 50, x),
    new Stop(itunes, icons.getIconI("stop"), 80, x),
    new Previous(itunes, icons.getIconI("resultset_first"), 110, x),
    new Next(itunes, icons.getIconI("resultset_last"), 140, x),
    new SoundLow(itunes, icons.getIconI("sound_low"), 170, x),
    new SoundHigh(itunes, icons.getIconI("sound"), 200, x)
  };
  
  currentS = itunes.current();
}
int currentX = 0;
String currentS = "";

public void draw() {
  background(0);
  
  // display controls
  for(int i = 0 ; i<cs.length ; i++) 
    cs[i].display();  
    
  // display current track, with buffer
  try {
  text(currentS, currentX, 20);
  } catch (Exception e) {}
  currentX += 1;
  if(currentX > width) {
     currentX = -10; 
     currentS = itunes.current();
  }
}

public void mousePressed() {
  // check which button has been pressed
  for(int i = 0 ; i < cs.length; i++) 
     if(cs[i].isPressed()) {
       new Thread(cs[i]).start();
     }
       
}
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
   
   public void display() {
     image(img, x, y);
   }
   
   public boolean isPressed() {
      return 
      mouseX < x+img.width &&
      mouseX > x &&
      mouseY < y+img.height &&
      mouseY > y; 
   }
   
   public void run() {pressed();}
   public abstract void pressed();
}

class Play extends Control {
  public Play(iTunesLibrary itunes, PImage img, int x, int y) {super(itunes, img, x, y);} 
  public void pressed() {itunes.play();} 
}
class Stop extends Control {
  public Stop(iTunesLibrary itunes, PImage img, int x, int y) {super(itunes, img, x, y);} 
  public void pressed() {itunes.pause();} 
}
class Next extends Control {
  public Next(iTunesLibrary itunes, PImage img, int x, int y) {super(itunes, img, x, y);}
  public void pressed() {itunes.next();}
}
class Previous extends Control {
  public Previous(iTunesLibrary itunes, PImage img, int x, int y) {super(itunes, img, x, y);}
  public void pressed() {itunes.previous();}
}
class SoundLow extends Control {
  public SoundLow(iTunesLibrary itunes, PImage img, int x, int y) {super(itunes, img, x, y);}
  public void pressed() {itunes.soundLow();}
}
class SoundHigh extends Control {
  public SoundHigh(iTunesLibrary itunes, PImage img, int x, int y) {super(itunes, img, x, y);}
  public void pressed() {itunes.soundHigh();}
}
  public int sketchWidth() { return 300; }
  public int sketchHeight() { return 75; }
  static public void main(String args[]) {
    PApplet.main(new String[] { "Hello" });
  }
}
