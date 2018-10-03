$(document).ready(function () {
    $('select').formSelect();
    $('.datepicker').datepicker({
    	format: 'yyyy-mm-dd',
    });
    $('.timepicker').timepicker({
    	twelveHour: false
    });
    $('.materialboxed').materialbox();
});
var instance = M.Timepicker.getInstance(elem);