module platform.container {
  requires platform.api;

  provides platform.api.tx.TransactionManager
      with platform.container.tx.SimpleTransactionManager;
}
