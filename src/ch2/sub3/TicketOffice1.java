package ch2.sub3;

public class TicketOffice1 implements Runnable {
    private Cinema cinema;

    public TicketOffice1(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        cinema.sellTickets1(1);
        cinema.sellTickets1(1);
        cinema.returnTickets1(1);
        cinema.returnTickets2(1);
        long vacanciesCinema1 = cinema.getVacanciesCinema1();
        long vacanciesCinema2 = cinema.getVacanciesCinema2();
    }
}
