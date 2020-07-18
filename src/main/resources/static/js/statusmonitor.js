$(document).ready(function(){
    var progressbar = $( "#progressbar" );
    var progressLabel = $( ".progress-label" );

    progressbar.progressbar({
      value: false,
      change: function() {
        progressLabel.text( "Reloading " + progressbar.progressbar( "value" ) + "%" );
      },
      complete: function() {
        progressLabel.text( "Complete!" );
      }
    });

    function progress() {
      var val = progressbar.progressbar( "value" ) || 0;

      progressbar.progressbar( "value", val + 2 );

      if ( val < 99 ) {
        if (val < 50) {
        $("#div1").html("<div id=\"div1\"><h2>smaller 50</h2></div>");
        } else {
          $("#div1").html("<div id=\"div1\"><h2>bigger 50</h2></div>");
        }
        setTimeout( progress, 200 );
      }
    }

    setTimeout( progress, 2000 );

  $("button").click(function(){
    $.ajax({url: "/update", success: function(result){


      if (result == "true") {

        progressbar.progressbar( "value", 0 );
        //setTimeout( progress, 200 );
        $("#div1").html("<div id=\"div1\"><h2>true data</h2></div>");
      } else {

        progressbar.progressbar( "value", 0 );
        //setTimeout( progress, 200 );
        $("#div1").html("<div id=\"div1\"><h2>false data</h2></div>");
      }
    }});
  });
});




