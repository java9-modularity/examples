module easytext.analysis.coleman {
   requires easytext.analysis.api;

   provides javamodularity.easytext.analysis.api.Analyzer with javamodularity.easytext.analysis.coleman.Coleman;
}
