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

$.fn.datetimepicker.Constructor.Default = $.extend({}, $.fn.datetimepicker.Constructor.Default, {
    // icons: {
    //     time: 'far fa-clock',
    //     date: 'far fa-calendar',
    //     up: 'far fa-arrow-up',
    //     down: 'far fa-arrow-down',
    //     previous: 'far fa-chevron-left',
    //     next: 'far fa-chevron-right',
    //     today: 'far fa-calendar-check-o',
    //     clear: 'far fa-trash',
    //     close: 'far fa-times'
    // }
    locale: 'hr'
});
$( document ).ready(function() {
    var startDateSelector = $('#startDate');
    var endDateSelector = $('#endDate');

    var start = moment(startDateSelector.val(), 'dd.mm.yyyy hh:mm a').toDate();
    var end = moment(endDateSelector.val(), 'dd.mm.yyyy hh:mm a').toDate();

    startDateSelector.datetimepicker({
        date: start,
        sideBySide: true
    });
    endDateSelector.datetimepicker({
        date: end,
        useCurrent: false,
        sideBySide: true
    });

    startDateSelector.on("change.datetimepicker", function (e) {
        $('#endDate').datetimepicker('minDate', e.date);
    });
    endDateSelector.on("change.datetimepicker", function (e) {
        $('#startDate').datetimepicker('maxDate', e.date);
    });
});

