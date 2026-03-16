package trivia;

import java.util.ArrayList;
import java.util.LinkedList;

// REFACTOR ME
public class Game implements IGame {
   ArrayList<Player> players = new ArrayList<>();

   LinkedList<String> popQuestions = new LinkedList<>();
   LinkedList<String> scienceQuestions = new LinkedList<>();
   LinkedList<String> sportsQuestions = new LinkedList<>();
   LinkedList<String> rockQuestions = new LinkedList<>();

   int currentPlayer = 0;
   boolean isGettingOutOfPenaltyBox;

   public Game() {
      for (int i = 0; i < 50; i++) {
         popQuestions.addLast("Pop Question " + i);
         scienceQuestions.addLast(("Science Question " + i));
         sportsQuestions.addLast(("Sports Question " + i));
         rockQuestions.addLast(createRockQuestion(i));
      }
   }

   public String createRockQuestion(int index) {
      return "Rock Question " + index;
   }

   public boolean isPlayable() {
      return (howManyPlayers() >= 2);
   }

   public boolean add(String playerName) {

      Player player = new Player(playerName);
      players.add(player);

      System.out.println(playerName + " was added");
      System.out.println("They are player number " + players.size());
      return true;
   }

   public int howManyPlayers() {
      return players.size();
   }

   public void roll(int roll) {
      System.out.println(currentPlayer().name + " is the current player");
      System.out.println("They have rolled a " + roll);

      if (currentPlayer().inPenaltyBox){
         if (roll % 2 != 0) {
            isGettingOutOfPenaltyBox = true;

            System.out.println(currentPlayer().name + " is getting out of the penalty box");
            printRoll(roll);
         } else {
            System.out.println(currentPlayer().name + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
         }

      } else {

         printRoll(roll);
      }

   }

   private void printRoll(int roll) {
      Player player = currentPlayer();

      player.place = player.place + roll;
      if (player.place > 12) player.place = player.place - 12;

      System.out.println(player.name
              + "'s new location is "
              + player.place);

      System.out.println("The category is " + currentCategory());
      askQuestion();
   }

   private void askQuestion() {
      String category = currentCategory();

      switch (category) {
         case "Pop":
            System.out.println(popQuestions.removeFirst());
            break;
         case "Science":
            System.out.println(scienceQuestions.removeFirst());
            break;
         case "Sports":
            System.out.println(sportsQuestions.removeFirst());
            break;
         case "Rock":
            System.out.println(rockQuestions.removeFirst());
            break;
      }
   }


   private String currentCategory() {
      int position = (currentPlayer().place - 1) % 4;

      switch (position) {
         case 0:
            return "Pop";
         case 1:
            return "Science";
         case 2:
            return "Sports";
         default:
            return "Rock";
      }
   }

   public boolean handleCorrectAnswer() {
      if (currentPlayer().inPenaltyBox) {
         if (isGettingOutOfPenaltyBox) {
            return printCorrect();
         } else {
            nextPlayer();
            return true;
         }


      } else {

         return printCorrect();
      }
   }

   private boolean printCorrect() {
      System.out.println("Answer was correct!!!!");
      Player player = currentPlayer();
      player.purse++;
      System.out.println(currentPlayer().name
                         + " now has "
                         + player.purse
                         + " Gold Coins.");

      boolean winner = didPlayerWin();
      nextPlayer();

      return winner;
   }

   public boolean wrongAnswer() {
      System.out.println("Question was incorrectly answered");
      System.out.println(currentPlayer().name + " was sent to the penalty box");
      currentPlayer().inPenaltyBox = true;

      nextPlayer();
      return true;
   }

   private void nextPlayer() {
      currentPlayer++;
      if (currentPlayer == players.size()) {
         currentPlayer = 0;
      }
   }

   private boolean didPlayerWin() {
      return !(currentPlayer().purse == 6);
   }

   private Player currentPlayer() {
      return players.get(currentPlayer);
   }
}
