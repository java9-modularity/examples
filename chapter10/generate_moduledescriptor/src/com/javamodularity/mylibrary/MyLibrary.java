package com.javamodularity.mylibrary;

import com.javamodularity.mylibrary.internal.Util;

import java.sql.SQLException;
import java.sql.Driver;
import java.util.logging.Logger;

public class MyLibrary {

   private Util util = new Util();
   private Driver driver;

   public MyLibrary(Driver driver) throws SQLException {
     Logger logger = driver.getParentLogger();
     logger.info("Started MyLibrary");
   }

}
