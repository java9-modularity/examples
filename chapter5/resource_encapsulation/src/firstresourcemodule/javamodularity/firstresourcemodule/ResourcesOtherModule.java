package javamodularity.firstresourcemodule;

import java.lang.ClassLoader;
import java.util.*;
import java.util.stream.Stream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.RuntimeException;

public class ResourcesOtherModule {

   public static void main(String... args) throws Exception {
      Optional<Module> otherModule = ModuleLayer.boot().findModule("secondresourcemodule"); //<1>

      otherModule.ifPresent(other -> {
         try {
            InputStream m_tl = other.getResourceAsStream("top_level_resource2.txt"); //<2>
            InputStream m_pkg = other.getResourceAsStream(
                "javamodularity/secondresourcemodule/resource_in_package2.txt"); //<3>
            InputStream m_class = other.getResourceAsStream(
                "javamodularity/secondresourcemodule/A.class"); //<4>
            InputStream m_meta = other.getResourceAsStream("META-INF/resource_in_metainf.txt"); //<5>
            InputStream cz_pkg =
              Class.forName("javamodularity.secondresourcemodule.A")
                   .getResourceAsStream("resource_in_package2.txt"); //<6>

            assert Stream.of(m_tl, m_class, m_meta)
                         .noneMatch(Objects::isNull);
            assert Stream.of(m_pkg, cz_pkg)
                         .allMatch(Objects::isNull);

         } catch (Exception e) {
            throw new RuntimeException(e);
         }
      });
   }

}
