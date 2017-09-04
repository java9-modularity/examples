module easytext.analysis.kincaid {
   requires easytext.analysis.api;

   provides javamodularity.easytext.analysis.api.Analyzer with javamodularity.easytext.analysis.kincaid.FleschKincaid;
}
