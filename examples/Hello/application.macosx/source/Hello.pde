import net.hellonico.famfam.*;
import net.hellonico.pitunes.*;

iTunesLibrary itunes;
IconLibrary icons;
Control[] cs;
PFont font;

void setup() {
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

void draw() {
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

void mousePressed() {
  // check which button has been pressed
  for(int i = 0 ; i < cs.length; i++) 
     if(cs[i].isPressed()) {
       new Thread(cs[i]).start();
     }
       
}
