$(document).ready(function () {
    $('select').formSelect();
    $('.datepicker').datepicker({
    	format: 'yyyy-mm-dd',
    	disableWeekends: /*[[${finesDeSemanaEstado}]]*/ 'true',
    	firstDay: 1,
    	minDate: new Date(),
    });
    $('.timepicker').timepicker({
    	twelveHour: false
    });
    $('.materialboxed').materialbox();
});
var instance = M.Timepicker.getInstance(elem);