package easytext.domain.api;

public class Text {

   private String theText;

   public String getTheText() {
      return this.theText;
   }

   public void setTheText(String theText) {
      this.theText = theText;
   }

   public int wordcount() {
      return 42; // Why not
   }

}
