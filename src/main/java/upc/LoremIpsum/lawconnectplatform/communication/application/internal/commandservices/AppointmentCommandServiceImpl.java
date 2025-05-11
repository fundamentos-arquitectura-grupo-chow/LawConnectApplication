package upc.LoremIpsum.lawconnectplatform.communication.application.internal.commandservices;

import upc.LoremIpsum.lawconnectplatform.communication.application.internal.outboundServices.ExternalConsultationCommunicationService;
import upc.LoremIpsum.lawconnectplatform.communication.application.internal.outboundServices.ExternalFollowUpCommunicationService;
import upc.LoremIpsum.lawconnectplatform.communication.application.internal.outboundServices.ExternalPaymentCommunicationService;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.aggregates.Appointment;
import upc.LoremIpsum.lawconnectplatform.communication.domain.model.commands.CreateAppointmentCommand;
import upc.LoremIpsum.lawconnectplatform.communication.domain.services.AppointmentCommandService;
import upc.LoremIpsum.lawconnectplatform.communication.infrastructure.persistence.jpa.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentCommandServiceImpl implements AppointmentCommandService {

    private final AppointmentRepository appointmentRepository;
    private final ExternalConsultationCommunicationService externalConsultationCommunicationService;
    private final ExternalFollowUpCommunicationService externalFollowUpCommunicationService;
    private final ExternalPaymentCommunicationService externalPaymentCommunicationService;

    public AppointmentCommandServiceImpl(AppointmentRepository appointmentRepository, ExternalConsultationCommunicationService externalConsultationCommunicationService, ExternalFollowUpCommunicationService externalFollowUpCommunicationService, ExternalPaymentCommunicationService externalPaymentCommunicationService) {
        this.appointmentRepository = appointmentRepository;
        this.externalConsultationCommunicationService = externalConsultationCommunicationService;
        this.externalFollowUpCommunicationService = externalFollowUpCommunicationService;
        this.externalPaymentCommunicationService = externalPaymentCommunicationService;
    }

    @Override
    public Optional<Appointment> handle(CreateAppointmentCommand command) {

        var consultation = externalConsultationCommunicationService.getConsultationById(command.consultationId());

        if (consultation.isEmpty()) {
            throw new IllegalArgumentException("Consultation not found");
        }
        var appointment = new Appointment(command, consultation.get());

        appointmentRepository.save(appointment);

        var message = command.description() + " - " + command.location();

        externalFollowUpCommunicationService.createNotification(
                "Appointment created",
                message,
                consultation.get().getClientId(),
                consultation.get().getId()
        );

        return Optional.of(appointment);
    }
}
