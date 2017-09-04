package app.a;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import platform.api.ContainerApplication;

import app.a.internal.Worker;

public class AppA implements ContainerApplication {

  ScheduledExecutorService executor;
  ScheduledFuture<?> scheduledFuture;

  public void startApp() {
    System.out.println("Starting App A");
    executor = Executors.newScheduledThreadPool(1);
    scheduledFuture =
      executor.scheduleAtFixedRate(new Worker(), 2L, 12L, TimeUnit.SECONDS);
  }

  public void stopApp() {
    scheduledFuture.cancel(false);
    executor = null;
    System.out.println("Stopping App A");
  }

}
