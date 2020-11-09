import Bohaterowie.Bohaterowie;
import Potwory.TablicaPotworów;
import Bohaterowie.TablicaBohaterów;
import java.util.*;

public class Start {




    //static Bohaterowie[] team = new Bohaterowie[6];
    //Bohaterowie[] drużyna = new Bohaterowie[number];
    static int number = 0;



    public static void start() {


        Scanner myScanner = new Scanner(System.in);

        Team  team = new Team();
        TablicaBohaterów tablicaBohaterów = new TablicaBohaterów();
        TablicaPotworów tablicaPotworów = new TablicaPotworów();
        Bohaterowie[] kopiaboh = tablicaBohaterów.boh;
        Collections.shuffle(Arrays.asList(kopiaboh));
        Bohaterowie[] karczma = new Bohaterowie[12];
        System.arraycopy(kopiaboh, 0, karczma, 0, 12);

        System.out.println("Jesteś w karczmie wybierz bohaterów aby utworzyć drużynę.\n");
        //int number = 0;

        Bohaterowie[] dru = team.team;
        //Bohaterowie[] team = new Bohaterowie[6];
        boolean dosc = false;
        do {
            System.out.println("╔═══════════════════════════════╗");
            System.out.println("║   Liczba osób w drużynie: "+number+"   ║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ A • Dodaj członka drużyny     ║");
            System.out.println("║ B • Wyświetl aktualną drużynę ║");
            System.out.println("║ C • Zakończ i wyrusz w drogę  ║");
            System.out.println("╚═══════════════════════════════╝");

            char choice = myScanner.next().charAt(0);
            char choice2 = Character.toLowerCase(choice);
            switch (choice2) {
                case ('a') -> {
                    System.out.println("╔═════════════════════════════════╗");
                    System.out.println("║ Osoby znajdujące się w tawernie ║");
                    for (int i = 0; i < karczma.length; i++) {
                        if(karczma[i] != null) {
                            System.out.println("╠═════════════════════════════════╣");
                            System.out.println("║ [" + i + "] " + karczma[i] + "                    ║");
                        }
                    }
                    System.out.println("╚═════════════════════════════════╝");

                    int wyb;
                    do {
                        while (!myScanner.hasNextInt()) {
                            System.out.println("╔══════════════╗");
                            System.out.println("║ To nie numer ║");
                            System.out.println("╚══════════════╝");
                            myScanner.next(); // this is important!
                        }
                        wyb = myScanner.nextInt();
                    } while (wyb < 0);
                    if (wyb <= karczma.length-1) {
                        if (karczma[wyb] != null)
                        {
                            team[number] = karczma[wyb];
                            karczma[wyb] = null;
                            number++;
                        }
                        else
                        {
                            System.out.println("╔════════════════════════════════════════╗");
                            System.out.println("║       Postać została już wybrana.      ║");
                            System.out.println("╚════════════════════════════════════════╝");
                        }

                        if (number == 6) dosc = true;

                    }
                    else {
                        System.out.println("╔════════════════════════════════════════╗");
                        System.out.println("║ Nie ma takiej opcji! Spróbuj ponownie. ║");
                        System.out.println("╚════════════════════════════════════════╝");
                    }
                }
                case ('b') -> {
                    if (number == 0) System.out.println("Musisz mieć przynajmiej jednego członka w drużynie");
                    else {
                        System.out.println("╔══════════════════╗");
                        System.out.println("║ Twoja drużyna    ║");
                        System.out.println("╠══════════════════╣");
                        for (int i = 0; i < number; i++) {
                            int p1=i+1;
                            System.out.println("║ [" + p1 + "] • " + dru[i]+"   ║");
                        }
                        System.out.println("╚══════════════════╝");
                    }
                }
                case ('c') -> {
                    if (number == 0) System.out.println("Musisz mieć przynajmiej jednego członka w drużynie");
                    else {
                        dosc = true;


                    }

                }
                default -> {
                    System.out.println("╔════════════════════════════════════════╗");
                    System.out.println("║ Nie ma takiej opcji! Spróbuj ponownie. ║");
                    System.out.println("╚════════════════════════════════════════╝");
                }}


        }while (!dosc);
        System.out.println("╔══════════════════╗");
        System.out.println("║ Twoja drużyna    ║");
        System.out.println("╠══════════════════╣");
        for (int i = 0; i < number; i++) {
            int p1=i+1;
            System.out.println("║ [" + p1 + "] • " + dru[i]+"   ║");
        }
        System.out.println("╚══════════════════╝");
/*
        System.out.println("╔══════════╗");
        System.out.println("║     "+walkaE.showhp()+"/"+walkaE.maxHP+"     ║");
        System.out.println("║ - - - -  ║");
        System.out.println("║   "+walkaB.showhp()+"/"+walkaB.maxHP+"      ║");
        System.out.println("╚══════════╝");
        System.out.println();

*/

            System.out.println("╔═════════╦═════════╦═════════╗");
            System.out.println("║  " + tablicaPotworów.potwory[4].hp + "/" + tablicaPotworów.potwory[4].maxhp + "  ║  " + tablicaPotworów.potwory[2].hp + "/" + tablicaPotworów.potwory[2].maxhp + "  ║  " + tablicaPotworów.potwory[1].hp + "/" + tablicaPotworów.potwory[1].maxhp + "  ║");
            System.out.println("║  " + tablicaPotworów.potwory[7].hp + "/" + tablicaPotworów.potwory[7].maxhp + "  ║  " + tablicaPotworów.potwory[3].hp + "/" + tablicaPotworów.potwory[3].maxhp + "  ║  " + tablicaPotworów.potwory[8].hp + "/" + tablicaPotworów.potwory[8].maxhp + "  ║");
            System.out.println("║ -  -  - ║ -  -  - ║ -  -  - ║");

            System.out.print("║  " + team[0].hp + "/" + team[0].maxhp + "  ║  ");
            if(team[1]==null)
            {
                System.out.print("       ║");
            }
            else
            {
                System.out.print(team[1].hp + "/" + team[1].maxhp + "  ║  ");
            }
        if(team[2]==null)
        {
            System.out.println("       ║");
        }
        else
        {
            System.out.println(team[2].hp + "/" + team[2].maxhp + "  ║  ");
        }
        if(team[3]==null)
        {
            System.out.print("║         ║");
        }
        else
        {
            System.out.print("║  "+team[3].hp + "/" + team[3].maxhp + "  ║  ");
        }
        if(team[4]==null)
        {
            System.out.print("      ║  ");
        }
        else
        {
            System.out.print(team[4].hp + "/" + team[4].maxhp + "  ║  ");
        }
        if(team[5]==null)
        {
            System.out.println("       ║");
        }
        else
        {
            System.out.println(team[5].hp + "/" + team[5].maxhp + "  ║  ");
        }

            System.out.println("╚═════════╩═════════╩═════════╝");
            System.out.println();
        }
    }

