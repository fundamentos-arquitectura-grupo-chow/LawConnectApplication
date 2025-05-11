package upc.LoremIpsum.lawconnectplatform.consultation.domain.model.commands;

public record CreatePaymentByConsultationIdCommand(
        Long consultationId,
        Double amount,
        Integer currency
)
{
}
