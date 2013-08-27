var date = "14 Aug 2013";
var optional = false;
function validate(optional, value) {
    var result = optional || /(0?[1-9]|[12][0-9]|3[01]) (Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec){1} \d{4}$/i.test(value);
    /*
     * if pass the regexp, verify correctness of the date 
     * valid: 31 Jan 2010 or 29 Dec 2012 
     * invalid: 29 Dec 2013 or 31 Mar 2013
     */
    console.log(result);
    if (result) {
        var parts = value.split(' ');
        var day = parts[0];
        var month = parts[1];
        console.log(day);
        console.log(month);
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
}

//tests
console.log("true:");
validate(date);
validate(false, "01 jan 2013");
validate(false, "31 Jun 2010");
console.log("false:");
validate(false, "223 Ja 0201");
validate(false, "2 Hec 2010");
validate(false, "Jan 02 2013");

