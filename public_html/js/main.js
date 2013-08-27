/*
 * Custom UI callbacks
 */
function wider() {
    $('div#article').animate({"width": "90%"});
}

/*
 * jQuery layout enhancements
 */
$(document).ready(function() {
    $('#hide_btn').click(function() {
        $(".aside").hide('slow');
        setTimeout(wider, 600);
    });
    $('#facebook').mouseenter(function() {
        $(this).addClass("facebook-active");
    }).mouseleave(function() {
        $(this).removeClass("facebook-active").addClass("facebook-dark");
    });
    $('#twitter').mouseenter(function() {
        $(this).addClass("twitter-active");
    }).mouseleave(function() {
        $(this).removeClass("twitter-active").addClass("twitter-dark");
    });
    $('#google').mouseenter(function() {
        $(this).addClass("google-active");
    }).mouseleave(function() {
        $(this).removeClass("google-active").addClass("google-dark");
    });
    /*
     * if (!Modernizr.inputtypes['date']) {
     *    $('input[type=date]').datepicker();   
     * }
     */    
    $('input[name="startDate"]').datepicker({dateFormat: "dd M yy"});
    $('input[name="endDate"]').datepicker({dateFormat: "dd M yy"});
});

