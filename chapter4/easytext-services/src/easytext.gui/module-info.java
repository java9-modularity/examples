module easytext.gui {

   exports javamodularity.easytext.gui to javafx.graphics;

   requires javafx.graphics;
   requires javafx.controls;
   requires easytext.analysis.api;

   uses javamodularity.easytext.analysis.api.Analyzer;
}
