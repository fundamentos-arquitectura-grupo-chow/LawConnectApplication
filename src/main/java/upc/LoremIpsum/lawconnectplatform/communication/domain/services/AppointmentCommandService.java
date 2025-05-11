package upc.LoremIpsum.lawconnectplatform.communication.domain.services;


import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.Appointment;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.CreateAppointmentCommand;

import java.util.Optional;

public interface AppointmentCommandService {
    Optional<Appointment> handle(CreateAppointmentCommand command);
}
