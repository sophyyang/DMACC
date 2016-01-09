/*
 * Author: Sophy Yang
 * Date: 2016-01-09
 */

public class TicketOrdering {
	private int ticketBalance;
	final int MAX_TICKET = 6;
	final String lines = "======================";
	private String errorMsg;
	private String overMax = MAX_TICKET + " is the max available per order. " ;
	private String noValidOrder= "You must ener a valid posistive number up to 6";

	public TicketOrdering(int b) {
		this.ticketBalance = b;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public int getTicketBalance() {
		return ticketBalance;
	}

	public void setTicketBalance(int ticketBalance) {
		this.ticketBalance = ticketBalance;
	}

	public int getMAX_TICKET() {
		return MAX_TICKET;
	}

	public void decreaseTicket(int b) {
		this.setErrorMsg(lines);
		if (this.getTicketBalance() == 0) {
			this.setErrorMsg("      " + this.getTicketBalance() + " tickets remaining.       ");
		} else {
		if (b <= 0) {
			this.setErrorMsg(noValidOrder);
		} else {

			if (b <= MAX_TICKET) {
				if (b > this.ticketBalance) {
					this.setErrorMsg("Only " + this.getTicketBalance() + " tickets remaining.");
				} else {
					this.setTicketBalance(this.getTicketBalance() - b);
					this.setErrorMsg(b + " tickets purchased, " + this.getTicketBalance() + " tickets remaining.");
				}

			} else {
				this.setErrorMsg(overMax + this.getTicketBalance() + " tickets remaining.");
			}
		}
	}
	}
}
