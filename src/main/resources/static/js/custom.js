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

$("#region").on('change', function () {
    var selected;
    selected = $(this).val();

    var body = {
        ids : selected
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/v1/organisation-unit",
        data: JSON.stringify(body),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var countySelector= $('#county');

            countySelector.empty();
            $.each(data,function(i,obj)
            {
                $("<option />",{
                    val: obj.id,
                    text: obj.name
                }).appendTo(countySelector);
            });
            countySelector.selectpicker('refresh');
            console.log("SUCCESS : ", data);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
});

$("#region").on('change', function () {
    var selected;
    selected = $(this).val();

    var body = {
        ids : selected
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/v1/organisation-unit",
        data: JSON.stringify(body),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var countySelector= $('#county');

            countySelector.empty();
            $.each(data,function(i,obj)
            {
                $("<option />",{
                    val: obj.id,
                    text: obj.name
                }).appendTo(countySelector);
            });
            countySelector.selectpicker('refresh');
            console.log("SUCCESS : ", data);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
});

$("#county").on('change', function () {
    var selected;
    selected = $(this).val();

    var body = {
        ids : selected
    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/v1/city",
        data: JSON.stringify(body),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var citySelector= $('#city');

            citySelector.empty();
            $.each(data,function(i,obj)
            {
                $("<option />",{
                    val: obj.id,
                    text: obj.name
                }).appendTo(citySelector);
            });
            citySelector.selectpicker('refresh');
            console.log("SUCCESS : ", data);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
});

$("#citySize").on('change', function () {
    var selected;
    selected = $(this).val();

    var selectedCounties = $('#county').val();

    var body = {
        ids : selectedCounties,
        sizeIds: selected


    };

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/v1/city/by-size-and-county",
        data: JSON.stringify(body),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            var citySelector= $('#city');

            citySelector.empty();
            $.each(data,function(i,obj)
            {
                $("<option />",{
                    val: obj.id,
                    text: obj.name
                }).appendTo(citySelector);
            });
            citySelector.selectpicker('refresh');
            console.log("SUCCESS : ", data);
        },
        error: function (e) {
            console.log("ERROR : ", e);
        }
    });
});


$("#reset-button").click(function (e) {
    $('#region').selectpicker('refresh');
    $('#county').selectpicker('refresh');
    $('#citySize').selectpicker('refresh');
    $('#city').selectpicker('refresh');
});


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

