$(document).ready(function() {
    /*
     * Actions on search box interactions
     */
    $(".subnav").on("click", "a", function() {
        console.log("enter onclick");
        $("input[name='search']").val($(this).text());
        $(".subnav li").css({
            visibility: 'hidden'});
        console.log("enter onclick");
    });
    console.log("go-go-og   ");
    $("input[name='search']").keydown(function(event) {
        var key = event.which;
        console.log(key);
        var lis = $(".subnav li");
        var search = $("input[name='search']");
        if (lis.size() > 0) {
            if ([34, 39, 40].indexOf(key) !== -1) {
                var selected = lis.filter(".selected");
                console.log("selected exists: " + selected.length);
                if (selected.length) {
                    if (!selected.is(":last-child")) {
                        selected.removeClass("selected");
                        console.log(selected.next().html());
                        selected = selected.next();
                        selected.addClass("selected");
                        console.log(selected.find("a").text());
                    }
                } else {
                    selected = lis.first();
                    selected.addClass("selected");
                }
                search.val(selected.find("a").text());
                console.log(event);
            }
            else if ([33, 37, 38].indexOf(key) !== -1) {
                var selected = lis.filter(".selected");
                console.log("selected exists: " + selected.length);
                if (selected.length) {
                    if (!selected.is(":first-child")) {
                        selected.removeClass("selected");
                        console.log(selected.prev().html());
                        selected = selected.prev();
                        selected.addClass("selected");
                        console.log(selected.find("a").text());
                    }
                } else {
                    selected = lis.last();
                    selected.addClass("selected");
                }
                search.val(selected.find("a").text());
                console.log(event);
            }
        }
    });
    $("input[name='search']").keypress(function(event) {
        if ($(".subnav li").size() === 1) {
            for (var i = 0; i < 3; i++) {
                $(".subnav li").clone().appendTo($(".subnav"));
                console.log("added");
            }
            console.log("entered");
        }
        console.log("pass");
        $(".subnav li").css({
            visibility: 'visible',
            top: '120%',
            opacity: "1",
            transition: "all"
        });
    });
});

