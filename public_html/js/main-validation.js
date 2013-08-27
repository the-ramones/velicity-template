/*
 * Add a custom validation method
 * @param {type} param1
 * @param {type} param2
 */
$.validator.addMethod("reportdate", function(value, element) {

    /*
     * if pass the regexp, verify correctness of the date 
     * valid: 31 Jan 2010 or 29 Dec 2012 
     * invalid: 29 Dec 2013 or 31 Mar 2013
     */
    result = this.optional(element) || /(0?[1-9]|[12][0-9]|3[01]) (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec){1} \d{4}$/i.test(value);

    if (result === true) {
        parts = value.split(' ');
        var day = parts[0];
        var month = parts[1];
        if (/^Feb$/i.test(month)) {
            if (day == 29) {
                if (day % 4 !== 0 || day % 100 === 0 || day % 400 !== 0) {
                    return false;
                }
                ;
            } else if (day > 28) {
                return false;
            }
        }
        if (/^(Apr|Jun|Sep|Nov){1}$/i.test(month)) {
            if (day > 30) {
                return false;
            }
        } else {
            if (day > 31) {
                return false;
            }
        }
    }
    return result;
});

// english version:
// /(0?[1-9]|[12][0-9]|3[01])(Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec){1}\d{4}$/i
// russian version
// /(0?[1-9]|[12][0-9]|3[01])(Янв|Дек|Мар|Апр|Май|Июн|Июл|Авг|Сен|Окт|Ноя|Дек){1}\d{4}$/i
// YYYY-MM-DD (ISO date)
// ^((((19|20)(([02468][048])|([13579][26]))-02-29))|((20[0-9][0-9])|(19[0-9][0-9]))-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))$

$("form[name='report-add']").validate({
    lang: 'ru',
    debug: true,
    rules: {
        startDate: {required: true,
            reportdate: true
        },
        endDate: {
            reportdate: true
        },
        performer: {
            required: true,
            rangelength: [1, 255]
        },
        activity: {
            required: true,
            rangelength: [1, 255]
        }
    }
});

$("form[name='search-report']").validate({
    lang: 'en',
    debug: true,
    rules: {
        id: {
            required: true,
            digits: true,
            min: 1
        }
    }
});