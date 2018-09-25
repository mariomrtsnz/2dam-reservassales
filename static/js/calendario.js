$(function() {
    $('#calendar').fullCalendar({
        editable: true,
        weekends: false,
        defaultView: 'agendaWeek',
        header: {
            left: '',
            center: 'title',
        },
        minTime: '08:00:00',
        maxTime: '22:00:00',
        locale: 'es',
        displayEventTime: true
    })
});