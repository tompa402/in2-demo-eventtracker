(function ($) {
    "use strict";
    // Scroll to top button appear
    $(document).on('scroll', function () {
        var scrollDistance = $(this).scrollTop();
        if (scrollDistance > 100) {
            $('.scroll-to-top').fadeIn();
        } else {
            $('.scroll-to-top').fadeOut();
        }
    });

// Smooth scrolling using jQuery easing
    $(document).on('click', 'a.scroll-to-top', function (e) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: ($($anchor.attr('href')).offset().top)
        }, 1000, 'easeInOutExpo');
        e.preventDefault();
    });
})(jQuery);

$("#search-option").on('change', function () {
    var formElements = ["name-div", "start-date-div", "end-date-div", "free-entry-div", "location-div"];
    var selectedValue = $(this).find(':selected').val();
    if (selectedValue === "") {
        $("#searchForm").hide();
    } else {
        $("#searchForm").show();
        $("#" + selectedValue).show();
    }

    formElements.forEach(function (value) {
        if (value !== selectedValue) {
            $("#" + value).hide();
        }
    });
});