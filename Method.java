abstract class Method {
   boolean completed;
   int threadId;
   Method(int t) {
      threadId = t;
   }
   protected void log(String s) {
      String indent = new String();
      for(int i = 0; i < getIndent(); i++) {
         indent += " ";
      }
      System.out.println(threadId + indent + " " + getName() + " " + s);
   }
   public abstract void step();
   public abstract String getName();
   public boolean isCompleted() {
      return completed;
   }
   public int getIndent() {
      return 0;
   }
}
