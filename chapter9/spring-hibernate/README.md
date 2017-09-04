
Need java.naming as a *compile time* dependency because of: `sessionFactory.getCurrentSession()`


Need to add javassist to automatic modules:

```
Caused by: java.lang.IllegalAccessError: superinterface check failed: class books.impl.entities.BookEntity_$$_jvst7f7_0 (in module bookapp) cannot access class javassist.util.proxy.ProxyObject (in unnamed module @0x1ecfcbc9) because module bookapp does not read unnamed module @0x1ecfcbc9
```

Need to build jars to make classpath scanning work. This is probably because Spring doesnt understand the extra top level dir in exploded form.

Export api packages:
```
Caused by: java.lang.IllegalAccessException: class org.springframework.aop.support.AopUtils cannot access interface books.api.service.BooksService (in module bookapp) because module bookapp does not export books.api.service to unnamed module @2bac9ba

```

Need to (dynamic) export service impl packages:
Caused by: java.lang.IllegalAccessException: class org.springframework.beans.BeanUtils cannot access class books.impl.service.HibernateBooksService (in module bookapp) because module bookapp does not export books.impl.service to unnamed module @6239aba6