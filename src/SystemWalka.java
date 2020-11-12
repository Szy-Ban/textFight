import Bohaterowie.Bohaterowie;
import Magia.Magia;
import Magia.TablicaMagii;
import Runy.Runy;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SystemWalka {


    static Bohaterowie[] teamini = new Bohaterowie[Team.number];
    int mori = 0;
    boolean alive = true;

    public void walka() throws InterruptedException
    {
        mori = 0;
        alive = true;
        Scanner scanner = new Scanner(System.in);
        TablicaMagii tablicaMagii = new TablicaMagii();
        //Team team = new Team();
        Runy runy = new Runy();
        Sortowanie sortowanie = new Sortowanie();
        Random random = new Random();
        int zyc=0;

        System.arraycopy(Team.team, 0, teamini, 0, Team.number);

        int bard = 0;
        for (Bohaterowie bohaterowie : teamini) {
            if (bohaterowie.klasa.equals("Bard")) {
                bard++;
                System.out.println(bohaterowie.name + " jest bardem. Chowajcie dzieci!");
            }
        }



        Arrays.sort(teamini, sortowanie);




        System.out.println("Pole bitwy");
        System.out.println();

        //tu zaczyna się tura
        while(alive)
        {
            for(int x = 0;x < Walka.potworybitwa.length;x++)
            {
                if(Walka.potworybitwa[x].hp <= 0){ mori++;}
                if (Walka.potworybitwa.length == mori)
                {
                    alive = false;
                    System.out.println("Wygrałeś bitwę");
                    break;
                }
            }

            PoleBitwy.main();

            System.out.println("Kolejność ataku :");


            for (int i = 0; i <= teamini.length - 1; i++) { System.out.println(teamini[i]); }
            for (int i = 0; i <= teamini.length - 1; i++) { if(!alive){break; }

                if (teamini[i].hp > 0)
                {
                    System.out.println("co chcesz zrobić (jesteś teraz " + teamini[i] + ")");
                    System.out.println("1: Atak");
                    System.out.println("2: Zobacz Planszę");
                    System.out.println("3: Zobacz szczegóły");
                    System.out.println("4: Użyj Runy");
                    System.out.println("5: Użyj Magii");
                    int wyb = scanner.nextInt();
                    switch (wyb)
                    {
                        case (1) ->
                                {
                                    System.out.println("Wybierz cel");
                                    int atak = scanner.nextInt(6);
                                    if (Walka.potworybitwa[atak].hp > 0)
                                    {
                                        int obr = (int) ((Math.random() * (teamini[i].atk - 1)) + 1) - Walka.potworybitwa[atak].armor;
                                        if(obr <= 0){obr = 0;}
                                        Walka.potworybitwa[atak].hp = Walka.potworybitwa[atak].hp - obr;
                                        System.out.println("zadałeś potworowi " + Walka.potworybitwa[atak] + " " + obr + " obrażeń");
                                        if (Walka.potworybitwa[atak].hp <= 0)
                                        {
                                            System.out.println("zabiłeś potwora " + Walka.potworybitwa[atak]);
                                            Walka.potworybitwa[atak].hp =0;


                                           /* for(int x = 0;x < Walka.potworybitwa.length;x++)
                                            {
                                                if(Walka.potworybitwa[x].hp <= 0){ mori++;}
                                                if (Walka.potworybitwa.length == mori)
                                                {
                                                    alive = false;
                                                    System.out.println("Wygrałeś bitwę");
                                                    break;
                                                }
                                            }*/
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("ten potwór nie żyję wybierz jeszcze raz");
                                        i--;
                                    }
                                }
                        case (2) -> { PoleBitwy.main();i--; }
                        case(3)->
                                {
                                    PoleBitwy.main();
                                    System.out.println("\ninformacje na temat bohaterów: \n");
                                    for(int a=0;a<= teamini.length-1;a++) { System.out.println(teamini[a].lit +" nazwa: "+teamini[a].name+" klasa: "+teamini[a].klasa+" hp: " + teamini[a].hp + "/" + teamini[a].maxhp+" pkt magii: "+teamini[a].pktmagii); }

                                    System.out.println("\ninformacje na temat potworów: \n");
                                    for(int a=0;a<= Walka.potworybitwa.length-1;a++) { System.out.println(Walka.potworybitwa[a] + " hp: " + Walka.potworybitwa[a].hp + "/" + Walka.potworybitwa[a].maxhp); }
                                    System.out.println();
                                    i--;
                                }
                        case(4)->
                                {
                                    if (teamini[i].type.equals("steel")){

                                        runy.steel();

                                    }
                                    i--;
                                }
                        case(5)->
                                {
                                    if(teamini[i].mage){
                                        switch(teamini[i].type){
                                            case("fire")-> MagiaWWalce.MagiaOgnia();
                                            case("water")-> MagiaWWalce.MagiaWody();
                                            case("wind")-> MagiaWWalce.MagiaWiatru();
                                            case("earth")-> MagiaWWalce.MagiaZiemi();
                                            case("light")-> MagiaWWalce.MagiaSwiatła();
                                            case("blood")-> MagiaWWalce.MagiaKrwi();
                                            case("thunder")-> MagiaWWalce.MagiaBłyskawic();
                                        }
                                        if(!MagiaWWalce.magia){ i--; }
                                        else{MagiaWWalce.magia = false;
                                        teamini[i].pktmagii = teamini[i].pktmagii - MagiaWWalce.pkt;
                                           /* for(int x = 0;x < Walka.potworybitwa.length;x++)
                                            {
                                                if(Walka.potworybitwa[x].hp <= 0){ mori++; }
                                                if (mori == Walka.potworybitwa.length)
                                                {
                                                    alive = false;
                                                    System.out.println("Wygrałeś bitwę");
                                                    break;
                                                }
                                            }*/
                                            }

                                    }
                                    else{
                                        System.out.println("nie jesteś magiem");
                                        i--;
                                    }
                                }
                        default ->
                                {
                                    System.out.println("nie ma takiej opcji");
                                    i--;
                                }
                    }
                }
            }
            if(!alive){break;}
            System.out.println("Czas na turę potworów");
            for(int i = 0;i<= Walka.potworybitwa.length-1;i++)
            {
                if(!alive){break;}


                if (Walka.potworybitwa[i].hp > 0)
                {
                    int wyb = random.nextInt(2);
                    switch (wyb)
                    {
                        case (0) ->
                                {
                                    int atak = random.nextInt(Team.number);
                                    if (teamini[atak].hp > 0)
                                    {
                                        if(teamini[atak].status.equals("Mgła")){
                                            {if(teamini.length ==1){break;} i--; }}
                                        else{
                                        //zadawanie obrażeń przez potwory
                                        int obr = (int) ((Math.random() * (Walka.potworybitwa[i].atk - 1)) + 1) - teamini[atak].armor;
                                        if(obr <= 0){obr = 0;}
                                        teamini[atak].hp = teamini[atak].hp - obr;

                                        System.out.println("potwór zadał bohaterowi " + teamini[atak] + " " + obr + " obrażen");
                                        Thread.sleep(1000);

                                        //sprawdzenie czy potówr nie zabił bohatera
                                        if (teamini[atak].hp <= 0)
                                        {
                                            System.out.println("potwory zabiły bohatera " + teamini[atak]);
                                            teamini[atak].hp = 0;


                                            for (int a = 0; a <= Team.number - 1; a++)
                                            {
                                                if (teamini[a].hp <= 0) { zyc++; }
                                            }
                                            if (zyc == Team.number)
                                            {
                                                alive = false;
                                                System.out.println("Zostałesz pokonany");
                                                i = Walka.potworybitwa.length - 1;
                                                System.exit(0);
                                            }
                                        }
                                    }
                                    }
                                    else { i--; }
                                }
                        case (1)->     //trzeba zwiększyć ilość licz dla case(0) żeby wszystkie potwory nie uciekały przed bardami + ten case może służyć jako miejsce na specjalne efekty potworów
                                {
                                    if (bard > 0)
                                    {
                                        if (Walka.potworybitwa[i].hp < 10 * bard)
                                        {
                                            Walka.potworybitwa[i].hp = 0;
                                            System.out.println("Bestia usłyszawsza katofonie wykonaną ze strony barda uciekła z pola bitwy");
                                        }
                                        else
                                        {
                                            System.out.println("Potwór usłyszawszy katofonie ze strony barda został oszołomiony");
                                        }
                                    }
                                    else{
                                        i--;
                                    }







                                }
                    }
                }


            }
            if(zyc!=Team.number){
                for (Bohaterowie bohaterowie : teamini) {
                    bohaterowie.status = "";
                }
                System.out.println("Koniec tury potworów czas na twoją");}

        }
        System.out.println("Koniec walki");

    }
}