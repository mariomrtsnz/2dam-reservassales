$(document).ready(function () {
    $('#calendar').fullCalendar({
        editable: false,
        defaultView: 'agendaWeek',
        eventLimit: true,
        header: {
            left: '',
            center: 'title',
        },
        minTime: '08:00:00',
        maxTime: '22:00:00',
        locale: 'es',
        displayEventTime: true,
        events: {
        	url: '/events',
        	type: 'GET',
        	error: function() {
        		alert('Error al coger los eventos');
        	},
        },
        eventClick: function(event, element) {
        	editEvent(event, element);
        }
    });
});

function editEvent(event, elements) {
	window.location.href = `/admin/editar-reserva/${event.id}`;
//	alert ("ID:" + event.id + "  EventStart  " + eventStart + "   " + eventEnd + "   " + event.end);
}