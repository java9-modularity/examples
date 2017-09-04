module easytext.algorithm.coleman {

   requires easytext.algorithm.api;

   provides javamodularity.easytext.algorithm.api.Analyzer
       with javamodularity.easytext.algorithm.coleman.ColemanAnalyzer;

}
