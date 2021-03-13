abstract class Method {
   boolean completed;
   int threadId;
   Method(int t) {
      threadId = t;
   }
   protected void log(String s) {
      System.out.println(threadId + " " + getName() + " " + s);
   }
   public abstract void step();
   public abstract String getName();
   public boolean isCompleted() {
      return completed;
   }
}
