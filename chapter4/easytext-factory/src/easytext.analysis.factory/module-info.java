module easytext.analysis.factory {
   requires transitive easytext.analysis.api;
   requires easytext.analysis.kincaid;
   requires easytext.analysis.coleman;

   exports javamodularity.easytext.analysis.factory;
}
