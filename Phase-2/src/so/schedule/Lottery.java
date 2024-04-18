package so.schedule;

import so.Process;
import so.Ticket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Lottery extends SchedulerQueue {

    public Lottery() {
        super(new Comparator<Process>() {
            @Override
            public int compare(Process sp1, Process sp2) {
                Random rd = new Random();
                List<Ticket> tickets = new ArrayList<>();
                Ticket[] sp1Ticket = sp1.getTicket();
                Ticket[] sp2Ticket = sp2.getTicket();
                for (int i = 0; i < sp1Ticket.length; i++) {

                    if (sp1Ticket[i] != null) {
                        tickets.add(sp1Ticket[i]);
                    }

                }
                for (int i = 0; i < sp2Ticket.length; i++) {

                    if (sp2Ticket[i] != null) {
                        tickets.add(sp2Ticket[i]);
                    }

                }
                Ticket luckyTicket = tickets.get(rd.nextInt(tickets.size()));
                System.out.println("");
                System.out.println("BILHETE PREMIADO : " + luckyTicket.getValue());

                for (int i = 0; i < sp1Ticket.length; i++) {

                    if (sp1Ticket[i] == luckyTicket) {
                        System.out.println("PARABÉNS " + sp1.getId());
                        return -1;
                    }

                }
                for (int i = 0; i < sp2Ticket.length; i++) {

                    if (sp2Ticket[i] == luckyTicket) {
                        System.out.println("PARABÉNS " + sp2.getId());
                        return 1;
                    }
                }
                return 0;
            }
        });
    }

}