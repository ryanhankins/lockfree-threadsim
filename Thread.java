import java.util.Random;

public class Thread {
   Node head;
   Random rand = new Random();
   Method currentMethod;
   int threadId;
   char currentArgument;
   public Thread(Node h, int id) {
      head = h;
      threadId = id;
   }
   public Method randomMethod() {
      Method m = null;
      currentArgument = (char)(rand.nextInt(26) + 'a');
      switch(rand.nextInt(3)) {
	 case 0:
         m = new Add(head, currentArgument, threadId);
         break;

	 case 1:
         m = new Remove(head, currentArgument, threadId);
         break;

         case 2:
         m = new Contains(head, currentArgument, threadId);
         break;

         case 3:
         System.out.println("no method found");
      }
      return m;
   }
   public void step(int line) {
      if (currentMethod == null) {
         currentMethod = randomMethod();
	 currentMethod.log(line);
      } else {
	currentMethod.step(line);
      }
      if (currentMethod.isCompleted()) {
	 currentMethod = null;
      }
   }
   public boolean betweenMethods() {
      return currentMethod == null;
   }
}
