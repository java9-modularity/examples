package platform.api.tx;

import java.util.Iterator;
import java.util.ServiceLoader;

public interface TransactionManager {

  long start();

  void commit(long txId);

  void rollback(long txId);

  static Iterator<TransactionManager> getTransactionManagers() {
    return ServiceLoader.load(TransactionManager.class).iterator();
  }

}
