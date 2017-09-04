package javamodularity.ormframework;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;

public class OrmFramework {

  private Lookup lookup;

  public OrmFramework(Lookup lookup) { this.lookup = lookup; }

  public <T> T loadfromDatabase(String query, Class<T> clazz) {
     try {
       MethodHandle ctor = lookup.findConstructor(clazz, MethodType.methodType(void.class));
       T entity =  (T) ctor.invoke();

       Lookup privateLookup = MethodHandles.privateLookupIn​(clazz, lookup);
       VarHandle title = privateLookup.findVarHandle(clazz, "title", String.class); // Name/type presumably found in some orm mapping config
       title.set(entity, "Loaded from database!");
       return entity;
     } catch(Throwable e) {
       throw new RuntimeException(e);
     }

  }

}
