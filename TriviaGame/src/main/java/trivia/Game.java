package trivia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Game implements IGame {
   private final QuestionDeck questionDeck = new QuestionDeck();
   private Board board = new Board();
   ArrayList<Player> players = new ArrayList<>();

   Map<Category, LinkedList<String>> questions = new HashMap<>();

   int currentPlayer = 0;
   boolean isGettingOutOfPenaltyBox;

   public Game() {
      questions.put(Category.POP, new LinkedList<>());
      questions.put(Category.SCIENCE, new LinkedList<>());
      questions.put(Category.SPORTS, new LinkedList<>());
      questions.put(Category.ROCK, new LinkedList<>());
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

      player.place = board.move(player.place, roll);
      if (player.place > 12) player.place = player.place - 12;

      System.out.println(player.name
              + "'s new location is "
              + player.place);

      System.out.println("The category is " + currentCategory().label());
      askQuestion();
   }

   private void askQuestion() {
      Category category = currentCategory();
      System.out.println(questionDeck.drawQuestion(category));
   }


   private Category currentCategory() {
      int position = (currentPlayer().place - 1) % 4;

       return switch (position) {
           case 0 -> Category.POP;
           case 1 -> Category.SCIENCE;
           case 2 -> Category.SPORTS;
           default -> Category.ROCK;
       };
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
