package javamodularity.firstresourcemodule;

import java.util.Optional;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.RuntimeException;
import java.net.URL;

public class ResourcesInModule {

   public static void main(String... args) throws Exception {
      Class clazz = ResourcesInModule.class;
      InputStream cz_pkg = clazz.getResourceAsStream("resource_in_package.txt"); //<1>
      URL cz_tl = clazz.getResource("/top_level_resource.txt"); //<2>

      Module m = clazz.getModule(); //<3>
      InputStream m_pkg = m.getResourceAsStream(
        "javamodularity/firstresourcemodule/resource_in_package.txt"); //<4>
      InputStream m_tl = m.getResourceAsStream("top_level_resource.txt"); //<5>

      assert Stream.of(cz_pkg, cz_tl, m_pkg, m_tl)
                   .noneMatch(Objects::isNull);
   }

}
