package easytext.client;

import java.util.ServiceLoader;

import easytext.repository.api.TextRepository;

public class Client {

   public static void main(String... args) {
      TextRepository repository = ServiceLoader.load(TextRepository.class)
         .iterator().next();

      repository.findText("HHGTTG").wordcount();
   }

}
