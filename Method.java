abstract class Method {
   boolean completed;
   int threadId;
   int line;
   Method(int t) {
      threadId = t;
   }
   protected void log(int l) {
      line = l;
      log();
   }
   protected void log() {
      log("");
   }
   protected void log(String s) {
      String indent = new String();
      for(int i = 0; i < getIndent(); i++) {
         indent += " ";
      }
      System.out.println(String.format("%1$5s ", line) +
		         threadId + indent + " " + getName() +
		         "(" + getArgStr() + ")" + " " + s);
   }
   public int getLine() {
      return line;
   }
   public String getArgStr() {
      return "";
   }
   public void step(int l) {
      line = l;
      step();
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
