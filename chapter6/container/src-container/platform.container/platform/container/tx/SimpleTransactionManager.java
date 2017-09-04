package platform.container.tx;

import java.util.concurrent.atomic.AtomicLong;
import platform.api.tx.TransactionManager;

public class SimpleTransactionManager implements TransactionManager {

  private AtomicLong nextTxId = new AtomicLong();

  @Override
  public long start() {
    return nextTxId.getAndIncrement();
  }

  @Override
  public void commit(long txId) {
    if(txId >= nextTxId.get())
      throw new IllegalStateException("Cannot commit tx with unknown id " + txId);

    System.out.println("Committing tx with id " + txId);
  }

  @Override
  public void rollback(long txId) {
    if(txId >= nextTxId.get())
      throw new IllegalStateException("Cannot rollback tx with unknown id " + txId);

    System.out.println("Rolling back tx with id " + txId);
  }

}
