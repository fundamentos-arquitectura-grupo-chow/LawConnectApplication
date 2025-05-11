package upc.LoremIpsum.lawconnectplatform.communication.domain.services;

import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.Appointment;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.queries.GetAllAppointmentsByConsultationIdQuery;

import java.util.List;

public interface AppointmentQueryService {
    List<Appointment> handle(GetAllAppointmentsByConsultationIdQuery query);
}
