//"chatbot" to recommend classical music based off user preferences
import java.util.*;
import java.io.*;

public class BeethovenBot {
    //initialize trees for two, arraylists for two
    static ArrayList<String> cListS = new ArrayList<String>();
    static ArrayList<String> cListR = new ArrayList<String>();
    static ArrayList<String> uListD = new ArrayList<String>();
    static ArrayList<String> uListH = new ArrayList<String>();
    static ArrayList<String> dList = new ArrayList<String>();
    static ArrayList<String> sList = new ArrayList<String>();
    static ArrayList<String> surprise = new ArrayList<String>();
    //to read user input in the menu
    Scanner userChoice; 

    public void fileRead() {
       
    }

    public BeethovenBot() {
        userChoice = new Scanner (System.in);
        int index;
        Random ran = new Random();
        String piece;
        while (true) {
            switch (menu()){
                case 1:
                    System.out.println("Would you prefer 1) Studious or 2) Romantic?");
                    int decision = userChoice.nextInt();
                    if (decision == 1)
                    {
                        index = ran.nextInt(cListS.size() - 1);
                        piece = cListS.get(index);
                        System.out.println("I recommend " + piece);
                    }

                    else
                    {
                        index = ran.nextInt(cListR.size() - 1);
                        piece = cListR.get(index);
                        System.out.println("I recommend " + piece);
                    }
                    break;

                case 2:
                    index = ran.nextInt(dList.size() - 1);
                    piece = dList.get(index);
                    System.out.println("I recommend " + piece);
                    break;

                case 3:
                    System.out.println("Would you prefer 1) Danceable or 2) Happy?");
                    decision = userChoice.nextInt();
                    if (decision == 1)
                    {
                        index = ran.nextInt(uListD.size() - 1);
                        piece = uListD.get(index);
                        System.out.println("I recommend " + piece);
                    }

                    else
                    {
                        index = ran.nextInt(uListH.size() - 1);
                        piece = uListH.get(index);
                        System.out.println("I recommend " + piece);
                    }
                    break;

                case 4:
                    index = ran.nextInt(sList.size() - 1);
                    piece = sList.get(index);
                    System.out.println("I recommend " + piece);
                    break;

                case 5:
                    surprise.addAll(cListS);
                    surprise.addAll(cListR);
                    surprise.addAll(uListD);
                    surprise.addAll(uListH);
                    surprise.addAll(sList);
                    surprise.addAll(dList);

                    index = ran.nextInt(surprise.size() - 1);
                    piece = surprise.get(index);
                    System.out.println("I recommend " + piece);
                    break;

                case 6:
                    userChoice.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public int menu() {
        System.out.println("Hello, welcome to the Beethoven Bot! Below are 5 overall moods.");
        System.out.println("1) Calm");
        System.out.println("2) Dramatic");
        System.out.println("3) Upbeat");
        System.out.println("4) Sad");
        System.out.println("5) Surprise me!");
        System.out.println("6) Quit");

        System.out.println("Please select an overall mood: ");
        int n = userChoice.nextInt();

        return n;
    }

    public static void main(String[] args) throws Exception {
        //to read the files with the piece recommendations
        BufferedReader calmFile = new BufferedReader (new FileReader("calm.txt"));
        BufferedReader romanticFile = new BufferedReader (new FileReader("romantic.txt"));
        BufferedReader upbeatFile = new BufferedReader (new FileReader("upbeat.txt"));
        BufferedReader happyFile = new BufferedReader (new FileReader("happy.txt"));
        BufferedReader dramaticFile = new BufferedReader (new FileReader("dramatic.txt"));
        BufferedReader sadFile = new BufferedReader (new FileReader("sad.txt"));
        String line;
        String word1;
        String word2;

        while (calmFile.ready())
        {
            cListS.add(calmFile.readLine());
            /*System.out.println(calmFile.readLine());
            line = calmFile.readLine();
            word1 = "Studious";
            word2 = "Romantic";
            while (!(line.equals(word1)))
            {
                System.out.println(calmFile.readLine());
                if (line.equals(word2))
                {
                    break;
                }
            }

            while (!(line.equals(word2)))
            {
                System.out.println(line);
            }*/
        }
            
        while (romanticFile.ready())
        {
            cListR.add(romanticFile.readLine());
        }

        //reading from upbeatFile and adding to different lists based on keywords
        while (upbeatFile.ready() )
        {
            uListD.add(upbeatFile.readLine());
            /*line = upbeatFile.readLine();
            word1 = "Danceable";
            word2 = "Happy";
            while (!(line.equals(word1)))
            {
                System.out.println(upbeatFile.readLine());
                if (line.equals(word2))
                {
                    break;
                }
            }

            while (!(line.equals(word2)))
            {
                System.out.println(line);
            }*/
        }
        while (happyFile.ready())
        {
            uListH.add(happyFile.readLine());
        }

        //reading from dramaticFile and adding to dList
        while (dramaticFile.ready())
        {
            dList.add(dramaticFile.readLine());
        }

        //reading from sadFile and adding to sList
        while (sadFile.ready())
        {
            sList.add(sadFile.readLine());
        }

       calmFile.close();
       upbeatFile.close();
       dramaticFile.close();
       sadFile.close();
       
       new BeethovenBot();
    }
}
