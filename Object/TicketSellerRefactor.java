
public class TicketSellerRefactor {
	private TicketOffice ticketOffice;
	
	public TicketSellerRefactor(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}
	
//	public TicketOffice getTicketOffice() {
//		return ticketOffice;
//	}
	
	public void sellTo(Audience audience) {
//		인터페이스 요소만 남김
//		if (audience.getBag().hasInvitation()) {
//			Ticket ticket = ticketOffice.getTicket();
//			audience.getBag().setTicket(ticket);
//		} else {
//			Ticket ticket = ticketOffice.getTicket();
//			audience.getBag().minusAmount(ticket.getFee());
//			ticketOffice.plusAmount(ticket.getFee());
//			audience.getBag().setTicket(ticket);
//		}
		ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
	}
}
