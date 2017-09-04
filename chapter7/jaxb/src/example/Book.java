package example;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Book {
  private String title;

  public String getTitle() {
    return title;
  }

  @XmlElement
  public void setTitle(String title) {
    this.title = title;
  }
}
